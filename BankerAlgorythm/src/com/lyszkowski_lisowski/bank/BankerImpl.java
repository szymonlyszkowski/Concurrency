package com.lyszkowski_lisowski.bank;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class BankerImpl {

    /**
     * Bank's starting capital.
     */
    private final int startingCapital;

    /**
     * Bank's current capital.
     */
    private int currentCapital;

    /**
     * Bank's clients.
     */
    private ClientsImpl clients;

    /**
     * Flag notifying about clients who wait for loan for a long time.
     */
    private boolean isWaitingForMoney = false;

    public BankerImpl(int startingCapital) {
        this.startingCapital = startingCapital;
        this.currentCapital = startingCapital;
    }

    // getters & setters
    public int getStartingCapital() {
        return startingCapital;
    }
    public int getCurrentCapital() {
        return currentCapital;
    }
    public void setCurrentCapital(int currentCapital) {
        this.currentCapital = currentCapital;
    }
    public ClientsImpl getClients() {
        return clients;
    }
    public void setClients(ClientsImpl clients) {
        this.clients = clients;
    }
    public boolean isWaitingForMoney() {
        return isWaitingForMoney;
    }
    public void setWaitingForMoney(boolean isWaitingForMoney) {
        this.isWaitingForMoney = isWaitingForMoney;
    }
}
