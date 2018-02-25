import java.io.IOException;

import controller.MainProcessController;

public class CalcUsageAmount {

    public static void main(String[] args) {
        // service start
        try {
            MainProcessController mainProcess = new MainProcessController();
            mainProcess.start();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ファイルが存在しません");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}