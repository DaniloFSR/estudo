
package br.com.danilofsr.projetobanco;


import java.util.Random;
import java.util.ArrayList;

public class Conta extends Cliente {
   
   private static int contasAtivas;
   static ArrayList<String> senha = new ArrayList<String>();
   private Random random = new Random();
   private String essaSenha;
   private double saldo;
   private double limite = 200;
    
   public Conta(String n,String c)  {
      this.nome=n;
      this.cpf=c;

       if(senha.size()>0){
           boolean verificou;
           essaSenha=Integer.toString(random.nextInt(99)+10);
           do {
              verificou=true;
              for(int i=0;i<senha.size();++i){
                 if(senha.get(i).equals(essaSenha)){
                    essaSenha=Integer.toString(random.nextInt(99)+10);
                    verificou=false; 
                    break;
                 }
              }
           }while(verificou=false);
           senha.add(essaSenha);
       }else{
           essaSenha=Integer.toString(random.nextInt(99)+10);
           senha.add(essaSenha);
       }

   }

   public static void setCadastro(int i) {
        contasAtivas = contasAtivas+i;	
   }

   public static int getCadastro() {
        return contasAtivas;
   }   

   public String getCPF() {
 
      return cpf;
   }

   public String getCliente() {
 
        return mostra();
   }

    public String getSenha() {
        return essaSenha;  
    }


    public double getSaldo(){
        return saldo;
    }

    protected void alteraSenha(String senhaNova) {
	essaSenha = senhaNova;
    }

    public boolean deposita(double valor) {
          if(valor>=0){
              saldo=saldo+valor;
              return true;
          }else{
              return false; 
          }
    }


    public String getDados() {
        return mostra()+" \nSenha:"+essaSenha+ " \nLimite: "+Double.toString(limite)+" \nSaldo: "+Double.toString(saldo);
    }  

    public boolean saca(double valor) {
        if((saldo-valor)>=(limite*-1)&&(valor>=0)) {
             saldo=saldo-valor;
             return true;
        } else {
             return false;
        }
    }

    public boolean transfere(double valor, Conta felizada) {
        if(saca(valor)==true) {
            return felizada.deposita(valor);
        }else{
            return false;
        }
    }


    public String transfereDados() {
	return nome+"\r\n"+cpf+"\r\n"+essaSenha+"\r\n"+Double.toString(saldo);
    } 

}

