package com.lyszkowski_lisowski.recursiveNetwork;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class RecursiveNetwork {

    public void startLearing(int steps) {

        Resources.FIRST_NEURON.start();
        Resources.SECOND_NEURON.start();
        Resources.THIRD_NEURON.start();

    }

}
