package infrastucture;

import application.EthHistoryCatalog;
import application.EthDto;
import application.EthHistoryDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JPAEthHistoryCatalogRepository implements EthHistoryCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EthHistoryDto> getHistory(String walletId) {
        return null;
    }

}

