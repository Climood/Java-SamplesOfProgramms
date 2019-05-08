/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kormen2.pkg3.pkg7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Muduck
 */
public class Kormen237 {
   public static void SummaSearch(int Arr[],int left,int x,int right){
       if(left<right){
          SummaSearch(Arr,left,x,(left+right)/2);
          SummaSearch(Arr,(left+right)/2+1,x,right);
          Summa(Arr,left,x,right);
        }
   }
    public static void Summa(int Arr[],int left,int x,int right){ 
        int middle=(left+right)/2;
        int i=left;
        int j=middle+1;
        for(int k=left;k<=right;k++){
            if(Arr[i]+Arr[j]==x){
               System.out.println("Два элемента найдены, их значения: "+Arr[i]+" "+Arr[j]);
            }
            j++;
            if(i == middle+1){
                //System.out.println("Пара не найдена");
                break;
            }
            if(j>=right){
                i++;
                j=middle+1;
            } 
        }
    }
    public static void main(String[] args) { int size=0;
        Scanner In=new Scanner(System.in);
        System.out.println("Введите размер массива для сортировки.");
            size=In.nextInt();
        int Arr[]=new int[size];
        Random rnd=new Random();
        System.out.print("Массив вида : ");
        for(int i=0;i<size;i++){
            Arr[i]=rnd.nextInt(40);
            System.out.print(Arr[i]+" ");
        }
        //SummaSearch(Arr,0,10,Arr.length-1);
        int Test[]={5,3,4,1,7,6};
        //SummaSearch(Arr,0,7,Test.length-1);
        SummaSearch(Test,0,7,Test.length-1);
        
    }
}
