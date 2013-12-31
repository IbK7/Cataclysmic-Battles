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
import java.util.ArrayList;

import com.blp.nova.Game;
import com.blp.nova.core.CoreObject;
import com.blp.nova.enums.Direction;
import com.blp.nova.gfx.Animation;
import com.blp.nova.handlers.Textures;
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
    private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();

    /**
     * this is used to control the gravety in the game, and how fast the player will fall
     * <br>This is the amount that will be added to the velY when falling
     */
    private float gravity = 0.55f;
    /**
     * Make sure the player is always trying to fall
     */
    private boolean falling = true;
    /**
     * by default, the player is not jumping, duh
     */
    private boolean jumping = false;
    /**
     * by default, the player is not moving, duh
     * <br>Used to determine when the player should be animating
     */
    private boolean moving = false;
    
    /**
     * the animation set for when the player is moving right
     */
    private Animation animeRight;
    /**
     * the animation set for when the player is moving left
     */
    private Animation animeLeft;
    
    /**
     * used to control which sprites are being used
     */
    private Direction direction = Direction.RIGHT;
    
    

    /**
     * Creates a new player
     * @param x the far left x coordinate
     * @param y the upper y coordinate
     * @param width the width of the players rectangle (would be same as sprite more than likely)
     * @param height the height of the players rectangle (would be same as sprite more than likely)
     * @param id the ID of the player
     * @param tex the <code>Texture</code> object
     */
    public Player(float x, float y, int id, Textures tex) {
        super(x, y, id, tex);
        this.setSize(32, 70);
        animeRight = new Animation(3, tex.playerRight);
        animeLeft = new Animation(3, tex.playerLeft);
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
        if(moving){
            if(direction == Direction.RIGHT)
                animeRight.runAnimation();
            else if(direction == Direction.LEFT)
                animeLeft.runAnimation();
        }
    }

    @Override
    /**
     * draws the player onto the screen
     * @param g the graphics context
     */
    public void render(Graphics g) {
        if(!moving){
            if(direction == Direction.RIGHT)
                g.drawImage(tex.playerStandingRight, (int)x, (int)y, null);
            else if(direction == Direction.LEFT)
                g.drawImage(tex.playerStandingLeft, (int)x, (int)y, null);
        }
        else{
            if(direction == Direction.RIGHT)
                animeRight.drawAnimation(g, x, y);
            else if(direction == Direction.LEFT)
                animeLeft.drawAnimation(g, x, y);
        }
        super.render(g);
    }
    
    
    /**
     * Helper method to check for collision with blocks and such
     */
    private void checkCollision(){
        
        for(CoreObject obj : gameObjects){
            if(obj instanceof Block){  //do this stuff if the object is a Block
                if(getBottomBounds().intersects(obj.getTopBounds())){   //collision between bottom of player and top of block
                    velY = 0; //stop trying to fall
                    y = obj.getY() - height;  //sets our y to the top of the block
                    jumping = false; //we can jump again
                    falling = false;
                }else
                    falling = true;
                if(getTopBounds().intersects(obj.getBottomBounds())){   //collision between top of player and bottom of block
                    fall();
                    y = obj.getY() + obj.getHeight() + 1;  //we need to stop being inside the block so we can fall
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
        /*
         * gravity is acceleration due to a magnetic pull (gravitational pull)
         * Earth's gravity is 9.8 m/s^2, but its still a form of acceleration, which is the change in VELOCITY over time
         * that is why add the gravity to the velocity of y, rather than y itself, this also makes it gradually fall faster
         */
        if(falling){
            velY += gravity;
            if(velY >= 15)
                velY = 13;
        }
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

    /**
     * @return true if the player moving
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * @param moving : is the player moving?
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    
    /**
     * Changes the direction the player is facing
     * @param direction the new direction to set
     */
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    
    /**
     * @return the current direction the player is facing
     */
    public Direction getDirection(){
        return direction;
    }
    


}
