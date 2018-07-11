package pl.com.marcinkrol.mycoinwallet.application.implementation;

import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.domain.*;

public class StandardEthBalanceProcess implements EthBalanceProcess {

    private AccountAddressRepository accountAddressRepository;
    private EthBalanceRepository ethBalanceRepository;
    private EthBalanceFacade ethBalanceFacade;
    private TokenConverter tokenConverter;

    public StandardEthBalanceProcess(AccountAddressRepository accountAddressRepository,
                                     EthBalanceRepository ethBalanceRepository,
                                     EthBalanceFacade ethBalanceFacade,
                                     TokenConverter tokenConverter) {
        this.accountAddressRepository = accountAddressRepository;
        this.ethBalanceRepository = ethBalanceRepository;
        this.ethBalanceFacade = ethBalanceFacade;
        this.tokenConverter = tokenConverter;
    }

    public EthBalanceDto getBalance(String walletId) {
        String balance = ethBalanceFacade.getEthBalance(walletId);
        //System.out.println(balance);
        //AccountAddress accountAddress = new AccountAddress(walletId);
        //if (!accountAddressRepository.exists(walletId)) {
        //    accountAddressRepository.put(accountAddress);
        //}
        String convertedBalance = tokenConverter.weiToEthConvert(balance);

        EthBalanceDto ethBalanceDto = new EthBalanceDto();
        ethBalanceDto.setEthBalance(convertedBalance);
        ethBalanceDto.setBtcBalance("0");
        ethBalanceDto.setUsdBalance("0");
        return ethBalanceDto;
    }

}
