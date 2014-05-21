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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> MouseInput
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class MouseInput extends MouseAdapter {
    
    public static final int  BUTTON_LEFT  = 0x1;
    public static final int  BUTTON_RIGHT = 0x3;

    private static boolean[] buttons      = new boolean[5];
    public static int clickX, clickY, hoverX, hoverY, pressX, pressY;
    
    

    @Override
    /**
     * This method is called whenever a mouse button is clicked
     */
    public void mouseClicked(MouseEvent e) {
        int mouse = e.getButton(); //used to check what button was clicked
        clickX = e.getX();
        clickY = e.getY();
    }

    @Override
    /**
     * This is called while we have a mouse button held down
     */
    public void mousePressed(MouseEvent e) {
        pressX = e.getX();
        pressY = e.getY();
        buttons[e.getButton()] = true;
    }

    @Override
    /**
     * This is called whenever we release the mouse button
     */
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;

    }

    

}
