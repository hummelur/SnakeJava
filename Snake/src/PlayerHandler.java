import GameObjects.*;

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
    private int maxTick = 14;

    private Dir CurrentDir = Dir.Right;
    private Player player;
    private Game game;
    private boolean alive = true;

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
            // Checks if the player pos should be on the other side of the screen when hitting the wall
            screenWrap();
            // Checks if the player collides with the tail
            if(tailCollisionCheck()){
                alive = false;
            }
        }
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

    public boolean tailCollisionCheck(){
        if(player.getTailArray().length > 0){
            for (Tail tail : player.getTailArray()){
                System.out.println(tail.getX());
                if(tail.getX() == player.getX() && tail.getY() == player.getY()){
                    player.resetTailArray();
                    return true;
                }
            }
        }
        return false;
    }

    private void screenWrap(){
        if(player.getX() > 15){
            player.setX(0);
        } else if(player.getY() > 15){
            player.setY(0);
        } else if(player.getX() < 0){
            player.setX(16);
        } else if(player.getY() < 0){
            player.setY(16);
        }
    }
}

