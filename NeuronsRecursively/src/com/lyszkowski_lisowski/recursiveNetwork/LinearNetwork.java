package com.lyszkowski_lisowski.recursiveNetwork;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class LinearNetwork implements Runnable {

    private int steps;

    public LinearNetwork(int steps) {
        this.steps = steps;
    }


    public void startLearning() {

        for (int i = 0; i < this.steps; i++) {
            Resources.FIRST_NEURON.runLinear();
            Resources.SECOND_NEURON.runLinear();
            Resources.THIRD_NEURON.runLinear();
        }

    }

    @Override
    public void run() {
        startLearning();
    }
}
