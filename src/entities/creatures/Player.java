package entities.creatures;

import gfx.Assets;

import java.awt.*;
import AIGame.Game;
/**
 * Created by Adam on 14/04/2015.
 */
public class Player extends Creature{

    private Game game;

    public Player(Game game, int x, int y) {
        super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput(){

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.none, (int)x, (int)y, width, height, null);
    }
}
