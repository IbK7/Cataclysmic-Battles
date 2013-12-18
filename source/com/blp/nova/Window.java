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
package com.blp.nova;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.blp.nova.libs.Reference;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Window
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Window {
    private static JFrame frame;
    
    public static void initWindow(String title){
        frame = new JFrame(title);
    }
    
    public static void addGame(Game game){
        frame.add(game);
    }
    
    public static void createWindow(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "icon3.png");  //This is the image we will be using as our window's icon
        Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION + "cursor.gif");
        frame.setIconImage(icon); //sets the icon we specified above
        frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
        frame.setSize(Game.WIDTH, Game.HEIGHT); //sets the size of our window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes it so that when we click the red X (on windows, red circle i guess for macs) we then exit the game
        frame.setFocusable(true); //This way we are able to use keyboards and our mouse and all that good stuff
        frame.setLocationRelativeTo(null); //makes our frame start in the center of our screen
        frame.setResizable(false); //for now, if we resize our window, we will get a lot of bugs with the graphics
        frame.setVisible(true); //This actually shows the frame/window
        frame.pack(); //packs all our components and settings into one nice frame package (metaphorical of course)
    }
    
    public static void setTitle(String title){
        frame.setTitle(title);
    }
    

}
