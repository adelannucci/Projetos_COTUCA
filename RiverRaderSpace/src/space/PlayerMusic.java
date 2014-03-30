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
 * @author adelannucci
 */
public class PlayerMusic implements Runnable {
    
    private Player player;
    private InputStream is;
    public boolean end = false;
    
    
    public PlayerMusic(int music){
        try {
            switch(music){
                
                case 1:
                    is = getClass().getResourceAsStream("/sons/lv1.mid"); 
                    player = Manager.createPlayer(is,"audio/midi");
                    break;
                case 2:
                    is = getClass().getResourceAsStream("/sons/lv2.mid"); 
                    player = Manager.createPlayer(is,"audio/midi");
                    break;
                case 3:
                    is = getClass().getResourceAsStream("/sons/lv3.mid"); 
                    player = Manager.createPlayer(is,"audio/midi");
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }

    }
    
    //desaloca a musica para trocar o som
    public void tradeMusic(){
        player.deallocate();
    }

    public void inicia(){
        end = false;
        Thread t = new Thread(this);
        // Inicia a thread
        t.start();
    }
    
    //inicia a musica
    public void musicStart(){
        try {
            player.setLoopCount(-1);
            player.start();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }
    
    public void run() {
        try {
            player.setLoopCount(-1);
            player.start();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
        while(!end){}
        
    }
 
}
