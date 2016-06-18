package hayoc.knowledge.database;

import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by hayoc on 1/06/2016.
 */
@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({TestModule.class})
public class DatabaseTests {

    @Inject
    private ContextDatabase contextDatabase;


    @Test
    public void allDBTests() {
        //SETUP
        ContextDatabaseTest contextDatabaseTest = new ContextDatabaseTest(contextDatabase);

        //TESTS
        contextDatabaseTest.test_storeAndRetrieve();

        //TEARDOWN
        contextDatabase.close();
    }
}
