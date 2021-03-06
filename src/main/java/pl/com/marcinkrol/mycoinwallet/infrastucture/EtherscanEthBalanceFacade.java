package pl.com.marcinkrol.mycoinwallet.infrastucture;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import pl.com.marcinkrol.mycoinwallet.domain.EthBalanceFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EtherscanEthBalanceFacade implements EthBalanceFacade {

    public static final String apiKey = "ATE1PZHA2KYKRP36TRBE1EI297YVR2PI49";

    public String getEthBalance(String walletId) {
        String result = "";
        String balanceUrlRequest = "https://api.etherscan.io/api?module=account&action=balance&address="
                + walletId + "&tag=latest&apikey=" + apiKey;
        try {
            URL url = new URL(balanceUrlRequest);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(inputLine);
                result = (String) jsonObject.get("result");
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
