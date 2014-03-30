/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.Random;

/**
 *
 * @author adelannucci
 */
public class MapControlCenter {

    public int currentMap;
    private int maxMap;
    private byte fuelX;
    private byte fuelY;
    private Random rand;
    
    public MapControlCenter(byte max){
        currentMap = 0;
        maxMap = max;
        rand = new java.util.Random();
    }
    
    //chama o proximo mapa
    public int nextMap(){
        //currentMap++;
        //int nextMap = 0;
        /*while(true){
            nextMap = rand.nextInt(maxMap)+1;
            if(currentMap != nextMap){
                currentMap = nextMap;
                break;
            }*/
        currentMap ++;
        if (currentMap == 9){
            currentMap = 1;
            
        }
        
        /*
        if(this.currentMap == maxMap){
            this.currentMap = 1;
        }
        */
        pointFuel();
        return this.currentMap;
    }
    
    //define a localizacao do fuel
    private void pointFuel(){
      switch(currentMap){
             case 1:
                 fuelX = 10;
                 fuelY = 27;
                 break;
             case 2:
                 fuelX = 5;
                 fuelY = 25;
                 break;
             case 3:
                 fuelX = 5;
                 fuelY = 35;
                 break;
             case 4:
                 fuelX = 5;
                 fuelY = 38;
                 break;
             case 5:
                 fuelX = 6;
                 fuelY = 34;
                 break;
             case 6:
                 fuelX = 6;
                 fuelY = 28;
                 break;
             case 7:
                 fuelX = 10;
                 fuelY = 33;
                 break;
             case 8:
                 fuelX = 9;
                 fuelY= 21;
             default:
                 break;
         } 
    }
    
    public byte getFuelX(){return fuelX;}
    public byte getFuelY(){return fuelY;}
    
    
}
