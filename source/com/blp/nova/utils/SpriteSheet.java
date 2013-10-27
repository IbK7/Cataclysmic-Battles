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

import java.awt.image.BufferedImage;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> SpriteSheet
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class SpriteSheet {
    
    private BufferedImage image;
    private int width;
    private int height;
    
    public SpriteSheet(BufferedImage image, int width){
        this.image = image;
        this.width = width;
        this.height = width;
    }
    
    public SpriteSheet(BufferedImage image, int width, int height){
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    
    public BufferedImage getSprite(int col, int row){
        
        return image.getSubimage((col * width) - width, (row * height) - height, width, height);
    }

}
