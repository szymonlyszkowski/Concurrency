package com.lyszkowski_lisowski.recursiveNetwork;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.neurons.NeuronOne;
import com.lyszkowski_lisowski.neurons.NeuronThree;
import com.lyszkowski_lisowski.neurons.NeuronTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by szymonidas on 26.10.14.
 */
public class Resources {

    public static NeuronOne FIRST_NEURON = new NeuronOne(100);
    public static NeuronTwo SECOND_NEURON = new NeuronTwo(100);
    public static NeuronThree THIRD_NEURON = new NeuronThree(100);
    public static Semaphore SEMAPHORE = new Semaphore(1,true);

    public static void printNeurons()
    {
        System.out.println("Vale of first neuron = " + FIRST_NEURON.getCounter());
        System.out.println("Value of second neuron = " + SECOND_NEURON.getCounter());
        System.out.println("Value of third neuron = " + THIRD_NEURON.getCounter());
    }
}
