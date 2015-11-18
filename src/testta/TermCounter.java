/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hendri
 */
public class TermCounter {

    public static ArrayList<String> TermList = new ArrayList<String>();

    private static String[] getUniqueKeys(String[] keys) {
        String[] uniqueKeys = new String[keys.length];
        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;
        for (int i = 1; i < keys.length; i++) {
            for (int j = 0; j <= uniqueKeyIndex; j++) {
                if (keys[i].equals(uniqueKeys[j])) {
                    keyAlreadyExists = true;
                }
            }
            if (!keyAlreadyExists) {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }

    private static ArrayList<String> getKey(ArrayList<String> arr) {
        return arr;
    }

    public static void main(String[] args) throws IOException {

        String inputFile1 = "D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\yoi.txt";
        BufferedReader br1 = new BufferedReader(new FileReader(new File(inputFile1)));
        String line1 = br1.readLine();

        while (line1 != null) {
            TermList.add(line1);
            line1 = br1.readLine();
        }


        String[] keys = new String[TermList.size()];
        keys = TermList.toArray(keys);

//        String[] keys = text.split(" ");
        String[] uniqueKeys;
//        String[] keys = new String[]
//        String[] uniqueKeys;

        int count = 0;
        uniqueKeys = getUniqueKeys(keys);
        File file = new File("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\after.txt");
        FileWriter fw = new FileWriter(file);

        for (String key : uniqueKeys) {
            if (null == key) {
                break;
            }
            for (String s : keys) {
                if (key.equals(s)) {
                    count++;
                }
            }
            System.out.println("Count of [" + key + "] is : " + count);
            fw.write("Count of [" + key + "] is : " + count);
            fw.write(System.lineSeparator());
            count = 0;
        }
        fw.flush();
        fw.close();
    }

}