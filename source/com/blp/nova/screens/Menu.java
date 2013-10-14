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
package com.blp.nova.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.blp.nova.Game;
import com.blp.nova.libs.Images;
import com.blp.nova.libs.Reference;
import com.blp.nova.utils.Button;


/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Menu
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Menu {

    public Button play, options, quit;  //Our buttons on the menu
    
    /**
     * Creates a new menu with the play, options, and quit buttons
     */
    public Menu(){
        int fillerY = 150; //used to facilitate the placing of the buttons vertically
        play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50).setText("Play");
        options = new Button(Reference.CENTER_X - 100, fillerY+=60, 200, 50).setText("Options");
        quit = new Button(Reference.CENTER_X - 100, fillerY+=60, 200, 50).setText("Quit");
        
    }

    
    /**
     * Draws the menu
     * @param g the Graphics context of our <strong> <code> Game class </strong> </code>
     */
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.title, 128, 10, null);
        
        Font viking = new Font("Viking-Normal", Font.PLAIN, 32);
        g.setFont(viking);  //sets the font of the text on the buttons
        
        play.drawButton(g, 55);
        options.drawButton(g, 15);
        quit.drawButton(g, 55);

    }
}
