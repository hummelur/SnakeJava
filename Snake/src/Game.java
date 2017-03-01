import GameObjects.Board;
import GameObjects.GameObjects;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by filipolsen on 2017-02-20.
 */
public class Game extends Canvas implements Runnable{

    private Window window;
    private Thread thread;
    private Board board;
    private PlayerHandler ph;
    public static GameObjects food;
    private boolean running = false;

    // GameLoop variables
    double interpolation = 0;
    final int TICKS_PER_SECOND = 60;
    final int SKIP_TICKS = 1000/TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    public static void main(String[] args){
        Thread t1 = new Thread(new Game());
        t1.start();
    }

    public Game(){
        window = new Window(965, 988, "Snacke", this);
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
        board = new Board(0, 0, 960, 960);
        ph = new PlayerHandler(board, this);
        running = true;
    }

    public void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        double next_game_tick = System.currentTimeMillis();
        int loops;

        while(running){
            loops = 0;
            while(System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP){
                // Render and update

                render();

                next_game_tick += SKIP_TICKS;
                loops++;
            }
            interpolation = (System.currentTimeMillis() + SKIP_TICKS - next_game_tick / (double)SKIP_TICKS);
        }
        stop();
    }

    public void render(){
        // inits and gets the bufferstrategy
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0, getWidth(), getHeight());

        board.render(g);
        ph.update();
        ph.food.render(g);

        g.dispose();
        bs.show();
    }
}
