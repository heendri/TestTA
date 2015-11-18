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
import java.util.ArrayList;
public class Document {
    private int id;
    private ArrayList<String> isi = new ArrayList<String>();
    
    public Document(int id,ArrayList<String> isi){
        this.id=id;
        this.isi=isi;
    }
    
    public Document(){}
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the isi
     */
    public ArrayList<String> getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(ArrayList<String> isi) {
        this.isi = isi;
    }

    /**
     * @return the isi
     */
    

    /**
     * @param isi the isi to set
     */
   
    
}
