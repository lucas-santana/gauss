/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas Santana
 *          Richard Rosatti
 */
public class EliminacaoGauss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int n=4;
       
       //matriz para triangular inferior
        double mat[][] = {{2,0,0,0},{3,5,0,0},{1,-6,8,0},{-1,4,-3,9}};
        double b[] = {4,1,48,6};
        double x[];
        
        //matriz para triangular superior
        double mat2[][] = {{5,-2,6,1},{0,3,7,-4},{0,0,4,5},{0,0,0,2}};
        double b2[] = {1,-2,28,8};
        double x2[];
        
        //matriz para resolução de gauss
        double mat3[][] = {{1,0,1},{1,1,0},{2,3,1}};
        double b3[] = {0,1,1};
        double x3[];
        
        
        
        
      /*  for (int i=0;i<n;i++){
            
            
            for (int j=0;j<n;j++){
               System.out.print("\t"+mat[i][j]);
            }
             System.out.println();
            
            
        }*/
        
        //x = triangularInferior(n,mat,b);
        //x2 = triangularSuperior(n, mat2, b2);
        x3 = gauss(n, mat2, b2);
          
          
        for(int i=0;i<n;i++){
            System.out.println(x3[i]);
        }
    }
    
    
    
    
     public static double[] triangularInferior(int n, double mat[][],double b[]){
        
        double x[] = new double[n];
        double soma = 0.0;
        x[0] = b[0]/mat[0][0];
        
        for (int i=1;i<n;i++){
            soma = 0.0;
            
            for (int j=0;j<i;j++){
                soma = soma + mat[i][j]*x[j];
            }
            
            x[i] = (b[i]-soma)/mat[i][i];
        }
        return x;
    }
     
     
     public static double[] triangularSuperior(int n, double mat[][],double b[]){
         
         double x[] = new double[n];
        double soma = 0.0;
        x[n-1] = b[n-1]/mat[n-1][n-1];
        
        for (int i=n-2;i>=0;i--){
            soma = 0.0;
            
            for (int j=n-1;j>=0;j--){
                soma = soma + mat[i][j]*x[j];
            }
            
            x[i] = (b[i]-soma)/mat[i][i];
        }
        return x;
         
     }
     
     public static double[] gauss(int n, double mat[][],double b[]){
         double m;
         double x[] = new double[n];
         
         for(int k=0;k<=n-1;k++){
             for (int i=k+1;i<n;i++){
                 m = mat[i][k]/mat[k][k];
                 
                 for (int j=k;j<n;j++){
                     mat[i][j] = mat[i][j] - m*mat[k][j];
                 }
                 b[i] = b[i]- m*b[k];
             }
             
         }
         
         x = triangularSuperior(n, mat, b);
         return x;
     }
     
     
    
}
