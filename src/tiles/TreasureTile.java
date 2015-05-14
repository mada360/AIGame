package tiles;

/**
 * Created by Adam on 15/04/2015.
 */
import gfx.Assets;

public class TreasureTile extends Tile {

    private static boolean found = false;

    public TreasureTile(int id) {
        super(Assets.treasure, id);
    }

    public boolean isFound(){
        return found;
    }

    public void setFound(){
        found = true;
    }

}


