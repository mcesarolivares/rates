package com.coralogix.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ExchangeRate")
public class ExchangeRate {

    @Id
    @Column(name = "originCurrency")
    private String originCurrency;
    
    @Column(name = "finalCurrency")
    private String finalCurrency;
    
    @Column(name = "date")
    private String date;
    
    @Column(name = "value")
    private String value;
    
    public String getOriginCurrency() {
        return originCurrency;
    }
    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }
    public String getFinalCurrency() {
        return finalCurrency;
    }
    public void setFinalCurrency(String finalCurrency) {
        this.finalCurrency = finalCurrency;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
