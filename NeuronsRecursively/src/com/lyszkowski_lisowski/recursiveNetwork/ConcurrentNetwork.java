package com.lyszkowski_lisowski.recursiveNetwork;

import com.lyszkowski_lisowski.resources.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class ConcurrentNetwork {

    /**
     * Method realizes recursive neural network in 3 distinct threads.
     * @param steps
     */
    public void startLearing(int steps) {

        new Thread(Resources.FIRST_NEURON).start();
        new Thread(Resources.SECOND_NEURON).start();
        new Thread(Resources.THIRD_NEURON).start();

    }

}
