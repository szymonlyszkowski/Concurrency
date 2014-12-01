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

    public LinkedBlockingQueue<Client> getClients() {
        return clients;
    }

    /**
     * FIFO of the resource - gives the access priority to clients
     */
    private LinkedBlockingQueue<Client> clients;


    public Resource(int resourceId) {
        this.resourceId = resourceId;
        clients = new LinkedBlockingQueue<Client>();
    }


    public void serviceDelivered(Client client) {
        LOGGER.info("Service delivered by: " + resourceId + " invoked by: " + client.getClientId() + " service defined: " + client.getResourceIdDefined());
    }


    @Override
    public void run() {
        /**
         * Synchronized on Resource object.
         * When Client object is taken from Resource queue,
         * Resource object(thread) blocked for other Client threads,
         * service delivered by Resource class is called.
         */
        synchronized (this) {
            while (clients.peek() != null) {
                try {
                    Client client = clients.poll();
                    this.wait();
                    client.accessService(this);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
