package infrastucture;

import domain.EthBalanceRepository;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EthBalanceRepository ethBalanceRepository() {
        return new JPAEthBalanceRepository();
    }

}
