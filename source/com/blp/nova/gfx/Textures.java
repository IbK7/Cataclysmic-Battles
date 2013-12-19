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
public class Textures {
    
    /*
     * Spritesheets
     */
    private SpriteSheet blockSheet;
    private SpriteSheet playerSheet;
    
    /*
     * Player textures
     */
    public BufferedImage playerStandingRight;
    public BufferedImage playerStandingLeft;
    public BufferedImage playerRight[] = new BufferedImage[4];
    public BufferedImage playerLeft[] = new BufferedImage[4];
    
    /*
     * Block textures
     */
    public BufferedImage blockStone;
    public BufferedImage blockMetal;
    
    /**
     * Constructs the texture container
     */
    public Textures(){
        blockSheet = new SpriteSheet(Images.spritesheetBlocks, 32);
        playerSheet = new SpriteSheet(Images.spritesheetPlayer, 32, 70);
        
        initTextures();
    }
    
    /**
     * Initializes all the different textures
     */
    private void initTextures(){
        blockStone = blockSheet.getSprite(1, 1);
        blockMetal = blockSheet.getSprite(2, 1);
        
        playerStandingRight = playerSheet.getSprite(12, 1);
        playerStandingLeft = playerSheet.getSprite(1, 1);
        
        playerRight[0] = playerSheet.getSprite(8, 1);
        playerRight[1] = playerSheet.getSprite(9, 1);
        playerRight[2] = playerSheet.getSprite(10, 1);
        playerRight[3] = playerSheet.getSprite(11, 1);
        
        playerLeft[0] = playerSheet.getSprite(5, 1);
        playerLeft[1] = playerSheet.getSprite(4, 1);
        playerLeft[2] = playerSheet.getSprite(3, 1);
        playerLeft[3] = playerSheet.getSprite(2, 1);
    }

}
