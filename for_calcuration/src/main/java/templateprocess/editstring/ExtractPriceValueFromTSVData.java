package templateprocess.editstring;

public class ExtractPriceValueFromTSVData implements ManipulateString {

    private final int INDEX_OF_PRICE_PLACE = 4;
    
    private final String TAB = "\t";

    private final String OTHER_THAN_NUMBER = "[^0-9]";

    private final String EMPTY_STRING = "";
   
    @Override
    public String extractTargetString(String targetOriginalString) {
        String[] dividedTarget = divideWithTab(targetOriginalString);
        return dividedTarget[INDEX_OF_PRICE_PLACE];
    }

    @Override
    public String manipulaleTargetString(String extractedString) {
        return replaceToEmptyStringWithoutNumber(extractedString);
    }

    private String[] divideWithTab(String targetOriginalString) {
        return targetOriginalString.split(TAB);
    }

    private String replaceToEmptyStringWithoutNumber(String extractedString) {
        return extractedString.replaceAll(OTHER_THAN_NUMBER, EMPTY_STRING);
    }
}