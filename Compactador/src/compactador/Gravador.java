package compactador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

class Gravador
{
	private final byte MAX = (byte) 256;
    private RandomAccessFile arquivo;
    
    private String sobra = "";
    
    byte bits[] = new byte[MAX];
    

    public Gravador (String nomeArq)
    {
    	try {
    		
    		String aux[] = nomeArq.split("\\.");
    		nomeArq = aux[0];
    		aux = null;
    		
    		File arqC = new File(nomeArq + ".alv");
			arquivo = new RandomAccessFile (arqC,"rw");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    }

    public void gravarCabecalho(String cabecalho)
    {
    	String aux[] = cabecalho.split("\\:");
    	int bit = 0;
    	
    	
    	try {
    		
    		//grava zero na pos da sobra
    		arquivo.writeInt(0);
    		
			for(String elemento : aux)
			{
				bit = Integer.parseInt(elemento);
				arquivo.writeInt(bit);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void grava (String bits)
    {
        // concatenar sobra com bits; caso a concatenacao tenha menos
        // que 8 bits, deixa todos os bits em sobra; caso tenha 8 ou
        // mais, grava todos os blocos de 8 bits possiveis, deixando
        // em sobra o que sobrar
        int i = 0;
        while(i<bits.length())
        {

            for(;(sobra.length() < 8) && ( i < bits.length()); i++)
            {
                sobra += bits.charAt(i); 
            }  
            

            if(sobra.length() == 8)
            {
            	int b = convertStrParaInt(sobra);
                //grava
            	try {
					arquivo.writeByte(b);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(String.format("%d: %s %s", b, sobra.substring(0, 4), sobra.substring(4,8)));
                sobra = "";
            }
        }   
    }

    private int convertStrParaInt(String str)
    {
    	int out = 0;
    	int exp = 8;
    	int base = 2;
    	for (int i = 0; i<8; i++)
    	{
    		exp = 8 - (i+1);
    		if(str.charAt(i) == '1')
    			out += Math.pow(base, exp);
    	}
    	
    	return out;
    }
    
    public void esvazia ()
    {
        //informacao para dizer quantos bits sobraram
    	if(sobra.equals(""))
    		return;
    	
    	int qtdBit = 8 - sobra.length();
    	// completa sobra com zeros suficientes para formar 1 byte,
        // gravando-o a seguir
        for(int i = sobra.length(); i < 8; i++)
        {
            sobra += "0";
        }
        
        int b = convertStrParaInt(sobra);
        //grava
    	try {
			arquivo.writeByte(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.println(String.format("%d: %s %s", b, sobra.substring(0, 4), sobra.substring(4,8)));
        sobra = "";
        
        try {
			arquivo.seek(0);
			arquivo.writeInt(qtdBit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void arquivoClose()
    {
    	try {
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}