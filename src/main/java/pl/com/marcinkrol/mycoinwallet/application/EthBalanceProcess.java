package pl.com.marcinkrol.mycoinwallet.application;

public interface EthBalanceProcess {

    EthBalanceDto getBalance(String walletId);

}
