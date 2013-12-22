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
package com.blp.nova.world;

import java.awt.image.BufferedImage;

import com.blp.nova.Controller;
import com.blp.nova.Game;
import com.blp.nova.gfx.Textures;
import com.blp.nova.libs.Identities;
import com.blp.nova.libs.Images;
import com.blp.nova.objects.Block;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Level
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Level {

    private BufferedImage image;
    private Controller controller = Game.getInstance().getController();
    private Textures tex = Game.getInstance().getTextureHandler();
    
    public Level(int levelNumber){
        switch(levelNumber){
            case 1:
                image = Images.levelOne;
                break;
            default:
                image = Images.levelOne;
        }
    }
    
    public void loadLevel(){
        int w = image.getWidth();
        int h = image.getHeight();
        
        for(int x = 0; x < w; x++){
            for(int y = 0; y < h; y++){
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 255 && green == 255 && blue == 255)
                    controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_STONE, tex.blockStone));
                else{
                    if(red == 255)
                        controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_METAL, tex.blockMetal));
                }
            }
        }
    }
}
