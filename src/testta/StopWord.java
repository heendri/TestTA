/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testta;

import com.sun.xml.internal.fastinfoset.EncodingConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hendri
 */
public class StopWord {

    public static String[] stopWordsofwordnet = {
        "without", "see", "unless", "due", "also", "must", "might", "like", "]", "[", "}", "{", "<", ">", "?", "\"", "\\", "/", ")", "(", "will", "may", "can", "much", "every", "the", "in", "other", "this", "many", "any", "an", "or", "for", "in", "an", "an ", "is", "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren’t", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can’t", "cannot", "could",
        "couldn’t", "did", "didn’t", "do", "does", "doesn’t", "doing", "don’t", "down", "during", "each", "few", "for", "from", "further", "had", "hadn’t", "has", "hasn’t", "have", "haven’t", "having",
        "he", "he’d", "he’ll", "he’s", "her", "here", "here’s", "hers", "herself", "him", "himself", "his", "how", "how’s", "i ", " i", "i’d", "i’ll", "i’m", "i’ve", "if", "in", "into", "is",
        "isn’t", "it", "it’s", "its", "itself", "let’s", "me", "more", "most", "mustn’t", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "ought", "our", "ours", "ourselves",
        "out", "over", "own", "same", "shan’t", "she", "she’d", "she’ll", "she’s", "should", "shouldn’t", "so", "some", "such", "than",
        "that", "that’s", "their", "theirs", "them", "themselves", "then", "there", "there’s", "these", "they", "they’d", "they’ll", "they’re", "they’ve",
        "this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn’t", "we", "we’d", "we’ll", "we’re", "we’ve",
        "were", "weren’t", "what", "what’s", "when", "when’s", "where", "where’s", "which", "while", "who", "who’s", "whom",
        "why", "why’s", "with", "won’t", "would", "wouldn’t", "you", "you’d", "you’ll", "you’re", "you’ve", "your", "yours", "yourself", "yourselves"};

    public static ArrayList<String> wordsList = new ArrayList<String>();
    public static ArrayList<String> numbList = new ArrayList<String>();
    public static ArrayList<String> stopwordList = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        String s = "This String Contains the stop words like is am are so this program will remove all of them at your will thanks to you for watching this tutorial";
//        s = s.trim().toLowerCase().replaceAll("\\s+", " ");
//        String[] words = s.split(" ");
        //Input data to numblist stopword
        for (int i = 1; i <= 11429; i++) {
            numbList.add(Integer.toString(i));
        }
        String inputFile1 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\stoplist.txt";
            BufferedReader br1 = new BufferedReader(new FileReader(new File(inputFile1)));
            String line1 = br1.readLine();
            StringBuilder sb1 = new StringBuilder();
            String[] words1 = line1.split(" ");
        while(!("eof").equals(line1)){
            stopwordList.add(line1);
            line1 = br1.readLine();
        }
        System.out.println(stopwordList.size());
//            //Masukkan String ke wordlist
//            for (String word : words1) {
//                stopwordList.add(word);
//            }
        int jmldata = 5;
        int count = 1;
//        String inputFile = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\docs_1.txt";
//        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
//        String line = br.readLine();
//        StringBuilder sb = new StringBuilder();
//        int count = 1;
//        String[] words = line.split(" ");
        for (int tempi = 1; tempi <= 11429; tempi++) {
            String inputFile = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\datasplit\\docs_" + count + ".txt";
            BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            String[] words = line.split(" ");
            //Masukkan String ke wordlist
            for (String word : words) {
                wordsList.add(word);
            }

            //Outputkan isi wordlist
//            for (String wordsList1 : wordsList) {
//                System.out.println(wordsList1);
//            }
            System.out.println("udah");
            System.out.println(wordsList.size());
            //remove stop words here from the temp list
//            for (int i = 0; i < wordsList.size(); i++) {
//                // get the item as string
//                for (int j = 0; j < stopWordsofwordnet.length; j++) {
//                    if (stopWordsofwordnet[j].contains(wordsList.get(i))) {
//                        wordsList.remove(i);
//                    }
//                }
//            }
//            for (int i = 0; i < wordsList.size(); i++) {
//                // get the item as string
//                for (int j = 0; j < stopwordList.size(); j++) {
//                    if (stopwordList.get(j).contains(wordsList.get(i))) {
//                        wordsList.remove(i);
//                    }
//                }
//            }
            for (int i = 0; i < wordsList.size(); i++) {
                for (int j = 0; j < numbList.size(); j++) {
                    if (numbList.get(j).contains(wordsList.get(i))) {
                        wordsList.remove(i);
                    }
                }
            }
            //Output data ke file
            File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\tes\\docs_" + count + ".txt");
            FileWriter fw = new FileWriter(file);
            for (String str : wordsList) {
//                System.out.println(str);
                fw.write(str);
                fw.write(System.lineSeparator());
            }
            wordsList.clear();
//            words =null;
            count++;
           fw.flush();
           fw.close(); 
        }
        
        //Outputkan isi wordlist
//            for (String wordsList1 : stopwordList) {
//                System.out.println(wordsList1);
//            }

//        stopWordsofwordnet[210] = "1";
//        System.out.println(stopWordsofwordnet[211]);
//        System.out.println(stopWordsofwordnet[210]);
//        System.out.println(numbList.get(9));
//        System.out.println("Tes");
//
//        wordsList.clear();
//        for (String str : wordsList) {
//            System.out.println(str);
//        }
        
    }
}
