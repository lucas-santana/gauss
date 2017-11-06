/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Lucas Santana
 *          Richard Rosatti
 *
 *          Teste
 */
public class EliminacaoGauss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=3;//ordem da matriz

        Metodos metodos = new Metodos();


       
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

        //matriz exemplo 2 aula 11  que não pode ser resolvido sem pivoteamento
        double mat4[][] = {{2,2,-1},{3,3,1},{1,-1,5}};
        double b4[] = {3,7,5};
        double x4[];


        x = metodos.triangularInferior(mat.length,mat,b);
        x2 = metodos.triangularSuperior(mat2.length, mat2, b2);
        x3 = metodos.gauss(mat3.length, mat3, b3);
        x4 = metodos.gaussComPivotamentoParcial(mat4.length,mat4,b4);


        metodos.imprimirVetor(x4);



        //Teste para saber se está trocando a linha corretamente
       /* metodos.imprimirMatriz(mat4);
        metodos.trocaLinhas(0,1,mat4);

        System.out.println("------------------------------------");

        metodos.imprimirMatriz(mat4);*/

    }
    
    
    
    

     
     
    
}
