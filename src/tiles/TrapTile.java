package tiles;

/**
 * Created by Adam on 15/04/2015.
 */
import gfx.Assets;

public class TrapTile extends Tile {

    private boolean triggered = false;

    public TrapTile(int id) {
        super(Assets.trap, id);
    }

    public boolean isTriggered(){
        return triggered;
    }

    public void setTriggered(){
        triggered = true;
    }

}
