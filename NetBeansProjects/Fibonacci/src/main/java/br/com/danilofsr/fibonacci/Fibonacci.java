package br.com.danilofsr.fibonacci;

import java.util.Scanner;


public class Fibonacci {
    
    public static int[] sequenciaFibonacci;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int posicao = scan.nextInt(); 
        sequenciaFibo(posicao);
        System.out.println(sequenciaFibonacci[posicao-1]);
    }
    
    public static void sequenciaFibo(int num){
        sequenciaFibonacci = new int[num];
        for(int i=0; i<num; i++){
            sequenciaFibonacci[i] = calcularFibonacci(i);
        } 
    }
    
    public static int calcularFibonacci(int num){
        if(num < 2){
            return 1;
        }
        return calcularFibonacci(num-1) + calcularFibonacci(num-2);
    }
    
}
