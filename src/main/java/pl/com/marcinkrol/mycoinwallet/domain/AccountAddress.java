package pl.com.marcinkrol.mycoinwallet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountAddress {

    @Id
    @GeneratedValue
    private Long id;
    private String walletId;

    AccountAddress(){}

    public Long getId() {
        return id;
    }

    public String getWalletId() {
        return walletId;
    }

}
