package pl.com.marcinkrol.mycoinwallet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountAddress {

    @Id
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
