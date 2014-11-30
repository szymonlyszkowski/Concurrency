package com.lyszkowski_lisowski.models;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Client implements Runnable {


    public int getClientId() {
        return clientId;
    }

    private int clientId;

    public Integer getResourceIdDefined() {
        return resourceIdDefined;
    }

    public void setResourceIdDefined(Integer resourceIdDefined) {
        this.resourceIdDefined = resourceIdDefined;
    }

    private Integer resourceIdDefined;

    public Client(int clientId) {
        this.clientId = clientId;
        this.resourceIdDefined = null;
    }



    public void accessService(Resource resource) {

        synchronized (resource){
            resource.serviceDelivered(this);
            resource.notify();
        }

    }

    @Override
    public void run() {




    }
}
