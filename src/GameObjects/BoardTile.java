package GameObjects;

import java.awt.*;

/**
 * Created by filipolsen on 2017-02-20.
 */
public class BoardTile implements GameObjects{
    private int posx, posy, WIDTH, HEIGHT, SCALE;
    public BoardTile(int posx, int posy, int WIDTH, int HEIGHT, int SCALE){

        this.posx = posx;
        this.posy = posy;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.SCALE = SCALE;

    }

    @Override
    public int getX() {
        return posx;
    }

    @Override
    public int getY() {
        return posy;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public void setX(int posx) {
        this.posx = posx;
    }

    @Override
    public void setY(int posy) {
        this.posy = posy;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(posx * SCALE, posy * SCALE, WIDTH, HEIGHT);
    }
}

