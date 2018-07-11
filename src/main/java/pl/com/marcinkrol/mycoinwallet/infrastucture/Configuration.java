package pl.com.marcinkrol.mycoinwallet.infrastucture;

import org.springframework.context.annotation.Bean;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.application.implementation.StandardEthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.domain.*;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EthHistoryCatalog ethHistoryCatalog() {
        return new JPAEthHistoryCatalogRepository();
    }

    @Bean
    public EthBalanceRepository ethBalanceRepository() {
        return new JPAEthBalanceRepository();
    }

    @Bean
    public EthBalanceFacade ethBalanceFacade() {
        return new EtherscanEthBalanceFacade();
    }

    @Bean
    public AccountAddressRepository accountAddressRepository() {
        return new JPAAccountAddressRepository();
    }

    @Bean
    public TokenConverter tokenConverter() {
        return new StandardTokenConverter();
    }

    @Bean
    public EthBalanceProcess ethBalanceProcess() {
        return new StandardEthBalanceProcess(accountAddressRepository(),
                ethBalanceRepository(),
                ethBalanceFacade(),
                tokenConverter());
    }

}
