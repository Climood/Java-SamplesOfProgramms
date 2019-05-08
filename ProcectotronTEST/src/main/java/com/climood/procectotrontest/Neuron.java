/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climood.procectotrontest;

/**
 *
 * @author Muduck
 */
import javax.sql.rowset.serial.SerialArray;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.Perceptron;
import org.neuroph.nnet.learning.HopfieldLearning;
import org.neuroph.util.TransferFunctionType;
 
public class Neuron {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NeuralNetwork&amp;lt;HopfieldLearning&amp;gt; nNetwork = new Perceptron(2, 1);
         
        DataSet trainingSet =
                 new DataSet(2, 1); 
         
        trainingSet. addRow (new DataSetRow (new double[]{0, 0},
                 new double[]{0}));
                trainingSet. addRow (new DataSetRow (new double[]{0, 1},
                 new double[]{1}));
                trainingSet. addRow (new DataSetRow (new double[]{1, 0},
                 new double[]{1}));
                trainingSet. addRow (new DataSetRow (new double[]{1, 1},
                 new double[]{1}));
                // learn the training set
                nNetwork.learn(trainingSet);
                // save the trained network into file
                nNetwork.save("or_perceptron.nnet"); 
                System.out.println("end");
 
                // set network input
                nNetwork.setInput(0, 0);
                // calculate network
                nNetwork.calculate();
                // get network output
                double[] networkOutput = nNetwork.getOutput();
                 
                for (double i : networkOutput)
                    System.out.println(i);
                 
    }
 
}

