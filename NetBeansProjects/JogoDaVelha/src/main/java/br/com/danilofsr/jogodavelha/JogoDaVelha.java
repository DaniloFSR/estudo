package br.com.danilofsr.jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
    

public static Scanner scan = new Scanner(System.in);
public static char[][] tabuleiro = new char[3][3];


    public static void main(String[] args) {
        setValorInicial();
        imprimirTabuleiro();
        System.out.println("Jogador 1 = X\tJogador 2 = O\nInforme 0 para sair\n");
        boolean ganhou = false;
        byte jogada = 1;
        char marca;
        while(!ganhou){
            if(jogada %2 == 1){ //Vez do jogador 1
                System.out.println("Jogador 1: escolha a posição");
                marca = 'X';
            }else{ //Vez do jogador 2
                System.out.println("Jogador 2: escolha a posição");
                marca = 'O';
            }
            byte linha = jogada("linha"); //Entrar com valor para linha
            byte coluna = jogada("coluna"); //Entrar com valor para coluna
            if(tabuleiro[linha][coluna]=='X'||tabuleiro[linha][coluna]=='O'){
                System.out.println("Posição já ocupada! Tente novamente");
            }else{
                tabuleiro[linha][coluna] = marca;
                jogada++;
            }
            System.out.println();
            imprimirTabuleiro();
            ganhou = confereJogo(marca);
            if(ganhou==true){
                System.out.println("Parabéns pela vitória jogador "+(jogada%2+1));
            }else if(jogada > 9){
                System.out.println("Ninguem ganhou essa partida");
                ganhou = true;
            }
        }
    }
    
    
    private static byte jogada(String mensagem){
        boolean posicaoValida=false;
        byte posicao = 0;
        while(!posicaoValida){
            System.out.println("Entre com a posição da "+mensagem+" (1-3)");
            posicao = scan.nextByte();
            if(posicao<=3&&posicao>=1){
                posicaoValida=true;
            }else if(posicao==0){
                System.exit(0);
            }else{
                System.out.println("Posição invalida! Tente novamente!");
            }            
        }
        posicao--;
        return posicao;
    }
    
    
    private static void imprimirTabuleiro(){
        for (char[] coluna : tabuleiro) {    
            for (int i = 0; i < tabuleiro.length; i++) {
                System.out.print(coluna[i] + " | ");
            }
        System.out.println();
    }
    }
    
    private static boolean confereJogo(char marca){                                      //Verificação
         return tabuleiro[0][0]==marca&&tabuleiro[0][1]==marca&&tabuleiro[0][2]==marca|| //Linha 1
                tabuleiro[1][0]==marca&&tabuleiro[1][1]==marca&&tabuleiro[1][2]==marca|| //Linha 2
                tabuleiro[2][0]==marca&&tabuleiro[2][1]==marca&&tabuleiro[2][2]==marca|| //Linha 3
                tabuleiro[0][0]==marca&&tabuleiro[1][0]==marca&&tabuleiro[2][0]==marca|| //Coluna 1
                tabuleiro[0][1]==marca&&tabuleiro[1][1]==marca&&tabuleiro[2][1]==marca|| //Coluna 2
                tabuleiro[0][2]==marca&&tabuleiro[1][2]==marca&&tabuleiro[2][2]==marca|| //Coluna 3
                tabuleiro[0][0]==marca&&tabuleiro[1][1]==marca&&tabuleiro[2][2]==marca|| //Diagonal 1
                tabuleiro[0][2]==marca&&tabuleiro[1][1]==marca&&tabuleiro[2][0]==marca;  //Diagonal 2                 
    }
    
    private static void setValorInicial(){  
        for (char[] charInicial : tabuleiro) {
            for (int j = 0; j < tabuleiro.length; j++) {
                charInicial[j] = ' ';
            }
        }
    }
     
    
}
