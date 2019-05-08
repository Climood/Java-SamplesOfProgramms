/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Muduck
 */

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Random rnd = new Random();
        int pidor_count[]=new int [12];
        for(int i=0;i<12;i++){
            pidor_count[i]=rnd.nextInt(123);
        }
        for(int i=0;i<12;i++){
           System.out.println("pidor_count["+i+"] = "+pidor_count[i]);
        }
        Scanner in=new Scanner(System.in);
        String enter=in.nextLine();
        System.out.println(enter.length());
        enter="";
        System.out.println(enter.length());
        Vector<String> test=new Vector<String>();
        Vector<Double> result=new Vector<Double>();
        String test2=new String();
        test2="23+45";
        test.addElement("23");
        test.addElement("+");
        test.addElement("45");
        System.out.println(test.elementAt(0));
        System.out.println(test.elementAt(1));
        System.out.println(test.elementAt(2));
        
        
    }
    
}
