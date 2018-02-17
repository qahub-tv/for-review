package templateprocess.editstring;

public class ExtractPriceValueFromTSVData implements ManipulateString{

    private final int indexOfPricePlace = 4;

    @Override
    public String extractTargetString(String targetOriginalString){
        String[] dividedTarget = divideWithTab(targetOriginalString);
        return dividedTarget[indexOfPricePlace];
    }

    @Override
    public String manipulaleTargetString(String extractedString){
        return replaceToEmptyStringWithoutNumber(extractedString);
    }

    private String[] divideWithTab(String targetOriginalString){
        return targetOriginalString.split("\t");
    }
    
    private String replaceToEmptyStringWithoutNumber(String extractedString){
        return extractedString.replaceAll("[^0-9]", "");
    }
}