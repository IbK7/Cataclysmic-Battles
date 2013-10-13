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
import java.awt.Rectangle;

import com.blp.nova.Game;
import com.blp.nova.input.MouseInput;
import com.blp.nova.libs.Images;
import com.blp.nova.libs.Reference;

/**
 * Project: CataclysmicBattles <br>
 *
 * Class: Menu
 *
 * @author BossLetsPlays
 *
 */
public class Menu {

    public Rectangle play, options, quit;  //Our buttons on the menu
    
    /**
     * Creates a new menu with the play, options, and quit buttons
     */
    public Menu(){
        int fillerY = 150; //used to facilitate the placing of the buttons vertically
        play = new Rectangle(Reference.CENTER_X - 100, fillerY, 200, 50);
        options = new Rectangle(Reference.CENTER_X - 100, fillerY+=60, 200, 50);
        quit = new Rectangle(Reference.CENTER_X - 100, fillerY+=60, 200, 50);
        
    }

    /**
     * Utility method to facilitate the drawing of rectangles for our buttons
     * @param g the Graphics context of our <strong> <code> Game class </strong> </code>
     * @param rect the rectangle or in our case, the <i> button </i> to be drawn
     * @param text the text to be displayed on the button
     * @param offsetX  The horizontal offset determines how to far or near to the left of the button to start drawing the rectangle
     */
    public void drawButton(Graphics g, Rectangle rect, String text, int offsetX){
        Font viking = new Font("Viking-Normal", Font.PLAIN, 32);
        g.setFont(viking);  //sets the font of the text on the buttons
        if(MouseInput.MOUSE.intersects(rect)){  //show our buttons in yellow when our mouse hovers over them
            g.setColor(Color.YELLOW);
        }else  //other wise, show the button in white
            g.setColor(Color.WHITE);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(text, rect.x + offsetX, rect.y + 38);
    }
    
    /**
     * Draws the menu
     * @param g the Graphics context of our <strong> <code> Game class </strong> </code>
     */
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.title, 128, 10, null);
        drawButton(g, play, "Play", 55);
        drawButton(g, options, "Options", 15);
        drawButton(g, quit, "Quit", 55);
    }
}
