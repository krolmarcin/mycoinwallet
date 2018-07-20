package pl.com.marcinkrol.mycoinwallet.domain;

import java.math.BigDecimal;

public class StandardBalanceCalculator implements BalanceCalculator {

    private static final int USD_PRECISION = 2;
    private static final int BTC_PRECISION = 6;

    public String calculateBalance(String weiBalance, String priceValue, String currency) {
        BigDecimal currentWeiBalance = new BigDecimal(weiBalance);
        BigDecimal currentPrice = new BigDecimal(priceValue);
        BigDecimal result = currentWeiBalance.multiply(currentPrice);
        int precision = 2;
        if (currency.equalsIgnoreCase("usd")) {
            precision = USD_PRECISION;
        } else if (currency.equalsIgnoreCase("btc")) {
            precision = BTC_PRECISION;
        }
        return "" + result.setScale(precision, BigDecimal.ROUND_HALF_DOWN);
    }

}
