/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;

/**
 *
 * @author Hendri
 */
public class main {
    public static ArrayList<Document> testList= new ArrayList<Document>();
    public static ArrayList<String> temp = new ArrayList<String>();
    
    public static void main(String[] args) {
//        Document d = new Document(1,"Hendri");
//        Document d1 = new Document(1,"Hendrw");
        Document d = new Document();
        temp.add("hendri");
        temp.add("aja");
        d.setId(1);
        d.setIsi(temp);
        
        testList.add(d);
//        testList.add(d1);
        
        for(Document s : testList){
            System.out.println(" "+s.getIsi()+" "+s.getId());
        }
        
        
        
        
    }
    
    
    
           
}
