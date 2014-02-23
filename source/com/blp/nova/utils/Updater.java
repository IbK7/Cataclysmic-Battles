/*   Copyright 2013 BossLetsPlays(Matthew Rogers)
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
package com.blp.nova.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.blp.nova.Game;
import com.blp.nova.libs.Reference;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Updater
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Updater {
    private static String currentVersion, newVersion;
    public static int     update = 0;

    public static void checkForUpdate(boolean isAuto) {
        currentVersion = Reference.VERSION;

        try {
            URL site = new URL("https://raw.github.com/BossLetsPlays/Cataclysmic-Battles/master/version.txt");
            Scanner scan = new Scanner(site.openStream());
            newVersion = scan.nextLine();
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (currentVersion.equals(newVersion)) {
            if (!isAuto)
                doNotUpdate();
            return;
        } else {
            Object[] options =
            {
                    "Update",
                    "Do Not Update"
            };

            int temp = JOptionPane.showOptionDialog(null, "An update has been found for Cataclysmic Battles (current version: " + currentVersion + " new version: " + newVersion +
                    "\nUpdate may take several minutes!\nDo not close the game while updating!\nA window will pop up when the update is complete!", "Updater", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (temp == 1) return;
            else {
                updateAllFiles();
//                updateFile("Game.jar", "LINK FOR JAR");
                finishUpdate();
                return;

            }
        }

    }

    private static void finishUpdate() {
        JOptionPane.showMessageDialog(null, "Game has been updated to version " + newVersion + "\nGame will now close", "Update Completed", JOptionPane.INFORMATION_MESSAGE);
        Game.exit();
    }

    private static void doNotUpdate() {
        JOptionPane.showMessageDialog(null, "No Update Found", "Updater", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    
    private static void updateFile(String file, String link){
        System.out.println("Updating file: " + file);
        try {
            URL url = new URL(link);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0, 1 << 24);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void updateAllFiles(){
        ArrayList<File> roots = new ArrayList<File>();
        roots.addAll(Arrays.asList(
                new File(Reference.RESOURCE_LOCATION),
                new File(Reference.FONT_LOCATION),
                new File(Reference.SOUND_LOCATION),
                new File(Reference.SPRITE_LOCATION)
                ));
    }
    
    private static void search(String root){
        boolean willUpdate = true;
        File folder = new File(root);
        File[] fileList = folder.listFiles();
        for(File file : fileList){
            String path = file.getAbsolutePath().replace('\\', '/');
            String str0 = file.getPath().replace('\\', '/');
            String str1 = null;
            if(str0.lastIndexOf('.') > 1){
                willUpdate = true;
                str1 = str0.substring(2);
            } else willUpdate = false;
            
            if(willUpdate){
                String link = "https://raw.github.com/BossLetsPlays/Cataclysmic-Battles/master/" + str1;
                updateFile(str0, link);
            }
            
            if(!path.contains("."))
                search(path + "/");
            
        }
    }

}
