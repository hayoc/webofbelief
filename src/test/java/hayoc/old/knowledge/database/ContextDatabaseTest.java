package hayoc.old.knowledge.database;

import hayoc.old.knowledge.beanz.Context;

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
        context.setId("Culinary");

        contextDatabase.save(context);
        Context storedContext = contextDatabase.query(context.getId());

        assertEquals(storedContext.getId(), context.getId());
    }

}
