package com.lyszkowski_lisowski.recursiveNetwork;
import com.lyszkowski_lisowski.resources.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class LinearNetwork implements Runnable {

    private int steps;
    private Resources resources;

    public LinearNetwork(int steps, Resources resources) {
        this.steps = steps;
        this.resources = resources;
    }


    public void startLearning() {

        for (int i = 0; i < this.steps; i++) {
            this.resources.getFirstNeuron().runLinear();
            this.resources.getSecondNeuron().runLinear();
            this.resources.getThirdNeuron().runLinear();
        }

    }

    @Override
    public void run() {
        startLearning();
    }
}
