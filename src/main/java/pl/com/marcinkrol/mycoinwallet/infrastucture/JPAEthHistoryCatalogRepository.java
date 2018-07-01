package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.application.EthHistoryDto;

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