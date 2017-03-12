package GameObjects;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by filipolsen on 2017-02-20.
 */
public class Board implements GameObjects{

    private int posx, posy, WIDTH, HEIGHT;
    public List<GameObjects> boardTiles = new ArrayList<>();
    private Player player;

    public Board(int posx, int posy, int WIDTH, int HEIGHT){
        this.posx = posx;
        this.posy = posy;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        int SCALE_WIDTH = WIDTH / 16;
        int SCALE_HEIGHT = HEIGHT / 16;
        System.out.println(SCALE_WIDTH + " " + SCALE_HEIGHT);

        // Adds the tiles of the map
        for(int y = 0; y < 16; y++){
            for(int x = 0; x < 16; x++){
                if(x == 10 && y == 10){
                    player = new Player(boardTiles.get(8));
                }
                boardTiles.add(new BoardTile(x, y, SCALE_WIDTH, SCALE_WIDTH, SCALE_WIDTH));
            }
        }
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

    public Player getPlayer(){
        return player;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(posx, posy, WIDTH, HEIGHT);

        player.render(g);
    }
}
