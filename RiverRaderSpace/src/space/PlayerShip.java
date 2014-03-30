package space;



import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adelannucci
 */
public class PlayerShip extends Sprite {
    
    public int width;
    public int height;
    
    //public int x;
    //public int y;
    
    public int pointX;
    public int pointY;
    public int score = 0;
    
    public int life = 10;
    public final int FUEL = 600;
    public int fuel = 600;
    
    public int explodir = 9;
    
    public boolean kill = false;
    
    public PlayerShip(Image image){
        super(image);
    }
    
    public PlayerShip(Image image, int frameWidth, int frameHeight){
        super(image, frameWidth, frameHeight);
        inicia(frameWidth, frameHeight);
    }
	
    public PlayerShip(Sprite s) {
        super(s);
        inicia(s.getWidth(), s.getHeight());		
    }

    private void inicia(int width, int height){
        // Pega a largura e altura no construtor e coloca em variáveis
        // pór ser maios rápido o acesso
        this.width  = width;
        this.height = height;
        
        //x = 0;
        //y = 0;

    }
    
    public void checkPoint(){
        pointX = getX();
        pointY = getY();
    }
    
    public void explodir(){
        
        setFrame(explodir);
        explodir++;
        try { Thread.sleep(15); } 
        catch (InterruptedException ex) {}
        
    }
    
    public void kill(){
        life--;
        fuel = FUEL;
        this.setPosition(pointX, pointY);
    }
    
    public void fuellControl(){
        //this.setPosition(x, y);
        fuel--;
        if(fuel == 0){
            //this.kill();
            kill = true;
        }
    }
    
    
    
    public boolean colisionMap(TiledLayer map, boolean type){
    
        if(this.collidesWith(map, type)){
            kill = true;
            return kill;
        }
        
        return kill;
    }
    
    public boolean colisionSprite(Sprite sp, boolean type){
    
        if(this.collidesWith(sp, type)){
            kill = true;
            return kill;
        }
        kill = false;
        return kill;
    }
    
  
}
