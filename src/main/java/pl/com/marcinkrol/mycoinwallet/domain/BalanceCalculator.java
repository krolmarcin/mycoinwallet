package pl.com.marcinkrol.mycoinwallet.domain;

public interface BalanceCalculator {

    String calculateBalance(String weiBalance, String priceValue, int precision);

}
