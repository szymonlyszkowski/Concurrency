package com.lyszkowski_lisowski.neurons;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class NeuronOne extends Thread implements ActivationFunction {

    private int steps = 0;
    private int neuronCounter;
    private int maxSteps;

    public NeuronOne (int neuronCounter, int maxSteps) {
        this.neuronCounter = neuronCounter;
        this.maxSteps = maxSteps;
    }

    @Override
    public int activate() {
        int result = neuronCounter - 1;
        return result;
    }

    public void runLinear() {
        System.out.println("Semaphore acquired for neuron 1");
        int output = this.activate();
        Resources.SECOND_NEURON.setNeuronCounter(output);
        Resources.THIRD_NEURON.setNeuronCounter(output);
        Resources.printNeurons();
        System.out.println("Semaphore released from neuron 1");
        this.steps++;
    }

    @Override
    public void run() {
        while (this.maxSteps > this.steps) {
            try {
                Resources.SEMAPHORE.acquire();
                System.out.println("Semaphore acquired for neuron 1");
                int output = this.activate();
                Resources.SECOND_NEURON.setNeuronCounter(output);
                Resources.THIRD_NEURON.setNeuronCounter(output);
                Resources.printNeurons();
                Resources.SEMAPHORE.release();
                System.out.println("Semaphore released from neuron 1");
                this.steps++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //gettery & settery

    public int getNeuronCounter() {
        return neuronCounter;
    }

    public void setNeuronCounter(int neuronCounter) {
        this.neuronCounter = neuronCounter;
    }
}
