package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.domain.AccountAddress;
import pl.com.marcinkrol.mycoinwallet.domain.AccountAddressRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JPAAccountAddressRepository implements AccountAddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(AccountAddress accountAddress) {
        entityManager.persist(accountAddress);
    }

    @Override
    public AccountAddress get(String walletId) {
        return null;
    }

    @Override
    public Long getId(String walletId) {
        String queryMessage = "From AccountAddress a WHERE a.walletId=:walletId";
        Query query = entityManager.createQuery(queryMessage);
        query.setParameter("walletId", walletId);
        AccountAddress accountAddress = (AccountAddress) query.getResultList().get(0);
        return accountAddress.getId();
    }

    @Override
    public boolean exists(String walletId) {
        String queryMessage = "From AccountAddress a WHERE a.walletId=:walletId";
        Query query = entityManager.createQuery(queryMessage);
        query.setParameter("walletId", walletId);
        return (!query.getResultList().isEmpty());
    }

}
