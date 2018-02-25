package templateprocess.editstring;

import templateprocess.TemplateProcess;

public class ManipulateStringTemplate implements TemplateProcess {

    private final ManipulateString manipulateString;

    private final int INDEX_OF_PRICE_DATA = 0;

    public ManipulateStringTemplate(ManipulateString manipulateString) {
        this.manipulateString = manipulateString;
    }

    @Override
    public Object executeTemplate(Object... targetOriginalString) {

        if (targetOriginalString[INDEX_OF_PRICE_DATA] instanceof String) {
            String targetString = manipulateString.extractTargetString(targetOriginalString[INDEX_OF_PRICE_DATA].toString());
            return manipulateString.manipulaleTargetString(targetString);
        }

        return "";
    }
}