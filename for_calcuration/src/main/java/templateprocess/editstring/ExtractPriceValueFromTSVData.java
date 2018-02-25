package templateprocess.editstring;

import org.apache.commons.lang3.StringUtils;

public class ExtractPriceValueFromTSVData implements ManipulateString {

    private final int INDEX_OF_PRICE_PLACE = 4;
    
    private final String TAB = "\t";

    private final String REGEXP_NON_DIGIT = "[^0-9]";

    @Override
    public String extractString(String value) {
        String[] dividedValue = divideWithTab(value);
        return dividedValue[INDEX_OF_PRICE_PLACE];
    }

    @Override
    public String manipulateString(String value) {
        return replaceFromNonDiditToEmpty(value);
    }

    private String[] divideWithTab(String value) {
        return value.split(TAB);
    }

    private String replaceFromNonDiditToEmpty(String value) {
        return value.replaceAll(REGEXP_NON_DIGIT, StringUtils.EMPTY);
    }
}