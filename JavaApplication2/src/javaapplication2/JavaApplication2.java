/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Muduck
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ThreeD[][][]=new int [3][4][5];
        for (int i=0;i<3;i++){
            for(int i1=0;i1<4;i1++){
                for(int i2=0;i2<5;i2++){
                    ThreeD[i][i1][i2]=i*i1*i2;
                }
            }
        }
        for (int i=0;i<3;i++){
            for(int i1=0;i1<4;i1++){
                for(int i2=0;i2<5;i2++){
                    System.out.print(ThreeD[i][i1][i2]+ " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
}
