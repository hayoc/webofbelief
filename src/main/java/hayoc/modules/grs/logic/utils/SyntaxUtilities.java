package hayoc.modules.grs.logic.utils;

import hayoc.modules.grs.Thought;
import hayoc.raisin.common.rules.AbstractRuleUtilities;

import java.util.List;

/**
 * Created by Hayo on 24/01/2017.
 */
public class SyntaxUtilities {

    public static String concatRaisinGoal(List<Thought> thoughts, Thought goal) {
        String end = parenthesizeConjunctions(thoughts) + wrap(AbstractRuleUtilities.CONDITIONAL) + goal.getProposition() + AbstractRuleUtilities.CLOSE_PARENTHESIS;
        return end;
    }

    private static String wrap(String string) {
        return " " + string + " ";
    }

    private static String wrap(char c) {
        return wrap(String.valueOf(c));
    }

    private static String parenthesizeConjunctions(List<Thought> thoughts) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < thoughts.size(); i++) {
            if (i == 0) {
                result.append(AbstractRuleUtilities.OPEN_PARENTHESIS + " ");
                result.append(thoughts.get(i));
            } else {
                result.append(wrap(AbstractRuleUtilities.CONJUNCTION));
                result.append(AbstractRuleUtilities.OPEN_PARENTHESIS);
                result.append(thoughts.get(i));
            }
        }

        for (int i = 0; i < thoughts.size() - 1; i++) {
            result.append(AbstractRuleUtilities.CLOSE_PARENTHESIS);
        }

        return result.toString();
    }
}
