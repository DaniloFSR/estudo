package br.com.danilofsr.matrizes5;

import java.text.DecimalFormat;
import java.util.Random;


public class NotasAlunos {
    public static void main(String[] args) {
        double[][] notasAlunos = new double[5][4];
        Random random = new Random(); //instancia para gerar valores aleatórios
        for(int i=0; i<notasAlunos.length; i++){ //Laço para atribuir notas e mostrar na tela
            for(int j=0; j<notasAlunos[i].length; j++){
                notasAlunos[i][j]=random.nextDouble(10);
                System.out.println("Aluno"+i+" Nota"+j+" = "+notasAlunos[i][j]);
            }
        }
        System.out.println();    
        DecimalFormat formato = new DecimalFormat("0.00"); 
        for(double[] notas : notasAlunos){ //Exibe as notas com o formato especificado acima
            for(double nota : notas){
               System.out.println(formato.format(nota));
            }
        }
    }            
}
