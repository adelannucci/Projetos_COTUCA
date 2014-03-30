/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/**
 *
 * @author adelannucci
 */
public class EnemyControlCenter {
    
    private int enemy1X;
    private int enemy2X;
    private int enemy3X;
    
    private int enemy1Y;
    private int enemy2Y;
    private int enemy3Y;
        
    
    public EnemyControlCenter(){
        enemy1X = 0;
        enemy1Y = 0;
        enemy2X = 0;
        enemy2Y = 0;
        enemy3X = 0;
        enemy3Y = 0;
    }

    //posiciona os inimigos de acordo com o mapa
    public void pointEnemy(int map){
      switch(map){
             case 1:
                 enemy1X = 5;
                 enemy1Y = 44;
                 enemy2X = 9;
                 enemy2Y = 17;
                 enemy3X = 7;
                 enemy3Y = 28;
                 break;
             case 2:
                 enemy1X = 7;
                 enemy1Y = 24;
                 enemy2X = 8;
                 enemy2Y = 27;
                 enemy3X = 7;
                 enemy3Y = 16;
                 break;
             case 3:
                 enemy1X = 8;
                 enemy1Y = 9;
                 enemy2X = 6;
                 enemy2Y = 39;
                 enemy3X = 8;
                 enemy3Y = 21;
                 break;
             case 4:
                 enemy1X = 8;
                 enemy1Y = 41;
                 enemy2X = 9;
                 enemy2Y = 30;
                 enemy3X = 7;
                 enemy3Y = 7;             
                 break;
             case 5:
                 enemy1X = 4;
                 enemy1Y = 41;
                 enemy2X = 7;
                 enemy2Y = 39;
                 enemy3X = 7;
                 enemy3Y = 3;
                 break;
             case 6:
                 enemy1X = 5;
                 enemy1Y = 44;
                 enemy2X = 7;
                 enemy2Y = 32;
                 enemy3X = 7;
                 enemy3Y = 20;
                 break;
             case 7:
                 enemy1X = 5;
                 enemy1Y = 43;
                 enemy2X = 7;
                 enemy2Y = 23;
                 enemy3X = 7;
                 enemy3Y = 9;
                 break;
             case 8:
                 enemy1X = 7;
                 enemy1Y = 40;
                 enemy2X = 5;
                 enemy2Y = 31;
                 enemy3X = 7;
                 enemy3Y = 13;
                 break;
             default:
                 break;
         } 
    }
    
    
    public int getenemy1X(){
        return enemy1X;
    }
    public int getenemy2X(){
        return enemy2X;
    }
    public int getenemy3X(){
        return enemy3X;
    }
    
   public int getenemy1Y(){
        return enemy1Y;
    }
    public int getenemy2Y(){
        return enemy2Y;
    }
    public int getenemy3Y(){
        return enemy3Y;
    }
    
}
