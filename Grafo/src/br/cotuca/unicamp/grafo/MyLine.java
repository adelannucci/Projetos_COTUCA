package br.cotuca.unicamp.grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class MyLine
{
   private int x1; // x coordinate of first endpoint
   private int y1; // y coordinate of first endpoint
   private int x2; // x coordinate of second endpoint
   private int y2; // y coordinate of second endpoint
   private Color myColor; // color of this shape
   private String l1,l2,l3;

   // constructor with input values
   public MyLine( int x1, int y1, int x2, int y2, Color color, String l1, String l2, String l3 )
   {
      this.x1 = x1; // set x coordinate of first endpoint
      this.y1 = y1; // set y coordinate of first endpoint
      this.x2 = x2; // set x coordinate of second endpoint
      this.y2 = y2; // set y coordinate of second endpoint
      this.l1 = l1;
      this.l2 = l2;
      this.l3 = l3;
      myColor = color; // set the color
   } // end MyLine constructor
   
   // Actually draws the line
   public void draw( Graphics g )
   {
      g.setColor( myColor );
      g.drawString(l1, x1-5, y1-5);
      g.drawString(l2, x2-5, y2-5);
      g.drawString(l3, (x1+x2)/2, (y1+y2)/2);
      g.drawArc(x1-8, y1-8, 10, 10, 0, 360);
      g.drawArc(x2-8, y2-8, 10, 10, 0, 360);
      g.drawLine( x1, y1, x2, y2 );

   } // end method draw
} // end class MyLine

