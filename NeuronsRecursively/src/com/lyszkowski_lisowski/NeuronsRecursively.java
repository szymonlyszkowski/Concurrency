package com.lyszkowski_lisowski;

import com.lyszkowski_lisowski.recursiveNetwork.LinearNetwork;
import com.lyszkowski_lisowski.recursiveNetwork.RecursiveNetwork;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class NeuronsRecursively {

    public static final int NUMBER_OF_STEPS = 100;

    public static void main(String[] args) {

//        new RecursiveNetwork().startLearing(NUMBER_OF_STEPS);

        new LinearNetwork().startLearning(NUMBER_OF_STEPS);

    }
}
