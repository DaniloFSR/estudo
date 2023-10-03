package br.com.danilofsr.aulatecnologia;

public class AulaTecnologia {
    public static void main(String[] args) {

        
String palavra = "";
int contador = 0;

while(palavra.equals("")&&contador<=5) {
	if(contador == 1){
		palavra = "código java ";
	}
        contador = contador + 1;
}
System.out.println(palavra+contador);

        
    }
}
