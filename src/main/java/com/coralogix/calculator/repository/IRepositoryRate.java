package com.coralogix.calculator.repository;

import com.coralogix.calculator.model.ExchangeRate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryRate extends JpaRepository<ExchangeRate, String> {

}
