/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hendri
 */
public class TestIseng {

    public static void main(String[] args) {
        List<String> stockList = new ArrayList<String>();
        stockList.add("stock1");
        stockList.add("stock2");
        stockList.add("stock2");

        String[] stockArr = new String[stockList.size()];
        stockArr = stockList.toArray(stockArr);

        for (String s : stockArr) {
            System.out.println(s);
        }
    }
}
