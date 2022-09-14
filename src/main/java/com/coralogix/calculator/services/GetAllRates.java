package com.coralogix.calculator.services;

import com.coralogix.calculator.domain.EntityBase;
import com.coralogix.calculator.domain.Usecase;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.repository.IRepositoryRate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para listar todos los tipo de cambios.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>14-09-2022 - Creaci&oacute;n</li>
 *         </ul>
 */
@Service
public class GetAllRates extends Usecase<EntityBase, List<ExchangeRate>> {

    @Autowired
    private IRepositoryRate repositoryRate;

    @Override
    protected List<ExchangeRate> constructUseCase(EntityBase entity) {
        return repositoryRate.findAll();
    }
    
    
}
