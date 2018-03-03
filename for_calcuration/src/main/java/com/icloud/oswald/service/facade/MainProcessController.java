package main.java.com.icloud.oswald.service.facade;

import main.java.com.icloud.oswald.model.iterator.Iterator;
import main.java.com.icloud.oswald.model.aggregator.rowdata.FileRowDataAggregate;

import java.io.IOException;
import main.java.com.icloud.oswald.validation.JudgeContainsPrice;
import main.java.com.icloud.oswald.validation.JudgeTargetContains;
import main.java.com.icloud.oswald.service.template.TemplateProcess;
import main.java.com.icloud.oswald.service.template.extract.string.ManipulateStringTemplate;
import main.java.com.icloud.oswald.service.extract.ManipulateString;
import main.java.com.icloud.oswald.service.extract.string.ExtractPriceValueFromTSVData;

public class MainProcessController {

    public void execute() throws IOException {

        Iterator fileRowData = new FileRowDataAggregate("../resources/static/for_calcuration_2018_03.txt").iterator();

        TemplateProcess templateProcess = new ManipulateStringTemplate(new ExtractPriceValueFromTSVData());

        JudgeTargetContains containsYenWithComma = new JudgeContainsPrice();

        int totalPrice = 0;
        while (fileRowData.hasNext()) {
            if (!containsYenWithComma.hasSpecificWord(fileRowData.next())) {
                continue;
            }

            totalPrice += Integer
                    .parseInt(templateProcess.executeTemplate(fileRowData.current().toString()).toString());
        }

        System.out.println(totalPrice);
    }
}