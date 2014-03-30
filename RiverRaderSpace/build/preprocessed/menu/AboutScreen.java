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
public class AboutScreen extends Form implements CommandListener {

    private Game midlet;
    private Command backCommand = new Command("Back", Command.BACK, 1);

    public AboutScreen (Game midlet) {
        super("About");
        this.midlet = midlet;
        StringItem stringItem = new StringItem(null,"River Raid Space\nVersion 1.0.0\nBy adelannucci and Ednaldo");
        append(stringItem);
        addCommand(backCommand);
        setCommandListener(this);
    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == backCommand) {
            midlet.mainMenuScreenShow();
            return;
        }
    }
}