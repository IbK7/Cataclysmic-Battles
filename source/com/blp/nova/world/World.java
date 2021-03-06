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
package com.blp.nova.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.blp.nova.entity.Coin;
import com.blp.nova.entity.Entity;
import com.blp.nova.entity.Player;
import com.blp.nova.libs.Reference;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> World
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class World {
    
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<Block> blocks = new ArrayList<Block>();
    
    private int width;
    private int height;
    private int[] pixels;
    
    public World(String path){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(Reference.SPRITE_LOCATION + "levels/" + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = image.getWidth();
        height = image.getHeight();
        pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //pixels[x + y * width] gives us the hex of the pixel at the x, y location on the file
                if(Block.getFromID(pixels[x + y * width]) != null) //only add the block if there is a non-null block
                    blocks.add(new Block(pixels[x + y * width], x, y));
            }
        }
        
        Coin coin1 = new Coin(100, 300, this);
        Coin coin2 = new Coin(100, 350, this);
        Coin coin3 = new Coin(150, 300, this);
        Coin coin4 = new Coin(150, 400, this);
    }
    
    public void tick(){
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).tick();
    }
    
    public void render(Graphics g){
        for(int i = 0; i < blocks.size(); i++)
            blocks.get(i).render(g);
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).render(g);
    }
    
    public void addEntity(Entity e){
        entities.add(e);
    }
    
    public ArrayList<Entity> getEntities(){
        return entities;
    }
    
    public ArrayList<Block> getBlocks(){
        return blocks;
    }
    
    
    public void removeEntity(int index){
        entities.remove(index);
    }
    public Player getPlayer(){
        for(Entity e : entities)
            if(e instanceof Player) return (Player) e;
        return null;
    }

}
