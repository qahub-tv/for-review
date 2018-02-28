package main.java.com.icloud.oswald.service.facade;

import filedata.Iterator;
import filedata.FileRowDataAggregate;

import java.io.IOException;
import judge.JudgeContainsPrice;
import judge.JudgeTargetContains;
import templateprocess.TemplateProcess;
import templateprocess.editstring.ExtractPriceValueFromTSVData;
import templateprocess.editstring.ManipulateString;
import templateprocess.editstring.ManipulateStringTemplate;

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