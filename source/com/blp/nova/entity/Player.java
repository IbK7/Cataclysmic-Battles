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
import java.awt.Rectangle;
import java.util.ArrayList;

import com.blp.nova.Controller;
import com.blp.nova.core.CoreObject;
import com.blp.nova.gfx.Texture;
import com.blp.nova.libs.Identities;
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
     * convenience block to help when checking collision
     */
    private Block block;
    /**
     * Normally, I would recommend a float, but since we are using integers, this will be fine
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
    public Player(int x, int y, int width, int height, int id, Texture tex) {
        super(x, y, width, height, id, tex);
        
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
            if(obj.getId() == Identities.BLOCK_STONE){
                block = (Block) obj;
                if(getBottomBounds().intersects(block.getTopBounds())){   //collision between bottom of player and top of block
                    velY = 0;
                    y = block.getY() - height;
                    jumping = false;
                }
            }
        }
        
    }
    
    /**
     * Makes the player fall using gravity
     */
    public void fall(){
        if(falling)
            velY += gravity;
    }
    
    /**
     * Gets the lower bounds of the player
     * @return a rectangle representing the lower bounds
     */
    public Rectangle getBottomBounds(){
        return new Rectangle(x,y + (height/2), 30, height/2);
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
