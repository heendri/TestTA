/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Basis Data
 */
public class Tokenize {
    public static ArrayList<String> wordsList = new ArrayList<String>();
    public static void main(String[] asrStrings) throws FileNotFoundException, IOException{
        int count=1;
        for(int i=1;i<=5;i++){
            String inputFile = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\datasplit\\docs_" + count + ".txt";
            BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
            String line = br.readLine();
//            StringBuilder sb = new StringBuilder();
            String[] words = line.split(" ");
            System.out.println(words.length);
            
            for(String word : words){
                wordsList.add(line);
            }
            File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\ver2\\yoi" + count + ".txt");
            FileWriter fw = new FileWriter(file);
            for (String str : wordsList) {
                fw.write(str);
                fw.write(System.lineSeparator());
            }
            System.out.println("wordlist : "+wordsList.size()+"");
            wordsList.clear();
            count++;
            fw.flush();
            fw.close(); 
        }
    }
}
