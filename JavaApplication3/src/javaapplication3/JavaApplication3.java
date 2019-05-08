/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.util.Vector;
/**
 *
 * @author Muduck
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int nums[]={1,2,3,4,5,6,7,8,9,10};
        int sum=0;
        for(int i=0;i<10;i++,sum+=i){};
        System.out.println(sum);
        // Аналог в for each 
        sum=0;
        for(int x:nums){sum+=x;};
        System.out.println(sum);
        Vector test=new Vector();
        Vector<Double> result=new Vector<Double>();
        String test2=new String();
        test2="23+45";
        System.out.println("test2[0]"+test2.charAt(0));
        test.addElement("23");
        test.addElement("+");
        test.addElement("45");
        System.out.println(test.elementAt(0).toString());
        System.out.println(test.elementAt(1).toString());
        System.out.println(test.elementAt(2).toString());
        if(test.elementAt(0).toString()=="23"){
            System.out.println("succesfull");
        }
            }
          
    
}
