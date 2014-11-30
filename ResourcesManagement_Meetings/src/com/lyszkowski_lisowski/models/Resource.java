package com.lyszkowski_lisowski.models;


import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;

import static org.apache.log4j.Logger.getLogger;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Resource implements Runnable {

    public int getResourceId() {
        return resourceId;
    }
    private static final Logger LOGGER = getLogger(Resource.class);
    private int resourceId;
    private LinkedBlockingQueue<Client> clients;


    public Resource(int resourceId) {
        this.resourceId = resourceId;
        clients = new LinkedBlockingQueue<Client>();
    }


    public void serviceDelivered(Client client) {
        LOGGER.info("Service delivered by: " + resourceId + " invoked by: " + client.getClientId());
    }


    @Override
    public void run() {

        synchronized (clients) {
            while (clients.peek() != null) {
                try {
                    Client client = clients.poll();
                    clients.wait();
                    client.accessService(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
