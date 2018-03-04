package main.java.com.icloud.oswald.model.singleton.path;

public class FilePath implements Singleton {

    private static final FilePath = new FilePath();

    private final String filepath;

    private FilePath() {
        this.filepath = "";
    }

    public static FilePath getInstance() {
        return this;
    }
}