package pl.com.marcinkrol.mycoinwallet.domain;

import java.math.BigDecimal;

public class StandardBalanceCalulator implements BalanceCalculator {

    public String calculateBalance(String weiBalance, String priceValue, int precision) {
        BigDecimal currentWeiBalance = new BigDecimal(weiBalance);
        BigDecimal currentPrice = new BigDecimal(priceValue);
        BigDecimal result = currentWeiBalance.multiply(currentPrice);
        return "" + result.setScale(precision, BigDecimal.ROUND_HALF_DOWN);
    }

}
