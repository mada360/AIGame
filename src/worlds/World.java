package worlds;

import java.awt.*;
import tiles.Tile;
/**
 * Created by Adam on 15/04/2015.
 */
public class World {

    private int width, height;
    private int[][] tiles;

    public World(String path){
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics g){
        for(int y = 0; y < height; y++){
            for(int x = 0; y < width; x++){
                getTile(x,y).render(g, x* Tile.TILEWIDTH, y* Tile.TILEHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.waterTile;
        return t;
    }

    private void loadWorld(String path){

    }

}
