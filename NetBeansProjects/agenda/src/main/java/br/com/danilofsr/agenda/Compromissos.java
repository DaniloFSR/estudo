package br.com.danilofsr.agenda;

import java.util.Scanner;

public class Compromissos {
    
    private static int quantidadeAgendas;   
    private int id;
    private String[][][] compromissos = new String[12][31][25]; 
    
    
    public Compromissos(){
        quantidadeAgendas++;
        id = quantidadeAgendas;
    }

    
    public void setCompromisso(byte mes){ 
        Scanner scan = new Scanner(System.in);
        byte dia=12;
        byte horario=0;
        boolean valoresValidos=false;
        while(!valoresValidos){
            System.out.println("Informe o dia\nsair para cancelar");
            String sDia = scan.next();
            if(sDia.equals("sair")){System.exit(0);}
            System.out.println("Informe o horário do seu compromisso\nsair para cancelar");
            String sHorario = scan.next();
            if(sHorario.equals("sair")){System.exit(0);}
            if(sDia.matches("\\d+")&&sHorario.matches("\\d+")){
                dia = Byte.parseByte(sDia);
                horario = Byte.parseByte(sHorario);
                if(dia<=31&&dia>=1&&horario>=0&&horario<=24){
                   valoresValidos=true;
                }else{
                    System.out.println("Incompatibilidade no(s) valor(res) informado(s)! Por favor tente novamente!");
                }
            }else{
                System.out.println("Incompatibilidade no(s) tipo(s) do(s) valor(res) informado(s)! Por favor tente novamente!");    
            }
        }
        System.out.println("Escreva o compromisso");
        String compromisso = scan.next();
        boolean horarioDisponivel = false;
        if(compromissos[mes-1][dia-1][horario]==null){
            horarioDisponivel = true;
        }
        if(horarioDisponivel){
            compromissos[mes-1][dia-1][horario] = compromisso;
            System.out.println("Compromisso marcado com sucesso!");
        }else{
            System.err.println("Ja existe um compromisso neste horário");
            System.out.println("Mes: "+mes+" Dia: "+dia+" "+compromissos[mes-1][dia-1][horario]);
        }      
    }
    
    
    public String consultarCompromissos(byte mes){
        String agenda="";
        for(int i=0; i<compromissos[mes-1].length; i++){
            boolean dia = true;
            for(int j=0; j<compromissos[mes-1][i].length; j++){
                if(compromissos[mes-1][i][j]!=null){
                if(dia){
                    agenda = agenda+"\nDia: "+(i+1)+"\n";
                    dia = false;
                }
                    agenda = agenda+"Horario: "+j+" | "+compromissos[mes-1][i][j]+"\n";
                }
            }
        }
        return agenda;
    }
    
    
    public int getEndereco(){
        return id;
    }
    
    
        public static int getTotalAgendas(){
        return quantidadeAgendas;
    }
        
    
}
