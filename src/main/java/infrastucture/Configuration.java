package infrastucture;

import application.EthHistoryCatalog;
import domain.EthBalanceRepository;
import org.springframework.context.annotation.Bean;

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
