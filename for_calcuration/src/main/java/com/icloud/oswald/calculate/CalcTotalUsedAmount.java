package main.java.com.icloud.oswald.calculate;

import java.io.IOException;
import main.java.com.icloud.oswald.service.facade.MainProcessController;

public class CalcTotalUsedAmount {

    public static void main(String[] args) {
        // service start
        MainProcessController mainProcess = new MainProcessController();
        mainProcess.execute();
    }
}