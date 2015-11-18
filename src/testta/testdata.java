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
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Hendri
 * Kelas ini dibuat untuk memisahkan mega document menjadi mini document
 * done Yeah
 */
public class testdata {

    public static final String REGEX = "^d";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String inputFile = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\Sarjana!\\NPL\\doc-text";
        BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 1;

        while (!("eof").equals(line)) {
            while (!("   /").equals(line)) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
            System.out.println(sb.toString());
            System.out.println(sb.length());
            File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\ver2\\docs_" + count + ".txt");
            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.flush();
            fw.close();
            sb.delete(0, sb.length());
            count++;

            line = br.readLine();
        }



    }
}
