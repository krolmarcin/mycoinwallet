package pl.com.marcinkrol.mycoinwallet.application.implementation;

import org.springframework.transaction.annotation.Transactional;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.domain.*;

import java.util.List;

@Transactional
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

    @Override
    public EthBalanceDto getBalance(String walletId) {
        String weiBalance = ethBalanceFacade.getEthBalance(walletId);

        putAccAddressIfDoesNotExist(walletId);

        AccountAddress accountAddress = accountAddressRepository.get(walletId);

        String ethBalance = tokenConverter.weiToEthConvert(weiBalance);

        List<String> ethLastPriceList = ethLastPriceFacade.getLastEthPrice();
        String usdPrice = ethLastPriceList.get(0);
        String btcPrice = ethLastPriceList.get(1);

        String usdBalance = balanceCalculator.calculateBalance(ethBalance, usdPrice, "usd");
        String btcBalance = balanceCalculator.calculateBalance(ethBalance, btcPrice, "btc");

        EthBalance balance = new EthBalance(ethBalance, usdBalance, btcBalance, accountAddress);
        ethBalanceRepository.put(balance);

        return getEthBalanceDto(ethBalance, usdBalance, btcBalance);


    }

    private void putAccAddressIfDoesNotExist(String walletId) {
        if (!accountAddressRepository.exists(walletId)) {
            AccountAddress accountAddress = new AccountAddress(walletId);
            putAccountAddressToRepo(accountAddress);
        }
    }

    private void putAccountAddressToRepo(AccountAddress accountAddress) {
        accountAddressRepository.put(accountAddress);
    }

    private EthBalanceDto getEthBalanceDto(String convertedEthBalance, String usdBalance, String btcBalance) {
        EthBalanceDto ethBalanceDto = new EthBalanceDto();
        ethBalanceDto.setEthBalance(convertedEthBalance);
        ethBalanceDto.setBtcBalance(btcBalance);
        ethBalanceDto.setUsdBalance(usdBalance);
        return ethBalanceDto;
    }

}
