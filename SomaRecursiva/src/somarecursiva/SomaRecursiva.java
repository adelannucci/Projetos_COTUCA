/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package somarecursiva;

/**
 *
 * @author u11248
 */
public class SomaRecursiva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int i = soma(5,3);
       System.out.println(i);
       i = subtracao(5,3);
       System.out.println(i);
       i = multiplicacao(2,3);
       System.out.println(i);
       i = divisao(6,2);
       System.out.println(i);
       //System.out.println(positivo(10));
       
    }
    
    private static int soma(int x, int y){
        int result = 0;
        if (y == 0){
            return (x);
        }
        
        if(y>0){
            x++;
            y--;
            result = soma(x, y);  
        }else{
            x--;
            y++;
            result = soma(x, y);    
        }
        return result;
    }
    
    private static int subtracao(int x, int y){
        int result = 0;
        if (y == 0){
            return x;
        }
        
        if(y>0){
            x--;
            y--;
            result = subtracao(x, y);  
        }else{
            x--;
            y++;
            result = subtracao(x, y);    
        }
        return result;
    }
    
    private static int multiplicacao(int x, int y){
        if(y==1){
            return x;
        }
        if(y>0){
            y--;
            return soma(multiplicacao(x,y),x);
        }else{
            y++;
            return subtracao(multiplicacao(x,y),x);
        }

    }
    /*
    3*4
    3*3+3
    3*2+3
    3*1+3
    3*/
    
    private static int divisao(int x, int y){
        if(negativo(x) == negativo(y)){
            if(negativo(subtracao(x,y)) == negativo(x))
                return soma(divisao(subtracao(x,y),y),1);
            return 0;
        }
        
        if(negativo(soma(x,y)) == negativo(x)){
            return subtracao(divisao(soma(x,y),y),1); 
        }
        
        return 0;
        
        
   
    }
    
   //((x-y) /y) + 1
    
    private static boolean negativo(int a){
        
        if(a<0)
            return true;
        
        return false;
    }
    
}
