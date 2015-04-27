package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import gfx.Assets;

/**
 * Created by Adam on 15/04/2015.
 */
public class Tile {

    //Static stuff

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile waterTile = new WaterTile(1);
    public static Tile wallTile  = new WallTile(2);

    //Class

    protected BufferedImage texture;
    protected final int id;

    public static final int TILEWIDTH = 80,
                            TILEHEIGHT = 80;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
