package pl.com.marcinkrol.mycoinwallet.domain;

import java.math.BigDecimal;

public class StandardTokenConverter implements TokenConverter {

    public String weiToEthConvert(String value) throws ArithmeticException {
        BigDecimal number = new BigDecimal(value);
        BigDecimal factor = new BigDecimal("1000000000000000000");
        BigDecimal result = number.divide(factor);
        return "" + (result.setScale(4, BigDecimal.ROUND_HALF_DOWN));
    }

}
