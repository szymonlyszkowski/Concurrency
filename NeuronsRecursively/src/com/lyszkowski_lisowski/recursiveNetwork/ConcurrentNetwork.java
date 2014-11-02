package com.lyszkowski_lisowski.recursiveNetwork;

import com.lyszkowski_lisowski.resources.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class ConcurrentNetwork {

    private Thread thread1 = new Thread(Resources.FIRST_NEURON);
    private Thread thread2 = new Thread(Resources.SECOND_NEURON);
    private Thread thread3 = new Thread(Resources.THIRD_NEURON);

    /**
     * Method realizes recursive neural network in 3 distinct threads.
     * @param steps
     */
    public void startLearing(int steps) {
        thread1.start();
        thread2.start();
        thread3.start();
    }

    // gettery & settery

    public Thread getThread1() {
        return thread1;
    }

    public Thread getThread2() {
        return thread2;
    }

    public Thread getThread3() {
        return thread3;
    }
}
