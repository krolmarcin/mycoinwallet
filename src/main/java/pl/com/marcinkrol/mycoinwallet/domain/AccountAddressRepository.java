package pl.com.marcinkrol.mycoinwallet.domain;

public interface AccountAddressRepository {

    void put(AccountAddress accountAddress);

    AccountAddress get(String walletId);

    Long getId(String walletId);

    boolean exists(String walletId);

}
