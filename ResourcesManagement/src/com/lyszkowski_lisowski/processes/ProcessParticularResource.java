package com.lyszkowski_lisowski.processes;

import com.lyszkowski_lisowski.resources.Resource;
import com.lyszkowski_lisowski.resources.Resources;

/**
 * Created by szymonidas on 01.11.14.
 */
public class ProcessParticularResource implements Accessibility, Runnable {

    private int resourceId;
    private Resources resources;
    private int processId;


    public ProcessParticularResource(int resourceId, Resources resources, int processId) {
        this.resourceId = resourceId;
        this.resources = resources;
        this.processId = processId;
    }


    @Override
    public boolean canAccessAnyResource() {
        return false;
    }

    @Override
    public void actionOnResource() {
        System.out.println("Action done by process " + getProcessId() + " using resource: " + getResourceId() + " ! ");
    }

    @Override
    public void getInsideResource() {

        synchronized (resources.getResources()) {

            while (true) {

                try {
                    Resource resource = resources.getResources().get(this.getResourceId());
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

    public int getResourceId() {
        return resourceId;
    }

    @Override
    public void run() {

        if (canAccessAnyResource() == false) {

            getInsideResource();
        }

    }

    public int getProcessId() {
        return processId;
    }
}



