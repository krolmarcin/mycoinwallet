package pl.com.marcinkrol.mycoinwallet.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AccountAddress {

    @Id
    @GeneratedValue
    private Long id;
    private String walletId;

    AccountAddress() {
    }

    public AccountAddress(String walletId) {
        this.walletId = walletId;
    }

    public Long getId() {
        return id;
    }

    public String getWalletId() {
        return walletId;
    }

}
