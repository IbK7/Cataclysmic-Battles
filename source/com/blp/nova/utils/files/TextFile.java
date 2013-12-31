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
package com.blp.nova.utils.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> TextFile
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class TextFile {
    
    private static String line;
    
    /**
     * Reads 1 line from a text file
     * @param path the text file
     * @return 1 line of text from the file
     */
    public static String readFile(String path){
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(path));
            line = file.readLine();
            file.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        return line;
    }
    
    /**
     * Writes text to a file
     * @param path the text file
     * @param text the text to be written
     */
    public static void writeFile(String path, String text){
        try {
            FileWriter file = new FileWriter(path);
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

}
