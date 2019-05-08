/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climood.simpleperceptron;

import java.util.Arrays;

/**
 *
 * @author Muduck
 */
public class SimplePerceptron {
    double enters[];
    double out;
    double weights[];
    double [][]pattern = {   //Logistic rule what we learn
    {0,0, 0},                //current = OR
    {0,1, 1},
    {1,0, 1},
    {1,1, 1}
};
    SimplePerceptron(){
        enters=new double[2];
        weights=new double[enters.length];
        for(int i=0;i<enters.length;i++){ //set Random deffined weights
            weights[i]=Math.random()*0.2+0.1;
        }
    }
    void countOut(){
        out=0;
        for(int i=0;i<enters.length;i++){
            out+=enters[i]*weights[i];
        }
        if(out>0.5) out=1; else out=0;
    }
    void studyPerceptron(){
        double gError=0;
        do{
            gError=0;
            for(int p=0;p<pattern.length;p++){
                double error=0;
                enters=Arrays.copyOf(pattern[p], pattern[p].length-1);
                countOut();
                error=pattern[p][pattern.length]-out;
                gError+=Math.abs(error);
                for(int i=0;i<enters.length;i++){
                    weights[i]+=0.1*error*enters[i]; //0.1 - коэффицент обучения, на сам вход умножаем на случай нулевого входа(он не должен учавствовать в построении веса)
                }
            }
        }while(gError!=0);
    }
    public void main(String Args[]){
        
    }
    
}
