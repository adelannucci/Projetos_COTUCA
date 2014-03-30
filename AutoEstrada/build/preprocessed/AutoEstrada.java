import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class AutoEstrada extends MIDlet
{

    private Display display;
    private AutoEstradaCanvas autoEstradaCanvas;

    public AutoEstrada()
    {
        display = Display.getDisplay(this);
        autoEstradaCanvas = new AutoEstradaCanvas();
    }

    protected void startApp(){
        display.setCurrent(autoEstradaCanvas);
    }
    protected void pauseApp(){}
    protected void destroyApp(boolean unconditional){}

    public void exitMIDlet(){
        destroyApp(false);
        notifyDestroyed();
    }
}
