/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newthreaddemo;
class NewThread implements Runnable{
    Thread t;
    NewThread(){
        t=new Thread(this,"второй поток");
        t.start();
    }
    public void run(){
        try{
            for(int i=5, sum=0;i>0;i--,sum+=i){
                System.out.println("Второй поток"+sum);
            t.sleep(500);
        };
        }catch(InterruptedException ex){
            System.out.println("Второй поток прерван");
        }
        System.out.println("Второй поток завершен");
    }
}
/**
 *
 * @author Muduck
 */
public class NewThreadDemo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new NewThread();
        try{
            for(int i=5,sum=0;i>0;i--,sum+=i){
                System.out.println("Главный поток"+ sum);
                Thread.sleep(1000);
            }
        }catch(InterruptedException ex){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
    
}
