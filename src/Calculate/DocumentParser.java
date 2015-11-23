/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Hendri
 */
public class DocumentParser {

//    private ArrayList<String[]> termsDocsArray = new ArrayList<String[]>();//all token
    public List<String[]> termsDocsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();//hold docs vector
    private List<float[]> tfDocsVector = new ArrayList<float[]>();//hold docs vector
    private List<float[]> NIDFDocsVector = new ArrayList<float[]>();//hold docs vector
//    private final List<int> DocScore = new ArrayList<int>();//hold docs vector
    ArrayList<Float> arrScore= new ArrayList<Float>();
    

    /**
     * Method to create termVector according to its tfidf score.
     */
//    public double tfCalculator(String[] totalterms, String termToCheck) {
//        double count = 0;  //to count the overall occurrence of the term termToCheck
//        for (String s : totalterms) {
//            if (s.equalsIgnoreCase(termToCheck)) {
//                count++;
//            }
//        }
//        return count / totalterms.length;
//    }
    public double tfCalculator(String[] totalterms, String termToCheck) {
        float count = 0;  //to count the overall occurrence of the term termToCheck
        for (String s : totalterms) {
            if (s.equalsIgnoreCase(termToCheck)) {
                count++;
            }
        }

        if (count > 0) {
            return (1 + (Math.log10(count)));
        } else {
            return 0;
        }

    }

    public void termOccurence() {
        System.out.println("Term Occurence...");
        int mark = 0;
        boolean tanda = false;
        int count = 0;
        double jmldata = termsDocsArray.size();
        float[] tfvectors = new float[allTerms.size()];
        System.out.println(termsDocsArray.size());
        for (String s : allTerms) {
            for (int i = 0; i < termsDocsArray.size(); i++) {
                String[] ss = termsDocsArray.get(i);
                for (int j = 0; j < ss.length; j++) {
//                    System.out.println("panjang array : "+ss.length);
//                    System.out.println(ss[j]);
//                    System.out.println(tanda);
                    if (s.equalsIgnoreCase(ss[j])) {
                        tanda = true;
                    }
                }

                System.out.println(mark);
                if (tanda == true) {
                    mark++;
                }
            }

            tfvectors[count] = (float) (Math.log10((jmldata - mark + 0.5) / (mark + 0.5)));
            count++;
            mark = 0;
            tanda = false;

        }

        NIDFDocsVector.add(tfvectors);
    }
    
    public float DocScore(float[] docsVector1,float[] docsVector2 ){
        float score = 0;
        for(int i=0;i<docsVector1.length;i++){
            score+=docsVector1[i]*docsVector2[i];
        }
        
        return score;
    }
    
    public void DocumentScoring(){
        float score = 0;
        for(int i =0;i<tfDocsVector.size();i++){
            score = DocScore(tfDocsVector.get(i),NIDFDocsVector.get(0));
            System.out.println("Score Docs ke-"+(i+1)+"= "+score);
            arrScore.add(score);
        }
    }

    public void tes() {
//        for(String s : allTerms){
//            System.out.println(s);
//        }
//        System.out.println(termsDocsArray.size());
//        System.out.println(allTerms.size());
        for (float[] f : NIDFDocsVector) {
            System.out.println(Arrays.toString(f));
        }
    }

    public double idfCalculator(List<String[]> allTerms, String termToCheck) {
        double count = 0;
        for (String[] ss : allTerms) {
            for (String s : ss) {
                if (s.equalsIgnoreCase(termToCheck)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

//    public double idfCalculator(List<String[]> allTerms, String termToCheck) {
//        double count = 0;
//        for (String[] ss : allTerms) {
//            for (String s : ss) {
//                if (s.equalsIgnoreCase(termToCheck)) {
//                    count++;
//                    break;
//                }
//            }
//        }
//        return Math.log(allTerms.size() / count);
//    }
//    public void tfIdfCalculator() {
//        double tf; //term frequency
//        double idf; //inverse document frequency
//        double tfidf; //term requency inverse document frequency        
//        for (String[] docTermsArray : termsDocsArray) {
//            double[] tfidfvectors = new double[allTerms.size()];
//            int count = 0;
//            for (String terms : allTerms) {
//                tf = tfCalculator(docTermsArray, terms);
//                idf = idfCalculator(termsDocsArray, terms);
////                idf = new TfIdf().idfCalculator(termsDocsArray, terms);
//                tfidf = tf * idf;
//                tfidfvectors[count] = tfidf;
//
//                count++;
//            }
//            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;            
//        }
//    }
    public void tfIdfCalculator() {
        double tf; //term frequency
        double idf; //inverse document frequency
//        double tfidf; //term requency inverse document frequency  
        int counter = 1;
        float[] dfvectors = new float[allTerms.size()];
        for (String[] docTermsArray : termsDocsArray) {
            float[] tfvectors = new float[allTerms.size()];
            int count = 0;
            for (String terms : allTerms) {
                tf = tfCalculator(docTermsArray, terms);
                
//                idf = new TfIdf().idfCalculator(termsDocsArray, terms);
//                tfidf = tf * idf;

                tfvectors[count] = (float) tf;
                
                count++;
            }
            tfDocsVector.add(tfvectors);  //storing document vectors;
            System.out.println("Done insert : " + counter);
            counter++;
        }

    }

    public void printTF() throws IOException {
        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\tf.txt");
        FileWriter fw = new FileWriter(file);
        for (float s[] : tfDocsVector) {
            fw.write(Arrays.toString(s));
            fw.write(System.lineSeparator());
        }
        fw.flush();
        fw.close();
    }
    
    public void printScore() throws IOException{
        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\score.txt");
        FileWriter fw = new FileWriter(file);
        for (float ff : arrScore) {
            
            fw.write(System.lineSeparator());
        }
        fw.flush();
        fw.close();
    }

    public void viewvector() {
        for (double s[] : tfidfDocsVector) {
            System.out.println(Arrays.toString(s));
        }
    }
    
    public void viewScore(){
        for(float f : arrScore){
            System.out.println(f);
        }
    }

    public void viewterm() {
        System.out.println(allTerms.size());
//        for(String s : allTerms){
//            System.out.println(s);
//        }
    }

    public void printvector() throws IOException {
        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\termarr.txt");
        FileWriter fw = new FileWriter(file);
        for (double s[] : tfidfDocsVector) {
            fw.write(Arrays.toString(s));
            fw.write(System.lineSeparator());
        }
        fw.flush();
        fw.close();
    }

    public void printVocabulary() throws IOException {
        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\vocab.txt");
        FileWriter fw = new FileWriter(file);

        for (String s : allTerms) {
            fw.write(s);
            fw.write(System.lineSeparator());
        }
        fw.flush();
        fw.close();
    }

    public void parseFiles(String filePath) throws FileNotFoundException, IOException {
        File[] allfiles = new File(filePath).listFiles();
        BufferedReader in = null;
        for (File f : allfiles) {
            if (f.getName().endsWith(".txt")) {
                in = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String s = null;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
                String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
                for (String term : tokenizedTerms) {
                    if (!allTerms.contains(term)) {  //avoid duplicate entry
                        allTerms.add(term);
                    }
//                    totterm++;
                }
                termsDocsArray.add(tokenizedTerms);
                System.out.println("Done read " + f.getName());
            }
        }
//        System.out.println("total term :"+totterm);
    }

}
