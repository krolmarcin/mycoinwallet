package pl.com.marcinkrol.mycoinwallet.application;

import java.time.LocalDateTime;

public class EthBalanceHistoryDto {

    String etcBalance;
    String ethBalance;
    String usdBalance;
    LocalDateTime date;

    public String getEtcBalance() {
        return etcBalance;
    }

    public void setEtcBalance(String etcBalance) {
        this.etcBalance = etcBalance;
    }

    public String getEthBalance() {
        return ethBalance;
    }

    public void setEthBalance(String ethBalance) {
        this.ethBalance = ethBalance;
    }

    public String getUsdBalance() {
        return usdBalance;
    }

    public void setUsdBalance(String usdBalance) {
        this.usdBalance = usdBalance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
