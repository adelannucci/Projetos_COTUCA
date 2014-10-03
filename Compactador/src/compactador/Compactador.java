/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compactador;

import java.io.FileNotFoundException;

/**
 *
 * @author u11248
 */
public class Compactador {

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
    	
    	//String fileName = "Teste.txt";
    	//String fileName = "lena.bmp";
    	String fileName = "Biblia.txt";
    	//String fileName = "GIMPPortable.exe";
    	
    	Codificador cd = new Codificador(fileName);
    	cd.compactar();
    	
    	Decodificador des = new Decodificador(fileName);
    	des.iniciar();
		

    }
}
