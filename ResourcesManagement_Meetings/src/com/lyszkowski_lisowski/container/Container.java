package com.lyszkowski_lisowski.container;

import com.lyszkowski_lisowski.models.Client;
import com.lyszkowski_lisowski.models.Resource;

import java.util.ArrayList;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Container {

    public static ArrayList<Resource> getResourcesContainer() {
        return resourcesContainer;
    }

    private static ArrayList<Resource> resourcesContainer;

    public static ArrayList<Client> getClientsContainer() {
        return clientsContainer;
    }

    private static ArrayList<Client> clientsContainer;


    public Container() {

        resourcesContainer = new ArrayList<Resource>();
        clientsContainer = new ArrayList<Client>();

    }

    public void addResourceToContainer(Resource resource){

        resourcesContainer.add(resource);
    }

    public void addClientToContainer(Client client){
        clientsContainer.add(client);
    }


}
