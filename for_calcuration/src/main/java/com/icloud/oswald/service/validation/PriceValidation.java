package com.icloud.oswald.service.validation;

public class PriceValidation {

    public static final String CONTAINS_YEN_WITH_COMMA = ".*[0-9,]円.*";

    public boolean hasPrice(String value) {

        return value.toString().matches(CONTAINS_YEN_WITH_COMMA);
        
    }
}