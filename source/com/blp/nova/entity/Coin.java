/*   Copyright 2014 Matthew Rogers "BossLetsPlays"
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.blp.nova.world.World;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 * <strong>Class:</strong> Coin
 *
 * @author <a href = "http://blp.vc-network.com"> BossLetsPlays</a>
 */
public class Coin extends Entity {

    public Coin(int x, int y, World world) {
        super(x, y, world);
    }

    @Override
    public void tick() {}
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x + 8, y + 8, 16, 16);
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
    
    @Override
    public Rectangle getTop() {
        return null;
    }
    
    @Override
    public Rectangle getBottom() {
        return null;
    }
    
    @Override
    public Rectangle getRight() {
        return null;
    }
    
    @Override
    public Rectangle getLeft() {
        return null;
    }

}
