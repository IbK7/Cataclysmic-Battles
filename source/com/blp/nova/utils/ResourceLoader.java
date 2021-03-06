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

import com.blp.nova.libs.Reference;


/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> ResourceLoader
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class ResourceLoader {


    /**
     * Loads all of the fonts to be used in the game
     */
    public static void loadFonts(){
        Fonts.addFont(new Fonts("VIKING-N.TTF")); //This is the file name, NOT the font name
        Fonts.addFont(new Fonts("NEUROPOL.TTF"));
        Fonts.addFont(new Fonts("PLANK___.TTF"));
    }
    
    
    /**
     * Load sounds into the game<br>
     * This includes <code>Sound</code> Effects and <code>Music</code>
     */
    public static void loadSounds(){
        AudioPlayer.addSound(Reference.SOUND_LASER, "Laser.ogg");
        AudioPlayer.addSound(Reference.SOUND_COIN, "Coin.ogg");
        
        AudioPlayer.addMusic(Reference.MUSIC_MOON, "Moon.ogg");
    }

}
