package com.lyszkowski_lisowski.recursiveNetwork;

import com.lyszkowski_lisowski.neurons.NeuronOne;
import com.lyszkowski_lisowski.neurons.NeuronThree;
import com.lyszkowski_lisowski.neurons.NeuronTwo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class Resources {

    public static NeuronOne FIRST_NEURON = new NeuronOne(100);
    public static NeuronTwo SECOND_NEURON = new NeuronTwo(100);
    public static NeuronThree THIRD_NEURON = new NeuronThree(100);

    public static Semaphore SEMAPHORE = new Semaphore(1,false);

    public static void printNeurons() {
        System.out.println("Value of the first neuron = " + FIRST_NEURON.getCounter());
        System.out.println("Value of the second neuron = " + SECOND_NEURON.getCounter());
        System.out.println("Value of the third neuron = " + THIRD_NEURON.getCounter());
    }
}
