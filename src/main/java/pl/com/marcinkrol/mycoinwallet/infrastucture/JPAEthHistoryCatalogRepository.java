package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceHistoryDto;
import pl.com.marcinkrol.mycoinwallet.domain.AccountAddress;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class JPAEthHistoryCatalogRepository implements EthHistoryCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EthBalanceHistoryDto> getHistory(String walletId) {
        return null;
    }

}