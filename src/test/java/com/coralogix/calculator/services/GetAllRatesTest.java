package com.coralogix.calculator.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.coralogix.calculator.CalculatorApplicationTests;
import com.coralogix.calculator.domain.EntityBase;
import com.coralogix.calculator.model.ExchangeRate;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GetAllRatesTest extends CalculatorApplicationTests {

    @Autowired
    private GetAllRates getAllRates;
    
    @Test
    public void getAll() {
        List<ExchangeRate> rates= getAllRates.ejecutar(new EntityBase());
        assertTrue(rates.size() >= 0);
    }
}
