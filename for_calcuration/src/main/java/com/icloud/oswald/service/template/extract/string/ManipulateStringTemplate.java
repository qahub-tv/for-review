package main.java.com.icloud.oswald.service.template.extract.string;

import org.apache.commons.lang3.StringUtils;
import main.java.com.icloud.oswald.service.extract.ManipulateString;
import main.java.com.icloud.oswald.service.template.TemplateProcess;

public class ManipulateStringTemplate implements TemplateProcess {

    private final ManipulateString manipulateString;

    private final int INDEX_OF_PRICE_DATA = 0;

    public ManipulateStringTemplate(ManipulateString manipulateString) {
        this.manipulateString = manipulateString;
    }

    @Override
    public Object executeTemplate(Object... value) {

        if (value[INDEX_OF_PRICE_DATA] instanceof String) {
            String extractedString = manipulateString.extractString(value[INDEX_OF_PRICE_DATA].toString());
            return manipulateString.manipulateString(extractedString);
        }

        return StringUtils.EMPTY;
    }
}