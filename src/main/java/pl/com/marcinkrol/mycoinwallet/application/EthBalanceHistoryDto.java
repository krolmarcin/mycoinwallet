package pl.com.marcinkrol.mycoinwallet.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class EthBalanceHistoryDto {

    private String btcBalance;
    private String ethBalance;
    private String usdBalance;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    public String getBtcBalance() {
        return btcBalance;
    }

    public void setBtcBalance(String btcBalance) {
        this.btcBalance = btcBalance;
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
