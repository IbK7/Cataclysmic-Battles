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
import java.awt.image.BufferedImage;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Animation
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Animation {
    
    /**
     * Used to make sure <code>nextFrame()</code> does not excede <code>frames</code>
     */
    private int count = 0;
    /**
     * Used to make sure <code>runAnimation()</code> does not excede <code>speed</code>
     */
    private int index = 0;
    /**
     * determines how fast the frames will animate
     */
    private int speed;
    /**
     * the number of images/steps in the animation
     */
    private int frames;

    /**
     * the current image being displayed
     */
    private BufferedImage currentImage;
    /**
     * an array containing images for each frame
     */
    private BufferedImage anime[];

    /**
     * Constructs a new animation set
     * @param speed the speed of the animation
     * @param anime the array of images
     */
    public Animation(int speed, BufferedImage anime[]) {
        this.speed = speed;
        this.anime = anime;
        frames = anime.length;
    }

    /**
     * Runs the animation and updates the frames<br>
     * Called in the <code><strong>tick</code></strong> method of the object being animated
     */
    public void runAnimation() {
        index++;
        if (index > speed) {
            index = 0;
            nextFrame();
        }
    }

    /**
     * Moves the animation on to the next frame<br>
     * Used in the <code>runAnimation</code> method
     */
    private void nextFrame() {
        for (int k = 0; k < frames; k++)
            if (count == k)
                currentImage = anime[k];

        count++;
        if (count > frames)
            count = 0;
    }

    /**
     * Draws the current image or frame in the animation set<br>
     * Used in the <code><strong>render</code></strong> method of the object being animated
     * @param g the <code>Graphics</code> context
     * @param x the x coordinate of the object
     * @param y the y coordinate of the object
     */
    public void drawAnimation(Graphics g, float x, float y) {
        g.drawImage(currentImage, (int) x, (int) y, null);
    }
    
    

}
