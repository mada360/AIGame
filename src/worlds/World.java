package worlds;

import java.awt.*;

import Utils.Utils;
import tiles.Tile;
/**
 * Created by Adam on 15/04/2015.
 */
public class World {

    private int width, height, spawnX, spawnY;
    private int[][] tiles;

    public World(String path){
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics g){
        for(int y = 0; y < height - 1; y++){
            for(int x = 0; y < width -1 ; x++){
                getTile(x,y).render(g, x* Tile.TILEWIDTH, y* Tile.TILEHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

}
