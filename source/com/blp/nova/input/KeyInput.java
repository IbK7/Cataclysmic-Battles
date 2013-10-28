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

import com.blp.nova.Controller;
import com.blp.nova.Game;
import com.blp.nova.core.CoreObject;
import com.blp.nova.entity.Player;
import com.blp.nova.libs.Identities;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> KeyInput
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class KeyInput extends KeyAdapter {
    
    /**
     * We will set this to our actual player, in the constructor
     * <br>We have this so we can easily access methods such as <code>setVelX(int)</code>
     *  and <code>setVelY(int)</code>
     */
    private Player player;
    
    private boolean[] keyDown = new boolean[2];  //Set this to however many keys you wish to have smooth movement for, for the time being, I am only checking A and D
                                                  //I may add the W for jumping later on
    
    /**
     * Used to initialize attributes in the <code>KeyInput</code> class
     */
    public KeyInput(){
        for(CoreObject obj : Controller.getObjects()){    //Runs through the entire array list (for each CoreObject in the array list, do this)
            if(obj.getId() == Identities.PLAYER)          //If the objects ID is equal to Identities.PLAYER (1) then do this
                player = (Player) obj;                    //Sets our player attribute(above) to the object in our Controller
        }
    }
    
    @Override
    /**
     * This is called when ever we push a button on our keyboard
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(Game.state){
            case GAME:
                if(key == KeyEvent.VK_W)
                    player.setVelY(-5);      //because coordinates start from bottom down(y values), we need to subtract a value to go up
                if(key == KeyEvent.VK_A){
                    player.setVelX(-5);
                    keyDown[0] = true;  //set the booleans to true!
                }
                if(key == KeyEvent.VK_D){
                    player.setVelX(5);
                    keyDown[1] = true;
                }
                break;
            case MENU:
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                break;
            
        }
    }
    
    @Override
    /**
     * This is called when ever we release a button on our keyboard
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(Game.state){
            case GAME:
                if(key == KeyEvent.VK_W)
                    player.setVelY(0);
                if(key == KeyEvent.VK_A)
                    keyDown[0] = false;  //if you only set the velocity here, it will freeze for a bit if you try to switch to D too quickly
                if(key == KeyEvent.VK_D)
                    keyDown[1] = false;
                
                if(keyDown[0] && !keyDown[1])  //Do this if our A is still pushed
                    player.setVelX(-5);
                if(!keyDown[0] && keyDown[1])  //If D is still pushed
                    player.setVelX(5);
                if(!keyDown[0] && !keyDown[1])  //If neither are pushed
                    player.setVelX(0);
                
                
                break;
            case MENU:
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
