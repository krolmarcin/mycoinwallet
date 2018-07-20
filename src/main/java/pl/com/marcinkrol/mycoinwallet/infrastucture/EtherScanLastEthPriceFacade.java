package pl.com.marcinkrol.mycoinwallet.infrastucture;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import pl.com.marcinkrol.mycoinwallet.domain.EthLastPriceFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

import static pl.com.marcinkrol.mycoinwallet.infrastucture.EtherscanEthBalanceFacade.apiKey;

public class EtherScanLastEthPriceFacade implements EthLastPriceFacade {

    public List<String> getLastEthPrice() {
        List<String> result = new LinkedList<String>();
        String balanceUrlRequest = "https://api.etherscan.io/api?module=stats&action=ethprice&apikey=" + apiKey;
        try {
            URL url = new URL(balanceUrlRequest);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONObject fullObject = (JSONObject) JSONValue.parseWithException(inputLine);
                JSONObject jsonInFullObject = (JSONObject) fullObject.get("result");
                String ethUsd = (String) jsonInFullObject.get("ethusd");
                result.add(ethUsd);
                String ethBtc = (String) jsonInFullObject.get("ethbtc");
                result.add(ethBtc);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
