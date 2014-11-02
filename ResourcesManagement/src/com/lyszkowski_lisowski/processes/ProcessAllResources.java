package com.lyszkowski_lisowski.processes;

import com.lyszkowski_lisowski.resources.Resource;
import com.lyszkowski_lisowski.resources.Resources;

import java.util.Iterator;

/**
 * Created by szymonidas on 01.11.14.
 */
public class ProcessAllResources implements Accessibility, Runnable {

    private Resources resources;

    public ProcessAllResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public boolean canAccessAnyResource() {
        return true;
    }

    @Override
    public void actionOnResource() {
        System.out.println("Action done using arbitrary resource ! ");
    }

    @Override
    public void getInsideResource() {

        synchronized (resources.getResources()) {

            Iterator<Resource> resourcesIterator = this.resources.getResources().iterator();
            System.out.println("AGOT ITERATOR ALL RESC" + resources.getResourcesAmount());
            while (resourcesIterator.hasNext()) {
                try {
                    resources.getResources().wait();

                    System.out.println("Resource gained" + resourcesIterator.next().getResourceId());
                    actionOnResource();
                    resources.getResources().notifyAll();


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
}
