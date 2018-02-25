package judge;

import judge.JudgeTargetContains;

public class JudgeContainsPrice implements JudgeTargetContains {

    public static final String CONTAINS_YEN_WITH_COMMA = ".*[0-9,]円.*";

    @Override
    public boolean judgeContainsSpecificWord(Object originalRowString) {

        if (originalRowString instanceof String) {
            return originalRowString.toString().matches(CONTAINS_YEN_WITH_COMMA);
        }

        return false;
    }
}