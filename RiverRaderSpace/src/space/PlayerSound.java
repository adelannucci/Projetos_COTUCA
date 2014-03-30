/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author u11253
 */
public class PlayerSound implements Runnable {
    
    private Player explosion;
    private Player shot;
    private InputStream is;
    
    public PlayerSound(){
        try{
            is = getClass().getResourceAsStream("/sons/explosion.WAV"); 
            explosion = Manager.createPlayer(is,"audio/X-wav");
            explosion.setLoopCount(1);
            is = getClass().getResourceAsStream("/sons/shot.WAV"); 
            shot = Manager.createPlayer(is,"audio/X-wav"); 
            shot.setLoopCount(1);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }
    
    //som do tiro
    public void shot(){
        try {
            shot.start();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }
    
    //som da explosao
    public void explosion(){
        try {
            explosion.start();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }
    
    //desaloca os sons
    public void deallocate(){
        explosion.deallocate();
        shot.deallocate();
    }
    
    public void inicia(){
        
        Thread t = new Thread(this);
        // Inicia a thread
        t.start();
    }
    
    public void run() {
        
        while(true){
        
        }
    }
    
}
