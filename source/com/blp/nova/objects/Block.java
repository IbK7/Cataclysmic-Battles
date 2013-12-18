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
package com.blp.nova.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.blp.nova.core.CoreObject;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Block
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Block extends CoreObject {
    
    public Block(float x, float y, int id, BufferedImage image) {
        super(x, y, id, image);
        this.image = image;
        this.setSize(32, 32);
        
    }
    
    @Override
    public void tick() {}

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)x, (int)y, null);
    }
    

    
    
    

}
