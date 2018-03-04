package main.java.com.icloud.oswald.service.template.extract.string;

import org.apache.commons.lang3.StringUtils;
import main.java.com.icloud.oswald.service.extract.ExtractString;
import main.java.com.icloud.oswald.service.template.TemplateProcess;

public class ExtractStringTemplate implements TemplateProcess {

    private final ExtractString manipulateString;

    private final int INDEX_OF_PRICE_DATA = 0;

    public ExtractStringTemplate(ExtractString manipulateString) {
        this.manipulateString = manipulateString;
    }

    @Override
    public Object execute(Object... value) {

        if (value[INDEX_OF_PRICE_DATA] instanceof String) {
            String extractedString = manipulateString.extract(value[INDEX_OF_PRICE_DATA].toString());
            return manipulateString.manipulateString(extractedString);
        }

        return StringUtils.EMPTY;
    }
}