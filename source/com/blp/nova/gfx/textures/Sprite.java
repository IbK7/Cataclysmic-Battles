/*   Copyright 2014 BossLetsPlays(Matthew Rogers)
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
package com.blp.nova.gfx.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Sprite
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Sprite {

    private int x;
    private int y;
    private int size;
    private SpriteSheet spritesheet;
    private BufferedImage image;
    
    public Sprite(int x, int y, int size, SpriteSheet spritesheet){
        this.x = x;
        this.y = y;
        this.size = size;
        this.spritesheet = spritesheet;
        image = spritesheet.getSprite(x, y, size);
    }
    
    public void render(Graphics g, int x, int y){
        g.drawImage(image, x, y, null);
    }
}
