package com.lyszkowski_lisowski;

import com.lyszkowski_lisowski.recursiveNetwork.LinearNetwork;
import com.lyszkowski_lisowski.recursiveNetwork.RecursiveNetwork;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class NeuronsRecursively {

    public static final int NUMBER_OF_STEPS = 1000;

    public static void main(String[] args) {

        long concStartTime = System.currentTimeMillis();
        new RecursiveNetwork().startLearing(NUMBER_OF_STEPS);

        while (Resources.FIRST_NEURON.isAlive() || Resources.SECOND_NEURON.isAlive() || Resources.THIRD_NEURON.isAlive()) {

        }

        long concFinishTime = System.currentTimeMillis() - concStartTime;

        long linearStartTime = System.currentTimeMillis();
        new LinearNetwork().startLearning(NUMBER_OF_STEPS);
        long linearFinishTime = System.currentTimeMillis() - linearStartTime;

        System.out.println("Time for concurrent processing: " + concFinishTime + "[ms]");
        System.out.println("Time for linear processing: " + linearFinishTime + "[ms]");

    }
}
