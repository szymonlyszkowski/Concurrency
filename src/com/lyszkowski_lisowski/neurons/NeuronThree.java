package com.lyszkowski_lisowski.neurons;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;

/**
 * Created by szymonidas on 26.10.14.
 */
public class NeuronThree extends Thread implements ActivationFunction {

    private int neuronCounter;

    public  NeuronThree(int counterValue) {

        neuronCounter = counterValue;
    }

    @Override
    public int activate() {

        --neuronCounter;
        ++neuronCounter;
        ++neuronCounter;
        --neuronCounter;
        neuronCounter = (neuronCounter-2);

        return neuronCounter;
    }

    @Override
    public int getCounter() {
        return this.neuronCounter;
    }

    @Override
    public void setCounter(int value) {
        neuronCounter = value;
    }

    @Override
    public void run() {



        while (Resources.THIRD_NEURON.getCounter() >= 0) {
            try {
                Resources.SEMAPHORE.acquire();
                System.out.println("Semaphore acquired for neuron 3");
                int output = this.activate();
                Resources.FIRST_NEURON.setCounter(output);
                Resources.SECOND_NEURON.setCounter(output);
                Resources.printNeurons();
                Resources.SEMAPHORE.release();
                System.out.println("Semaphore released from neuron 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
