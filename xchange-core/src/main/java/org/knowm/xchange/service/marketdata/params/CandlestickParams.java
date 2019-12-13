package org.knowm.xchange.service.marketdata.params;

import java.util.Date;
import org.knowm.xchange.dto.marketdata.Candlestick;

public interface CandlestickParams extends Params {

  Candlestick.CandlestickInterval getInterval();

  Integer getLimit();

  Date getStart();

  Date getEnd();
}
