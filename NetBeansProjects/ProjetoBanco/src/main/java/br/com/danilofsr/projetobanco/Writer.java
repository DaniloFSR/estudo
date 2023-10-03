
package br.com.danilofsr.projetobanco;


import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Writer{

    public Writer(ArrayList<Conta> contas) {


        try {

        String escreve;

        String diretorioAtual = System.getProperty("user.dir");
        File arquivo = new File(diretorioAtual + File.separator + "Dados.txt");
        FileWriter fw = new FileWriter(arquivo);
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=0;i<contas.size();++i){
	escreve = contas.get(i).transfereDados();
	bw.write(escreve);
	bw.newLine();
        }

        bw.close();
        fw.close();

        }catch(IOException e) {
	JOptionPane.showMessageDialog(null,"Erro Writer");
        }


    }

}
