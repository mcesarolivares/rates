package com.coralogix.calculator.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.coralogix.calculator.CalculatorApplicationTests;
import com.coralogix.calculator.domain.GeneralException;
import com.coralogix.calculator.entity.SearchRateEntity;
import com.coralogix.calculator.model.ExchangeRate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchRateTest extends CalculatorApplicationTests {

    @Autowired
    private SearchRate saveRate;
    
    @Test
    public void rateExist() {
        SearchRateEntity entity = new SearchRateEntity("USD", "PEN");
        ExchangeRate rate = saveRate.ejecutar(entity);
        assertNotNull(rate);
    }
    
    @Test
    public void rateError() {
        SearchRateEntity entity = new SearchRateEntity("LLL", "PEN");
        Throwable exception = assertThrows(GeneralException.class, () -> saveRate.ejecutar(entity));
        assertEquals("Error al leer el servicio", exception.getMessage());
    }
    
}
