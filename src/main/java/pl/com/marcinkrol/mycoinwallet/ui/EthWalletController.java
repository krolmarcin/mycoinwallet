package pl.com.marcinkrol.mycoinwallet.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.marcinkrol.mycoinwallet.application.EthDto;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryDto;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

import java.util.List;

@RestController
@RequestMapping("/eth")
public class EthWalletController {

    private EthHistoryCatalog ethHistoryCatalog;
    private EthBalanceRepository ethBalanceRepository;

    public EthWalletController(EthHistoryCatalog ethHistoryCatalog, EthBalanceRepository ethBalanceRepository) {
        this.ethHistoryCatalog = ethHistoryCatalog;
        this.ethBalanceRepository = ethBalanceRepository;
    }

    @GetMapping("/{walletId}/history")
    public List<EthHistoryDto> getHistory(@PathVariable String walletId) {
        return ethHistoryCatalog.getHistory(walletId);
    }

    @GetMapping("/{walletId}/balance")
    public List<EthDto> getBalance(@PathVariable String walletId) {
        return ethBalanceRepository.getBalance(walletId);
    }

}
