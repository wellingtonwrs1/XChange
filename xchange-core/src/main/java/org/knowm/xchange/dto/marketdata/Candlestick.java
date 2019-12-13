package org.knowm.xchange.dto.marketdata;

import static java.util.concurrent.TimeUnit.*;
import static java.util.concurrent.TimeUnit.DAYS;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.Assert;

public final class Candlestick implements Serializable {

  private final CurrencyPair currencyPair;
  private final CandlestickInterval interval;
  private final Date openTime;
  private final BigDecimal open;
  private final BigDecimal high;
  private final BigDecimal low;
  private final BigDecimal close;
  private final BigDecimal volume;
  private final Date closeTime;

  private Candlestick(
      CurrencyPair currencyPair,
      CandlestickInterval interval,
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

  public CandlestickInterval getInterval() {
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

  @Override
  public String toString() {
    return "Candlestick{"
        + "currencyPair="
        + currencyPair
        + ", interval="
        + interval
        + ", openTime="
        + openTime
        + ", open="
        + open
        + ", high="
        + high
        + ", low="
        + low
        + ", close="
        + close
        + ", volume="
        + volume
        + ", closeTime="
        + closeTime
        + '}';
  }

  public enum CandlestickInterval {
    MINUTE("1m", MINUTES.toMillis(1)),
    THREE_MINUTES("3m", MINUTES.toMillis(3)),
    FIVE_MINUTES("5m", MINUTES.toMillis(5)),
    FIFTEEN_MINUTES("15m", MINUTES.toMillis(15)),
    THIRTY_MINUTES("30m", MINUTES.toMillis(30)),

    HOURLY("1h", HOURS.toMillis(1)),
    TWO_HOURLY("2h", HOURS.toMillis(2)),
    FOUR_HOURLY("4h", HOURS.toMillis(4)),
    SIX_HOURLY("6h", HOURS.toMillis(6)),
    EIGHT_HOURLY("8h", HOURS.toMillis(8)),
    TWELVE_HOURLY("12h", HOURS.toMillis(12)),

    DAILY("1d", DAYS.toMillis(1)),
    THREE_DAILY("3d", DAYS.toMillis(3)),
    WEEKLY("1w", DAYS.toMillis(7)),
    MONTHLY("1M", DAYS.toMillis(30));

    private final String code;
    private final Long millis;

    CandlestickInterval(String code, Long millis) {
      this.code = code;
      this.millis = millis;
    }

    public String getCode() {
      return code;
    }

    public Long getMillis() {
      return millis;
    }
  }

  /**
   * Builder to provide the following to {@link Candlestick}:
   *
   * <ul>
   *   <li>Provision of fluent chained construction interface
   * </ul>
   */
  public static class Builder {

    private CurrencyPair currencyPair;
    private CandlestickInterval interval;
    private Date openTime;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private Date closeTime;

    // Prevent repeat builds
    private boolean isBuilt = false;

    public Candlestick build() {
      validateState();
      Candlestick ticker =
          new Candlestick(
              currencyPair, interval, openTime, open, high, low, close, volume, closeTime);
      isBuilt = true;
      return ticker;
    }

    private void validateState() {
      if (isBuilt) {
        throw new IllegalStateException("The entity has been built");
      }
    }

    public Builder currencyPair(CurrencyPair currencyPair) {
      Assert.notNull(currencyPair, "Null currencyPair");
      this.currencyPair = currencyPair;
      return this;
    }

    public Builder interval(CandlestickInterval interval) {
      Assert.notNull(interval, "Null interval");
      this.interval = interval;
      return this;
    }

    public Builder openTime(Date openTime) {
      this.openTime = openTime;
      return this;
    }

    public Builder open(BigDecimal open) {
      this.open = open;
      return this;
    }

    public Builder high(BigDecimal high) {
      this.high = high;
      return this;
    }

    public Builder low(BigDecimal low) {
      this.low = low;
      return this;
    }

    public Builder close(BigDecimal close) {
      this.close = close;
      return this;
    }

    public Builder volume(BigDecimal volume) {
      this.volume = volume;
      return this;
    }

    public Builder closeTime(Date closeTime) {
      this.closeTime = closeTime;
      return this;
    }
  }
}
