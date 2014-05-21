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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> KeyInput
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class KeyInput extends KeyAdapter {
    
    private static boolean[] keys = new boolean[256];
    
    @Override
    /**
     * This is called when ever we push a button on our keyboard
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = true;
    }
    
    @Override
    /**
     * This is called when ever we release a button on our keyboard
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = false;
    }
    
    public static boolean getKey(int key){
        return keys[key];
    }
    
    

}
