package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalance;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAEthBalanceRepository implements EthBalanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EthBalanceDto getBalance(String walletId) {
        return null;
    }

    public void put(EthBalance ethBalance) {
        entityManager.persist(ethBalance);
    }


}
