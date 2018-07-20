package pl.com.marcinkrol.mycoinwallet.domain;

import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;

public interface EthBalanceRepository {

    EthBalanceDto getBalance(String walletId);

    void put(EthBalance ethBalance);

}
