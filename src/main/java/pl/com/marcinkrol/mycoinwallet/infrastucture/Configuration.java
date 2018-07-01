package pl.com.marcinkrol.mycoinwallet.infrastucture;

import org.springframework.context.annotation.Bean;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

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

}
