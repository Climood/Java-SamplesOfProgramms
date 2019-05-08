/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba.pkg11;
import java.util.Scanner;
/**
 *
 * @author Muduck
 */
public class Laba11{
    public static void main(String args[]){
        
        String data[] = {"sqrt(z)","1/z","exp(z)"};
        String result = "";
        Scanner in=new Scanner(System.in);
        System.out.println("Строка:");
        String enter=in.nextLine();
        for(int i = 0;i<enter.length();i++){
            switch(enter.charAt(i)){
                case '1':
                    result +="*"+data[0];
                    break;
                case '2':
                    result += "*"+data[1];
                    break;
                case '3':
                    result += "*"+data[2];
                    break;
                case '0':
                    if(i==0){
                        result +=data[i].replaceFirst("z",data[i+1]);
                        i+=2;
                    }else
                        result +="*"+data[i-1].replaceFirst("z",data[(Integer).getInteger((String)enter.charAt(i))+1]);
                    i++;
                    break;
            }
        }
        System.out.println(result);
    }
}