package pl.com.marcinkrol.mycoinwallet.domain;

import javax.persistence.*;

@Entity
public class EthBalance {

    @Id
    private Long id;
    private String ethBalance;
    private String usdBalance;
    private String btcBalance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountAddressId")
    private AccountAddress accountAddress;

    EthBalance() {
    }

    public EthBalance(String ethBalance, String usdBalance, String btcBalance, AccountAddress accountAddress) {
        this.ethBalance = ethBalance;
        this.usdBalance = usdBalance;
        this.btcBalance = btcBalance;
        this.accountAddress = accountAddress;
    }

    public Long getId() {
        return id;
    }

    public String getEthBalance() {
        return ethBalance;
    }

    public String getUsdBalance() {
        return usdBalance;
    }

    public String getBtcBalance() {
        return btcBalance;
    }

}
