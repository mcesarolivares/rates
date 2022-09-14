package com.coralogix.calculator.repository;

import com.coralogix.calculator.dto.CurrencyDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency", url = "http://192.168.1.71:8080/fixer")
public interface CurrencyClientRest {

    @GetMapping("/latest")
    public CurrencyDto get(@RequestParam String base,@RequestParam String symbols);
}
