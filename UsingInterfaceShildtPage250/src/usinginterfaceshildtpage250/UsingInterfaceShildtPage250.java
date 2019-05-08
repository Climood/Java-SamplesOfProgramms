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
class FixedStack implements IntStack{
    private int stc[];
    private int last_index;
    FixedStack(){
        stc=new int[10];
        last_index=-1;
    }
    FixedStack(int s){
        stc=new int[s];
        last_index=-1;
    }
    public void push(int i){
        if(last_index==stc.length-1){ System.out.println("В стеке нет места чел"); }
        else { stc[++last_index]=i; }
    }
    public int pop(){
        if(last_index==-1){ System.out.println("В стеке нет элементов чел"); return 0; }
        else { return stc[last_index--]; }
    }
}
public class UsingInterfaceShildtPage250 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FixedStack stackfix=new FixedStack(10);
        DynStack stackdyn=new DynStack();
        IntStack interstack;
        interstack=stackfix;
        interstack.pop();
        interstack.push(23);
        interstack=stackdyn;
        interstack.pop();
        for(int i=0;i<25;i++){
            interstack.push(23);
        }
    }
    
}
