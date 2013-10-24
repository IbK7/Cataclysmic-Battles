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

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.blp.nova.libs.Reference;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> AudioPlayer
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class AudioPlayer {
    
    
    /**
     * A hash map to contain all of our game's sound effects
     */
    private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    /**
     * A hash map to contain all of our game's music
     */
    private static Map<String, Music> musicMap = new HashMap<String, Music>();
    
    
    
    /**
     * Used to help sounds not "machine gun" when mouse hovers over a button
     */
    public static boolean hasPlayedHover = false;
    
    
    /**
     * Adds a new sound into the hash map<br>
     * The file must be <strong>.xm, .mod, .aif, .wav or .ogg</strong> format
     * @param key the key or ID that will be used to access this sound effect
     * @param path the name of the sound file
     */
    public static void addSound(String key, String path){
        try {
            soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
        } catch (SlickException e) {
            
            e.printStackTrace();
        }
    }
    
    
    /**
     * Adds a new song into the hash map<br>
     * The file must be <strong>.xm, .mod, .ogg, or .aif/f</strong> format
     * @param key the key or ID that will be used to access this song
     * @param path the name of the song file
     */
    public static void addMusic(String key, String path){
        try {
            musicMap.put(key, new Music(Reference.SOUND_LOCATION + path));
        } catch (SlickException e) {
            
            e.printStackTrace();
        }
    }
    
    /**
     * Used to obtain a sound to be played
     * @param key the key or ID of the sound
     * @return the sound
     */
    public static Sound getSound(String key){
        return soundMap.get(key);
    }
    
    
    /**
     * Used to obtain a song to be played
     * @param key the key or ID of the song
     * @return the song
     */
    public static Music getMusic(String key){
        return musicMap.get(key);
    }
    
    /**
     * Plays a sound effect
     * @param key the key of the sound
     */
    public static void playSound(String key){
        soundMap.get(key).play(); //We will later be working with volume when we get into options portion of the tutorial
    }
    
    /**
     * Loops a song
     * @param key the key of the song
     */
    public static void playMusic(String key){
        musicMap.get(key).loop(); //We will later be working with volume when we get into options portion of the tutorial
    }

}
