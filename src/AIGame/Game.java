package AIGame;

import display.Display;
import gfx.Assets;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.SettingsState;
import states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Adam on 13/04/2015.
 */
public class Game implements Runnable{

    private boolean running = false;
    private Display display;
    private Thread thread;
    private int size = 50;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;
    private State settingsState;

    //Input
    private KeyManager keyManager;

    public String title;
    public int width, height;


    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        settingsState = new SettingsState(this);
        State.setState(gameState);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear display
        g.clearRect(0, 0, width, height);

        //Begin drawing
        //BG
        g.setColor(Color.white);
        g.fillRect(0 , 0, width,height);

        if(State.getState() != null){
            State.getState().render(g);
        }

        //End Drawing
        bs.show();
        g.dispose();
    }

    public void run(){
        init();

        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public synchronized void start(){
        if(running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        } catch (InterruptedException e){
           e.printStackTrace();
        }
    }
}
