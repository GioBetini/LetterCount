import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class View {
    public static void main(String[] args) throws Exception { 
        String text = JOptionPane.showInputDialog("Insira o texto.");
        int [] vet = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String textMin = text.toLowerCase();
        String trimmedText = textMin.replaceAll("\\s", "");
        for (int i = 0; i < trimmedText.length(); i++){ //i = i+1
            int num = trimmedText.charAt(i);
            vet[num-97] = vet[num-97] + 1;
        }
        try{
            File txt = new File("contagem de letras.txt");
            if (txt.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Arquivo criado, procure por contagem de letras no menu iniciar");
              } else {
                txt.delete();
                txt.createNewFile();
                JOptionPane.showMessageDialog(null,"O arquivo anterior foi excluído e um novo foi criado, procure por contagem de letras no menu iniciar");
              }
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Erro");
            e.printStackTrace();
        }
        try{
            
            FileWriter escrita = new FileWriter("contagem de letras.txt");
            for(int j = 0; j < vet.length-1; j++ ){
                escrita.write(alfabeto[j]+" = "+vet[j]+"\n");
                
            }
            escrita.close();
        JOptionPane.showMessageDialog(null, "A escrita foi concluída com sucesso");
        } catch (IOException e) {
        JOptionPane.showMessageDialog(null,"Erro");
        e.printStackTrace();
        }
        
        //System.out.println(trimmedTexto.length());
        }
}
