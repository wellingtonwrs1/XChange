package org.knowm.xchange.service.marketdata.params;

import org.knowm.xchange.dto.marketdata.Candlestick;

import java.util.Date;

public interface CandlestickParams extends Params {

    Candlestick.CandlestickInterval getInterval();

    Integer getLimit();

    Date getStart();

    Date getEnd();

}
