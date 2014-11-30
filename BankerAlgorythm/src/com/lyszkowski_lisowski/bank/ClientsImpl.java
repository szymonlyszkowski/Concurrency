package com.lyszkowski_lisowski.bank;

import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class ClientsImpl {

    /**
     * List of the clients.
     */
    private ArrayList<ClientImpl> clients = new ArrayList<ClientImpl>();

    /**
     * Amount of the clients.
     */
    private final int clientsAmount;

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(ClientsImpl.class);

    /**
     * Constructor.
     *
     * @param clientsAmount
     * @param maxLoan
     */
    public ClientsImpl(int clientsAmount, int maxLoan) {
        this.clientsAmount = clientsAmount;

        createClients(this.clients, maxLoan);
    }

    private void createClients(ArrayList<ClientImpl> clients, int maxLoan) {

        for (int i=0; i<clientsAmount; i++) {
            if (logger.isDebugEnabled()) {
                clients.add(new ClientImpl(i, (int)(maxLoan * Math.random())));
                if (logger.isDebugEnabled()) {
                    logger.debug("Client added with id: " + i);
                }
            }
        }
        synchronized (clients) {
            clients.notifyAll();
        }
    }

    // getters & setters
    public int getClientsAmount() {
        return clientsAmount;
    }
    public ArrayList<ClientImpl> getClients() {
        return clients;
    }
    public void setClients(ArrayList<ClientImpl> clients) {
        this.clients = clients;
    }
}
