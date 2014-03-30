/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.IOException;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import space.Game;

/**
 *
 * @author adelannucci
 */
public class MainMenuScreen extends List implements CommandListener {

    private Game midlet;
    private Command selectCommand = new Command("Select", Command.ITEM,1);
    private Command exitCommand = new Command("Exit", Command.EXIT,1);
    public MainMenuScreen(Game midlet) {
        super("River Raid Space",Choice.IMPLICIT);
        this.midlet = midlet;

        append("New Game",null);
        append("Settings",null);
        append("High Scores", null);
        append("Help",null);
        append("About",null);
        addCommand(exitCommand);
        addCommand(selectCommand);
        setCommandListener(this);
    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == exitCommand) {
            midlet.mainMenuScreenQuit();
        } 
        else if (c == selectCommand) {
            processMenu();
        } 
        else {
            processMenu();
        }
    }
    
    private void processMenu() {
        try {
            List down = (List)midlet.display.getCurrent();
            switch (down.getSelectedIndex()) {
                case 0: 
                    scnNewGame(); 
                    break;
                case 1: 
                    scnSettings(); 
                    break;
                case 2: 
                    scnHighScore(); 
                    break;
                case 3: 
                    scnHelp(); 
                    break;
                case 4: 
                    scnAbout(); 
                break;
            }
        } 
        catch (Exception ex) {
        // Proper Error Handling should be done here
        System.out.println("processMenu::"+ex);
        }
    }
    
    private void scnNewGame() {
        midlet.start();
    }
    
    private void scnSettings() {
        midlet.settingsScreenShow();
    }
    
    private void scnHighScore() {
        midlet.highScoreScreenShow();
    }
    
    private void scnHelp() {
        midlet.helpScreenShow();
    }
    
    private void scnAbout() {
        midlet.aboutScreenShow();
    }
    
    public void restart(){
        midlet.end();
    }
}
