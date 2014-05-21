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
package com.blp.nova.main;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.blp.nova.Game;
import com.blp.nova.libs.Reference;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Window
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Window {
    private static JFrame frame;
    
    public static void createWindow(Game game, String title){
        frame = new JFrame(title);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "icon.png");  //This is the image we will be using as our window's icon
        Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION + "cursor.gif");
        frame.add(game);
        frame.setIconImage(icon); //sets the icon we specified above
        frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
        frame.setSize(Game.WIDTH, Game.HEIGHT); //sets the size of our window
        
        frame.addWindowListener(                                 //adds a listener that we can use to exit the game
                new WindowAdapter(){                             //annonomous inner class
                    public void windowClosing(WindowEvent e){    //annonomous inner method that is called when the red X is pressed
                        Game.exit();
                    }
                }
                );
        
        frame.setFocusable(true); //This way we are able to use keyboards and our mouse and all that good stuff
        frame.setLocationRelativeTo(null); //makes our frame start in the center of our screen
        frame.setResizable(false); //for now, if we resize our window, we will get a lot of bugs with the graphics
        frame.setVisible(true); //This actually shows the frame/window
        frame.pack(); //packs all our components and settings into one nice frame package (metaphorical of course)
    }
    
    /**
     * Sets the title of the game
     * @param title the title to be given to the game
     */
    public static void setTitle(String title){
        frame.setTitle(title);
    }
    

}
