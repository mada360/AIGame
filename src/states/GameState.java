package states;

import KB.KBWorld;
import entities.creatures.Player;
import worlds.World;

import java.awt.*;
import AIGame.Game;
/**
 * Created by Adam on 14/04/2015.
 */
public class GameState extends State{

    private Player player;
    private World world;

    KBWorld KB = new KBWorld();

    public GameState(Game game){
        super(game);
        player = new Player(game, KB.getPlayerX(), KB.getPlayerY());
        world = new World("res/worlds/world1.txt");
    }



    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);

    }

}
