
package br.com.danilofsr.projetobanco;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Menu{

   private ArrayList<Conta> contas = new ArrayList<>();
   private boolean sair = false;
   private static int exe;    


   public Menu(ArrayList<Conta> dadosContas){
	contas = dadosContas;
   }
    


   public ArrayList<Conta> trabalhaContas(){
   exe=exe+1;

       do {
           
          String op = "sair"; 
          op = JOptionPane.showInputDialog(null,"Informe \n (1) Criar uma conta \n (2) Acessar uma conta existente \n (3) Ver cadastro \n (4) Remover conta \n (sair) Finalizar");

          switch(op){  

             case "1":
                String nome = JOptionPane.showInputDialog(null,"Informe seu nome");
                String cpf = criarCPF();
                if(criar(nome,cpf)==true) {
                     JOptionPane.showMessageDialog(null,"Conta criada com sucesso");
                     JOptionPane.showMessageDialog(null,contas.get(contas.size()-1).getCliente()+"\n Senha: "+contas.get(contas.size()-1).getSenha());
                     System.out.println("\n\nCliente: "+contas.get(contas.size()-1).getCliente()+" - Senha:"+contas.get(contas.size()-1).getSenha());
                } else {
                     JOptionPane.showMessageDialog(null,"Conta não o foi criada. Algo inesperado aconteceu");
                } 
                     continue;

             case "2":
                String op2 = JOptionPane.showInputDialog(null,"Informe: sua senha");
                boolean achouConta=false;
                for(int i=0;i<contas.size();++i){
                     if(op2.equals(contas.get(i).getSenha())){
                         achouConta=true;
                         boolean operacao = acessa(contas.get(i));      
                         if(operacao==true) {
                             JOptionPane.showMessageDialog(null,"Operação sucedida");
                                       if(sair==true){
                                           return contas;
                                       }
                        }else{ 
                              JOptionPane.showMessageDialog(null,"Falha na operação"); 
                        }
                         break;
                     }
                }
                if(achouConta==false) JOptionPane.showMessageDialog(null,"Senha invalida");
                continue;

             case "3":

                String op3 = JOptionPane.showInputDialog(null,"Informe seu CPF");
                boolean encontrou = false;

                for(int i=0;i<contas.size();++i){
                       if(op3.equals(contas.get(i).getCPF())){
                           JOptionPane.showMessageDialog(null,contas.get(i).getCliente()+"\n Senha: "+contas.get(i).getSenha());
                           encontrou=true;
                           break;  
                       }
                       
                }
                if(encontrou==false){
                   JOptionPane.showMessageDialog(null,"CPF não cadastrado");
                }

                continue;


            case "4":
                if(removerConta()==true){
	     JOptionPane.showMessageDialog(null,"Conta removida com sucesso!");
	 }else{
	     JOptionPane.showMessageDialog(null,"Falha na operação!");
                }
 	 continue;


             case "sair":
                sair=true;
                return contas;

             default:
          }

       }while(true);
  
   }

   private String criarCPF(){

      String cpf2;
      boolean verificou=true;

      if(!contas.isEmpty()) {

           cpf2 = JOptionPane.showInputDialog(null,"Informe seu cpf ");


          do{

             for(int i=0;i<contas.size();++i){
                if(contas.get(i).getCPF().equals(cpf2)||cpf2.contains(" ")||cpf2.equals("")) {
                   cpf2 = JOptionPane.showInputDialog(null,"Informe um cpf valido");
                   verificou=false;
                   break; 
                } else {
                   verificou=true;
                }
             }
          } while(verificou==false);

          return cpf2;

      } else {

            cpf2 = JOptionPane.showInputDialog(null,"Informe seu cpf ");
            
            do{
               verificou=true;
               if(cpf2.contains(" ")||cpf2.equals("")) {
                  verificou=false;
                  cpf2 = JOptionPane.showInputDialog(null,"Informe um cpf valido"); 
               }
            }while(verificou==false);

      }

       return cpf2;
 
   } 
    





   private boolean criar(String n, String c) {
      Conta transfere = new Conta(n, c);
      contas.add(transfere);
      Conta.setCadastro(1);
      return true;
   }



   private boolean acessa(Conta titular) {
       String op = JOptionPane.showInputDialog("Cliente: "+titular.getCliente()+"\n Informe: \n"+
       "(1)Saque - (2)Deposito - (3)Transação - (4) Extrato - (sair)Finalizar Operação");
        switch(op){
           case "sair":
           sair=true;
           return sair;

           case "1":
           double valor1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor do saque"));
           return titular.saca(valor1);

           case "2":
           double valor2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor do deposito"));
           return titular.deposita(valor2);

           case "3":
           Conta destino=titular;
           boolean achouConta=false;
           String transfereCPF = JOptionPane.showInputDialog(null,"Informe o CPF da conta destino");
           for(int i=0;i<contas.size();++i){
 	if(transfereCPF.equals(contas.get(i).getCPF())){
	     destino = contas.get(i);
                    achouConta=true;
                    break;
               }
           }
           if(achouConta==true){
                 String prosseguir = JOptionPane.showInputDialog(null,"Confirmar transa  o para: "+destino.getCliente());
	  if(prosseguir.equals("sim")||prosseguir.equals("yes")||prosseguir.equals("s")||prosseguir.equals("y")||prosseguir.equals("prosseguir")){
                       double valor3 = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor da transferencia"));
	        return titular.transfere(valor3,destino);
	   }else{
 	        JOptionPane.showMessageDialog(null,"Transfer ncia cancelada!");
                       return true;
                  }
           } else {
	JOptionPane.showMessageDialog(null,"CPF n o encontrado");
	return false;
           }

           case "4":
	JOptionPane.showMessageDialog(null,titular.getDados());
	return true;

        }

        return true;
   }


  private boolean removerConta() {
      String cpf = JOptionPane.showInputDialog(null,"Informe o cpf da conta que deseja remover");
      String senha = JOptionPane.showInputDialog(null,"Informe a senha relacionada a conta");
      boolean encontrou=false;

	for(int i=0;i<contas.size();++i){
	      if(contas.get(i).getCPF().equals(cpf)&&contas.get(i).getSenha().equals(senha)){
		encontrou=true;
		try{
			contas.remove(contas.get(i));
			JOptionPane.showMessageDialog(null,"Conta removida!");
			Conta.setCadastro(-1);
			return true;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Erro inesperado!");
			return false;
		}
                     }
	}
       if(encontrou==false){
	JOptionPane.showMessageDialog(null,"Contra n o encontrada");
       }
       return false;
   } 


  public boolean getSair(){
          System.out.println("\n\n"+exe+" Clico(s) de Execu  o");
          return sair;
  }

  public ArrayList<Conta> transfereDados(){

  	return contas;

  }

}

