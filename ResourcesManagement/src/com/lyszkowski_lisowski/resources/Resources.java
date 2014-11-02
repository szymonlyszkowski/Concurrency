package com.lyszkowski_lisowski.resources;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by szymonidas on 01.11.14.
 */
public class Resources {

    private int resourcesAmount;
    private ConcurrentHashMap<Integer, Resource> resources;

    public Resources(int resourcesAmount) {
        this.resourcesAmount = resourcesAmount;
        this.resources = new ConcurrentHashMap(resourcesAmount);

        createResources(this.resources);
    }


    private void createResources(ConcurrentHashMap<Integer, Resource> resources) {

        int id = 0;

        while (id < getResourcesAmount()) {
            resources.put(id, new Resource(id));
            System.out.println("Resource added with id: " + id);
            ++id;
        }
        synchronized (resources) {
            resources.notifyAll();

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
