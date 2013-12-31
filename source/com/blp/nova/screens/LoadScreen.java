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
package com.blp.nova.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.blp.nova.Game;
import com.blp.nova.libs.Images;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> LoadScreen
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class LoadScreen {
    private static int width = 540;
    private static int numResources = 8;
    private static int loadAdd = width / numResources;
    private static int loadStatus = 0;
    
    private static String msg = "Loading resources...";
    
    /**
     * Renders the graphics of the loading screen
     * @param g the <code>Graphics</code> context
     */
    public static void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.loading, 0, 0, null);
        g.setColor(Color.RED);
        g.drawRect(49, 399, width, 51); //draws the outline of the bar
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString(msg, 51, 395);
        g.setColor(Color.BLUE);
        g.fillRect(50, 400, loadStatus, 50); //fills in the bar as resources are loaded
    }
    
    /**
     * Fills in the blue loading bar
     */
    public static void loadMore(){
        loadStatus += loadAdd;
    }
    
    /**
     * Sets the message to be displayed above the loading bar
     * @param msg the message to be displayed
     */
    public static void setMessage(String msg){
        LoadScreen.msg = msg;
    }
    
    

}
