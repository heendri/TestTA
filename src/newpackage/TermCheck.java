/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Hendri
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TermCheck {

    public static ArrayList<String> term = new ArrayList<String>();
    public static ArrayList<String> temp = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        boolean found = false;

        int count = 1;

        for (int ite1 = 0; ite1 < 11429; ite1++) {
            System.out.println("Processing data....."+count+"");
            String inputFile1 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\afterstemming\\docs_" + count + ".txt";
            BufferedReader br1 = new BufferedReader(new FileReader(new File(inputFile1)));
            String line1 = br1.readLine();

            while (line1 != null) {
                term.add(line1);
                line1 = br1.readLine();
            }
            for (String s : term) {
                if (!temp.contains(s)) {
                    temp.add(s);
                }
            }

            term.clear();
            count++;
            System.out.println("done");
        }

        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\termlist.txt");
        FileWriter fw = new FileWriter(file);
        for (String str : temp) {
//                System.out.println(str);
            fw.write(str);
            fw.write(System.lineSeparator());
        }
        
        fw.flush();
        fw.close();

//        for (String x : temp) {
//            System.out.println(x);
//        }

    }
}
