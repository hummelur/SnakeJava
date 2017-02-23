package GameObjects;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by filipolsen on 2017-02-20.
 */
public class Player implements GameObjects {

    private GameObjects pos;
    private Tail[] tailArray = new Tail[0];
    private int tailTotal = 0;

    public Player(GameObjects bt){
        this.pos = bt;
    }


    @Override
    public int getX() {
        return pos.getX();
    }

    @Override
    public int getY() {
        return pos.getY();
    }

    @Override
    public int getWidth() {
        return pos.getWidth();
    }

    @Override
    public int getHeight() {
        return pos.getHeight();
    }

    @Override
    public void setX(int posx) {
        pos.setX(posx);
    }

    @Override
    public void setY(int posy) {
        pos.setY(posy);
    }

    @Override
    public String getType() {
        return "Player";
    }

    public void eatFood(){
       addTail();
    }

    public void addTail(){
        tailTotal++;
        tailArray = addTailToArray(tailArray,
                    new Tail(pos.getX(), pos.getY(), pos.getWidth(), pos.getHeight(), pos.getHeight()));
    }

    private Tail[] addTailToArray(Tail[] t, Tail addTail){
        t = Arrays.copyOf(t, t.length + 1);
        t[t.length - 1] = addTail;
        return t;
    }

    public void update(){
        // Shift the array with a new position for the tail
        if(tailTotal != 0) {
            if (tailTotal == tailArray.length) {
                System.out.println(tailArray.length);
                for (int i = 0; i < tailArray.length - 1; i++) {
                    tailArray[i] = tailArray[i + 1];
                }
            }
            // adds the tail
            tailArray[tailTotal - 1] = new Tail(pos.getX(), pos.getY(), pos.getWidth(), pos.getHeight(), pos.getWidth());
        }
    }

    @Override
    public void render(Graphics g) {
        int SCALE = pos.getHeight();
        for(Tail t : tailArray){
            t.render(g);
        }
        g.setColor(Color.GREEN);
        g.fillRect(pos.getX() * SCALE, pos.getY() * SCALE,pos.getWidth(), pos.getHeight());
    }
}
