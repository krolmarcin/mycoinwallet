package pl.com.marcinkrol.mycoinwallet.ui;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceHistoryDto;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/eth")
public class EthWalletController {

    private EthHistoryCatalog ethHistoryCatalog;
    private EthBalanceRepository ethBalanceRepository;
    private EthBalanceProcess ethBalanceProcess;

    public EthWalletController(EthHistoryCatalog ethHistoryCatalog,
                               EthBalanceRepository ethBalanceRepository,
                               EthBalanceProcess ethBalanceProcess) {
        this.ethHistoryCatalog = ethHistoryCatalog;
        this.ethBalanceRepository = ethBalanceRepository;
        this.ethBalanceProcess = ethBalanceProcess;
    }

    @GetMapping("/{walletId}/history")
    public List<EthBalanceHistoryDto> getHistory(@PathVariable String walletId,
                                                 @RequestParam("from") @DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm") LocalDateTime from,
                                                 @RequestParam("to") @DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm") LocalDateTime to) {
        return ethHistoryCatalog.getHistory(walletId, from, to);
    }

    @GetMapping("/{walletId}/balance")
    public EthBalanceDto getBalance(@PathVariable String walletId) {
        return ethBalanceProcess.getBalance(walletId);
    }

}
