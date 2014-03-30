package space;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 * @author u11248
 */
public class GameDesign {
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image Space16;
    private Image ship96_96;
    private Sprite ship;
    public int shipseq001Delay = 200;
    public int[] shipseq001 = {0, 1, 2, 6, 7, 8, 3, 4, 5, 9, 10, 11};
    private Image SpaceTiled64_80;
    private Image fire40_16;
    private Sprite ponte;
    public int ponteseq001Delay = 200;
    public int[] ponteseq001 = {3, 6, 5};
    private Image boss1;
    private Sprite boss_1;
    public int boss_1seq001Delay = 200;
    public int[] boss_1seq001 = {0};
    private Sprite bullet;
    public int bulletseq001Delay = 200;
    public int[] bulletseq001 = {0, 1, 2, 3, 4, 5};
    private Image shot;
    private Image enemy3;
    private Sprite enemy_1;
    public int enemy_1seq001Delay = 200;
    public int[] enemy_1seq001 = {0, 1, 2, 5, 4, 3, 6, 7, 8};
    private Image enemy1;
    private Sprite enemy_2;
    public int enemy_2seq001Delay = 200;
    public int[] enemy_2seq001 = {0, 1, 2, 5, 4, 3, 6, 7, 8};
    private Sprite enemy_3;
    public int enemy_3seq002Delay = 200;
    public int[] enemy_3seq002 = {0, 1, 2, 5, 4, 3, 6, 7, 8};
    private Sprite fuel;
    public int fuelseq001Delay = 200;
    public int[] fuelseq001 = {0};
    private Image fuel32x32;
    private Image enemy2;
    private TiledLayer Map2;
    private Image Tiled_Complete;
    private TiledLayer Map1;
    private Image astrd;
    private Image asteroid;
    private Image life;
    private TiledLayer Map6;
    private TiledLayer Map7;
    private TiledLayer Map4;
    private TiledLayer Map5;
    private TiledLayer Map3;
    private TiledLayer Map8;
    private Image Tiled_2;
    private Image energy;
    private Sprite explode;
    public int explodeseq001Delay = 200;
    public int[] explodeseq001 = {6, 7, 8};
//</editor-fold>//GEN-END:|fields|0|
    
//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

