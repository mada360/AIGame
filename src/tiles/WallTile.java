package tiles;

/**
 * Created by Adam on 15/04/2015.
 */
import gfx.Assets;
public class WallTile extends Tile {

    public WallTile(int id){
        super(Assets.none,id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
