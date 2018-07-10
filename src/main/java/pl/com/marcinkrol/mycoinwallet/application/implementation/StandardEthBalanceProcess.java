package pl.com.marcinkrol.mycoinwallet.application.implementation;

import pl.com.marcinkrol.mycoinwallet.application.EthBalanceProcess;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceDto;
import pl.com.marcinkrol.mycoinwallet.domain.AccountAddress;
import pl.com.marcinkrol.mycoinwallet.domain.AccountAddressRepository;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceFacade;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceRepository;

public class StandardEthBalanceProcess implements EthBalanceProcess {

    private AccountAddressRepository accountAddressRepository;
    private EthBalanceRepository ethBalanceRepository;
    private EthBalanceFacade ethBalanceFacade;

    public StandardEthBalanceProcess(AccountAddressRepository accountAddressRepository,
                                     EthBalanceRepository ethBalanceRepository,
                                     EthBalanceFacade ethBalanceFacade) {
        this.accountAddressRepository = accountAddressRepository;
        this.ethBalanceRepository = ethBalanceRepository;
        this.ethBalanceFacade = ethBalanceFacade;
    }

    public EthBalanceDto getBalance(String walletId) {
        String balance = ethBalanceFacade.getEthBalance(walletId);
        //System.out.println(balance);
        //AccountAddress accountAddress = new AccountAddress(walletId);
        //if (!accountAddressRepository.exists(walletId)) {
        //    accountAddressRepository.put(accountAddress);
        //}
        EthBalanceDto ethBalanceDto = new EthBalanceDto();
        ethBalanceDto.setEthBalance(balance);
        ethBalanceDto.setBtcBalance("0");
        ethBalanceDto.setUsdBalance("0");
        return ethBalanceDto;
    }

}
