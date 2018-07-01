package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.application.EthDto;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JPAEthBalanceRepository implements EthBalanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EthDto> getBalance(String walletId) {
        return null;
    }

}
