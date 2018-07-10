package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.domain.AccountAddress;
import pl.com.marcinkrol.mycoinwallet.domain.AccountAddressRepository;

public class JPAAccountAddressRepository implements AccountAddressRepository {

    public void put(AccountAddress accountAddress) {
    }

    public AccountAddress get(String walletId) {
        return null;
    }

    public boolean exists(String walletId) {
        return false;
    }

}
