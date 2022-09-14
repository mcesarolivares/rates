package com.coralogix.calculator.domain;

public class GeneralException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String mensaje;
    
    public GeneralException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        return this.mensaje;
    }
}
