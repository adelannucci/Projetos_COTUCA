package compactador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Codificador {
	
	private String fileName;
	private Arvore tree;
    private String strCod[];
    
    public Codificador( String name)
    {
    	fileName = name;
    	tree = new Arvore(fileName);
    	tree.gerarRaiz();
    	strCod = tree.getCodigos();
    }
    
	public void compactar()
	{
		System.out.println("Vetor de codigos: ");
        for(int i = 0; i<256;i++)
        {
            if(strCod[i] != null)
           {
               System.out.println(String.format("Codigo %d : %s", i, strCod[i] ) );
           }   
        }
        
        System.out.println("COMPACTANDO");
        Gravador compac = new Gravador(fileName);
        compac.gravarCabecalho(tree.getCabecalho());
        RandomAccessFile arq;
		try {
			arq = new RandomAccessFile (fileName,"r");
		
        
	        long len = -1;
	        try 
	        {
	            len = arq.length();
	        } catch (IOException ex) {
	            Logger.getLogger(Arvore.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        for(int i = 0; i<len;i++){
	            try 
	            {
	                int read = arq.readByte() & 255;
	                if(read>=0 && read<256)
	                {
	                	compac.grava(strCod[read]);
	                }
	            } 
	            //Falha ao ler do arquivo
	            catch (IOException ex) {
	                Logger.getLogger(Arvore.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	             	        
	        compac.esvazia();
	        arq.close();
	        compac.arquivoClose();
	        tree = null;
	        System.out.println("Compactado.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
