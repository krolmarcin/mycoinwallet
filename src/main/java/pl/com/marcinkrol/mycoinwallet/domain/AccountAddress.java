package pl.com.marcinkrol.mycoinwallet.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class AccountAddress {

    @Id
    @GeneratedValue
    private Long id;
    private String walletId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountAddressId")
    private List<EthBalance> ethBalances;

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

    public List<EthBalance> getEthBalances() {
        return ethBalances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountAddress that = (AccountAddress) o;

        return walletId.equals(that.walletId);
    }

    @Override
    public int hashCode() {
        return walletId.hashCode();
    }

}
