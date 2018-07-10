package pl.com.marcinkrol.mycoinwallet.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryDto;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

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
    public List<EthHistoryDto> getHistory(@PathVariable String walletId) {
        return ethHistoryCatalog.getHistory(walletId);
    }

    @GetMapping("/{walletId}/balance")
    public EthBalanceDto getBalance(@PathVariable String walletId) {
        return ethBalanceProcess.getBalance(walletId);
    }

}
