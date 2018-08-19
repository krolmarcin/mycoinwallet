package pl.com.marcinkrol.mycoinwallet.infrastucture;

import pl.com.marcinkrol.mycoinwallet.application.EthHistoryCatalog;
import pl.com.marcinkrol.mycoinwallet.application.EthBalanceHistoryDto;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalance;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class JPAEthHistoryCatalogRepository implements EthHistoryCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EthBalanceHistoryDto> getHistory(String walletId, LocalDateTime from, LocalDateTime to) {

        String queryGetHistoryFromDateToDate = "SELECT e FROM EthBalance e " +
                "LEFT JOIN FETCH e.accountAddress i " +
                "WHERE i.walletId = :walletId " +
                "AND e.date BETWEEN :from AND :to";

        Query query = entityManager.createQuery(queryGetHistoryFromDateToDate);
        query.setParameter("walletId", walletId);
        query.setParameter("from", from);
        query.setParameter("to", to);

        List<EthBalanceHistoryDto> ethBalanceHistoryDtos = new LinkedList<>();

        List<EthBalance> ethBalances = query.getResultList();


        for (EthBalance ethBalance : ethBalances) {
            ethBalanceHistoryDtos.add(createEthBalancesDto(ethBalance));
        }

        return ethBalanceHistoryDtos;
    }

    private EthBalanceHistoryDto createEthBalancesDto(EthBalance ethBalance) {
        EthBalanceHistoryDto ethBalanceHistoryDto = new EthBalanceHistoryDto();
        ethBalanceHistoryDto.setBtcBalance(ethBalance.getBtcBalance());
        ethBalanceHistoryDto.setUsdBalance(ethBalance.getUsdBalance());
        ethBalanceHistoryDto.setEthBalance(ethBalance.getEthBalance());
        ethBalanceHistoryDto.setDate(ethBalance.getDate());
        return ethBalanceHistoryDto;
    }

}