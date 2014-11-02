package com.lyszkowski_lisowski.neurons;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;
import org.apache.log4j.Logger;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class NeuronThree extends Thread implements ActivationFunction {

    private int steps = 0;
    private int neuronCounter;
    private int maxSteps;

    private static final Logger logger = Logger.getLogger(NeuronThree.class);

    public NeuronThree (int neuronCounter, int maxSteps) {
        this.neuronCounter = neuronCounter;
        this.maxSteps = maxSteps;
    }

    @Override
    public int activate() {
        --neuronCounter;
        ++neuronCounter;
        ++neuronCounter;
        --neuronCounter;
        int result = neuronCounter - 10;
        return result;
    }

    public void runLinear() {
        if(logger.isDebugEnabled()){
            logger.debug("Semaphore acquired for neuron 3");
        }
        int output = this.activate();
        Resources.FIRST_NEURON.setNeuronCounter(output);
        Resources.SECOND_NEURON.setNeuronCounter(output);
        if(logger.isDebugEnabled()) {
            Resources.printNeurons();
            logger.debug("Semaphore released from neuron 3");
        }
        this.steps++;
    }

    @Override
    public void run() {
        while (this.maxSteps > this.steps) {
            try {
                Resources.SEMAPHORE.acquire();
                if(logger.isDebugEnabled()){
                    logger.debug("Semaphore acquired for neuron 3");
                }
                int output = this.activate();
                Resources.FIRST_NEURON.setNeuronCounter(output);
                Resources.SECOND_NEURON.setNeuronCounter(output);
                if(logger.isDebugEnabled()) {
                    Resources.printNeurons();
                }
                Resources.SEMAPHORE.release();
                if(logger.isDebugEnabled()){
                    logger.debug("Semaphore released from neuron 3");
                }
                this.steps++;
            } catch (InterruptedException e) {
                logger.error("An error has occurred: ", e);
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
