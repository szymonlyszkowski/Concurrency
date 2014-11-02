package com.lyszkowski_lisowski.resources;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by szymonidas on 01.11.14.
 */
public class Resources {

    private int resourcesAmount;
    /**
     * Monitor - can handle max 16 threads in the same time. (Default Java constant - can be modified)
     */
    private ConcurrentHashMap<Integer, Resource> resources;
    private int processesAmount;

    public Resources(int resourcesAmount) {
        this.resourcesAmount = resourcesAmount;
        this.resources = new ConcurrentHashMap(resourcesAmount);
        this.processesAmount = 0;
        createResources(this.resources);
    }


    public ConcurrentHashMap<Integer, Resource> getResources() {
        return resources;
    }

    private void createResources(ConcurrentHashMap<Integer, Resource> resources) {

        int id = 0;

        while (id < getResourcesAmount()) {
            resources.put(id, new Resource(id));
            System.out.println("Resource added with id: " + id);
            ++id;

        }
    }


    public int getResourcesAmount() {
        return resourcesAmount;
    }

    public int getProcessesAmount() {
        return this.processesAmount;
    }

    public void setProcessesAmount(int processesAmount) {
        this.processesAmount = processesAmount;
    }

    public void incrementProcessesHandled() {
        ++this.processesAmount;
    }
}
