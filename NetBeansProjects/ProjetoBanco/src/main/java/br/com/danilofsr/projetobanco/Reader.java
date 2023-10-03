package br.com.danilofsr.projetobanco;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Reader {

ArrayList<Conta> contas = new ArrayList<>();

    public Reader() {
	try{
	String nome,cpf,senha;
	double saldo;
        String diretorioAtual = System.getProperty("user.dir");
	File arquivo = new File(diretorioAtual + File.separator +"Dados.txt");
        if(arquivo.exists()){
            FileReader fw = new FileReader(arquivo);
            BufferedReader bw = new BufferedReader(fw);
            while(bw.ready()){
                nome = bw.readLine();
                cpf = bw.readLine();
                senha = bw.readLine();
                saldo = Double.parseDouble(bw.readLine());
                Conta transfere = new Conta(nome,cpf);
                transfere.deposita(saldo);
                transfere.alteraSenha(senha);
                contas.add(transfere);
            }
            bw.close();
            fw.close();
        }else{ 
            JOptionPane.showMessageDialog(null,"Não há dados disponíveis em: "+arquivo.getAbsolutePath());
        }
	}catch(IOException e){
	    JOptionPane.showMessageDialog(null,"Erro Reader");
	}

    }

    public ArrayList<Conta> retorna() {
	return contas;
    }


}
