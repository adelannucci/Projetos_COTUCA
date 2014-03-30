package compactador;

public class No
{
    private short codigo;
    private long quantidade=1;
    private No esq=null, dir=null;

    public No (int codigo)
    {
        this.codigo = (short)codigo;
    }
    
    public No (int codigo, long qtd)
    {
        this.codigo = (short)codigo;
        this.quantidade = qtd;
    }

    public No (No esq, No dir)
    {
        this.codigo = -1;
        this.quantidade = esq.quantidade+dir.quantidade;
        this.esq = esq;
        this.dir = dir;
    }

    public short getCodigo()
    {
        return this.codigo;
    }

    public long getQuantidade()
    {
        return this.quantidade;
    }

    public No getEsq()
    {
        return this.esq;
    }

    public No getDir()
    {
        return this.dir;
    }

    public void incQuantidade ()
    {
        this.quantidade++;
    }
}