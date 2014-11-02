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
        System.out.println("Action done by process" + getProcessId() + "using resource: " + getResourceId() + " ! ");
    }

    @Override
    public void getInsideResource() {

        synchronized (resources.getResources()) {

            System.out.println("PEEK QUEUE" + resources.getResources().peek().getResourceId());
//            try {
            while (resources.getResources().peek() != null) {

                // try {

                //resources.getResources().wait();

                Resource resource = resources.getResources().poll();
                System.out.println("Resource gained" + resources.getResources().peek().getResourceId());
//                    actionOnResource();

//                        Resource resource = resources.getResources().peek();
//                        System.out.println("Resource gained" + resource.getResourceId());

                try {
                    if (resource.getResourceId() == getResourceId()) {
                        resources.getResources().notifyAll();
                        actionOnResource();

                        resources.getResources().put(resource);


                    } else {
                        resources.getResources().put(resource);
                        resources.getResources().notifyAll();
                    }
                    resources.getResources().wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

            }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
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

    public void setProcessId(int processId) {
        this.processId = processId;
    }
}



