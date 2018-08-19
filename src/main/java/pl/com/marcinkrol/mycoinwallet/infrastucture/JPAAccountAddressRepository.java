package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.domain.AccountAddress;
import pl.com.marcinkrol.mycoinwallet.domain.AccountAddressRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JPAAccountAddressRepository implements AccountAddressRepository {

    private String getAccountAddressByWalletId = "From AccountAddress a WHERE a.walletId = :walletId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void put(AccountAddress accountAddress) {
        entityManager.persist(accountAddress);
    }

    @Override
    public AccountAddress get(String walletId) {
        Query query = entityManager.createQuery(getAccountAddressByWalletId);
        query.setParameter("walletId", walletId);
        return (AccountAddress) query.getResultList().get(0);
    }

    @Override
    public Long getId(String walletId) {
        Query query = entityManager.createQuery(getAccountAddressByWalletId);
        query.setParameter("walletId", walletId);
        AccountAddress accountAddress = (AccountAddress) query.getResultList().get(0);
        return accountAddress.getId();
    }

    @Override
    public boolean exists(String walletId) {
        Query query = entityManager.createQuery(getAccountAddressByWalletId);
        query.setParameter("walletId", walletId);
        return (!query.getResultList().isEmpty());
    }

}
