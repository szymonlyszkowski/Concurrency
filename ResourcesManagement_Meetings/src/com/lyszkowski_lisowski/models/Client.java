package com.lyszkowski_lisowski.models;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Client implements Runnable {

    public Client(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    private int clientId;

    public void accessService(Resource resource) {
        resource.serviceDelivered(this);
    }

    @Override
    public void run() {

    }
}
