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
package com.blp.nova.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.blp.nova.Game;


/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Renderer
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Renderer {

    /**
     * Renders the background of the game
     * <br>This includes things that will not effect or interact with the player
     * @param g the Graphics context of our <strong> <code> Game class </strong> </code>
     */
    public void renderBackground(Graphics g) {
        switch(Game.state){
            case GAME:
                break;
            case MENU:
                Game.getInstance().getMenu().render(g);
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                g.setColor(Color.RED);
                g.drawString("UNKNOWN GAMESTATE", 150, 150);
                break;
            
        }
    }

    /**
     * Renders the foreground of the game
     * <br>This includes things that will effect or interact with the player
     * @param g the Graphics context of our <strong> <code> Game class </strong> </code>
     */
    public void renderForeground(Graphics g) {

    }

}
