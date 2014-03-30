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
public class Player extends Sprite {
    
    public int width;
    public int height;
    
    // pontos de controle do sprite principal
    public int pointX;
    public int pointY;
    
    public int life = 5;
    public final int FUEL = 600;
    public int fuel = 600;
    
    //frame para explodir
    public int explodir = 9;
    
    public boolean kill = false;
    
    public Player(Image image){
        super(image);
    }
    
    public Player(Image image, int frameWidth, int frameHeight){
        super(image, frameWidth, frameHeight);
        inicia(frameWidth, frameHeight);
    }
	
    public Player(Sprite s) {
        super(s);
        inicia(s.getWidth(), s.getHeight());		
    }

    private void inicia(int width, int height){
        // Pega a largura e altura no construtor e coloca em variáveis
        // pór ser maios rápido o acesso
        this.width  = width;
        this.height = height;
    }
    
    // Atualiza o check point
    public void checkPoint(){
        pointX = getX();
        pointY = getY();
    }
    
    //animacao para explodir o sprite
    public void explodir(){
        
        setFrame(explodir);
        explodir++;
        try { Thread.sleep(15); } 
        catch (InterruptedException ex) {}
        
    }
    
    // mata o jogador
    public void kill(){
        life--;
        fuel = FUEL;
        this.setPosition(pointX, pointY);
    }
    
    //reduz a energia e verifica se acabou
    public void fuellControl(){
        //this.setPosition(x, y);
        fuel--;
        if(fuel == 0){
            //this.kill();
            kill = true;
        }
    }
    
    // verifica colisao com tiled
    public boolean colisionMap(TiledLayer map, boolean type){
    
        if(this.collidesWith(map, type)){
            kill = true;
            return kill;
        }
        
        return kill;
    }
    
    //verifica colisao com sprite
    public boolean colisionSprite(Sprite sp, boolean type){
    
        if(this.collidesWith(sp, type)){
            kill = true;
            return kill;
        }
        kill = false;
        return kill;
    }
    
  
}
