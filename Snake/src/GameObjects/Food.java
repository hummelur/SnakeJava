package GameObjects;

import java.awt.*;

/**
 * Created by Filips on 2017-02-28.
 */
public class Food implements GameObjects {

    private int posx, posy, SCALE;

    public Food(int x, int y, int SCALE){
        this.posx = x;
        this.posy = y;
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
        return SCALE;
    }

    @Override
    public int getHeight() {
        return SCALE;
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
        return "Food";
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(255, 90, 90));
        g.fillRect(posx * SCALE, posy * SCALE, SCALE, SCALE);
    }
}
