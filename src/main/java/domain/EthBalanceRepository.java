package domain;

import application.EthDto;
import java.util.List;

public interface EthBalanceRepository {

    List<EthDto> getBalance(String walletId);

}
