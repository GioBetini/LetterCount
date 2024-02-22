import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class View {
    public static void main(String[] args) throws Exception { 
        String text = JOptionPane.showInputDialog("Enter text.");
        int [] vet = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String [] alfabeto = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String textMin = text.toLowerCase();
        String trimmedText = textMin.replaceAll("\\s", "");
        for (int i = 0; i < trimmedText.length(); i++){ //i = i+1
            int num = trimmedText.charAt(i);
            vet[num-97] = vet[num-97] + 1;
        }
        try{
            File txt = new File("letter count.txt");
            if (txt.createNewFile()) {
                JOptionPane.showMessageDialog(null, "File created successfully, search for letter count into the start menu");
              } else {
                txt.delete();
                txt.createNewFile();
                JOptionPane.showMessageDialog(null,"Previous file has been deleted and another has been created, search for letter count into the start menu");
              }
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error");
            e.printStackTrace();
        }
        try{
            
            FileWriter escrita = new FileWriter("letter count.txt");
            for(int j = 0; j < vet.length-1; j++ ){
                escrita.write(alfabeto[j]+" = "+vet[j]+"\n");
                
            }
            escrita.close();
        JOptionPane.showMessageDialog(null, "writing was successfully completed");
        } catch (IOException e) {
        JOptionPane.showMessageDialog(null,"Error");
        e.printStackTrace();
        }
        
        //System.out.println(trimmedTexto.length());
        }
}
