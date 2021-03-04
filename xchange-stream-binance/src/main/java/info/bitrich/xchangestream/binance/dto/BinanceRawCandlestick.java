package info.bitrich.xchangestream.binance.dto;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Candlestick;

import java.math.BigDecimal;
import java.util.Date;

public class BinanceRawCandlestick {

  private final CurrencyPair currencyPair;
  private final Candlestick.CandlestickInterval interval;
  private final Date openTime;
  private final BigDecimal open;
  private final BigDecimal high;
  private final BigDecimal low;
  private final BigDecimal close;
  private final BigDecimal volume;
  private final Date closeTime;

  public BinanceRawCandlestick(
          CurrencyPair currencyPair,
          Candlestick.CandlestickInterval interval,
          Date openTime,
          BigDecimal open,
          BigDecimal high,
          BigDecimal low,
          BigDecimal close,
          BigDecimal volume,
          Date closeTime) {
    this.currencyPair = currencyPair;
    this.interval = interval;
    this.openTime = openTime;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
    this.closeTime = closeTime;
  }

  public CurrencyPair getCurrencyPair() {
    return currencyPair;
  }

  public Candlestick.CandlestickInterval getInterval() {
    return interval;
  }

  public Date getOpenTime() {
    return openTime;
  }

  public BigDecimal getOpen() {
    return open;
  }

  public BigDecimal getHigh() {
    return high;
  }

  public BigDecimal getLow() {
    return low;
  }

  public BigDecimal getClose() {
    return close;
  }

  public BigDecimal getVolume() {
    return volume;
  }

  public Date getCloseTime() {
    return closeTime;
  }
}
