package pl.com.marcinkrol.mycoinwallet.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EthHistoryCatalog {

    List<EthBalanceHistoryDto> getHistory(String walletId, LocalDateTime from, LocalDateTime to);

}
