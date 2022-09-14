package com.coralogix.calculator.services;

import com.coralogix.calculator.domain.GeneralException;
import com.coralogix.calculator.domain.Usecase;
import com.coralogix.calculator.dto.CurrencyDto;
import com.coralogix.calculator.entity.SearchRateEntity;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.repository.CurrencyClientRest;
import com.coralogix.calculator.repository.IRepositoryRate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para buscar tipo de cambio, si no existe consultar
 * a currency api para registrarlo.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>14-09-2022 - Creaci&oacute;n</li>
 *         </ul>
 */
@Service
public class SearchRate extends Usecase<SearchRateEntity, ExchangeRate> {

    @Autowired
    private IRepositoryRate repositoryRate;
    
    @Autowired
    private CurrencyClientRest clientRest;
    
    @Override
    protected ExchangeRate constructUseCase(SearchRateEntity entity) {
        Optional<ExchangeRate> find = repositoryRate.findById(entity.getOrigin());
        if (find.isPresent()) {
            return find.get();
        } else {
            try {
                CurrencyDto response = clientRest.get(entity.getOrigin(), entity.getDest());
                System.out.println(response);
                ExchangeRate rate = new ExchangeRate();
                if (response.isSuccess()) {  
                    response.getRates().forEach((x,y) -> {
                        rate.setOriginCurrency(entity.getOrigin());
                        rate.setFinalCurrency(x);
                        rate.setDate(response.getDate());
                        rate.setValue(y);
                        repositoryRate.save(rate);                    
                    });
                    return rate;
                } else {
                    throw new GeneralException("no existe");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new GeneralException("Error al leer el servicio");
            }
        }
    }
}
