import javax.swing.*;
import java.awt.*;

/**
 * Created by filipolsen on 2017-02-20.
 */

public class Window extends Canvas {
    public Window(int WIDTH, int HEIGHT, String title, Game game){
        JFrame frame = new JFrame(title);
        Dimension d = new Dimension(WIDTH, HEIGHT + (HEIGHT / 16 - 20));
        frame.setMinimumSize(d);
        frame.setPreferredSize(d);
        frame.setMaximumSize(d);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();
    }
}
