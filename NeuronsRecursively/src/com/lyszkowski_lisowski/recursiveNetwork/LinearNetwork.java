package com.lyszkowski_lisowski.recursiveNetwork;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class LinearNetwork {

    public void startLearning(int steps) {

        for (int i = 0; i < steps; i++) {
            Resources.FIRST_NEURON.runLinear();
            Resources.SECOND_NEURON.runLinear();
            Resources.THIRD_NEURON.runLinear();
        }

    }

}
