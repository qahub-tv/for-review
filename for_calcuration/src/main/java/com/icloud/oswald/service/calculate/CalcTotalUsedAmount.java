package com.icloud.oswald.service.calculate;

import java.io.IOException;
import com.icloud.oswald.service.facade.Facade;
import com.icloud.oswald.service.facade.processes.MainProcess;

public class CalcTotalUsedAmount {

    public static void main(String[] args) {
        // service start
        Facade mainProcess = new MainProcess();
        mainProcess.execute(args[0]);
    }
}