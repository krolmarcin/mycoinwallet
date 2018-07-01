package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EthBalance {

    @Id
    @GeneratedValue
    private Long id;
    private String ethBalance;
    private String usdBalance;
    private String btcBalance;

    EthBalance() {
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
