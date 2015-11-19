/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import objectexplorer.MemoryMeasurer;
import objectexplorer.ObjectGraphMeasurer;

/**
 *
 * @author Hendri
 */
public class main {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        DocumentParser d = new DocumentParser();
        int a=0;
        System.out.println("start");
        System.out.println("start baca file....");
        d.parseFiles("D:\\GDriveHendri\\Tugas\\Tugas Akhir\\TestTA\\Hasil\\cek");
        System.out.println("done..");
        System.out.println("start calculate...");
        System.out.println("Ukuran File "+MemoryMeasurer.measureBytes(d.termsDocsArray)+" Bytes ");
        
        d.termOccurence();
        d.tes();
//        d.tfIdfCalculator();
        System.out.println("done...");
//        d.viewvector();
//        d.viewterm();
        System.out.println("print output");
//        d.printVocabulary();
//        d.printvector();
//        d.printTF();
        System.out.println("done");
        
        

    }
}
