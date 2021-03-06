package com.lyszkowski_lisowski.application;

import com.lyszkowski_lisowski.notifier.Notifier;
import com.lyszkowski_lisowski.processes.ProcessAllResources;
import com.lyszkowski_lisowski.processes.ProcessParticularResource;
import com.lyszkowski_lisowski.resources.Resources;

/**
 * Created by szymonidas on 01.11.14.
 */
public class Application {

    public static final int RESOURCES_AMOUNT = 10;
    public static final int PROCESSES_AMOUNT_ALL = RESOURCES_AMOUNT + 1;
    public static final int PROCESSES_AMOUNT_PARTICULAR = RESOURCES_AMOUNT;


    public static void main(String... args) {

        Resources resources = new Resources(RESOURCES_AMOUNT);

        new Thread(new Notifier(resources)).start();


        for (int i = 0; i < PROCESSES_AMOUNT_ALL; i++) {
            /**
             * Processes which can access any resource
             */
            new Thread(new ProcessAllResources(i, resources)).start();

        }

        for (int i = 0; i < PROCESSES_AMOUNT_PARTICULAR; i++) {
            /**
             * Processes which can access only particular resource
             */
            new Thread(new ProcessParticularResource(i,resources,i)).start();
        }


    }
}
