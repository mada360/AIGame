package gfx;


import java.awt.image.BufferedImage;

/**
 * Created by Adam on 13/04/2015.
 */
public class Assets {

    private static final int size = 50;
    private static final int width = size, height = size;

    public static BufferedImage ground, grass, smell, water, treasure, fog, none, trap, goal;

    public static void init(){
        SpriteSheet dungeonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/dungeonSprites.png"));

        grass    = dungeonSheet.crop(0,       0,        size, size);
        none     = dungeonSheet.crop(width,   0,        size, size);
        fog      = dungeonSheet.crop(width*2, 0,        size, size);
        ground   = dungeonSheet.crop(0,       height,   size, size);
        water    = dungeonSheet.crop(width,   height,   size, size);
        treasure = dungeonSheet.crop(width*2, height,   size, size);
        trap     = dungeonSheet.crop(0,       height*2, size, size);
        goal     = dungeonSheet.crop(width,   height*2, size, size);
        smell    = dungeonSheet.crop(width*2, height*2, size, size);
    }

    public static BufferedImage getTile(char tileType){
        BufferedImage Image;

        switch (tileType){
            case 'g':
                Image = grass;
                break;
            case 'n':
                Image = none;
                break;
            case 'f':
                Image = fog;
                break;
            case 'd': //dirt
                Image = ground;
                break;
            case 'w':
                Image = water;
                break;
            case 't':
                Image = treasure;
                break;
            case 's': //spike
                Image = trap;
                break;
            case 'e': //end
                Image = goal;
                break;
            case 'o': //odour
                Image = smell;
                break;
            default:
                Image = none;
        }

        return Image;
    }
}
