package com.coralogix.calculator.domain;


public abstract class Usecase<E extends EntityBase, T> {

    /**
     * Ejecuci&oacute;n de caso de uso.
     * @param entity objeto de negocio
     * @return objeto de respuesta del caso de uso
     */
    public T ejecutar(E entity) {
        if (entity == null) {
            throw new GeneralException("Debe agregar un objeto de negocio");
        }
        return constructUseCase(entity);
    }

    /**
     * Inicializador de casos de uso.
     * @param entity objeto de negocio
     * @return objeto de respuesta del caso de uso
     */
    protected abstract T constructUseCase(E entity);
}
