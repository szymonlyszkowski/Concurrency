package com.lyszkowski_lisowski;

import com.lyszkowski_lisowski.recursiveNetwork.ConcurrentNetwork;
import com.lyszkowski_lisowski.recursiveNetwork.LinearNetwork;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class NeuronsRecursively {

    public static final int NUMBER_OF_STEPS = 10;

    public static void main(String[] args) {

        long concStartTime = System.currentTimeMillis();
        ConcurrentNetwork concNetwork = new ConcurrentNetwork();
        concNetwork.startLearing(NUMBER_OF_STEPS);

        while (concNetwork.getThread1().isAlive() && concNetwork.getThread2().isAlive() && concNetwork.getThread3().isAlive()) {

        }

        long concFinishTime = System.currentTimeMillis() - concStartTime;
        System.out.println("Time for concurrent processing: " + concFinishTime + "[ms]");

        long linearStartTime = System.currentTimeMillis();
        Thread linearThread = new Thread(new LinearNetwork(NUMBER_OF_STEPS));
        linearThread.start();
        while(linearThread.isAlive()){}
        long linearFinishTime = System.currentTimeMillis() - linearStartTime;

        System.out.println("Time for linear processing: " + linearFinishTime + "[ms]");

    }
}
