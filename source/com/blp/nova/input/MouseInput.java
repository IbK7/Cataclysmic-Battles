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
package com.blp.nova.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.blp.nova.Game;
import com.blp.nova.enums.GameState;
import com.blp.nova.libs.Audio;
import com.blp.nova.screens.Menu;
import com.blp.nova.utils.AudioPlayer;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> MouseInput
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class MouseInput extends MouseAdapter {

    /**
     * true if a mouse button is pressed
     */
    public static boolean pressed = false;

    /**
     * The x and y coordinates of the mouse
     */
    public static int MOUSE_X, MOUSE_Y;

    /**
     * Used to check for intersection in other classes <br> set to a 1x1 at location (1,1) by default, to avoid a NullPointerException
     */
    public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
    
    
    private Menu menu = Game.getInstance().getMenu();

    @Override
    /**
     * This method is called whenever a mouse button is clicked
     */
    public void mouseClicked(MouseEvent e) {
        int mouse = e.getButton(); //used to check what button was clicked
        Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1); //creates a 1x1 rectangle around the cursor to be used to check where it was clicked

        if (mouse == MouseEvent.BUTTON1) { //only do this stuff if the left mouse button was clicked

            switch (Game.state) { //depending on what state the game is in, check for the following cases
                case GAME:
                    break;
                case MENU:
                    if (rect.intersects(menu.play)) { //Example, if we click our menu's play button, change the state to GAME
                        AudioPlayer.playSound(Audio.SOUND_LASER); //make sure you play your sound before changing the game's state
                        Game.getInstance().levelOne.loadLevel();
                        Game.getInstance().initCamera(); //camera and key listener must be added after the player, which currently the player is being added when the level is loaded
                        Game.getInstance().addKeys();
                        Game.state = GameState.GAME;
                    } else if (rect.intersects(menu.options)) {
                        AudioPlayer.playSound(Audio.SOUND_LASER);
                        Game.state = GameState.OPTIONS;
                    }
                    break;
                case OPTIONS:
                    break;
                case PAUSE:
                    break;
                default:
                    break;

            }
        }
    }

    @Override
    /**
     * This is called while we have a mouse button held down
     */
    public void mousePressed(MouseEvent e) {
        pressed = true;
        MOUSE = new Rectangle(e.getX(), e.getY(), 1, 1);
        if(Game.state == GameState.MENU){
            if(MOUSE.intersects(menu.quit)){
                AudioPlayer.playSound(Audio.SOUND_LASER);
            }
        }
    }

    @Override
    /**
     * This is called whenever we release the mouse button
     */
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        MOUSE = new Rectangle(e.getX(), e.getY(), 1, 1);
        if(Game.state == GameState.MENU){
            if(MOUSE.intersects(menu.quit)){
                Game.exit();
            }
        }

    }

    @Override
    /**
     * This is called whenever the mouse is moved
     */
    public void mouseMoved(MouseEvent e) {
        MOUSE_X = e.getX();
        MOUSE_Y = e.getY();

        MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);

        switch (Game.state) {
            case GAME:
                break;
            case MENU:
                if ((MOUSE.intersects(menu.play)           //Only do this if the mouse is hovering over a button and the sound has not already played
                        || MOUSE.intersects(menu.options)
                        || MOUSE.intersects(menu.quit))
                        && !AudioPlayer.hasPlayedHover) {
                    
                    AudioPlayer.playSound(Audio.SOUND_LASER);
                    AudioPlayer.hasPlayedHover = true;  //The sound has played, so lets set it to true
                    
                }else if(!(MOUSE.intersects(menu.play)    //If the mouse is not hovering over a button, then reset the boolean to false
                        || MOUSE.intersects(menu.options)
                        || MOUSE.intersects(menu.quit))
                        && AudioPlayer.hasPlayedHover){
                    
                    AudioPlayer.hasPlayedHover = false;
                }
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                break;

        }

    }

}
