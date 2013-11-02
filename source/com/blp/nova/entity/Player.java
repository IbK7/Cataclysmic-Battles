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

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.blp.nova.Controller;
import com.blp.nova.core.CoreObject;
import com.blp.nova.gfx.Textures;
import com.blp.nova.objects.Block;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Player
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Player extends CoreObject {
    
    /**
     * convenience list to hold the data of <code>Controller.getObjects()</code>
     */
    private static ArrayList<CoreObject> blocks = Controller.getObjects();

    /**
     * Normally, I would recommend a float, but since we are using integers, this will be fine
     * <br>This is the amount that will be added to the velY when falling
     */
    private int gravity = 1;
    /**
     * Make sure the player is always trying to fall
     */
    private boolean falling = true;
    /**
     * by default, the player is not jumping, duh
     */
    private boolean jumping = false;
    

    /**
     * Creates a new player
     * @param x the far left x coordinate
     * @param y the upper y coordinate
     * @param width the width of the players rectangle (would be same as sprite more than likely)
     * @param height the height of the players rectangle (would be same as sprite more than likely)
     * @param id the ID of the player
     * @param tex the <code>Texture</code> object
     */
    public Player(int x, int y, int id, Textures tex) {
        super(x, y, id, tex);
        this.setSize(32, 70);
        
    }

    @Override
    /**
     * Runs the logic and updates the values of the player
     */
    public void tick() {
        x += velX;
        y += velY;
        
        fall();  //fall first, then check collision
        checkCollision();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
    
    /**
     * Helper method to check for collision with blocks and such
     */
    private void checkCollision(){
        
        for(CoreObject obj : blocks){
            if(obj instanceof Block){  //do this stuff if the object is a Block
                if(getBottomBounds().intersects(obj.getTopBounds())){   //collision between bottom of player and top of block
                    velY = 0; //stop trying to fall
                    y = obj.getY() - height;  //sets our y to the top of the block
                    jumping = false; //we can jump again
                }
                if(getTopBounds().intersects(obj.getBottomBounds())){   //collision between top of player and bottom of block
                    fall(); //hang for a split second, then fall (velY = -velY for an immediate fall)
                    y = obj.getY() + obj.getHeight();  //we need to stop being inside the block so we can fall
                }
                if(getRightBounds().intersects(obj.getLeftBounds())){   //collision between right of player and left of block
                    velX = 0; //stop trying to move
                    x = obj.getX() - width; //set our x to the edge of the block
                }
                if(getLeftBounds().intersects(obj.getRightBounds())){   //collision between left of player and right of block
                    velX = 0; //stop trying to move
                    x = obj.getX() + obj.getWidth(); //set our x to the edge of the block
                }
            }
        }
        
    }
    
    /**
     * Makes the player fall using gravity
     */
    public void fall(){
        if(falling)
            velY += gravity;  //gravity is acceleration due to a magnetic pull (gravitational pull)
                              //Earth's gravity is 9.8 m/s^2, but its still a form of acceleration, which is the change in VELOCITY over time
                              //that is why add the gravity to the velocity of y, rather than y itself, this also makes it gradually fall faster
    }
    

    /**
     * @return true if the player is jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * @param jumping the boolean to set the jumping state to
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    


}
