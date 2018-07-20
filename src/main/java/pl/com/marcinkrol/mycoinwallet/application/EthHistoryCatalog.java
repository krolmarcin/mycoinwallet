package pl.com.marcinkrol.mycoinwallet.application;

import java.util.List;

public interface EthHistoryCatalog {

    List<EthBalanceHistoryDto> getHistory(String walletId);

}
