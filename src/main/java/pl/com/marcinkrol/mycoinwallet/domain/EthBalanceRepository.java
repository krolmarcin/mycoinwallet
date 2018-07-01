package pl.com.marcinkrol.mycoinwallet.domain;

import pl.com.marcinkrol.mycoinwallet.application.EthDto;

import java.util.List;

public interface EthBalanceRepository {

    List<EthDto> getBalance(String walletId);

}
