package compactador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

class Arvore
{
    
    private No raiz = null;
    private No vetor[] = new No [256];
    private short qtdDiferentesChars = 0;
    private String nomeArqOriginal;
    private String strCod[] = new String[256];
    private String cabecalho = "";
	private RandomAccessFile arq;

    public Arvore (String nao)
    {
        this.nomeArqOriginal = nao;
    }
    
    //construtor usado para gerar a arvore com intuito de descompactar
    public Arvore (String nao, short qtd)
    {
        this.nomeArqOriginal = nao;
        this.qtdDiferentesChars = qtd;
        
        for (int i=0; i<256; i++)
            this.vetor[i] = null;
    }
    
    //reconstroi a arvore para descompactacao.
    public void reconstruirRaiz() 
    {  
        this.agrupa();
        this.ordena();
        this.geraArvore();
    }
    
    // Adiciona um novo elemento no vetor
    public void addNo(int cod, int qtd)
    {
    	vetor[cod] = new No(cod, qtd);
    }
    
    public No getRaiz(){
    	return raiz;
    }
    
    //utilixado para gerar a raiz quando se deseja compactar o arquivo
    public void gerarRaiz(){
        this.estatistica();
        this.agrupa();
        this.ordena();
        this.gerarCabecalho();
        this.geraArvore();
    }
    
    // para cada caractere lido do arquivo, verificar se na posicao que
    // lhe corresponde no vetor ha null; em caso positivo, instanciar a
    // posicao e incrementar a quantidade de diferentes characteres e,
    // em caso negativo incrementar a quantidade do No que estiver na
    // posicao
    private void estatistica ()
    {
        try 
        {
            arq = new RandomAccessFile (this.nomeArqOriginal,"r");
            
            long len = -1;
            try 
            {
                len = arq.length();
            } catch (IOException ex) {
                Logger.getLogger(Arvore.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (int i=0; i<256; i++)
                this.vetor[i] = null;
            
            for(int i = 0; i<len;i++){
                try 
                {
                    int read = arq.readByte() & 255;
                    if(read>=0 && read<256)
                    {
                        if(vetor[(int)read] == null)
                        {
                            vetor[read] = new No(read); 
                            this.qtdDiferentesChars++;
                        }
                        else
                        {
                            vetor[read].incQuantidade(); 
                        }
                    }
                } 
                //Falha ao ler do arquivo
                catch (IOException ex) {
                    Logger.getLogger(Arvore.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } 
        //Arquivo nao existe
        catch (FileNotFoundException ex) {
            Logger.getLogger(Arvore.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    // agrupa no inicio do vetor as posicoes instanciadas, deixando
    // os nulls no final do vetor
    private void agrupa ()
    {
        No vetAux[] = new No[this.qtdDiferentesChars];
        
        for(int i = 0; i<this.qtdDiferentesChars;i++)
        {
            vetAux[i] = null;
        }
        
        
        for(int i = 0, j = 0; i<256; i++){
            if(this.vetor[i] !=null){
                vetAux[j] = this.vetor[i];
                this.vetor[i] = null;
                j++;  
            }
        }
        
        System.arraycopy(vetAux, 0, this.vetor, 0, this.qtdDiferentesChars);
    }
    
    // ordena as qtdDiferentesChars primeiras posicoes do vetor
    // em ordem decrescente de quantidade
    private void ordena ()
    {
        boolean houveTroca = true;
        while (houveTroca) {
            houveTroca = false;
            for (int i = 0; i < this.qtdDiferentesChars-1; i++){
                
                if (vetor[i].getQuantidade() < vetor[i+1].getQuantidade()){
                    No variavelAuxiliar = vetor[i+1];
                    vetor[i+1] = vetor[i];
                    vetor[i] = variavelAuxiliar;
                    houveTroca = true;
                }
            }
        }  
    }
    
    // chamar ordena
    // juntar os dois ultimos elementos do vetor
    // sob um novo no, fazendo-o tornar-se o penultimo elemento
    // do vetor e tornando null o ultimo elemento do vetor
    // diminuir qtdDiferentesChars
    // repetir todos os passos acima, ate qtdDiferentesChars valer 1
    // colocar na raiz a posicao 0 de seu vetor    
        
    private void geraArvore ()
    {        
        for(int i = this.qtdDiferentesChars-1; i>0;i--)
        {
            No newNo = new No(this.vetor[i-1],this.vetor[i]);
            this.vetor[i] = null;
            this.vetor[i-1] = newNo;
            this.qtdDiferentesChars--;
            this.ordena();
        }
        
        this.raiz = this.vetor[0];   
    }
        
    public String[] getCodigos()
    {
        numString (this.raiz, "", 'r');
        return strCod;
    }
        
    private void numString (No raiz, String bit, char flag)
    {
        
        if (raiz == null)
            return;
                
        if(flag == 'd')
        {
            bit += "1";
        }
        
        if(flag == 'e')
        {
            bit += "0";
        }
        
        if(raiz.getCodigo() != -1)
        {
            this.strCod[raiz.getCodigo()] = bit;
            //System.out.println(bit);
        }
        
        numString(raiz.getEsq(), bit, 'e');
        numString(raiz.getDir(), bit, 'd');
    }
    
    private void gerarCabecalho()
    {
    	cabecalho = this.qtdDiferentesChars + ":";
    	for(No elemento: vetor)
    	{  	
    		if(elemento != null)
    			cabecalho += elemento.getCodigo() + ":" + elemento.getQuantidade() + ":";	
    	}
    }
    
    public String getCabecalho()
    {
    	return cabecalho;
    }
}













