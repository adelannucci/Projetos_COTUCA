package space;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import menu.AboutScreen;
import menu.HelpScreen;
import menu.HighScoreScreen;
import menu.MainMenuScreen;
import menu.SettingsScreen;
import menu.SplashScreen;

/**
 * @author adelannucci
 */
public class Game extends MIDlet {
    public Display display;
    
    private Image splashLogo;
    private boolean isSplash = true;
    private MainMenuScreen mainMenuScreen;
    private SettingsScreen settingsScreen;
    private HighScoreScreen highScoreScreen;
    private HelpScreen helpScreen;
    private AboutScreen aboutScreen;
    
    private MyGameCanvas canvas;
    
    public Game()
    {
        //this.newObj();  
    }
    
    private void newObj(){
        display = Display.getDisplay(this);
        canvas = new MyGameCanvas(this);
    }

    public void startApp() 
    {
        
        display = Display.getDisplay(this);
        mainMenuScreen = new MainMenuScreen(this);
        settingsScreen = new SettingsScreen(this);
        highScoreScreen = new HighScoreScreen(this);
        helpScreen = new HelpScreen(this);
        aboutScreen = new AboutScreen(this);
        if(isSplash) {
            isSplash = false;
            try {
                splashLogo = Image.createImage("/img/logo.png");
                new SplashScreen(display, mainMenuScreen, splashLogo,3000);
            } 
            catch(Exception ex) {
                mainMenuScreenShow();
            }
        } else {
            mainMenuScreenShow();
        }
        
        //display.setCurrent(t);
        
    }

    public void pauseApp() 
    {
            canvas.pausa();
    }

    public void destroyApp(boolean unconditional) 
    {
            canvas.pausa();
    }
    
    public void start(){
        this.newObj();
        display.setCurrent(canvas);
        canvas.inicia();
    }
    
    public void end(){
        display.setCurrent(mainMenuScreen);
        canvas.t.interrupt();
        System.gc();
        canvas = new MyGameCanvas(this);
    }
    
    public void mainMenuScreenShow() {
        display.setCurrent(mainMenuScreen);
    }
    
    public void settingsScreenShow() {
        display.setCurrent(settingsScreen);
    }
    
    public void highScoreScreenShow() {
        display.setCurrent(highScoreScreen);
    }
    
    public void helpScreenShow() {
        display.setCurrent(helpScreen);
    }
    
    public void aboutScreenShow() {
        display.setCurrent(aboutScreen);
    }
    
    public void mainMenuScreenQuit() {
        destroyApp(true);
    }
}
