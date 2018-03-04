package main.java.com.icloud.oswald.service.extract.string;

import main.java.com.icloud.oswald.service.extract.ExtractString;
import org.apache.commons.lang3.StringUtils;

public class ExtractPrice implements ExtractString {

    private final int INDEX_OF_PRICE = 4;
    
    private final String TAB = "\t";

    private final String REGEXP_NON_DIGIT = "[^0-9]";

    @Override
    public String extract(String value) {
        String[] dividedValue = value.split(TAB);
        return dividedValue[INDEX_OF_PRICE];
    }

    @Override
    public String manipulateString(String value) {
        return replaceFromNonDiditToEmpty(value);
    }

    private String replaceFromNonDiditToEmpty(String value) {
        return value.replaceAll(REGEXP_NON_DIGIT, StringUtils.EMPTY);
    }
}