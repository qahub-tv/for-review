package main.java.com.icloud.oswald.calculate;
import java.io.IOException;
import controller.MainProcessController;

public class CalcUsageAmount {

    public static void main(String[] args) {
        // service start
        try {
            MainProcessController mainProcess = new MainProcessController();
            mainProcess.execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ファイルが存在しません");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}