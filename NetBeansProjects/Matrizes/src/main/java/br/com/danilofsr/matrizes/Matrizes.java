//Atribuir valores numa matriz e imprimi-los na tela
package br.com.danilofsr.matrizes;

public class Matrizes {
    public static void main(String[] args) {
        double[][]x = new double[3][3];
        x[0][0]=10;
        x[0][1]=20;
        x[0][2]=30;
        x[1][0]=40;
        x[1][1]=50;
        x[1][2]=60;
        x[2][0]=70;
        x[2][1]=80;
        x[2][2]=90;
        System.out.print("MATRIZ \n");
        for(int i=0; i<x.length; i++){
            for(int j=0 ; j<x[i].length ; j++){
                System.out.print(i+"|"+j+" = "+x[i][j]+"\t");
            }
            System.out.println();
        }
    } 
}