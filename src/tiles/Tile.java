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

    //Background tiles
    public static Tile grassTile = new GrassTile(0);
    public static Tile noneTile = new NoneTile(1);
    public static Tile fogTile  = new FogTile(2);
    public static Tile groundTile  = new GroundTile(3);
    public static Tile waterTile  = new WaterTile(4);
    public static Tile treasureTile  = new TreasureTile(5);
    public static Tile trapTile  = new TrapTile(6);
    public static Tile goalTile  = new GoalTile(7);
    public static Tile smellTile  = new SmellTile(8);

    //Creature tiles
    public static Tile PlayerTile = new PlayerTile(9);
    //Need to be implemented
 /*   public static Tile Tile = new NoneTile(10);
    public static Tile Tile  = new FogTile(11);
    public static Tile Tile  = new GroundTile(12);
    public static Tile Tile  = new WaterTile(13);
    public static Tile Tile  = new TreasureTile(14);
    public static Tile Tile  = new TrapTile(15);
    public static Tile Tile  = new GoalTile(16);
    public static Tile Tile  = new SmellTile(17);*/

    private static boolean walkable = true;


    //Class

    protected BufferedImage texture;
    protected final int id;

    public static final int TILEWIDTH = 50,
                            TILEHEIGHT = 50;

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

    public static boolean isWalkable() {
        return walkable;
    }

}
