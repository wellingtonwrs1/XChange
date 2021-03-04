package info.bitrich.xchangestream.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.dto.marketdata.Candlestick;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class CandlestickBinanceWebsocketTransaction extends ProductBinanceWebSocketTransaction {

  private final BinanceRawCandlestick rawCandlestick;

  public CandlestickBinanceWebsocketTransaction(
          @JsonProperty("e") String eventType,
          @JsonProperty("E") String eventTime,
          @JsonProperty("s") String symbol,
          @JsonProperty("k") Map<String, String> node) {

    super(eventType, eventTime, symbol);

    rawCandlestick = new BinanceRawCandlestick(
            currencyPair,
            Arrays.stream(Candlestick.CandlestickInterval.values()).filter(i -> i.getCode().equals(node.get("i"))).findFirst().orElse(null),
            new Date(Long.parseLong(node.get("t"))),
            new BigDecimal(node.get("o")),
            new BigDecimal(node.get("h")),
            new BigDecimal(node.get("l")),
            new BigDecimal(node.get("c")),
            new BigDecimal(node.get("v")),
            new Date(Long.parseLong(node.get("T"))));
  }

  public BinanceRawCandlestick getRawCandlestick() {
    return rawCandlestick;
  }
}
