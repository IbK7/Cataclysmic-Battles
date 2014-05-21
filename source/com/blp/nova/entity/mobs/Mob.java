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
package com.blp.nova.entity.mobs;

import java.awt.Graphics;

import com.blp.nova.entity.Entity;
import com.blp.nova.enums.Direction;
import com.blp.nova.gfx.Animation;
import com.blp.nova.gfx.textures.Sprite;
import com.blp.nova.world.World;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Mob
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public abstract class Mob extends Entity {

    protected float     velX;
    protected float     velY;
    protected int       maxVelY   = 5;
    protected float     gravity   = 0.5f;
    protected Direction direction = Direction.RIGHT;
    protected boolean   falling   = true; //true;
    protected boolean jumping = false;
    protected boolean   moving    = false;
    protected Animation animeLeft;
    protected Animation animeRight;
    protected Sprite sprite2;

    public Mob(int x, int y, World world) {
        super(x, y, world);
    }

    @Override
    public void tick() {
        if (velX > 0) direction = Direction.RIGHT;
        else if (velX < 0) direction = Direction.LEFT;
        if (!hasHorizontalCollision()) x += velX;
        if(!hasVerticalCollision()) y += velY;
        fall();
        if (velX != 0) moving = true;
        else moving = false;
        if(moving) getAnimation().runAnimation();
    }

    @Override
    public void render(Graphics g) {
        if (moving) getAnimation().drawAnimation(g, x, y);
        else getStandingStill().render(g, x, y);
    }
    

    protected void fall() {
        if (falling) {
            velY += gravity;
            if (velY > maxVelY) velY = maxVelY;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public Animation getAnimation() {
        return direction == Direction.LEFT ? animeLeft : animeRight;
    }
    
    public Sprite getStandingStill(){
        return direction == Direction.LEFT ? sprite : sprite2;
    }

}
