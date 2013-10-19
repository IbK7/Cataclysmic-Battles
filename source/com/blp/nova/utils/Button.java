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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import com.blp.nova.input.MouseInput;
import com.blp.nova.libs.Audio;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Button
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
@SuppressWarnings("serial")
public class Button extends Rectangle {
    
    private String text;

    /**
     * Creates a default button/rectangle
     */
    public Button() {
        super();
    }

    /**
     * Creates a rectangle/button using data from a rectangle object
     * @param r A rectangle object
     */
    public Button(Rectangle r) {
        super(r);

    }

    /**
     * Creates a rectangle from a point
     * @param p A point object
     */
    public Button(Point p) {
        super(p);

    }

    /**
     * Creates a rectangle/button using a dimension
     * @param d A dimension object
     */
    public Button(Dimension d) {
        super(d);

    }

    /**
     * Creates a button/rectangle with a specified width and height
     * @param width The width of the button
     * @param height The height of the button
     */
    public Button(int width, int height) {
        super(width, height);

    }

    /**
     * Creates a button/rectangle from a point using a dimension
     * @param p A point object
     * @param d A dimension object
     */
    public Button(Point p, Dimension d) {
        super(p, d);

    }

    /**
     * Creates a button from a specified top-left corner and a specified width and height
     * @param x The far-left x-value of the button
     * @param y The highest y-value of the button
     * @param width The width of the button
     * @param height The height of the button
     */
    public Button(int x, int y, int width, int height) {
        super(x, y, width, height);

    }
    
    /**
     * Sets the text to be displayed on the button
     * @param text the text displayed on the button
     * @return this
     */
    public Button setText(String text){
        this.text = text;
        return this;
    }
    
    
    /**
     * Utility method to facilitate the drawing of rectangles for our buttons
     * @param g the Graphics context of our <strong> <code> Game class </strong> </code>
     * @param offset  The horizontal offset determines how to far or near to the left of the button to start drawing the rectangle
     */
    public void drawButton(Graphics g, int offset){
        int xx = x + offset;
        int yy = y + 38;
        
        
        if(MouseInput.MOUSE.intersects(this)){  //show our buttons in yellow when our mouse hovers over them
            g.setColor(Color.YELLOW);
        }else  //other wise, show the button in white
            g.setColor(Color.WHITE);
        
        if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this))
            g.drawRect(x, y, width, height);
        else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this)) //fills in the button when we press it
            g.fillRect(x, y, width, height);
        else
            g.drawRect(x,y,width,height);
        
        g.setColor(Color.RED);
        g.drawString(text, xx, yy);
    }

}
