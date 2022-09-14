package com.coralogix.calculator.entity;

import com.coralogix.calculator.domain.EntityBase;

public class SearchRateEntity extends EntityBase {

    private final String origin;
    private final String dest;
    
    public SearchRateEntity(String origin, String dest) {
        this.dest = dest;
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDest() {
        return dest;
    }
    
    
}