    public Image getSpace16() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (Space16 == null) {//GEN-END:|1-getter|0|1-preInit
 // write pre-init user code here
            Space16 = Image.createImage("/img/Tiled.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
 // write post-init user code here
        return this.Space16;//GEN-BEGIN:|1-getter|2|
    }//GEN-END:|1-getter|2|







    public Image getShip96_96() throws java.io.IOException {//GEN-BEGIN:|3-getter|0|3-preInit
        if (ship96_96 == null) {//GEN-END:|3-getter|0|3-preInit
 // write pre-init user code here
            ship96_96 = Image.createImage("/img/ship96_96.png");//GEN-BEGIN:|3-getter|1|3-postInit
        }//GEN-END:|3-getter|1|3-postInit
 // write post-init user code here
        return this.ship96_96;//GEN-BEGIN:|3-getter|2|
    }//GEN-END:|3-getter|2|




    public Sprite getShip() throws java.io.IOException {//GEN-BEGIN:|4-getter|0|4-preInit
        if (ship == null) {//GEN-END:|4-getter|0|4-preInit
 // write pre-init user code here
            ship = new Sprite(getShip96_96(), 32, 32);//GEN-BEGIN:|4-getter|1|4-postInit
            ship.setFrameSequence(shipseq001);//GEN-END:|4-getter|1|4-postInit
 // write post-init user code here
        }//GEN-BEGIN:|4-getter|2|
        return ship;
    }//GEN-END:|4-getter|2|




    public Image getSpaceTiled64_80() throws java.io.IOException {//GEN-BEGIN:|6-getter|0|6-preInit
        if (SpaceTiled64_80 == null) {//GEN-END:|6-getter|0|6-preInit
 // write pre-init user code here
            SpaceTiled64_80 = Image.createImage("/img/Tiled.png");//GEN-BEGIN:|6-getter|1|6-postInit
        }//GEN-END:|6-getter|1|6-postInit
 // write post-init user code here
        return this.SpaceTiled64_80;//GEN-BEGIN:|6-getter|2|
    }//GEN-END:|6-getter|2|








    public Image getFire40_16() throws java.io.IOException {//GEN-BEGIN:|8-getter|0|8-preInit
        if (fire40_16 == null) {//GEN-END:|8-getter|0|8-preInit
            // write pre-init user code here
            fire40_16 = Image.createImage("/img/shot.png");//GEN-BEGIN:|8-getter|1|8-postInit
        }//GEN-END:|8-getter|1|8-postInit
        // write post-init user code here
        return this.fire40_16;//GEN-BEGIN:|8-getter|2|
    }//GEN-END:|8-getter|2|





    public Sprite getPonte() throws java.io.IOException {//GEN-BEGIN:|11-getter|0|11-preInit
        if (ponte == null) {//GEN-END:|11-getter|0|11-preInit
            // write pre-init user code here
            ponte = new Sprite(getSpaceTiled64_80(), 64, 16);//GEN-BEGIN:|11-getter|1|11-postInit
            ponte.setFrameSequence(ponteseq001);//GEN-END:|11-getter|1|11-postInit
            // write post-init user code here
        }//GEN-BEGIN:|11-getter|2|
        return ponte;
    }//GEN-END:|11-getter|2|



    public Image getBoss1() throws java.io.IOException {//GEN-BEGIN:|13-getter|0|13-preInit
        if (boss1 == null) {//GEN-END:|13-getter|0|13-preInit
            // write pre-init user code here
            boss1 = Image.createImage("/img/boss1.png");//GEN-BEGIN:|13-getter|1|13-postInit
        }//GEN-END:|13-getter|1|13-postInit
        // write post-init user code here
        return this.boss1;//GEN-BEGIN:|13-getter|2|
    }//GEN-END:|13-getter|2|



    public Sprite getBoss_1() throws java.io.IOException {//GEN-BEGIN:|14-getter|0|14-preInit
        if (boss_1 == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            boss_1 = new Sprite(getBoss1(), 64, 64);//GEN-BEGIN:|14-getter|1|14-postInit
            boss_1.setFrameSequence(boss_1seq001);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return boss_1;
    }//GEN-END:|14-getter|2|



    public Image getShot() throws java.io.IOException {//GEN-BEGIN:|16-getter|0|16-preInit
        if (shot == null) {//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
            shot = Image.createImage("/img/shot.png");//GEN-BEGIN:|16-getter|1|16-postInit
        }//GEN-END:|16-getter|1|16-postInit
        // write post-init user code here
        return this.shot;//GEN-BEGIN:|16-getter|2|
    }//GEN-END:|16-getter|2|



    public Sprite getBullet() throws java.io.IOException {//GEN-BEGIN:|17-getter|0|17-preInit
        if (bullet == null) {//GEN-END:|17-getter|0|17-preInit
            // write pre-init user code here
            bullet = new Sprite(getShot(), 8, 15);//GEN-BEGIN:|17-getter|1|17-postInit
            bullet.setFrameSequence(bulletseq001);//GEN-END:|17-getter|1|17-postInit
            // write post-init user code here
        }//GEN-BEGIN:|17-getter|2|
        return bullet;
    }//GEN-END:|17-getter|2|



    public Image getEnemy3() throws java.io.IOException {//GEN-BEGIN:|19-getter|0|19-preInit
        if (enemy3 == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            enemy3 = Image.createImage("/img/enemy3.png");//GEN-BEGIN:|19-getter|1|19-postInit
        }//GEN-END:|19-getter|1|19-postInit
        // write post-init user code here
        return this.enemy3;//GEN-BEGIN:|19-getter|2|
    }//GEN-END:|19-getter|2|





    public Image getEnemy1() throws java.io.IOException {//GEN-BEGIN:|22-getter|0|22-preInit
        if (enemy1 == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            enemy1 = Image.createImage("/img/enemy1.png");//GEN-BEGIN:|22-getter|1|22-postInit
        }//GEN-END:|22-getter|1|22-postInit
        // write post-init user code here
        return this.enemy1;//GEN-BEGIN:|22-getter|2|
    }//GEN-END:|22-getter|2|



    public Sprite getEnemy_1() throws java.io.IOException {//GEN-BEGIN:|23-getter|0|23-preInit
        if (enemy_1 == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
            enemy_1 = new Sprite(getEnemy1(), 32, 32);//GEN-BEGIN:|23-getter|1|23-postInit
            enemy_1.setFrameSequence(enemy_1seq001);//GEN-END:|23-getter|1|23-postInit
            // write post-init user code here
        }//GEN-BEGIN:|23-getter|2|
        return enemy_1;
    }//GEN-END:|23-getter|2|



    public Image getFuel32x32() throws java.io.IOException {//GEN-BEGIN:|88-getter|0|88-preInit
        if (fuel32x32 == null) {//GEN-END:|88-getter|0|88-preInit
            // write pre-init user code here
            fuel32x32 = Image.createImage("/img/fuel32x32.png");//GEN-BEGIN:|88-getter|1|88-postInit
        }//GEN-END:|88-getter|1|88-postInit
        // write post-init user code here
        return this.fuel32x32;//GEN-BEGIN:|88-getter|2|
    }//GEN-END:|88-getter|2|



    public Sprite getFuel() throws java.io.IOException {//GEN-BEGIN:|89-getter|0|89-preInit
        if (fuel == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            fuel = new Sprite(getFuel32x32(), 32, 96);//GEN-BEGIN:|89-getter|1|89-postInit
            fuel.setFrameSequence(fuelseq001);//GEN-END:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return fuel;
    }//GEN-END:|89-getter|2|



    public Image getEnemy2() throws java.io.IOException {//GEN-BEGIN:|91-getter|0|91-preInit
        if (enemy2 == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            enemy2 = Image.createImage("/img/enemy2.png");//GEN-BEGIN:|91-getter|1|91-postInit
        }//GEN-END:|91-getter|1|91-postInit
        // write post-init user code here
        return this.enemy2;//GEN-BEGIN:|91-getter|2|
    }//GEN-END:|91-getter|2|



    public Sprite getEnemy_2() throws java.io.IOException {//GEN-BEGIN:|92-getter|0|92-preInit
        if (enemy_2 == null) {//GEN-END:|92-getter|0|92-preInit
            // write pre-init user code here
            enemy_2 = new Sprite(getEnemy2(), 32, 32);//GEN-BEGIN:|92-getter|1|92-postInit
            enemy_2.setFrameSequence(enemy_2seq001);//GEN-END:|92-getter|1|92-postInit
            // write post-init user code here
        }//GEN-BEGIN:|92-getter|2|
        return enemy_2;
    }//GEN-END:|92-getter|2|







    public Sprite getEnemy_3() throws java.io.IOException {//GEN-BEGIN:|95-getter|0|95-preInit
        if (enemy_3 == null) {//GEN-END:|95-getter|0|95-preInit
            // write pre-init user code here
            enemy_3 = new Sprite(getEnemy3(), 32, 32);//GEN-BEGIN:|95-getter|1|95-postInit
            enemy_3.setFrameSequence(enemy_3seq002);//GEN-END:|95-getter|1|95-postInit
            // write post-init user code here
        }//GEN-BEGIN:|95-getter|2|
        return enemy_3;
    }//GEN-END:|95-getter|2|



    public Image getAsteroid() throws java.io.IOException {//GEN-BEGIN:|97-getter|0|97-preInit
        if (asteroid == null) {//GEN-END:|97-getter|0|97-preInit
 // write pre-init user code here
            asteroid = Image.createImage("/img/astrd.png");//GEN-BEGIN:|97-getter|1|97-postInit
        }//GEN-END:|97-getter|1|97-postInit
 // write post-init user code here
        return this.asteroid;//GEN-BEGIN:|97-getter|2|
    }//GEN-END:|97-getter|2|


    public Image getAstrd() throws java.io.IOException {//GEN-BEGIN:|98-getter|0|98-preInit
        if (astrd == null) {//GEN-END:|98-getter|0|98-preInit
 // write pre-init user code here
            astrd = Image.createImage("/img/astrd.png");//GEN-BEGIN:|98-getter|1|98-postInit
        }//GEN-END:|98-getter|1|98-postInit
 // write post-init user code here
        return this.astrd;//GEN-BEGIN:|98-getter|2|
    }//GEN-END:|98-getter|2|




    public Image getTiled_Complete() throws java.io.IOException {//GEN-BEGIN:|100-getter|0|100-preInit
        if (Tiled_Complete == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            Tiled_Complete = Image.createImage("/img/Tiled.png");//GEN-BEGIN:|100-getter|1|100-postInit
        }//GEN-END:|100-getter|1|100-postInit
        // write post-init user code here
        return this.Tiled_Complete;//GEN-BEGIN:|100-getter|2|
    }//GEN-END:|100-getter|2|

    public TiledLayer getMap1() throws java.io.IOException {//GEN-BEGIN:|101-getter|0|101-preInit
        if (Map1 == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            Map1 = new TiledLayer(15, 56, getTiled_Complete(), 16, 16);//GEN-BEGIN:|101-getter|1|101-midInit
            int[][] tiles = {
                {25, 26, 27, 27, 26, 28, 0, 0, 0, 0, 17, 18, 18, 19, 20},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 26, 27, 27, 28, 0, 0, 0, 0, 17, 18, 19, 18, 20},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 5, 6, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {25, 26, 27, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 38, 38, 0, 0, 0, 3, 4},
                {1, 2, 0, 0, 0, 0, 0, 0, 39, 39, 0, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 26, 27, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 26, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23}
            };//GEN-END:|101-getter|1|101-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|101-getter|2|101-postInit
                for (int col = 0; col < 15; col++) {
                    Map1.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|101-getter|2|101-postInit
        // write post-init user code here
        return Map1;//GEN-BEGIN:|101-getter|3|
    }//GEN-END:|101-getter|3|

    public TiledLayer getMap2() throws java.io.IOException {//GEN-BEGIN:|102-getter|0|102-preInit
        if (Map2 == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            Map2 = new TiledLayer(15, 56, getTiled_Complete(), 16, 16);//GEN-BEGIN:|102-getter|1|102-midInit
            int[][] tiles = {
                {25, 26, 26, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 26, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 38, 36, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 35, 39, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 15, 16},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 19, 20},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {13, 14, 15, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 33, 34, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 33, 0, 0, 34, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 33, 0, 0, 34, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 33, 34, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 27, 26, 27, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 27, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23}
            };//GEN-END:|102-getter|1|102-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|102-getter|2|102-postInit
                for (int col = 0; col < 15; col++) {
                    Map2.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|102-getter|2|102-postInit
        // write post-init user code here
        return Map2;//GEN-BEGIN:|102-getter|3|
    }//GEN-END:|102-getter|3|

    public TiledLayer getMap3() throws java.io.IOException {//GEN-BEGIN:|105-getter|0|105-preInit
        if (Map3 == null) {//GEN-END:|105-getter|0|105-preInit
            // write pre-init user code here
            Map3 = new TiledLayer(15, 56, getTiled_Complete(), 16, 16);//GEN-BEGIN:|105-getter|1|105-midInit
            int[][] tiles = {
                {25, 26, 27, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 26, 27, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {13, 14, 14, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {17, 18, 18, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 37, 38, 0, 0, 5, 6},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 39, 37, 38, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 39, 37, 38, 7, 8},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 37, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 37, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 35, 37, 36, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 35, 37, 36, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 35, 37, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 37, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 36, 37, 35, 11, 12},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 36, 37, 35, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 37, 35, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 38, 38, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 39, 39, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 26, 27, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 27, 27, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23}
            };//GEN-END:|105-getter|1|105-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|105-getter|2|105-postInit
                for (int col = 0; col < 15; col++) {
                    Map3.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|105-getter|2|105-postInit
        // write post-init user code here
        return Map3;//GEN-BEGIN:|105-getter|3|
    }//GEN-END:|105-getter|3|

    public TiledLayer getMap4() throws java.io.IOException {//GEN-BEGIN:|106-getter|0|106-preInit
        if (Map4 == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            Map4 = new TiledLayer(15, 56, getTiled_Complete(), 16, 16);//GEN-BEGIN:|106-getter|1|106-midInit
            int[][] tiles = {
                {25, 27, 27, 27, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 27, 27, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 38, 38, 38, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 37, 0, 37, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 39, 39, 39, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {36, 36, 36, 36, 0, 0, 0, 0, 0, 0, 38, 38, 38, 38, 38},
                {33, 0, 0, 34, 0, 0, 0, 0, 0, 0, 37, 0, 0, 0, 37},
                {35, 35, 35, 35, 0, 0, 0, 0, 0, 0, 37, 0, 0, 0, 37},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 37, 0, 0, 0, 37},
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 39, 39, 39, 39, 39},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {7, 8, 0, 37, 37, 37, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 37, 0, 37, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 37, 37, 37, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 36, 7, 8},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 35, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {9, 10, 38, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 35, 39, 0, 0, 0, 0, 0, 0, 0, 0, 36, 7, 8},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36, 33, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 36, 33, 35, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 33, 35, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 26, 26, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 23, 24},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 27, 27, 27, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23}
            };//GEN-END:|106-getter|1|106-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|106-getter|2|106-postInit
                for (int col = 0; col < 15; col++) {
                    Map4.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|106-getter|2|106-postInit
        // write post-init user code here
        return Map4;//GEN-BEGIN:|106-getter|3|
    }//GEN-END:|106-getter|3|

    public TiledLayer getMap5() throws java.io.IOException {//GEN-BEGIN:|107-getter|0|107-preInit
        if (Map5 == null) {//GEN-END:|107-getter|0|107-preInit
            // write pre-init user code here
            Map5 = new TiledLayer(15, 56, getTiled_Complete(), 16, 16);//GEN-BEGIN:|107-getter|1|107-midInit
            int[][] tiles = {
                {25, 27, 27, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 27, 26, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {13, 14, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {17, 19, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 38, 38},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 33, 33, 37},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 38, 33, 33, 33, 37},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 38, 33, 39, 39, 39, 39},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 33, 39, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 33, 33, 33, 33, 33, 33, 33},
                {11, 12, 0, 0, 0, 0, 0, 0, 33, 0, 36, 0, 36, 0, 33},
                {31, 32, 0, 0, 0, 0, 0, 0, 33, 37, 37, 37, 37, 37, 33},
                {13, 14, 14, 16, 0, 0, 0, 0, 33, 0, 35, 0, 35, 0, 33},
                {17, 18, 18, 20, 0, 0, 0, 0, 33, 33, 33, 33, 33, 33, 33},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 38, 38},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 0, 37},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 39, 39},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 33, 33, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 33, 33, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 27, 26, 26, 28, 24, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 27, 27, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23}
            };//GEN-END:|107-getter|1|107-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|107-getter|2|107-postInit
                for (int col = 0; col < 15; col++) {
                    Map5.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|107-getter|2|107-postInit
        // write post-init user code here
        return Map5;//GEN-BEGIN:|107-getter|3|
    }//GEN-END:|107-getter|3|

    public TiledLayer getMap6() throws java.io.IOException {//GEN-BEGIN:|108-getter|0|108-preInit
        if (Map6 == null) {//GEN-END:|108-getter|0|108-preInit
            // write pre-init user code here
            Map6 = new TiledLayer(15, 55, getTiled_Complete(), 16, 16);//GEN-BEGIN:|108-getter|1|108-midInit
            int[][] tiles = {
                {25, 27, 27, 27, 27, 28, 0, 0, 0, 0, 21, 22, 22, 23, 24},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 27, 27, 27, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 8},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 10},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 12},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 33, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 33, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 5, 6},
                {11, 12, 0, 0, 33, 37, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {31, 32, 0, 33, 37, 33, 0, 0, 0, 0, 0, 0, 38, 38, 38},
                {33, 33, 33, 37, 33, 0, 0, 0, 0, 0, 0, 33, 37, 0, 37},
                {37, 0, 37, 33, 0, 0, 0, 0, 0, 0, 33, 37, 39, 39, 39},
                {33, 33, 33, 0, 0, 0, 0, 0, 0, 0, 37, 33, 0, 31, 32},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 37},
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 37, 38, 0, 0, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 39, 37, 38, 0, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 0, 39, 37, 38, 0, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 39, 37, 38, 0, 3, 4},
                {3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 39, 37, 0, 3, 4},
                {5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {21, 22, 23, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 31, 32, 0, 0, 31, 32, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 7, 8, 0, 0, 1, 2, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 9, 10, 0, 0, 3, 4, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 11, 12, 0, 0, 5, 6, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 31, 32, 0, 0, 31, 32, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 26, 26, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 27, 26, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23}
            };//GEN-END:|108-getter|1|108-midInit
            // write mid-init user code here
            for (int row = 0; row < 55; row++) {//GEN-BEGIN:|108-getter|2|108-postInit
                for (int col = 0; col < 15; col++) {
                    Map6.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|108-getter|2|108-postInit
        // write post-init user code here
        return Map6;//GEN-BEGIN:|108-getter|3|
    }//GEN-END:|108-getter|3|

    public TiledLayer getMap7() throws java.io.IOException {//GEN-BEGIN:|109-getter|0|109-preInit
        if (Map7 == null) {//GEN-END:|109-getter|0|109-preInit
            // write pre-init user code here
            Map7 = new TiledLayer(15, 56, getTiled_Complete(), 16, 16);//GEN-BEGIN:|109-getter|1|109-midInit
            int[][] tiles = {
                {25, 27, 27, 27, 26, 28, 0, 0, 0, 0, 21, 22, 22, 23, 24},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 26, 26, 27, 26, 28, 0, 0, 0, 0, 21, 22, 22, 23, 24},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 37, 38, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 39, 37, 38, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 39, 37, 38, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 39, 37, 38, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 38, 37, 39, 0, 0, 0, 0, 0, 5, 6},
                {9, 10, 0, 0, 38, 37, 39, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 38, 37, 39, 0, 0, 0, 0, 0, 37, 37, 37, 37},
                {9, 10, 0, 37, 39, 0, 0, 0, 0, 0, 0, 37, 0, 0, 37},
                {9, 10, 0, 39, 0, 0, 0, 0, 0, 0, 0, 37, 37, 37, 37},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {17, 18, 18, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {17, 18, 18, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 36, 36, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 35, 35, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 38, 38, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 39, 39, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 4},
                {11, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6},
                {31, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 32},
                {25, 27, 26, 26, 27, 28, 0, 0, 0, 0, 21, 22, 22, 22, 23},
                {0, 0, 0, 0, 29, 30, 0, 0, 0, 0, 29, 30, 0, 0, 0},
                {25, 27, 27, 26, 26, 28, 0, 0, 0, 0, 21, 22, 22, 23, 24}
            };//GEN-END:|109-getter|1|109-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|109-getter|2|109-postInit
                for (int col = 0; col < 15; col++) {
                    Map7.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|109-getter|2|109-postInit
        // write post-init user code here
        return Map7;//GEN-BEGIN:|109-getter|3|
    }//GEN-END:|109-getter|3|

    public Image getLife() throws java.io.IOException {//GEN-BEGIN:|110-getter|0|110-preInit
        if (life == null) {//GEN-END:|110-getter|0|110-preInit
            // write pre-init user code here
            life = Image.createImage("/img/life.png");//GEN-BEGIN:|110-getter|1|110-postInit
        }//GEN-END:|110-getter|1|110-postInit
        // write post-init user code here
        return this.life;//GEN-BEGIN:|110-getter|2|
    }//GEN-END:|110-getter|2|



    public Image getEnergy() throws java.io.IOException {//GEN-BEGIN:|113-getter|0|113-preInit
        if (energy == null) {//GEN-END:|113-getter|0|113-preInit
            // write pre-init user code here
            energy = Image.createImage("/img/energy.png");//GEN-BEGIN:|113-getter|1|113-postInit
        }//GEN-END:|113-getter|1|113-postInit
        // write post-init user code here
        return this.energy;//GEN-BEGIN:|113-getter|2|
    }//GEN-END:|113-getter|2|

    public Image getTiled_2() throws java.io.IOException {//GEN-BEGIN:|116-getter|0|116-preInit
        if (Tiled_2 == null) {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            Tiled_2 = Image.createImage("/img/Tiled_2.png");//GEN-BEGIN:|116-getter|1|116-postInit
        }//GEN-END:|116-getter|1|116-postInit
        // write post-init user code here
        return this.Tiled_2;//GEN-BEGIN:|116-getter|2|
    }//GEN-END:|116-getter|2|

    public TiledLayer getMap8() throws java.io.IOException {//GEN-BEGIN:|119-getter|0|119-preInit
        if (Map8 == null) {//GEN-END:|119-getter|0|119-preInit
            // write pre-init user code here
            Map8 = new TiledLayer(15, 56, getTiled_2(), 16, 16);//GEN-BEGIN:|119-getter|1|119-midInit
            int[][] tiles = {
                {85, 86, 87, 88, 89, 90, 0, 0, 0, 0, 99, 102, 102, 102, 103},
                {7, 0, 0, 0, 39, 40, 0, 0, 0, 0, 41, 42, 0, 34, 35},
                {13, 86, 87, 88, 89, 90, 0, 0, 0, 0, 91, 133, 132, 134, 95},
                {145, 146, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 26},
                {3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 124, 123, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 120, 122, 0, 0, 0, 18, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 23},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 115},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 8, 0, 0, 0, 0, 0, 0, 104, 105, 107, 107, 107, 107, 108},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 43},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 47, 46},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 239, 240, 241},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 242, 243, 244},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 242, 243, 244},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 242, 243, 244},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 242, 243, 244},
                {9, 8, 0, 0, 0, 117, 118, 0, 0, 0, 0, 0, 245, 246, 247},
                {9, 8, 0, 0, 0, 144, 144, 0, 0, 0, 0, 0, 0, 145, 146},
                {9, 8, 0, 0, 0, 149, 150, 0, 0, 0, 0, 0, 0, 51, 50},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 113, 114, 115, 116, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 239, 240, 241, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 242, 243, 244, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 245, 246, 247, 0, 0, 0, 0, 0, 6, 5},
                {9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {27, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5},
                {148, 148, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 23},
                {147, 147, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 141, 143},
                {155, 160, 156, 156, 157, 158, 0, 0, 0, 0, 86, 87, 88, 89, 90},
                {164, 0, 158, 0, 0, 166, 0, 0, 0, 0, 172, 173, 0, 174, 175},
                {159, 160, 156, 160, 156, 157, 0, 0, 0, 0, 85, 86, 87, 89, 90}
            };//GEN-END:|119-getter|1|119-midInit
            // write mid-init user code here
            for (int row = 0; row < 56; row++) {//GEN-BEGIN:|119-getter|2|119-postInit
                for (int col = 0; col < 15; col++) {
                    Map8.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|119-getter|2|119-postInit
        // write post-init user code here
        return Map8;//GEN-BEGIN:|119-getter|3|
    }//GEN-END:|119-getter|3|

    public Sprite getExplode() throws java.io.IOException {//GEN-BEGIN:|120-getter|0|120-preInit
        if (explode == null) {//GEN-END:|120-getter|0|120-preInit
            // write pre-init user code here
            explode = new Sprite(getEnemy1(), 32, 32);//GEN-BEGIN:|120-getter|1|120-postInit
            explode.setFrameSequence(explodeseq001);//GEN-END:|120-getter|1|120-postInit
            // write post-init user code here
        }//GEN-BEGIN:|120-getter|2|
        return explode;
    }//GEN-END:|120-getter|2|





    
}
