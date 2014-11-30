package com.lyszkowski_lisowski;

import com.lyszkowski_lisowski.bank.BankSimulationImpl;
import com.lyszkowski_lisowski.bank.BankerImpl;
import com.lyszkowski_lisowski.bank.ClientImpl;
import com.lyszkowski_lisowski.bank.ClientsImpl;
import org.apache.log4j.Logger;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class BankerAlgorithm {

    /**
     * Clients amount.
     */
    private static final int CLIENTS_AMOUNT = 10;

    /**
     * Max loan, also bank's starting capital.
     */
    private static final int MAX_LOAN = 1000;

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(BankerAlgorithm.class);

    public static void main(String[] args) {

        if (logger.isDebugEnabled()) {
            logger.debug("Start of banker algorithm");
        }

        BankerImpl banker = new BankerImpl(MAX_LOAN);

        ClientsImpl clients = new ClientsImpl(CLIENTS_AMOUNT, banker.getStartingCapital());

        banker.setClients(clients);

        while(true) {
            for (int i = 0; i < CLIENTS_AMOUNT; i++) {
                new Thread(new BankSimulationImpl(i, banker)).start();
            }
        }
    }
}
