/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronizedthreadsdemo;
class Callme{
void call(String msg){
    System.out.print("["+msg);
    try{
        Thread.sleep(1000);
    }catch(InterruptedException e){
        System.out.println("прервано");
    }
    System.out.println("]");
    }
}
class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public Caller(Callme targ,String s){
        target=targ;
        msg=s;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        synchronized(target){
            target.call(msg);
        }
    }
}
/**
 *
 * @author Muduck
 */
public class SynchronizedThreadsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Callme target=new Callme();
        Caller ob1=new Caller(target,"Добро пожаловать");
        Caller ob2=new Caller(target,"В синхронизированный");
        Caller ob3=new Caller(target,"мир");
        //ждем завершения потоков
        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch(InterruptedException ex){
            System.out.println("Прервано");
        }
    }
    
}
