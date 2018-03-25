package com.icloud.oswald.service.facade.processes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.icloud.oswald.model.rowdata.Rowdata;
import com.icloud.oswald.model.rowdata.text.Text;
import com.icloud.oswald.service.facade.Facade;
import com.icloud.oswald.service.validation.PriceValidation;

public class MainProcess implements Facade{

    private final String REGEXP_NON_DIGIT = "[^0-9]";

    @Override
    public void execute(String value) {
        try {
            PriceValidation validate = new PriceValidation();
            List<String> rows = read(value);
            int totalPrice = 0;
            for (String row : rows) {
                if (!validate.hasPrice(row)) {
                    continue;
                }
                String data = extract(row);
                totalPrice += Integer.parseInt(data);
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

    private List<String> read(String value) throws Exception {
        Path path = Paths.get(value);
        Rowdata rowdata = new Text();
        return rowdata.getValues(path);
    }

}