package states;

import java.awt.*;
import AIGame.Game;

/**
 * Created by Adam on 14/04/2015.
 */
public abstract class State {

    public abstract void tick();
    public abstract void render(Graphics g);

    private static State currentState = null;

    protected Game game;

    public State(Game game){
        this.game = game;
    }

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }
}
