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
package com.blp.nova.entity;

import java.awt.Graphics;

import com.blp.nova.core.CoreObject;
import com.blp.nova.gfx.Texture;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Player
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Player extends CoreObject {
    
    

    public Player(int x, int y, int id, Texture tex) {
        super(x, y, id, tex);
        
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tex.blockMetal, x, y, null);
    }
    

}
