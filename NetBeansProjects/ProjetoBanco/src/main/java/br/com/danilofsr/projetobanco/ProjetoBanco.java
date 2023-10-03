package br.com.danilofsr.projetobanco;

import java.util.ArrayList;

public class ProjetoBanco{

  

  public static void main(String args[]) {

      Reader r = new Reader();
      ArrayList<Conta> contas = r.retorna();

      Menu execute = new Menu(contas);
      contas = execute.trabalhaContas();

      execute.getSair();

      Writer w = new Writer(contas);


  }

}
