/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author Muduck
 */
class Node{
    Node left=null;
    Node right=null;
    int value;
    void show_value(){
        System.out.print(value+" ");
    }
    Node(int value){
        this.value=value;
    }
    Node(){
        value=0;
    }
}
class Tree{
Node root=null;
    Node left=null;
    Node right=null;
    Tree(){
        root=new Node();
    }
    Tree(int start_value){
        root=new Node(start_value);
    }
    void put(int what){
        if(root==null){
            System.out.println("Tree is empty!");
        }
        Node select=root;
        while(what<select.value && select.left!=null){
            select=select.left;
        }
        while(what>select.value && select.right!=null){
            select=select.right;
        }
    }
    
}
public class List {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
