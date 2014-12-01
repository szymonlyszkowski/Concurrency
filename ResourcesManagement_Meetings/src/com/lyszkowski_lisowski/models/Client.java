package com.lyszkowski_lisowski.models;

import org.apache.log4j.Logger;
import sun.misc.Cleaner;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Client implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(Client.class);

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
        this.resourceIdDefined = -1;
    }


    /**
     * Synchronized on Resource object.
     * Method checks whether this Client can access delivered resource
     * if yes adds this object to resource queue and access service. if not quit.
     * @param resource
     */
    public void accessService(Resource resource) {

        synchronized (resource){
            if (resource.getResourceId() == getResourceIdDefined() || getResourceIdDefined() ==-1 ) {
                resource.getClients().offer(this);
                resource.serviceDelivered(this);
                resource.notify();
                LOGGER.info("Service accessed on resource: " + resource.getResourceId());
            }
            else
            {
                resource.notify();
                LOGGER.info("Service not accessed because process invoking is not assigned to service called");
            }

        }

    }

    @Override
    public void run() {




    }
}
