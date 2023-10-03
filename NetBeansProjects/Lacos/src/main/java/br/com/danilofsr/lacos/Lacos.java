package br.com.danilofsr.lacos;


public class Lacos {

    public static void main(String[] args) {
        
        int inteiro=0;
        do{
            for(int i=0,j=10; i<=j; i++,j--,inteiro++){
               System.out.println("i = "+i+" j = "+j+" inteiro: "+inteiro);
                if(inteiro==20)break;
            }
        }while(inteiro<20);
        
        System.out.println("\n----------------------------------");
        
        int soma=0;
        for(int i=1; i<5; soma += i++);
        System.out.println("\n A soma é:"+soma);
           
        System.out.println("\n----------------------------------");
        
        String lista[] = new String[10];
        int n=0;        
        for(int i=0; i<lista.length; i++){
            lista[i] = "item"+i;
        }
        for(String item : lista){
            System.out.println(item);
        }
    }
}
