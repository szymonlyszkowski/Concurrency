package com.lyszkowski_lisowski.bank;

import org.apache.log4j.Logger;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class BankSimulationImpl implements IBankSimulation, Runnable {

    /**
     * Client's bank.
     */
    BankerImpl banker;

    /**
     * Bank's clients.
     */
    private int clientId;

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(BankSimulationImpl.class);

    /**
     * Constructor.
     *
     * @param clientId
     * @param banker
     */
    public BankSimulationImpl(int clientId, BankerImpl banker) {
        this.clientId = clientId;
        this.banker = banker;
    }

    @Override
    public void actionOnResource(ClientImpl client) {
        if(logger.isDebugEnabled()) {
            logger.debug("\n\nBank capital before operation: " + banker.getCurrentCapital() + " florens.\n");
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Client " + client.getId() +" has entered the bank");
        }

        if (client.getCurrentLoan() == 0) {
            int newLoan = (int)(client.getMaxLoan() * Math.random());

            if (banker.isWaitingForMoney() && client.getDemandsInRowRejected() < 10) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Cannot make the operation because bank is waiting for the money for other client");
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("Demand for " + newLoan + " florens has occurred");
                }

                if (banker.getCurrentCapital() >= newLoan) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Demand accepted");
                    }
                    banker.setCurrentCapital(banker.getCurrentCapital() - newLoan);
                    client.setCurrentLoan(newLoan);
                    if(client.getDemandsInRowRejected() >= 10) {
                        banker.setWaitingForMoney(false);
                    }
                    client.setDemandsInRowRejected(0);
                } else {
                    client.setDemandsInRowRejected(client.getDemandsInRowRejected() + 1);
                    if(client.getDemandsInRowRejected() == 10) {
                        banker.setWaitingForMoney(true);
                    }
                    if (logger.isDebugEnabled()) {
                        logger.debug("Demand rejected");
                    }
                }
            }
        } else {
            if(logger.isDebugEnabled()) {
                logger.debug("Wish to redeem " + client.getCurrentLoan() + " florens has occurred.");
            }

            banker.setCurrentCapital(banker.getCurrentCapital() + client.getCurrentLoan());
            client.setCurrentLoan(0);
        }

        if(logger.isDebugEnabled()) {
            logger.debug("\n\nBank capital after operation: " + banker.getCurrentCapital() + " florens.\n\n");
        }
    }

    @Override
    public void getInsideResource() {

        synchronized (banker.getClients().getClients()) {
            banker.getClients().getClients().notifyAll();
            ClientImpl client = banker.getClients().getClients().get(clientId);
            actionOnResource(client);
            try {
                banker.getClients().getClients().wait();
            } catch (InterruptedException e) {
                logger.error("An error has occurred!", e);
            }
        }
    }

    @Override
    public void run() {
        getInsideResource();
    }
}
