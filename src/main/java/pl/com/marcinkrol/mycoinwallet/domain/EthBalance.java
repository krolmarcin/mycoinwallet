package pl.com.marcinkrol.mycoinwallet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

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

    public AccountAddress getAccountAddress() {
        return accountAddress;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
