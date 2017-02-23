package GameObjects;

import java.awt.*;

/**
 * Created by filipolsen on 2017-02-20.
 */
public interface GameObjects {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void setX(int posx);
    void setY(int posy);
    String getType();
    void render(Graphics g);
}
