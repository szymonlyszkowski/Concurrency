package com.lyszkowski_lisowski.resources;

import com.lyszkowski_lisowski.NeuronsRecursively;
import com.lyszkowski_lisowski.neurons.NeuronOne;
import com.lyszkowski_lisowski.neurons.NeuronThree;
import com.lyszkowski_lisowski.neurons.NeuronTwo;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

/**
 *
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public class Resources {

    private NeuronOne firstNeuron = new NeuronOne(100, NeuronsRecursively.NUMBER_OF_STEPS, this);
    private NeuronTwo secondNeuron = new NeuronTwo(100, NeuronsRecursively.NUMBER_OF_STEPS, this);
    private NeuronThree thirdNeuron = new NeuronThree(100, NeuronsRecursively.NUMBER_OF_STEPS, this);

    private static final Logger logger = Logger.getLogger(Resources.class);

    public void printNeurons() {
        logger.debug("Value of the first neuron = " + firstNeuron.getNeuronCounter());
        logger.debug("Value of the second neuron = " + secondNeuron.getNeuronCounter());
        logger.debug("Value of the third neuron = " + thirdNeuron.getNeuronCounter());
    }

    // gettery & settery

    public NeuronOne getFirstNeuron() {
        return firstNeuron;
    }

    public NeuronTwo getSecondNeuron() {
        return secondNeuron;
    }

    public NeuronThree getThirdNeuron() {
        return thirdNeuron;
    }

}
