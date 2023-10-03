/*Criar uma matriz irregular com diferentes tamanhos de vetores

    O usuário deverá entrar com o numero de entrevistados e cada entrevistado
deverá informar o número de filhos e em seguida o nome de cada um deles.
    O tamanho do segundo vetor varia com o numero de filhos que o entrevistado
informar.
*/

package br.com.danilofsr.matrizes3;
import java.util.Scanner;

public class Matrizes3 {  
    public static void main(String args[]){
        System.out.println("Entre com o número de pessoas entrevistadas");
        Scanner scan = new Scanner(System.in);
        int entrevistados = scan.nextInt();
        String[][] nomesFilhos = new String[entrevistados][];
        for(int i=0; i<nomesFilhos.length; i++){
            System.out.println("Entrevistado: "+(i+1)+"\nEntre com a quantidade de filhos");
            int qtdFilhos = scan.nextInt();
            nomesFilhos[i] = new String[qtdFilhos];
            System.out.println("Entre com o(s) nome(s)");
            for(int j=0; j<nomesFilhos[i].length; j++){
                System.out.println("Nome do "+(j+1)+"º filho: ");
                nomesFilhos[i][j] = scan.next();
            }
        }
        System.out.println("\n");
        for(int i=0; i<nomesFilhos.length; i++){
            System.out.println("Entrevistado "+(i+1));
            for(int j=0; j<nomesFilhos[i].length; j++){
               System.out.println(nomesFilhos[i][j]);
            }
            System.out.println();
        }
    }
}
