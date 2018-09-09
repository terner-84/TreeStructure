/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.terner.testingtreeitem;

import java.io.Console;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hanus
 */
public class TernerIO {
    private static int level = 0;
    private static Map<Integer, Integer> hmotnosti = new HashMap<>();
    public static void main(String[] args) {
//        PrintWriter pw = new PrintWriter(System.out, true);
//        pw.println("Hello");
//        
//        try (FileWriter fw = new FileWriter("terner.txt")) {
//            String veta = String.format("Bla bla%nBla dva");
//            fw.write(veta);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
        Generator gen = new Generator(5, "00000");
        Item item = gen.getParent();
        
        print(item);
        
        for (Map.Entry<Integer, Integer> entry : hmotnosti.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("Level: %d - celková hmotnost: %d%n", key, value);
        }
        
    }
    
    private static void print(Item par) {
        
        
        for (Item item : par.getChildren()) {
            level = level + 1;
            System.out.printf("LEVEL: %d - ID: %s, parent ID: %s hmotnost: %d %n", level, item.getId_item(), item.getParent_Id(), item.getWeight());
            int ghg = 0;
            try {
                ghg = hmotnosti.get(level);
            } catch (Exception e) {
            }
            int we = item.getWeight() + ghg;
            hmotnosti.put(level, we);
            print(item);
            level = 0;
        }
    }
    
}
