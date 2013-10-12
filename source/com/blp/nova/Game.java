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
 * Project: CataclysmicBattles - 
 *
 * Class: Game
 *
 * @author BossLetsPlays
 *
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = -1890564841829395437L;
    private static JFrame frame = new JFrame();
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 4 * 3;
    public static final String TITLE = "Cataclysmic Battles";
    private static Game game = new Game();
    public static GameState state = GameState.MENU;

    private boolean running = false;
    private Thread thread;
    private Renderer gfx;
    public Menu menu;
    
    
    
    public static Game getInstance(){
        return game;
    }

    public void init() {
        ResourceLoader.loadImages();
        ResourceLoader.loadFonts();
        menu = new Menu();
        gfx = new Renderer();
        this.addMouseListener(new MouseInput());

    }

    public void tick() {

    }



    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(6, 0, 40));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        ///////////////////////////////////////////////////

        gfx.renderBackground(g);
        gfx.renderForeground(g);
        
        g.dispose();
        bs.show();

    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double numTicks = 60.0;
        double n = 1000000000 / numTicks;
        double delta = 0;
        int frames = 0;
        int ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / n;
            lastTime = currentTime;

            if (delta >= 1) {
                tick();
                ticks++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(ticks + " Ticks, FPS: " + frames);
//                frame.setTitle(TITLE + "        Ticks: " + ticks + "    FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
        }
        stop();
    }

    public static void main(String args[]) {
        Image icon = Toolkit.getDefaultToolkit().getImage(Reference.RESOURCE_LOCATION + "icon2.png");
        frame.add(game);
        frame.setTitle(TITLE);
        frame.setIconImage(icon);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        game.start();

    }

    private synchronized void start() {
        if (running)
            return;
        else
            running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running)
            return;
        else
            running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(1);
    }

}
