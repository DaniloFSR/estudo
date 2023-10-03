/*  Matriz tridimensional
Demonstração de uma matriz com três vetores de tamanho 2 cada
Cada vetor de tamanho 2 está representado um algarismo de numero binário (0 e 1) 
Em seguida:
Demonstração do funcionamento do alinhamento de loops dos três laços for.
*/

package br.com.danilofsr.matrizes2;

public class Matrizes2{
    public static void main(String args[]){
        double matriz[][][]=new double[2][2][2];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                for(int k=0; k<matriz[i][j].length; k++){
                    matriz[i][j][k] = i*Math.pow(2,2)+j*Math.pow(2,1)+k*Math.pow(2,0);
                    System.out.print(i+"|"+j+"|"+k+" = "+matriz[i][j][k]+"\t");
                }
                System.out.println();
            }
        }
        System.out.println("Demonstração do alinhamento dos laços for cada um em"
                + " função do tamanho de cada vetor");
        for(int i=0; i<matriz.length; i++){
            System.out.println("Começo do for i("+i+") < matriz length");
            for(int j=0; j<matriz[i].length; j++){
                System.out.println("Começo do for j("+j+") < matriz length");
                for(int k=0; k<matriz[i][j].length; k++){
                    System.out.println("k("+k+") < matriz length");
                }
                System.out.println("Fim do for j("+j+") < matriz length");
            }
            System.out.println("Fim do for i("+i+") < matriz length");
        }
    }
}