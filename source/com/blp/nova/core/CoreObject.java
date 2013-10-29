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
package com.blp.nova.core;

import java.awt.Graphics;

import com.blp.nova.gfx.Texture;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> CoreObject
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public abstract class CoreObject {

    /**
     * The x coordinate of the object on screen
     */
    protected int x;
    /**
     * The y coordinate of the object on screen
     */
    protected int y;
    
    /**
     * The velocity at which the object moves horizontally
     */
    protected int velX;
    /**
     * The velocity at which the object moves vertically
     */
    protected int velY;
    
    /**
     * The ID of the object, used to obtain the object in an array
     */
    protected int id;
    
    protected int width;
    protected int height;
    
    protected Texture tex;
    
    /**
     * Creates a new object, however because this is an abstract class, you must make a core object equal a <strong>sub type!</strong>
     * @param x the x coordinate of the object on screen
     * @param y the y coordinate of the object on screen
     * @param id the ID of the object
     */
    public CoreObject(int x, int y, int id, Texture tex){
        this.x = x;
        this.y = y;
        this.id = id;
        this.tex = tex;
        width = 32;
        height = 32;
    }
    
    
    /**
     * Creates a new object, however because this is an abstract class, you must make a core object equal a <strong>sub type!</strong>
     * @param x the x coordinate of the object on screen
     * @param y the y coordinate of the object on screen
     * @param id the ID of the object
     */
    public CoreObject(int x, int y, int width, int height, int id, Texture tex){
        this.x = x;
        this.y = y;
        this.id = id;
        this.tex = tex;
        this.width = width;
        this.height = height;
    }
    
    
    /**
     * Updates the objects position and attributes, checks logic in the game
     */
    public abstract void tick();
    /**
     * renders the object to the screen
     * @param g the <code>Graphics</code> context
     */
    public abstract void render(Graphics g);

    /**
     * Gets the x value
     * @return the x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Makes the object appear in a new x position
     * @param x the x coordinate to move to
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y value
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Makes the object appear in a new y position
     * @param y the y coordinate to move to
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the id of the object
     */
    public long getId() {
        return id;
    }

    /**
     * @param velX the velX to set
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * @param velY the velY to set
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }
    

}
