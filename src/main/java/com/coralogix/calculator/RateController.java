package com.coralogix.calculator;

import com.coralogix.calculator.domain.EntityBase;
import com.coralogix.calculator.entity.SearchRateEntity;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.services.SearchRate;
import com.coralogix.calculator.services.GetAllRates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rates")
public class RateController {

    @Autowired
    private GetAllRates getAllRates;
    
    @Autowired
    private SearchRate saveRate;
    
    /**
     * Obtener todas los tipo de cambios.
     * @return lista completa
     */
    @GetMapping
    public ResponseEntity<List<String>> getAllExchangeRate() {
        return new ResponseEntity<>(
                getAllRates.ejecutar(new EntityBase()).stream()
                .map(ExchangeRate::getOriginCurrency)
                .collect(Collectors.toList()), HttpStatus.OK);
    }
    
    /**
     * Buscar tipo de cambio.
     * @param origin origen
     * @param end destino
     * @return tipo de cambio encontrado
     */
    @GetMapping("/{origin}")
    public ResponseEntity<ExchangeRate> getExchangeRate(
            @PathVariable(value = "origin") String origin,
            @RequestParam(value = "final") String end) {
        
        SearchRateEntity entity = new SearchRateEntity(origin, end);
        return new ResponseEntity<ExchangeRate>(saveRate.ejecutar(entity), HttpStatus.OK);
    }
}
