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
package com.blp.nova.libs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;


/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Fonts
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Fonts {

    /**
     * An array list that contains all of our custom fonts
     */
    private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
    
    /**
     * The path to our font
     */
    private static String fontPath;
    
    /**
     * Creates a new custom font
     * @param filePath the file path of the TTF font
     */
    public Fonts(String filePath){
        Fonts.fontPath = Reference.FONT_LOCATION + filePath;
        registerFont();
    }
    
    /**
     * Registers the font with the graphics environment and temporary installs it onto the runtime
     */
    private void registerFont(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();   //we need to register our font with the graphics environment we are in
        
        try{
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));  //creates a true-type font from our file path
        } catch(Exception e){
            e.printStackTrace(); //this can fail, so lets make sure to print the error so we know that our crash had something to do with our loading of fonts
        }
    }
  

    /**
     * Adds a new font to our list
     * @param font the new <code> Fonts</code> object
     */
    public static void addFont(Fonts font){
        fontList.add(font);
    }
    
    

}
