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
package com.blp.nova.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.blp.nova.Game;
import com.blp.nova.enums.GameState;

/**
 * Project: CataclysmicBattles - 
 *
 * Class: MouseInput
 *
 * @author BossLetsPlays
 *
 */
public class MouseInput extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouse = e.getButton();
        Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);

        if (mouse == MouseEvent.BUTTON1) {

            switch (Game.state) {
                case GAME:
                    break;
                case MENU:
                    if (rect.intersects(Game.getInstance().menu.play))
                        Game.state = GameState.GAME;
                    break;
                case OPTIONS:
                    break;
                case PAUSE:
                    break;
                default:
                    break;

            }
        }
    }

}
