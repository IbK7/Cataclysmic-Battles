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
package com.blp.nova.main;

import com.blp.nova.Game;
import com.blp.nova.core.CoreObject;
import com.blp.nova.entity.Player;
import com.blp.nova.libs.Identities;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Camera
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Camera {
    
    private float x, y;
    private Player player;
    
    /**
     * Constructs a new camera to follow the player
     * @param x by default it is recommended you set this to 0
     * @param y by default it is recommended you set this to 0
     */
    public Camera(float x, float y){
        this.x = x;
        this.y = y;
        for(CoreObject obj : Game.getInstance().getController().getObjects())
            if(obj.getId() == Identities.PLAYER)
                player = (Player) obj;
    }
    
    /**
     * Updates the camera's x value so it can follow the player<p>
     * <strong>Algorithm</strong> used: Tweaning = <br><code>x += (target - value) * constant</code>
     */
    public void tick(){
        x += ((-player.getX() + Game.WIDTH / 2) - x) * 0.0275f;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }
    
    

}
