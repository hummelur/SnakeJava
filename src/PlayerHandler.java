import GameObjects.GameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import GameObjects.Board;
import GameObjects.Player;

/**
 * Created by filipolsen on 2017-02-20.
 */
public class PlayerHandler implements KeyListener{

    // The direction of the snake
    private enum Dir{
        Down,
        Up,
        Left,
        Right
    };
    private int tickPast = 0;
    private int maxTick = 10;

    private Dir CurrentDir = Dir.Right;
    private Player player;
    private Game game;


    public PlayerHandler(Board board, Game game){
        this.game = game;
        this.player = board.getPlayer();
        player.setX(0);
        player.setY(0);
        game.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println(e.getKeyChar());
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            CurrentDir = Dir.Down;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            CurrentDir = Dir.Up;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            CurrentDir = Dir.Left;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            CurrentDir = Dir.Right;
        } else if(e.getKeyCode() == KeyEvent.VK_E){
            player.eatFood();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void update(){
        tickPast++;
        if(maxTick <= tickPast){
            tickPast = 0;
            player.update();
            setSquare(CurrentDir);
        }

        System.out.println(tickPast);

    }

    public void setSquare(Dir dir){
        if(dir == Dir.Down){
            player.setY(player.getY() + 1);
        } else if (dir == Dir.Up){
            player.setY(player.getY() - 1);
        } else if(dir == Dir.Right){
            player.setX(player.getX() + 1);
        } else {
            player.setX(player.getX() - 1);
        }
    }
}

