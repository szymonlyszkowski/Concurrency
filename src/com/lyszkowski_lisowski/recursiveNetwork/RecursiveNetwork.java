package com.lyszkowski_lisowski.recursiveNetwork;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.neurons.NeuronOne;
import com.lyszkowski_lisowski.neurons.NeuronThree;
import com.lyszkowski_lisowski.neurons.NeuronTwo;

/**
 * Created by szymonidas on 26.10.14.
 */
public class RecursiveNetwork {

    public void startLearing() {

       Resources.FIRST_NEURON.start();
       Resources.SECOND_NEURON.start();
       Resources.THIRD_NEURON.start();
    }
}
