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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.blp.nova.gfx.Textures;

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
    protected float x;
    /**
     * The y coordinate of the object on screen
     */
    protected float y;
    
    /**
     * The velocity at which the object moves horizontally
     */
    protected float velX;
    /**
     * The velocity at which the object moves vertically
     */
    protected float velY;
    
    /**
     * The ID of the object, used to obtain the object in an array
     */
    protected int id;
    /**
     * The width of the object, used with collision
     */
    protected int width;
    /**
     * The height of the object, used with collision
     */
    protected int height;
    /**
     * An object that contains the game's textures
     */
    protected Textures tex;
    protected BufferedImage image;
    
    /**
     * Creates a new object, however because this is an abstract class, you must make a core object equal a <strong>sub type!</strong>
     * @param x the x coordinate of the object on screen
     * @param y the y coordinate of the object on screen
     * @param id the ID of the object
     * @param tex the Textures object that contains the images or textures of the entities and objects
     */
    public CoreObject(float x, float y, int id, Textures tex){
        this.x = x;
        this.y = y;
        this.id = id;
        this.tex = tex;
    }
    
    /**
     * Creates a new object, however because this is an abstract class, you must make a core object equal a <strong>sub type!</strong>
     * @param x the x coordinate of the object on screen
     * @param y the y coordinate of the object on screen
     * @param id the ID of the object
     * @param image the BufferedImage of the object
     */
    public CoreObject(float x, float y, int id, BufferedImage image){
        this.x = x;
        this.y = y;
        this.id = id;
        this.image = image;
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
     * Gets the upper bounds of the object
     * @return a rectangle representing the upper bounds
     */
    public Rectangle getTopBounds(){
        return new Rectangle((int)x, (int)y, width, 12);
    }
    
    /**
     * Gets the lower bounds of the object
     * @return a rectangle representing the lower bounds
     */
    public Rectangle getBottomBounds(){
        return new Rectangle((int)x, (int)y + (height - 6), width, 12);
    }
    
    /**
     * Gets the right bounds of the object
     * @return a rectangle representing the right bounds
     */
    public Rectangle getRightBounds(){
        return new Rectangle((int)x + (width - 6), (int)y, 6, height);
    }
    
    /**
     * Gets the left bounds of the object
     * @return a rectangle representing the left bounds
     */
    public Rectangle getLeftBounds(){
        return new Rectangle((int)x, (int)y, 6, height);
    }
    
    

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
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y value
     * @return the y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Makes the object appear in a new y position
     * @param y the y coordinate to move to
     */
    public void setY(float y) {
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
    public void setVelX(float velX) {
        this.velX = velX;
    }

    /**
     * @param velY the velY to set
     */
    public void setVelY(float velY) {
        this.velY = velY;
    }




    /**
     * @return the width of the object
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }




    /**
     * @return the height of the object
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * @param width the width to set
     * @param height the height to set
     */
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
    

}
