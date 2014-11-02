package com.lyszkowski_lisowski.recursiveNetwork;

import com.lyszkowski_lisowski.resources.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class ConcurrentNetwork {

    private Thread neuronOne;
    private Thread neuronTwo;
    private Thread neuronThree;

    public ConcurrentNetwork(Resources resources) {
        this.neuronOne = new Thread(resources.getFirstNeuron());
        this.neuronTwo = new Thread(resources.getSecondNeuron());
        this.neuronThree = new Thread(resources.getThirdNeuron());
    }

    /**
     * Method realizes recursive neural network in 3 distinct threads.
     *
     * @param steps
     */
    public void startLearning(int steps) {

        neuronOne.start();
        neuronTwo.start();
        neuronThree.start();

    }

    public Thread getNeuronThree() {
        return neuronThree;
    }

    public Thread getNeuronTwo() {
        return neuronTwo;
    }

    public Thread getNeuronOne() {
        return neuronOne;
    }
}
