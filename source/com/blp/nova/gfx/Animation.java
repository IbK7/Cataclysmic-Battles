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
package com.blp.nova.gfx;

import java.awt.Graphics;

import com.blp.nova.gfx.textures.Sprite;

public class Animation {

    /**
     * Used to make sure nextFrame() does not excede frames
     */
    private int      count = 0;
    /**
     * Used to make sure runAnimation() does not excede speed
     */
    private int      index = 0;
    /**
     * determines how fast the frames will animate
     */
    private int      speed;
    /**
     * the number of images/steps in the animation
     */
    private int      frames;

    private Sprite   currentSprite;
    private Sprite[] sprites;

    /**
     * Constructs a new animation set
     * @param speed the speed of the animation
     * @param sprites the array of images
     */
    public Animation(int speed, Sprite... sprites) {
        this.speed = speed;
        this.sprites = sprites;
        frames = sprites.length;
    }

    /**
     * Runs the animation and updates the frames
     * Called in the tick method of the object being animated
     */
    public void runAnimation() {
        index++;
        if (index > speed) {
            index = 0;
            nextFrame();
        }
    }

    /**
     * Moves the animation on to the next frame
     * Used in the runAnimation method
     */
    private void nextFrame() {
        for (int k = 0; k < frames; k++)
            if (count == k)
                currentSprite = sprites[k];

        count++;
        if (count > frames)
            count = 0;
    }

    /**
     * Draws the current image or frame in the animation set
     * Used in the render method of the object being animated
     * @param g the Graphics context
     * @param x the x coordinate of the object
     * @param y the y coordinate of the object
     */
    public void drawAnimation(Graphics g, int x, int y) {
        if(currentSprite != null)
            currentSprite.render(g, x, y);
    }

}
