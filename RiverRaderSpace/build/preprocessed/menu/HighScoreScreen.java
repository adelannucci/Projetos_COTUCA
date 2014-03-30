/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import space.Game;

/**
 *
 * @author adelannucci
 */
public class HighScoreScreen extends Form implements CommandListener {
    private Game midlet;
    
    private Command backCommand = new Command("Back", Command.BACK, 1);
    private Command resetCommand = new Command("Rest", Command.SCREEN,1);
    public HighScoreScreen (Game midlet) {
        super("High Score");
        this.midlet = midlet;
        StringItem stringItem = new StringItem(null,"ALV 100\nALV 50\nALV 10");
        append(stringItem);
        addCommand(backCommand);
        addCommand(resetCommand);
        setCommandListener(this);
    }
    public void commandAction(Command c, Displayable d) {
        if (c == backCommand) {
        midlet.mainMenuScreenShow();
        return;
        }
        if (c == resetCommand) {
            // not implemented yet
            System.out.println("Reset High Scores Not Implemented Yet");
        }
    }
}