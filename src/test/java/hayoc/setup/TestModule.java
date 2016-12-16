package hayoc.setup;

import com.google.inject.AbstractModule;
import hayoc.old.knowledge.MockBeliefDatabase;
import hayoc.old.knowledge.MockContextDatabase;
import hayoc.old.knowledge.database.AbstractBeliefDatabase;
import hayoc.old.knowledge.database.AbstractContextDatabase;

/**
 * Created by hayoc on 1/06/2016.
 */
public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AbstractBeliefDatabase.class).to(MockBeliefDatabase.class);
        bind(AbstractContextDatabase.class).to(MockContextDatabase.class);
    }
}
