package compactador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import compactador.Arvore;

public class Descodificador {
	
	private RandomAccessFile compactado;
	private RandomAccessFile descompactado;
	
	private File fileConpactado;
	private File fileDescompactado;
	
	private Arvore tree;
	
	private short qtdDiferentesChars;
	
	public Descodificador(String fileName)
	{
		String aux[] = fileName.split("\\.");
		fileName = aux[0];
		//aux = null;
		
		fileConpactado = new File(fileName + ".alv");
		fileDescompactado = new File(fileName + "1." + aux[1]);
		aux = null;
		//cria o arquivo compactado
		try
		{
			compactado = new RandomAccessFile (fileConpactado,"r");
			descompactado = new RandomAccessFile(fileDescompactado, "rw");
			compactado.readInt();
	        qtdDiferentesChars = (short) compactado.readInt();
			
			tree = new Arvore(fileName + ".alv", qtdDiferentesChars );
			
			//Reconstroi o vetor de No
	        for(int i = 0; i<qtdDiferentesChars;i++){
	        	
	        	tree.addNo(compactado.readInt(), compactado.readInt());      
	        }
	        
			tree.reconstruirRaiz();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void iniciar() throws FileNotFoundException
    {
    	
		System.out.println("DESCOMPACTANDO");
		
		String guia = "";
    	boolean eof = false;
    	
    	No aux; 
		aux = tree.getRaiz();
		try {
			guia = converteDecimalEmBinario(compactado.readByte() & 255);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	//le o arquivo conpactado ate o final
        while(!eof)
    	{
    		try {
				System.out.println("leu: "+guia);
				for(int i = 0;i<8; i++)
				{
					if(guia.charAt(i) == '1')
		        		aux = aux.getDir();
		        	else
		        		aux = aux.getEsq();
		        	
		        	if(aux.getCodigo() != -1)
		        	{
		        		descompactado.writeByte(aux.getCodigo());
		        		aux = tree.getRaiz();
		        	}		
				}
				guia = converteDecimalEmBinario(compactado.readByte() & 255);
			} catch (IOException e) {
				eof = true;
				System.out.println(guia);
			}	
    	}
    
        System.out.println("Descompactado.");
    }
	
    private String converteDecimalEmBinario(int decimal){  
    	  
        String bin = "";  
          
        while(decimal > 0){  
          
            if(decimal%2==0)  
                bin = "0" + bin;  
              
            else   
                bin = "1" + bin;  
                  
            decimal /= 2;  
        } 
        
        while(bin.length()<8)
        	bin = "0"+bin;
        
        return bin;
    }  

}
