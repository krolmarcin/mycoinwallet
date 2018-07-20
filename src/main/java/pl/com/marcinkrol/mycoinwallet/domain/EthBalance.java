package pl.com.marcinkrol.mycoinwallet.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EthBalance {

    @Id
    @GeneratedValue
    private Long id;
    private String ethBalance;
    private String usdBalance;
    private String btcBalance;
    private LocalDateTime date;

    @JoinColumn(name = "accountAddressId")
    private Long accountAddressId;

    EthBalance() {
    }

    public EthBalance(String ethBalance, String usdBalance, String btcBalance, Long id) {
        this.ethBalance = ethBalance;
        this.usdBalance = usdBalance;
        this.btcBalance = btcBalance;
        this.accountAddressId = id;
        this.date = LocalDateTime.now();
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

    public Long getAccountAddressId() {
        return accountAddressId;
    }
}
