package br.com.danilofsr.jogodavelhajop;

import javax.swing.JOptionPane;

public class JogoDaVelhaJOp {

    
    private static char tabuleiro[][] = new char[3][3];
    private static char marca;
    
    public static void main(String[] args) { 
        setValorInicial();
        byte turno = 1;
        boolean ganhou = false;
        String jogador;
        while(!ganhou){
            if(turno%2==1){
                jogador="Jogador 1";
                marca='X';
            }else{
                jogador="Jogador 2";
                marca='O';
            }
            byte coluna = jogada(jogador,"coluna");
            byte linha = jogada(jogador,"linha");
            if(tabuleiro[linha][coluna]=='X'||tabuleiro[linha][coluna]=='O'){
                JOptionPane.showMessageDialog(null,"Posição já ocupada! Tente novamente!");
            }else{
                tabuleiro[linha][coluna]=marca;
                turno++;
            }
            ganhou=confereJogo();
            if(ganhou){
                JOptionPane.showMessageDialog(null,"Parabéns pela vitória jogador "+(turno%2+1)+"\n"+imprimirTabuleiro());
                ganhou = true;
            }else if(turno>9){
                JOptionPane.showMessageDialog(null, "Fim dos turnos! Empate!"+"\n"+imprimirTabuleiro());
                ganhou=true;
            }
        }
        System.exit(0);
    }
    
    private static byte jogada(String jogador, String mensagem){
        boolean jogadaValida=false;
        byte posicao=' ';
        while(!jogadaValida){
            String info = JOptionPane.showInputDialog(null,jogador+"\nInforme 1 a 3 para a posição da "+mensagem+"\n0 - Para sair"+"\n"+imprimirTabuleiro());                            
            if(info.equals("1")||info.equals("2")||info.equals("3")){
                posicao = Byte.parseByte(info); 
                jogadaValida=true;
            }else if(info.equals("0")){
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null, "A posição informada não é um valor válido!");
            }      
        }
        posicao--;
        return posicao;
    }
    
    private static boolean confereJogo(){
    return tabuleiro[0][0]==marca&&tabuleiro[0][1]==marca&&tabuleiro[0][2]==marca|| //Linha 1
           tabuleiro[1][0]==marca&&tabuleiro[1][1]==marca&&tabuleiro[1][2]==marca|| //Linha 2
           tabuleiro[2][0]==marca&&tabuleiro[2][1]==marca&&tabuleiro[2][2]==marca|| //Linha 3
           tabuleiro[0][0]==marca&&tabuleiro[1][0]==marca&&tabuleiro[2][0]==marca|| //Coluna 1
           tabuleiro[0][1]==marca&&tabuleiro[1][1]==marca&&tabuleiro[2][1]==marca|| //Coluna 2
           tabuleiro[0][2]==marca&&tabuleiro[1][2]==marca&&tabuleiro[2][2]==marca|| //Coluna 3
           tabuleiro[0][0]==marca&&tabuleiro[1][1]==marca&&tabuleiro[2][2]==marca|| //Diagonal 1
           tabuleiro[0][2]==marca&&tabuleiro[1][1]==marca&&tabuleiro[2][0]==marca;  //Diagonal 2
    }
    
    private static String imprimirTabuleiro(){
        String tab="\n                Colunas\n                1   2   3\n";
        for(int i=0; i<tabuleiro.length; i++){
            if(i==1){
                tab=tab+"Linhas  2  ";
            }else{
                tab=tab+"             "+(i+1)+"  ";
            }
            for(int j=0; j<tabuleiro.length; j++){
                tab = tab+tabuleiro[i][j] + " | " ;                
            }
            tab = tab+"\n";
        }
        return tab;
    }
    
    
    private static void setValorInicial(){
        for(int i=0; i<tabuleiro.length; i++){
            for(int j=0; j<tabuleiro[i].length; j++){
                tabuleiro[i][j]='-';
            }
        }
    }
    
    
}
