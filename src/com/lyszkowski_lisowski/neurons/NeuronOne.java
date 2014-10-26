package com.lyszkowski_lisowski.neurons;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;

/**
 * Created by szymonidas on 26.10.14.
 */
public class NeuronOne extends Thread implements ActivationFunction {

    private int neuronCounter;

    public NeuronOne(int counterValue) {

        neuronCounter = counterValue;
    }

    @Override
    public int activate() {
        --neuronCounter;
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



        while (Resources.FIRST_NEURON.getCounter() >= 0) {
            try {
                Resources.SEMAPHORE.acquire();
                System.out.println("Semaphore acquired for neuron 1");
                int output = this.activate();
                Resources.SECOND_NEURON.setCounter(output);
                Resources.THIRD_NEURON.setCounter(output);
                Resources.printNeurons();
                Resources.SEMAPHORE.release();
                System.out.println("Semaphore released from neuron 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
