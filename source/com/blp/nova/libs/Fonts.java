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
 * Project: CataclysmicBattles - 
 *
 * Class: Fonts
 *
 * @author BossLetsPlays
 *
 */
public class Fonts {

    private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
    
    private static String fontPath;
    
    public Fonts(String filePath){
        Fonts.fontPath = Reference.FONT_LOCATION + filePath;
        registerFont();
    }
    
    private void registerFont(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try{
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
  

    public static void addFont(Fonts font){
        fontList.add(font);
    }
    
    

}
