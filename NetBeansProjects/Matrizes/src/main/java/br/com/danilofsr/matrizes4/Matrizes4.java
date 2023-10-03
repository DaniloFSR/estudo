//Encontrar o maior numero gerado aleatoreamente em uma matriz
package br.com.danilofsr.matrizes4;
import java.util.Random;

public class Matrizes4 {
    public static void main (String args[]){
       int matriz[][] = new int[4][4]; 
       Random random = new Random();
       for(int i=0; i<matriz.length; i++){
           for(int j=0; j<matriz[i].length;j++){
               matriz[i][j] = random.nextInt(1000);
           }
       }
       int maior = 0;
       int coluna = 0;
       int linha = 0;
       for(int i=0; i<matriz.length; i++){
           for(int j=0; j<matriz[i].length;j++){
               if(matriz[i][j]>maior){
                   maior = matriz[i][j];
                   linha = i;
                   coluna = j;
               }
           }
       }
       System.out.println("Maior valor da matriz é "+maior+" e está na linha "+linha
       +" e coluna "+coluna+"\n");
       System.out.println(matriz[linha][coluna]+"\n");
       for(int i=0; i<matriz.length; i++){
           for(int j=0; j<matriz[i].length;j++){
               System.out.print(matriz[i][j]+"(linha:"+i+"|coluna:"+j+")\t");
           }
           System.out.println();
       }
    }
}
