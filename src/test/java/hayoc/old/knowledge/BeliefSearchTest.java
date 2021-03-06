package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Belief;
import hayoc.old.knowledge.beanz.Context;
import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hayoc on 5/06/2016.
 */
@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({TestModule.class})
public class BeliefSearchTest {

    @Inject
    private BeliefSearch beliefSearch;

    @Test
    public void testBeliefSearch() {
        Context context = new Context();
        context.setBeliefs(Arrays.asList("belief1"));

        List<Belief> beliefs = beliefSearch.getBeliefs(context, 0.4f);
        assertEquals(beliefs.size(), 4);
    }
}
