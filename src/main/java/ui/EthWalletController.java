package ui;

import application.EthHistoryCatalog;
import application.EthDto;
import application.EthHistoryDto;
import domain.EthBalanceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
