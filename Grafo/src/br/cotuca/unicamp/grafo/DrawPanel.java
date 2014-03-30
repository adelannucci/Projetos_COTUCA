package br.cotuca.unicamp.grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
   private Random randomNumbers = new Random();   
   private MyLine lines[]; // array on lines
   private int acc = 0;
   // constructor, creates a panel with random shapes
   public DrawPanel(Vias[][] via, int  i)
   {
      setBackground( Color.WHITE );
      lines = new MyLine[ i*i ];
      printMap(i, via);
      
      
   } // end DrawPanel constructor
   
   private void printMap(int i, Vias[][] via){

	      // create lines
	      for ( int lin = 0; lin < i; lin++ )
	      {
	    	  for(int col = 0; col<i; col++){
	    		  // generate random coordinates
	    		  if(via[lin][col].isExiste())
	    		  {
		    		  int x1 = via[lin][col].getCidade1().getX();
		    		  int y1 = via[lin][col].getCidade1().getY();
		    		  int x2 = via[lin][col].getCidade2().getX();
		    		  int y2 = via[lin][col].getCidade2().getY();
		    		  // generate a random color
		    		  Color color = new Color( 0, 0, 0 );
		    		  if(via[lin][col].isPassar())
		    			  color = new Color( 255, 0, 0 );
		          
		 	         // add the line to the list of lines to be displayed
		 	         lines[ acc++ ] = new MyLine( x1, y1, x2, y2, color,via[lin][col].getCidade1().getNome(), via[lin][col].getCidade2().getNome(), (int)via[lin][col].getDistancia()+"");
	    		  } 
	    	  }
	      } // end for 
   }

   // for each shape array, draw the individual shapes
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      // draw the lines
      for ( int i = 0; i<acc; i++ )
         lines[i].draw( g );
   } // end method paintComponent
} // end class DrawPanel
