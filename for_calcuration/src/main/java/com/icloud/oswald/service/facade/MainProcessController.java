package main.java.com.icloud.oswald.service.facade;

import main.java.com.icloud.oswald.model.iterator.Iterator;
import main.java.com.icloud.oswald.model.aggregator.rowdata.FileRowDataAggregate;

import java.io.IOException;
import main.java.com.icloud.oswald.validation.RowDataValidation;
import main.java.com.icloud.oswald.validation.PriceValidation;
import main.java.com.icloud.oswald.service.template.TemplateProcess;
import main.java.com.icloud.oswald.service.template.extract.string.ExtractStringTemplate;
import main.java.com.icloud.oswald.service.extract.ExtractString;
import main.java.com.icloud.oswald.service.extract.string.ExtractPrice;

public class MainProcessController {

    public void execute() {

        try {

            Iterator fileRowData = new FileRowDataAggregate("main/resources/static/for_calcuration_2018_03.txt").iterator();

            TemplateProcess templateProcess = new ExtractStringTemplate(new ExtractPrice());

            RowDataValidation validate = new PriceValidation();

            int totalPrice = 0;
            while (fileRowData.hasNext()) {
                String rowData = fileRowData.next().toString();
                if (!validate.isPrice(rowData)) {
                    continue;
                }

                totalPrice += Integer
                        .parseInt(templateProcess.execute(rowData).toString());
            }

            System.out.println(totalPrice);

        } catch(IOException e) {

            e.printStackTrace();
            System.err.println("ファイルが存在しません");

        } catch(Exception e) {
            
            e.printStackTrace();
        }
    }
}