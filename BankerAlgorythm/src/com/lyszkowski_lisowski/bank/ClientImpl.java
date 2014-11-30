package com.lyszkowski_lisowski.bank;

/**
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 */
public class ClientImpl {

    /**
     * Client's id.
     */
    private final int id;

    /**
     * Max loan that can be taken from banker.
     */
    private final int maxLoan;

    /**
     * Current loan to pay back.
     */
    private int currentLoan;

    /**
     * Numbers of demands rejected in row.
     */
    private int demandsInRowRejected;

    /**
     * Constructor.
     *
     * @param maxLoan - max loan that cna be taken from banker.
     */
    public ClientImpl(int id, int maxLoan) {
        this.id = id;
        this.maxLoan = maxLoan;
        this.demandsInRowRejected = 0;
    }

    // getters & setters
    public int getId() {
        return id;
    }
    public int getMaxLoan() {
        return maxLoan;
    }
    public int getCurrentLoan() {
        return currentLoan;
    }
    public void setCurrentLoan(int currentLoan) {
        this.currentLoan = currentLoan;
    }
    public int getDemandsInRowRejected() {
        return demandsInRowRejected;
    }
    public void setDemandsInRowRejected(int demandsInRowRejected) {
        this.demandsInRowRejected = demandsInRowRejected;
    }
}
