//Criar uma outra versão apra criar várias agendas para pessoas diferentes e 
//salvar os dados em um arquivo txt

package br.com.danilofsr.agenda;
import java.util.Scanner;
        
public class Agenda {

    public static void main(String[] args) {
        Compromissos novoCompromisso = new Compromissos();
        Scanner scan = new Scanner(System.in);
        boolean sair = false;
        byte opcao;
        while(!sair){
            System.out.println("""
                               Informe:
                               1 - Ver compromissos
                               2 - Marcar compromisso
                               Outro numero para sair""");
            try{
                opcao = scan.nextByte();
            }catch(Exception e){
                System.err.println("O valor informado é inválido");
                opcao=0;
            }
            if(opcao==1||opcao==2){
                byte mes;
                System.out.println("""
                                   Informe: 
                                   1 - Janeiro\t2 - Fevereiro
                                   3 - Mar\u00e7o\t4 - Abril
                                   5 - Maio\t6 - Junho
                                   7 - Julho\t8 - Agosto
                                   9 - Setembro\t10 - outubro
                                   11 - Novembro\t12 - Dezembro""");
                        try{
                            mes=scan.nextByte();
                        }catch(Exception e){
                            System.err.println("O valor informado é inválido");
                            mes=0;
                        }
                        if(mes<1||mes>12){ 
                            System.err.println("Valor não corresponde a uma opção válida!");
                        }else if(opcao==2){
                            //chamar metodo marcarCompromissos
                            novoCompromisso.setCompromisso(mes);
                        }else{
                            //chamar metodo verCompromissos
                            System.out.println("Agenda nº:"+novoCompromisso.getEndereco());
                            System.out.println(novoCompromisso.consultarCompromissos(mes)+"\n");
                            System.out.println("Total de agendas: "+Compromissos.getTotalAgendas());
                        }                        
            }else{
                sair=true;
            }
        }   
    }
    
}
