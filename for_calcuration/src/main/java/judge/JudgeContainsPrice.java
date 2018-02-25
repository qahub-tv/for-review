package judge;

import judge.JudgeTargetContains;

public class JudgeContainsPrice implements JudgeTargetContains {

    public static final String regexYenWithComma = ".*[0-9,]円.*";

    @Override
    public boolean judge(Object originalRowString) {

        if (originalRowString instanceof String) {
            return originalRowString.toString().matches(regexYenWithComma);
        }

        return false;
    }
}