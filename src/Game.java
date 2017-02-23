import GameObjects.Board;

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
    private boolean running = false;

    public static void main(String[] args){
        Thread t1 = new Thread(new Game());
        t1.start();
    }

    public Game(){
        window = new Window(600, 600, "Snacke", this);
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
        board = new Board(0, 0, 600, 600);
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
        while(running){
            render();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop();
    }

    public void render(){
        // Update the player
        ph.update();
        // inits and gets the bufferstrategy
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        board.render(g);

        g.dispose();
        bs.show();
    }
}
