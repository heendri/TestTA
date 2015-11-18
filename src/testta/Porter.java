/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testta;

/**
 *
 * @author Hendri
 */
//import org.apache.lucene.analysis.PorterStemmer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.tartarus.snowball.ext.PorterStemmer;

public class Porter {

    public static ArrayList<String> termList = new ArrayList<String>();
    public static ArrayList<String> tempList = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int count = 1;
        PorterStemmer stem = new PorterStemmer();

        for (int ite1 = 1; ite1 <= 11429; ite1++) {
            String inputFile2 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\stopwordremoval\\docs_" + count + ".txt";
            BufferedReader br2 = new BufferedReader(new FileReader(new File(inputFile2)));
            String line2 = br2.readLine();
            System.out.println("Processing data ke-"+count+"");
            while (line2 != null) {
                termList.add(line2);
                line2 = br2.readLine();
            }
            for (int i = 0; i < termList.size(); i++) {
                stem.setCurrent(termList.get(i));
                stem.stem();
                tempList.add(stem.getCurrent());
            }

            File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\fix\\docs_" + count + ".txt");
            FileWriter fw = new FileWriter(file);
            for (String str : tempList) {
//                System.out.println(str);
                fw.write(str);
                fw.write(" ");
            }
            count++;
            tempList.clear();
            termList.clear();
            fw.flush();
            fw.close();
            System.out.println("Done");

        }

//        String inputFile2 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\yoi.txt";
//        BufferedReader br2 = new BufferedReader(new FileReader(new File(inputFile2)));
//        String line2 = br2.readLine();
//        while (line2 != null) {
//            termList.add(line2);
//            line2 = br2.readLine();
//        }
//        System.out.println(termList.size());
//        PorterStemmer stem = new PorterStemmer();
//        for (int i = 0; i < termList.size(); i++) {
//            stem.setCurrent(termList.get(i));
//            stem.stem();
//            tempList.add(stem.getCurrent());
////            System.out.println(termList.get(i));
//        }
//        System.out.println("Sebelum di Stemming.......");
//        for(String s : termList){
//            System.out.println(s);
//        }
//        System.out.println("Setelah di Stemming........");
//        for(String x : tempList){
//            System.out.println(x);
//        }
//        System.out.println("Start");
//        PorterStemmer stem = new PorterStemmer();
//        stem.setCurrent("relational");
//        stem.stem();
//        System.out.println(stem.getCurrent());
//        System.out.println("End");
    }
}
