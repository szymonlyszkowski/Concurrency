package com.lyszkowski_lisowski;

import com.lyszkowski_lisowski.recursiveNetwork.ConcurrentNetwork;
import com.lyszkowski_lisowski.recursiveNetwork.LinearNetwork;
import com.lyszkowski_lisowski.resources.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class NeuronsRecursively {

    public static final int NUMBER_OF_STEPS = 1000000;

    public static void main(String[] args) {

        //concurrent
        Resources resourcesForConcurrent = new Resources();

        long concStartTime = System.currentTimeMillis();
        ConcurrentNetwork concurrentNetwork = new ConcurrentNetwork(resourcesForConcurrent);
        concurrentNetwork.startLearning(NUMBER_OF_STEPS);

        while (concurrentNetwork.getNeuronOne().isAlive() || concurrentNetwork.getNeuronTwo().isAlive() || concurrentNetwork.getNeuronThree().isAlive()) {
        }

        long concFinishTime = System.currentTimeMillis() - concStartTime;
        System.out.println("Time for concurrent processing: " + concFinishTime + "[ms]");


        //linear
        Resources resourcesForLinear = new Resources();
        long linearStartTime = System.currentTimeMillis();
        Thread linearThread = new Thread(new LinearNetwork(NUMBER_OF_STEPS, resourcesForLinear));
        linearThread.start();
        while(linearThread.isAlive()){}
        long linearFinishTime = System.currentTimeMillis() - linearStartTime;

        System.out.println("Time for linear processing: " + linearFinishTime + "[ms]");

    }
}
