package pl.com.marcinkrol.mycoinwallet.application.implementation;

import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.domain.*;

import java.util.List;

public class StandardEthBalanceProcess implements EthBalanceProcess {

    private AccountAddressRepository accountAddressRepository;
    private EthBalanceRepository ethBalanceRepository;
    private EthBalanceFacade ethBalanceFacade;
    private EthLastPriceFacade ethLastPriceFacade;
    private TokenConverter tokenConverter;
    private BalanceCalculator balanceCalculator;

    public StandardEthBalanceProcess(AccountAddressRepository accountAddressRepository,
                                     EthBalanceRepository ethBalanceRepository,
                                     EthBalanceFacade ethBalanceFacade,
                                     TokenConverter tokenConverter,
                                     EthLastPriceFacade ethLastPriceFacade,
                                     BalanceCalculator balanceCalculator) {
        this.accountAddressRepository = accountAddressRepository;
        this.ethBalanceRepository = ethBalanceRepository;
        this.ethBalanceFacade = ethBalanceFacade;
        this.tokenConverter = tokenConverter;
        this.ethLastPriceFacade = ethLastPriceFacade;
        this.balanceCalculator = balanceCalculator;
    }

    public EthBalanceDto getBalance(String walletId) {
        String weiBalance = ethBalanceFacade.getEthBalance(walletId);
        putAccountAddressToRepo(walletId);
        String convertedEthBalance = tokenConverter.weiToEthConvert(weiBalance);

        List<String> ethLastPriceList = ethLastPriceFacade.getLastEthPrice();
        String usdPrice = ethLastPriceList.get(0);
        String btcPrice = ethLastPriceList.get(1);

        String usdBalance = balanceCalculator.calculateBalance(convertedEthBalance, usdPrice, 2);
        String btcBalance = balanceCalculator.calculateBalance(convertedEthBalance, btcPrice, 6);

        return getEthBalanceDto(convertedEthBalance, usdBalance, btcBalance);
    }

    private void putAccountAddressToRepo(String walletId) {
        AccountAddress accountAddress = new AccountAddress(walletId);
        if (!accountAddressRepository.exists(walletId)) {
            accountAddressRepository.put(accountAddress);
        }
    }

    private EthBalanceDto getEthBalanceDto(String convertedEthBalance, String usdBalance, String btcBalance) {
        EthBalanceDto ethBalanceDto = new EthBalanceDto();
        ethBalanceDto.setEthBalance(convertedEthBalance);
        ethBalanceDto.setBtcBalance(btcBalance);
        ethBalanceDto.setUsdBalance(usdBalance);
        return ethBalanceDto;
    }

}
