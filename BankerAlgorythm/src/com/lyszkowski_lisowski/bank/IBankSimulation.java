package com.lyszkowski_lisowski.bank;

/**
 *
 * @author <a href="mailto:171133@edu.p.lodz.pl">Szymon Łyszkowski</a>
 * @author <a href="mailto:171131@edu.p.lodz.pl">Andrzej Lisowski</a>
 *
 */
public interface IBankSimulation {

    public void actionOnResource(ClientImpl client);

    public void getInsideResource();

}
