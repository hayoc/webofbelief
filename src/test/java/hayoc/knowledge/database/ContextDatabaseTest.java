package hayoc.knowledge.database;

import hayoc.knowledge.Context;
import hayoc.knowledge.database.ContextDatabase;
import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by hayoc on 30/05/2016.
 */
public class ContextDatabaseTest {

    private ContextDatabase contextDatabase;

    public ContextDatabaseTest(ContextDatabase contextDatabase) {
       this.contextDatabase = contextDatabase;
    }

    public void test_storeAndRetrieve() {
        Context context = new Context();
        context.setId("CNJV");
        context.setRepresentation("Culinary");

        contextDatabase.store(context);
        Context storedContext = contextDatabase.query(context.getId());

        assertEquals(storedContext.getRepresentation(), context.getRepresentation());
    }

}
