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

import java.awt.image.BufferedImage;

import com.blp.nova.libs.Images;
import com.blp.nova.utils.SpriteSheet;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Texture
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Texture {
    
    private SpriteSheet sheetTest;
    
    public BufferedImage blockStone;
    public BufferedImage blockMetal;
    
    public Texture(){
        sheetTest = new SpriteSheet(Images.spritesheetTest, 32);
        
        
        initTextures();
    }
    
    private void initTextures(){
        blockStone = sheetTest.getSprite(1, 1);
        blockMetal = sheetTest.getSprite(2, 1);
    }

}
