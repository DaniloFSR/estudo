
package br.com.danilofsr.projetobanco;


import javax.swing.JOptionPane;
   
public class Cliente {

  protected String nome,cpf;

      public Cliente() {
      }


      public String mostra() {
          return ("("+"Cliente: "+nome+"\nCPF : "+cpf+")");         
      } 
  
 }

