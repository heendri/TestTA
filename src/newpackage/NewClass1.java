/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Hendri
 */
public class NewClass1 {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        int count = 0;
        System.out.println("tes");
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Hendri\\Google Drive\\Tugas\\Tugas Akhir\\TestTA\\doc.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (!"end".equals(line)) {
                sb.append(line);
                sb.append(" ");
                System.out.println(line);
                line = br.readLine();
                
            }

            System.out.println(sb.toString());
            // \t\n\r\f,.:;?![]' 
            StringTokenizer token = new StringTokenizer(sb.toString().toLowerCase(), "");
//            System.out.println(token);
            while (token.hasMoreTokens()) {
                String tkn = (String) token.nextToken();
//                System.out.println(tkn);
                count = count + 1;
            }
            System.out.println("udah");
//            return sb.toString();
            System.out.println(count);
        } finally {
            br.close();
        }
    }
}
