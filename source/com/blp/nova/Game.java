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

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.blp.nova.enums.GameState;
import com.blp.nova.gfx.Renderer;
import com.blp.nova.input.MouseInput;
import com.blp.nova.libs.Reference;
import com.blp.nova.screens.Menu;
import com.blp.nova.utils.ResourceLoader;


/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Game
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Game extends Canvas implements Runnable {

/**
 * Docs for serialVersionUID came from <code> java.io.Serializable </code>
 * <br><br>
 * The serialization runtime associates with each serializable class a version
 * number, called a serialVersionUID, which is used during deserialization to
 * verify that the sender and receiver of a serialized object have loaded
 * classes for that object that are compatible with respect to serialization.
 * If the receiver has loaded a class for the object that has a different
 * serialVersionUID than that of the corresponding sender's class, then
 * deserialization will result in an {@link InvalidClassException}.  A
 * serializable class can declare its own serialVersionUID explicitly by
 * declaring a field named <code>"serialVersionUID"</code> that must be static,
 * final, and of type <code>long</code>:<p>
 *
 * <PRE>
 * ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
 * </PRE>
 *
 * If a serializable class does not explicitly declare a serialVersionUID, then
 * the serialization runtime will calculate a default serialVersionUID value
 * for that class based on various aspects of the class, as described in the
 * Java(TM) Object Serialization Specification.  However, it is <em>strongly
 * recommended</em> that all serializable classes explicitly declare
 * serialVersionUID values, since the default serialVersionUID computation is
 * highly sensitive to class details that may vary depending on compiler
 * implementations, and can thus result in unexpected
 * <code>InvalidClassException</code>s during deserialization.  Therefore, to
 * guarantee a consistent serialVersionUID value across different java compiler
 * implementations, a serializable class must declare an explicit
 * serialVersionUID value.  It is also strongly advised that explicit
 * serialVersionUID declarations use the <code>private</code> modifier where
 * possible, since such declarations apply only to the immediately declaring
 * class--serialVersionUID fields are not useful as inherited members. Array
 * classes cannot declare an explicit serialVersionUID, so they always have
 * the default computed value, but the requirement for matching
 * serialVersionUID values is waived for array classes.
 */
    private static final long serialVersionUID = -1890564841829395437L;
    
    private static JFrame frame = new JFrame();  //Our window object
    public static final int WIDTH = 640;  //The width of our window
    public static final int HEIGHT = WIDTH / 4 * 3;  //Creates a nice 4:3 ratio for our window
    public static final String TITLE = "Cataclysmic Battles";  //The title of our game
    private static Game game = new Game();  //The instance of our game that we will be using
    public static GameState state = GameState.MENU;  //We start in this game state

    private boolean running = false;  //by default, we need this to be false so we do not exit our start method right away
    private Thread thread;  //the thread that will control our game loop
    private Renderer gfx;  //an object of our renderer class
    private Menu menu;  //our menu object
    
    
    /**
     * Used to access the Game class <i>non-static members</i>
     * @return the instance of the game
     */
    public static Game getInstance(){
        return game;
    }
    
    public Menu getMenu(){
        return menu;
    }

    /**
     * Acts as the constructor for the game
     * <br> I simply prefer it this way <br>
     * <strong> This initializes the game objects, resources, listeners, etc </strong>
     */
    public void init() {
        ResourceLoader.loadImages();  //Loads our images and sprites
        ResourceLoader.loadFonts();  //Loads our fonts
        menu = new Menu();  //creates our menu
        gfx = new Renderer();  //initializes our renderer
        MouseInput mouse = new MouseInput();  //local mouse input object is used instead of an anonymous inner type so we may have multiple mouse listeners working together better
        this.addMouseListener(mouse); //adds a listener to listen for clicking of mouse buttons
        this.addMouseMotionListener(mouse);  //adds a listener to listen for mouse motion

    }

    /**
     * Updates the objects in the game <br>
     * This also runs the <strong> <i> logic </i> </strong> in the game
     */
    public void tick() {

    }



    /**
     * This <strong> <i> renders the graphics </strong> </i> for the game
     * <p> This method uses a <strong> <i> triple buffering strategy </strong> </i> with a default background of a darkish purple
     */
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);  //Creates the buffer strategy if there isn't already one
            return;
        }

        Graphics g = bs.getDrawGraphics(); //We want to use the graphics that comes from our buffer strategy
        g.setColor(new Color(6, 0, 40));  
        g.fillRect(0, 0, WIDTH, HEIGHT);  //We are creating a background for our game here

        ///////////////////////////////////////////////////

        gfx.renderBackground(g);
        gfx.renderForeground(g);
        
        g.dispose();  //Disposes our graphics context (if we did not do this, animations would not work properly, it would also eat up a lot of memory
        bs.show();  //Shows whatever graphics were just disposed of

    }

    @Override
    /**
     * This is our main <strong> <i> game loop </strong> </i> that we are able to use thanks to the <strong> Runnable Interface </strong>
     */
    public void run() {
        init(); //Initializes our game
        long lastTime = System.nanoTime();  //gets the time before the loop
        final double numTicks = 60.0;  //We want to have 60 updates per second, too much and we will lag like a mofo, too litle and it will appear as though nothing is happening in the game
        double n = 1000000000 / numTicks;  
        double delta = 0;  //change over time
        int frames = 0;  //frames during that second
        int ticks = 0;  //ticks or updates during that second
        long timer = System.currentTimeMillis();  //We will be using this as, well, a timer

        while (running) {  //we only want to do this stuff if and only if the game is running
            long currentTime = System.nanoTime();  //the current time during the game loop
            delta += (currentTime - lastTime) / n;  //because the time is changing, we need to update our delta
            lastTime = currentTime;  /* Our last time now needs to be the previous time during the game loop, we do this by storing the current time, 
                                        this is why this goes AFTER the previous two lines */

            if (delta >= 1) { //We want to make sure our delta doesn't remain over 1
                tick();  //updates the game
                ticks++;  //Adds to the ticks per second
                delta--; //Lowering the delta value for the next run through
            }

            render();  //renders the game
            frames++;  //Adds to the frames per second

            if (System.currentTimeMillis() - timer > 1000) {  //We are going to print our frames and ticks to the console every second
                timer += 1000;  //Time must go on!
                System.out.println(ticks + " Ticks, FPS: " + frames);  //Prints the TPS and FPS to the console
//                frame.setTitle(TITLE + "        Ticks: " + ticks + "    FPS: " + frames);   //Use this if you have your frame as a class attribute and wish to have the FPS and TPS in your title bar
                ticks = 0;  //If we did not do these 2 lines, we would have 10000000000000000000 ticks and fps at one point, then another 10000000000000000000000000000000000000000 the next second
                frames = 0;
            }
        }
        stop(); //Once exit the loop, stop the game
    }

    public static void main(String args[]) {
        Image icon = Toolkit.getDefaultToolkit().getImage(Reference.RESOURCE_LOCATION + "icon2.png");  //This is the image we will be using as our window's icon
        frame.add(game);  //adds our game as a component to the frame
        frame.setTitle(TITLE); //sets the title
        frame.setIconImage(icon); //sets the icon we specified above
        frame.setSize(WIDTH, HEIGHT); //sets the size of our window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes it so that when we click the red X (on windows, red circle i guess for macs) we then exit the game
        frame.setFocusable(true); //This way we are able to use keyboards and our mouse and all that good stuff
        frame.setLocationRelativeTo(null); //makes our frame start in the center of our screen
        frame.setResizable(false); //for now, if we resize our window, we will get a lot of bugs with the graphics
        frame.setVisible(true); //This actually shows the frame/window
        frame.pack(); //packs all our components and settings into one nice frame package (metaphorical of course)
        game.start(); //starts the game

    }

    /**
     * This starts the game thread
     * <br> It is <strong> <i> synchronized </strong> </i> because we do not want to do anything else until this method is <strong> <i> 100% complete
     */
    private synchronized void start() {
        if (running) //if the game is already running, we do not want to run the game again
            return;
        else
            running = true;
        thread = new Thread(this);  //this thread controls our game
        thread.start();  //starts the thread, and thus the game loop
    }

    /**
     * This stops the game thread
     * <br> It is <strong> <i> synchronized </strong> </i> because we do not want to do anything else until this method is <strong> <i> 100% complete
     */
    private synchronized void stop() {
        if (!running)  //if the game has already stopped, why stop it again?
            return;
        else
            running = false;

        try {
            thread.join();  //a good way of closing a thread
        } catch (InterruptedException e) {
            e.printStackTrace();  //it has a chance of failing, so we need to catch the exception and report it to the console
        }

        System.exit(1);  //exits the game
    }

}
