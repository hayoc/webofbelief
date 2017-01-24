package hayoc.modules.grs.tasks.goal;

import hayoc.modules.grs.Context;
import hayoc.modules.grs.ContextTestUtils;
import hayoc.modules.grs.Thought;
import hayoc.modules.grs.logic.utils.SyntaxUtilities;
import hayoc.modules.grs.tasks.result.Result;
import hayoc.raisin.predicate.classical.rules.PredicateClassicalRuleUtilities;
import hayoc.raisin.predicate.classical.search.PredicateClassicalTableauxSearch;
import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by Hayo on 24/01/2017.
 */
@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({TestModule.class})
public class ValidCheckGoalTest {

    @Inject
    private PredicateClassicalRuleUtilities ruleUtilities;
    @Inject
    private PredicateClassicalTableauxSearch tableauxSearch;

    private ValidCheckGoal goal;

    private Context context;

    @Before
    public void setup() {
        goal = new ValidCheckGoal(ruleUtilities, tableauxSearch);
        context = ContextTestUtils.givenContext();

    }

    @Test
    public void testSimpleValidCheck() {
        Thought goalThought = new Thought();
        goalThought.setProposition("D0");
        Thought thought = new Thought();
        thought.setProposition(SyntaxUtilities.concatRaisinGoal(context.createThoughtBase().getThoughts(), goalThought));

        goal.setThought(thought);
        Result result = goal.execute();
        System.out.println(result.isValid());
    }

}
