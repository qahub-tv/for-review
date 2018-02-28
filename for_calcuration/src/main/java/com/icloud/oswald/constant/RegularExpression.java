package main.java.com.icloud.oswald.constant;

public class RegularExpression {
    private RegularExpression() {
    }

    public static final String CONTAINS_YEN_WITH_COMMA = ".*[0-9,]円.*";

    public static final String TAB = "\t";

    public static final String OTHER_THAN_NUMBER = "[^0-9]";

    public static final String EMPTY = "";
}