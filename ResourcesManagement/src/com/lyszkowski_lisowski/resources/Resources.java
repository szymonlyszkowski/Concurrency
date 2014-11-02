package com.lyszkowski_lisowski.resources;

import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by szymonidas on 01.11.14.
 */
public class Resources {

    private int resourcesAmount;
    private LinkedBlockingQueue<Resource> resources;

    public Resources(int resourcesAmount) {
        this.resourcesAmount = resourcesAmount;
        this.resources = new LinkedBlockingQueue(resourcesAmount);

        createResources(this.resources);
    }


    private void createResources(LinkedBlockingQueue<Resource> fifo) {

        int id = 0;

        while (id < getResourcesAmount()) {
            if (fifo.offer(new Resource(id))) {
                System.out.println("Resource added with id: " + id);

            }
            ++id;
        }
        synchronized (fifo) {
            fifo.notifyAll();

        }
    }


    public LinkedBlockingQueue<Resource> getResources() {
        return resources;
    }

    public void setResources(LinkedBlockingQueue<Resource> resources) {
        this.resources = resources;
    }

    public int getResourcesAmount() {
        return resourcesAmount;
    }

    public void setResourcesAmount(int resourcesAmount) {
        this.resourcesAmount = resourcesAmount;
    }
}
