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

import java.io.IOException;

import com.blp.nova.libs.Fonts;
import com.blp.nova.libs.Images;

/**
 * Project: CataclysmicBattles - 
 *
 * Class: ResourceLoader
 *
 * @author BossLetsPlays
 *
 */
public class ResourceLoader {

    private static BufferedImageLoader imageLoader = new BufferedImageLoader();
    
    public static void loadImages(){
        
        try{
            Images.title = imageLoader.loadImage("title.png");
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public static void loadFonts(){
        Fonts.addFont(new Fonts("VIKING-N.TTF"));
    }
    
}
