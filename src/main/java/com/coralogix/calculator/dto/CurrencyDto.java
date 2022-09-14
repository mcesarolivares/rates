package com.coralogix.calculator.dto;

import java.util.Date;
import java.util.Map;

public class CurrencyDto {

    private boolean success;
    private Date timestamp;
    private String base;
    private String date;
    private Map<String, String> rates;
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Map<String, String> getRates() {
        return rates;
    }
    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }
    
    @Override
    public String toString() {
        return "CurrencyDto [success=" + success + ", timestamp=" + timestamp + ", base=" + base + ", date=" + date
                + ", rates=" + rates + "]";
    }
    
}


