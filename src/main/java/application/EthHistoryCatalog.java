package application;

import java.util.List;

public interface EthHistoryCatalog {

    List<EthHistoryDto> getHistory(String walletId);

}
