package com.lyszkowski_lisowski.processes;

import com.lyszkowski_lisowski.resources.Resource;
import com.lyszkowski_lisowski.resources.Resources;

import java.util.Iterator;

/**
 * Created by szymonidas on 01.11.14.
 */
public class ProcessParticularResource implements Accessibility, Runnable {

    private int resourceId;
    private Resources resources;

    public ProcessParticularResource(int resourceId, Resources resources) {
        this.resourceId = resourceId;
        this.resources = resources;
    }


    @Override
    public boolean canAccessAnyResource() {
        return false;
    }

    @Override
    public void actionOnResource() {
        System.out.println("Action done using resource: " + getResourceId() + " ! ");
    }

    @Override
    public void getInsideResource() {

        synchronized (resources.getResources()) {

            Iterator<Resource> resourcesIterator = this.resources.getResources().iterator();
            try {
                while (resources.getResources().take()!=null) {

                    try {

                        resources.getResources().wait();
                        Resource resource = resources.getResources().peek();
                        System.out.println("Resource gained" + resource.getResourceId());
                        if (resource.getResourceId() == getResourceId()) {

                            actionOnResource();
                            resources.getResources().notifyAll();
                        } else {
                            resources.getResources().notifyAll();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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


}



