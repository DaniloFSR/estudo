package br.com.danilofsr.busca;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico {
    
    static File arquivo;
    static String dados; 
    static String nomeInformado;
    
    
    public Historico(String lista, String nomeInformado){
        this.nomeInformado = nomeInformado;
        String diretorioAtual = System.getProperty("user.dir");
        arquivo = new File (diretorioAtual + File.separator + "Historico_de_Busca.txt");
        dados = leia(arquivo);
        escreva(dados,lista,arquivo); 
    } 
    
    private static String leia (File arquivo){
        String dados = "";
        if (arquivo.exists()){
            try{
                BufferedReader lerArquivo = new BufferedReader(new FileReader(arquivo));
                while(lerArquivo.ready()){
                    dados = dados+lerArquivo.readLine()+"\n";
                }
                lerArquivo.close();
            }catch(IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }    
        }
        return dados;
    }
    
    private static void escreva(String dados, String lista, File arquivo){
            try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
            writer.write(dados);
            writer.write(dataHora());
            writer.write("Nome informado: "+nomeInformado+"\n");
            writer.write(lista);
            writer.newLine();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
    }
    
    
    private static String dataHora(){
        LocalDateTime defineDataHora = LocalDateTime.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        String data = formatoData.format(defineDataHora);
        String hora = formatoHora.format(defineDataHora);
        String dataHora = "Data:"+data+" Hora:"+hora+"\n";
        return dataHora;
    }
    
    public String info(){
        String info = "HISTORICO\n\n"+leia(arquivo);
        return info;
    }
}
