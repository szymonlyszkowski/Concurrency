package com.lyszkowski_lisowski.application;

import com.lyszkowski_lisowski.container.Container;
import com.lyszkowski_lisowski.models.Client;
import com.lyszkowski_lisowski.models.Resource;

import java.util.Random;

/**
 * Created by szymonidas on 30.11.14.
 */
public class Meetings {

    public static final int RESOURCES_AMOUNT = 10;
    public static final int CLIENTS_AMOUNT_ALL = RESOURCES_AMOUNT + 1;
    public static final int CLIENTS_AMOUNT_PARTICULAR = RESOURCES_AMOUNT;

    public static void main(String... args) {

        Container meetingsContainer = new Container();

        for (int i = 0; i < CLIENTS_AMOUNT_ALL; i++) {
            Client client = new Client(i);
            meetingsContainer.addClientToContainer(client);
            new Thread(client).start();
        }
        for (int i = 0; i < CLIENTS_AMOUNT_PARTICULAR; i++) {
            Client client = new Client(i + CLIENTS_AMOUNT_ALL);
            client.setResourceIdDefined(i);
            meetingsContainer.addClientToContainer(client);
            new Thread(client).start();
        }
        for (int i = 0; i < RESOURCES_AMOUNT; i++) {
            Resource resource = new Resource(i);
            meetingsContainer.addResourceToContainer(resource);
            new Thread(resource).start();
        }

        while (true) {

            for (Client client : Container.getClientsContainer()) {
                int resourceToPick = new Random().nextInt(RESOURCES_AMOUNT);
                client.accessService(Container.getResourcesContainer().get(resourceToPick));

            }
        }


    }
}
