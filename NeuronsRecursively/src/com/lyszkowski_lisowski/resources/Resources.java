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

    public static NeuronOne FIRST_NEURON = new NeuronOne(100, NeuronsRecursively.NUMBER_OF_STEPS);
    public static NeuronTwo SECOND_NEURON = new NeuronTwo(100, NeuronsRecursively.NUMBER_OF_STEPS);
    public static NeuronThree THIRD_NEURON = new NeuronThree(100, NeuronsRecursively.NUMBER_OF_STEPS);

    public static Semaphore SEMAPHORE = new Semaphore(1,false);

    private static final Logger logger = Logger.getLogger(Resources.class);

    public static void printNeurons() {
        logger.debug("Value of the first neuron = " + FIRST_NEURON.getNeuronCounter());
        logger.debug("Value of the second neuron = " + SECOND_NEURON.getNeuronCounter());
        logger.debug("Value of the third neuron = " + THIRD_NEURON.getNeuronCounter());
    }
}
