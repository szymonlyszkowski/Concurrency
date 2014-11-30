package com.lyszkowski_lisowski.models;


import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Resource implements Runnable {

    private int resourceId;
    private boolean canServiceAnyone;
    private int clientIdToService;
    private LinkedBlockingQueue<Client> clients;
    private static final Logger LOGGER = Logger.getLogger(Resource.class);

    public Resource(int resourceId, boolean canServiceAnyone, int clientIdToService) {
        this.resourceId = resourceId;
        clients = new LinkedBlockingQueue<Client>();
        this.canServiceAnyone = canServiceAnyone;
        this.clientIdToService = clientIdToService;
    }


    public void serviceDelivered(Client client){
        LOGGER.info("Service delivered by: " + resourceId + "invoked by: " + client.getClientId());
    }



    @Override
    public void run() {

        synchronized (clients){
            while(clients.peek()!=null){
                try {
                Client client = clients.poll();
                if((!canServiceAnyone && clientIdToService==client.getClientId()) || canServiceAnyone==true)
                    clients.wait();
                    client.accessService(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
