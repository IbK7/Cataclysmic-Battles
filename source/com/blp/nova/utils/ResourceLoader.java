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

import com.blp.nova.libs.Audio;
import com.blp.nova.libs.Fonts;
import com.blp.nova.libs.Images;


/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> ResourceLoader
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class ResourceLoader {

    private static BufferedImageLoader imageLoader = new BufferedImageLoader();
    
    /**
     * Loads all of the images and sprites to be used in the game
     */
    public static void loadImages(){
        
        try{
            Images.title = imageLoader.loadImage("title.png");
            Images.spritesheetTest = imageLoader.loadImage("test_spritesheet.png");
        } catch(IOException e){
            e.printStackTrace();  //We need to know why we crashed!
        }
        
    }

    /**
     * Loads all of the fonts to be used in the game
     */
    public static void loadFonts(){
        Fonts.addFont(new Fonts("VIKING-N.TTF")); //This is the file name, NOT the font name
    }
    
    
    /**
     * Load sounds into the game<br>
     * This includes <code>Sound</code> Effects and <code>Music</code>
     */
    public static void loadSounds(){
        AudioPlayer.addSound(Audio.SOUND_LASER, "Laser.ogg");
        
        AudioPlayer.addMusic(Audio.MUSIC_MOON, "Moon.ogg");
    }

}
