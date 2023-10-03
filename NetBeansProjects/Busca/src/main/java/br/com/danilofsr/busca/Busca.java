package br.com.danilofsr.busca;

import javax.swing.JOptionPane;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Busca {
    
    static int quantidadeDeBuscas=0;
    static int quantidadeDeArquivos=0;

    public static void main(String[] args) {
       String diretorio = System.getProperty("user.dir");
       String nomeArquivoInformado = JOptionPane.showInputDialog("Informe o nome do arquivo.");
       
       List<File> resultados = new ArrayList<>();
       buscarArquivos(new File(diretorio),nomeArquivoInformado,resultados);
       quantidadeDeArquivos = resultados.size();
       String lista_de_arquivos = "";      
       if (!resultados.isEmpty()) {
           for (File arquivo : resultados) {
               lista_de_arquivos = lista_de_arquivos + arquivo.getAbsolutePath() + "\n\n";
           }
           JOptionPane.showMessageDialog(null,quantidadeDeArquivos+" arquivo(s) encontrado(s): \n" + lista_de_arquivos);    
       } else {
           JOptionPane.showMessageDialog(null,"Nenhum arquivo encontrado com o nome: " + nomeArquivoInformado);
       }
       Historico registro = new Historico(lista_de_arquivos, nomeArquivoInformado);
    }
    
    private static void buscarArquivos(File diretorio, String nomeArquivo, List<File> resultados){
        quantidadeDeBuscas++;
        System.out.println("Busca nº: "+quantidadeDeBuscas+" Em diretorio: "+diretorio);
        File[] arquivos = diretorio.listFiles();
        if(arquivos!=null){
            for(File arquivo : arquivos){
                if(arquivo.isDirectory()){
                    buscarArquivos(arquivo, nomeArquivo, resultados);
                }else{
                    String formatoNomeArquivoProcurado = nomeArquivo.toLowerCase().replaceAll("\\s","");
                    formatoNomeArquivoProcurado = removerAcentos(formatoNomeArquivoProcurado);
                    String formatoNomeArquivo = arquivo.getName().toLowerCase().replaceAll("\\s","");
                    formatoNomeArquivo = removerAcentos(formatoNomeArquivo);
                    if(formatoNomeArquivo.contains(formatoNomeArquivoProcurado)){
                        resultados.add(arquivo);
                    }
                }
            }
        }
    }
    
    private static String removerAcentos(String nome){
        String nomeNormalizado = Normalizer.normalize(nome, Normalizer.Form.NFD);
        Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return padrao.matcher(nomeNormalizado).replaceAll("");
    }
    
   
}
