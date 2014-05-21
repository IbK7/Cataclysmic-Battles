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
package com.blp.nova.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.blp.nova.gfx.textures.Sprite;
import com.blp.nova.world.World;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Entity
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public abstract class Entity {
    
    protected int x;
    protected int y;
    protected Sprite sprite;
    protected World world;
    
    public Entity(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
        world.addEntity(this);
    }
    
    public abstract void tick();
    
    public void render(Graphics g){
        sprite.render(g, x, y);
    }
    
    
    protected boolean hasHorizontalCollision(){
        return false;
    }
    
    protected boolean hasVerticalCollision(){
        return false;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }
    
    public abstract Rectangle getTop();
    public abstract Rectangle getBottom();
    public abstract Rectangle getRight();
    public abstract Rectangle getLeft();
    public abstract Rectangle getBounds();
}
