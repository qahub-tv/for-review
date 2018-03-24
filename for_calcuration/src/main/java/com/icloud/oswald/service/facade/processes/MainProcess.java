package com.icloud.oswald.service.facade.processes;

import java.util.Iterator;
import com.icloud.oswald.model.aggregator.rowdata.FileRowDataAggregate;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import com.icloud.oswald.service.facade.Facade;
import com.icloud.oswald.service.validation.RowDataValidation;
import com.icloud.oswald.service.validation.PriceValidation;

public class MainProcess implements Facade{

    private final String REGEXP_NON_DIGIT = "[^0-9]";

    @Override
    public void execute(String value) {
        try {
            Iterator fileRowData = new FileRowDataAggregate().iterator(value);
            RowDataValidation validate = new PriceValidation();
            int totalPrice = 0;
            while (fileRowData.hasNext()) {
                String rowData = fileRowData.next().toString();
                if (!validate.isPrice(rowData)) {
                    continue;
                }
                totalPrice += Integer.parseInt(extract(rowData));
            }
            System.out.println(totalPrice);
        } catch(IOException e) {
            System.err.println("File not exist.");
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private String extract(String rowData) {
        String[] values = rowData.split("\t");
        String value = values[4].replaceAll(REGEXP_NON_DIGIT, StringUtils.EMPTY);
        return value;
    }
}