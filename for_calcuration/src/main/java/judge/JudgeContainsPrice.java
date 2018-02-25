package judge;

import judge.JudgeTargetContains;

public class JudgeContainsPrice implements JudgeTargetContains {

    public static final String CONTAINS_YEN_WITH_COMMA = ".*[0-9,]円.*";

    @Override
    public boolean hasSpecificWord(Object value) {

        if (value instanceof String) {
            return value.toString().matches(CONTAINS_YEN_WITH_COMMA);
        }

        return false;
    }
}