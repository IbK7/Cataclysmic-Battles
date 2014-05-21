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
import com.blp.nova.entity.Player;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Camera
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Camera {

    private float  x = 0, y = 0;

    /**
     * Updates the camera's x value so it can follow the player
     * Algorithm used: Tweaning = x += (target - value) * constant
     */
    public void tick(Player player) {
        x += ((-player.getX() + Game.WIDTH / 2) - x) * 0.0275f;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
