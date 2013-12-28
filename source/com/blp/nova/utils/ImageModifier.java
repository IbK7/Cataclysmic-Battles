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

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> ImageModifier
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class ImageModifier {
    
    /**
     * Scales an image down or up<p> 
     * <strong>Note:</strong> Use two images, the non-modified image and the image you actually use and has been/will be scaled
     * @param originalImage the original image that has not been scaled
     * @param type the type of image, for example: <code>BufferedImage.TYPE_INT_ARGB</code>
     * @param x the starting x coordinate of the portion of the image you want to scale
     * @param y the starting y coordinate of the portion of the image you want to scale
     * @param inititalWidth the width of the origional image
     * @param initialHeight the height of the origional image
     * @param scale how much to be scaled by<br>
     * scale < 1 = shrink<br>
     * scale > 1 = growth
     * @return the scaled image
     */
    public static BufferedImage resizeImage(BufferedImage originalImage, int type, float x, float y, int inititalWidth, int initialHeight, double scale){
        inititalWidth *= scale;
        initialHeight *= scale;
        BufferedImage resizedImage = new BufferedImage(inititalWidth, initialHeight, type);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, (int)x, (int)y, inititalWidth, initialHeight, null);
        g2d.dispose();
        return resizedImage;
    }

}
