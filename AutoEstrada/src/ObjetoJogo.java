
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public abstract class ObjetoJogo
{
    /* Atributos da classe conforme o planejado */
    protected Image image;
    protected int px;
    protected int py;
    protected int comprimento;
    protected int altura;

    /* Método abstrato que toda classe que herdar deverá implementar */
    public abstract void meDesenha(Graphics g);

    /* Métodos get e set para os atributos. */
    public int getPx()
    {
        return px;
    }
    public void setPx(int x)
    {
        px = x;
    }
    public int getPy()
    {
        return py;
    }
    public void setPy(int y)
    {
        py = y;
    }

    public int getComprimento()
    {
        return comprimento;
    }
    public int getAltura()
    {
        return altura;
    }
}