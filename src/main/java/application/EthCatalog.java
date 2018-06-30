package application;

import java.util.List;

public interface EthCatalog {

    List<EthDto> getBalance(String walletId);

}
