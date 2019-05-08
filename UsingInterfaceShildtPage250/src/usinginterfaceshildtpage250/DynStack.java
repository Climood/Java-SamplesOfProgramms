/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usinginterfaceshildtpage250;

/**
 *
 * @author Muduck
 */
public class DynStack implements IntStack {
    private int size=10; //default size
    private int last_index;
    private int stc[];
    DynStack(){
       stc=new int[size];
       last_index=-1;
    }
    DynStack(int S){
       stc=new int[S];
       last_index=-1;
    }
    public void push(int what){
    if(last_index==stc.length-1){
        int temp[]=new int[stc.length*2];
        System.out.println("Стек переполнен, удваиваем размер");
        for(int i=0;i<stc.length;i++){
            temp[i]=stc[i];
        }
        stc=temp;
        stc[++last_index]=what;
    }
    else{
        stc[++last_index]=what;
    }
    }
    public int pop(){
        if(last_index<0){
            System.out.println("В стеке нет элементов чел");
            return 0;
        }else{
            return stc[last_index--];
        }
    }
}
