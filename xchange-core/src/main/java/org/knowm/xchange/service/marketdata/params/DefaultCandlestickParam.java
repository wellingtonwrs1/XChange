package org.knowm.xchange.service.marketdata.params;

import java.util.Date;
import org.knowm.xchange.dto.marketdata.Candlestick;

public class DefaultCandlestickParam implements CandlestickParams {

  private Candlestick.CandlestickInterval interval;
  private Integer limit;
  private Date start;
  private Date end;

  public DefaultCandlestickParam(
      Candlestick.CandlestickInterval interval, Integer limit, Date start, Date end) {
    this.interval = interval;
    this.limit = limit;
    this.start = start;
    this.end = end;
  }

  @Override
  public Candlestick.CandlestickInterval getInterval() {
    return interval;
  }

  @Override
  public Integer getLimit() {
    return limit;
  }

  @Override
  public Date getStart() {
    return start;
  }

  @Override
  public Date getEnd() {
    return end;
  }
}
