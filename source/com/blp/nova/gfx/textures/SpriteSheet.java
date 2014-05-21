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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.blp.nova.libs.Reference;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> SpriteSheet
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class SpriteSheet {
    
    private String path;
    private BufferedImage image;
    
    
    public SpriteSheet(String path) {
        this.path = path;
        load();
    }
    
    private void load(){
        File file = null;
        try {
            file = new File(Reference.SPRITE_LOCATION + path);
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.err.println("Make sure file < " + path + " > is in " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
    
    public BufferedImage getSprite(int x, int y, int size){
        return image.getSubimage((x * size) - size, (y * size) - size, size, size);
    }
    

}
