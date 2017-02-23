import javax.swing.*;
import java.awt.*;

/**
 * Created by filipolsen on 2017-02-20.
 */

public class Window extends Canvas {
    public Window(int WIDTH, int HEIGHT, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();
    }
}
