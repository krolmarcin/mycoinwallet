package infrastucture;

import application.EthHistoryCatalog;
import application.EthDto;
import domain.EthBalanceRepository;

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
