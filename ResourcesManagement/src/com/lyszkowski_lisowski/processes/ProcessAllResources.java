package com.lyszkowski_lisowski.processes;

import com.lyszkowski_lisowski.resources.Resource;
import com.lyszkowski_lisowski.resources.Resources;

import java.util.Random;

/**
 * Created by szymonidas on 01.11.14.
 */
public class ProcessAllResources implements Accessibility, Runnable {

    private int processId;
    private Resources resources;

    public ProcessAllResources(int processId, Resources resources) {
        this.processId = processId;
        this.resources = resources;
    }

    @Override
    public boolean canAccessAnyResource() {
        return true;
    }

    @Override
    public void actionOnResource() {
        System.out.println("Action done by process " + " " + getProcessId() + " " + " using arbitrary resource ! ");
    }

    @Override
    public void getInsideResource() {

        synchronized (resources.getResources()) {

            while (true) {

                try {
                    Resource resource = resources.getResources().get(new Random().nextInt(10));
                    System.out.println("Resource gained " + resource.getResourceId());
                    actionOnResource();
                    resources.incrementProcessesHandled();
                    resources.getResources().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }


    @Override
    public void run() {

        if (canAccessAnyResource() == true) {

            getInsideResource();

        }

    }

    public int getProcessId() {
        return this.processId;
    }


}
