package ui;

import application.EthCatalog;
import application.EthDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eth")
public class EthWalletController {

    private EthCatalog ethCatalog;

    public EthWalletController(EthCatalog ethCatalog) {
        this.ethCatalog = ethCatalog;
    }

    @GetMapping("/{walletId}/balance")
    public List<EthDto> getBalance(@PathVariable String walletId){
        return ethCatalog.getBalance(walletId);
    }

}
