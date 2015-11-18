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
 * Done Yeeeeah
 */
public class StopwordRemoval {

    public static ArrayList<String> stopwordList = new ArrayList<String>();
    public static ArrayList<String> wordlist = new ArrayList<String>();
    public static ArrayList<String> templist = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int count = 1;
        int counter1 = 0;
        int counter2 = 0;
        int mark = 0;
        //Read Stopword list file
        String inputFile1 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\stoplist.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(new File(inputFile1)));
        String line1 = br1.readLine();
//        StringBuilder sb1 = new StringBuilder();
        while (!("eof").equals(line1)) {
            stopwordList.add(line1);
            line1 = br1.readLine();
        }
//        for(String word : stopwordList){
//            System.out.println(word);
//        }
        /**
         *
         * @author Basis Data Read file yang akan di bersihkan dari stopword
         */

        for (int ite1 = 1; ite1 <= 11429; ite1++) {
            String inputFile2 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\aftersplit\\docs_" + count + ".txt";
            BufferedReader br2 = new BufferedReader(new FileReader(new File(inputFile2)));
            String line2 = br2.readLine();
            while (line2 != null) {
                wordlist.add(line2);
                line2 = br2.readLine();
            }
            for (int i = 0; i < wordlist.size(); i++) {
                for (int j = 0; j < stopwordList.size(); j++) {
                    if (stopwordList.get(j).contains(wordlist.get(i))) {
                        System.out.println("kata : " + i + " adalah " + wordlist.get(i));
                        mark++;
                    }
                }
                if (mark == 0) {
                    templist.add(wordlist.get(i));
                }
                mark = 0;
            }

            File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\stopwordremoval\\docs_" + count + ".txt");
            FileWriter fw = new FileWriter(file);
            for (String str : templist) {
//                System.out.println(str);
                fw.write(str);
                fw.write(System.lineSeparator());
            }

            count++;
            wordlist.clear();
            templist.clear();
            fw.flush();
            fw.close();
        }
//        String inputFile2 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\aftersplit\\docs_5.txt";
//        BufferedReader br2 = new BufferedReader(new FileReader(new File(inputFile2)));
//        String line2 = br2.readLine();
//        while (line2 != null) {
//            wordlist.add(line2);
//            line2 = br2.readLine();
//        }
//
//        System.out.println(stopwordList.size());
//        try {
//            for (int i = 0; i < wordlist.size(); i++) {
//                for (int j = 0; j < stopwordList.size(); j++) {
//                    if (stopwordList.get(j).contains(wordlist.get(i))) {
//                        System.out.println("kata : " + i + " adalah " + wordlist.get(i));
//                        tes.add(i);
//                        mark++;
//                    }
//                }
//                if (mark == 0) {
//                    templist.add(wordlist.get(i));
//                }
//                mark = 0;
//            }
////            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        for (String w : templist) {
//            System.out.println(w);
//        }

//        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\hasilcoy.txt");
//        FileWriter fw = new FileWriter(file);
//        for (String str : templist) {
////                System.out.println(str);
//            fw.write(str);
//            fw.write(System.lineSeparator());
//        }
//        fw.flush();
//        fw.close();

//        for (int i = 0; i < wordlist.size(); i++) {
//            for (int j = 0; j < stopwordList.size(); j++) {
//                if (stopwordList.get(j).contains(wordlist.get(i))) {
//                    wordlist.remove(i);
//                }
//            }
//        }
//        
    }

}
