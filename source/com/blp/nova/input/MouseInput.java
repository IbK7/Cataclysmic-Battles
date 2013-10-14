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
     * The x and y coords of the mouse
     */
    public static int MOUSE_X, MOUSE_Y;
    
    /**
     * Used to check for intersection in other classes <br> set to a 1x1 at location (1,1) by default, to avoid a NullPointerException
     */
    public static Rectangle MOUSE = new Rectangle(1,1,1,1);

    @Override
    /**
     * This method is called whenever a mouse button is clicked
     */
    public void mouseClicked(MouseEvent e) {
        int mouse = e.getButton();  //used to check what button was clicked
        Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);  //creates a 1x1 rectangle around the cursor to be used to check where it was clicked

        if (mouse == MouseEvent.BUTTON1) {  //only do this stuff if the left mouse button was clicked

            switch (Game.state) {  //depending on what state the game is in, check for the following cases
                case GAME:
                    break;
                case MENU:
                    if (rect.intersects(Game.getInstance().getMenu().play))  //Example, if we click our menu's play button, change the state to GAME
                        Game.state = GameState.GAME;
                    else if(rect.intersects(Game.getInstance().getMenu().quit))
                        System.exit(1);  //Exits the game
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
    }
    
    @Override
    /**
     * This is called whenever we release the mouse button
     */
    public void mouseReleased(MouseEvent e) {
        
        pressed = false;
        
    }
    
    @Override
    /**
     * This is called whenever the mouse is moved
     */
    public void mouseMoved(MouseEvent e) {
        MOUSE_X = e.getX();
        MOUSE_Y = e.getY();
        MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
        
    }
    
    

}
