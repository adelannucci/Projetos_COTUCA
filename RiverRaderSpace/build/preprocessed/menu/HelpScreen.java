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
public class HelpScreen extends Form implements CommandListener {
    private Game midlet;
    private Command backCommand = new Command("Back", Command.BACK, 1);
    public HelpScreen (Game midlet) {
        super("Help");
        this.midlet = midlet;
        StringItem stringItem = new StringItem(null,
            "Quatro dias se passaram, comeco a achar que sera " +
            "impossivel escapar desta lugar. " +
            "Estou fazendo o possivel, sera que este hangar e infinito? " +
            "Pode ser que eu esteja andando em circulos!! " +
            "Ou estou preso em uma dilatacao temporal? "+
            "Precisso sair daqui rapidamente.");
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