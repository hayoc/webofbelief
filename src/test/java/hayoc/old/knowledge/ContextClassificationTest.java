package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Belief;
import hayoc.old.knowledge.beanz.Context;
import hayoc.old.knowledge.database.AbstractBeliefDatabase;
import hayoc.old.knowledge.database.AbstractContextDatabase;
import hayoc.old.logic.Constants;
import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hayo on 24/07/2016.
 */
@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({TestModule.class})
public class ContextClassificationTest {

    @Inject
    private ContextClassification contextClassification;
    @Inject
    private AbstractBeliefDatabase beliefDatabase;
    @Inject
    private AbstractContextDatabase contextDatabase;

    @Test
    public void testContextClassification() {
        Belief bel = createBelief("raven", "bird");
        beliefDatabase.save(bel);
        Context context1 = contextClassification.classifyBelief(bel);
        assertEquals(context1.getId(), "bird");

        Belief bel2 = createBelief("bird", "animal");
        beliefDatabase.save(bel2);
        Context context2 = contextClassification.classifyBelief(bel2);
        assertEquals(context2.getId(), "animal");

        Belief queriedBelief1 = beliefDatabase.query(bel.getId());
        Belief queriedBelief2 = beliefDatabase.query(bel2.getId());

        assertEquals(queriedBelief1.getContexts().get(0), context2.getId());
        assertEquals(queriedBelief2.getContexts().get(0), context2.getId());
        assertTrue(queriedBelief1.getContexts().size() == 1);
        assertTrue(queriedBelief2.getContexts().size() == 1);
    }

    private Belief createBelief(String subject, String predicate) {
        Belief belief = new Belief();
        belief.setId(subject + Constants.IS + predicate);
        belief.setConnective(Constants.IS);
        belief.setSubject(subject);
        belief.setPredicate(predicate);
        return belief;
    }
}
