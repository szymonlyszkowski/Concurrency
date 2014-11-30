package com.lyszkowski_lisowski.notifier;

import com.lyszkowski_lisowski.application.Application;
import com.lyszkowski_lisowski.resources.Resources;

/**
 * Created by szymonidas on 02.11.14.
 */
public class Notifier implements Runnable {

    private Resources resources;

    public Notifier(Resources resources) {
        this.resources = resources;
    }

    /*
    Checks if all processes were handled. When yes - notify all processes to awake which were waiting after actionOnResource()
     */
    private void wakeProcesses() {

        synchronized (resources.getResources()) {

            if (resources.getProcessesAmount() == Application.PROCESSES_AMOUNT_PARTICULAR + Application.PROCESSES_AMOUNT_ALL) {
                resources.setProcessesAmount(0);
                resources.getResources().notifyAll();
            }
        }
    }


    @Override
    public void run() {

        while(true){
            wakeProcesses();
        }


    }
}
