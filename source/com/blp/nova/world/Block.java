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
package com.blp.nova.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import com.blp.nova.gfx.textures.Sprite;
import com.blp.nova.gfx.textures.SpriteSheet;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 * 
 * <strong>Class:</strong> Block
 * 
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 * 
 */
public class Block {

    private static final SpriteSheet sheet = new SpriteSheet("terrain.png");

    private static Map<Integer, Block> blockMap = new HashMap<Integer, Block>(); //so we can remember the IDs and blocks/sprites associated with it
    private int id;
    private int x;
    private int y;
    private Sprite sprite;

    public static final Block block1 = new Block(0xFFFFFFFF, new Sprite(1, 1, 32, sheet));
    public static final Block block2 = new Block(0xFFFF0000, new Sprite(2, 1, 32, sheet));

    private Block(int id, Sprite sprite) { //yeah, I know, we need a better system, it will be better once I find a way to make collision be friendly when there is 
                                           // only 1 object of each type, just being renderered multiple times
        this.id = id;
        this.sprite = sprite;
        blockMap.put(id, this);
    }

    public Block(int id, int x, int y) {
        this.sprite = getFromID(id);
        this.x = x * 32;
        this.y = y * 32;
    }

    public void render(Graphics g) {
        sprite.render(g, x, y);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getTop() {
        return new Rectangle(x + 4, y, 24, 4);
    }

    public Rectangle getBottom() {
        return new Rectangle(x + 4, y + 28, 24, 4);
    }

    public Rectangle getRight() {
        return new Rectangle(x, y, 4, 32);
    }

    public Rectangle getLeft() {
        return new Rectangle(x + 28, y, 4, 32);
    }

    public static Sprite getFromID(int id) {
        if (blockMap.get(id) != null) return blockMap.get(id).sprite;
        return null;
    }

}
