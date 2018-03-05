package main.java.com.icloud.oswald.validation;

import main.java.com.icloud.oswald.validation.RowDataValidation;

public class PriceValidation implements RowDataValidation {

    public static final String CONTAINS_YEN_WITH_COMMA = ".*[0-9,]円.*";

    @Override
    public <T> boolean isPrice(T value) {

        if (value instanceof String) {
            return value.toString().matches(CONTAINS_YEN_WITH_COMMA);
        }

        return false;
    }
}