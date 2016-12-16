package hayoc.setup;

import com.google.inject.AbstractModule;
import hayoc.old.knowledge.database.AbstractBeliefDatabase;
import hayoc.old.knowledge.database.AbstractContextDatabase;
import hayoc.old.knowledge.database.BeliefDatabase;
import hayoc.old.knowledge.database.ContextDatabase;

/**
 * Created by hayoc on 1/06/2016.
 */
public class WOBModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AbstractBeliefDatabase.class).to(BeliefDatabase.class);
        bind(AbstractContextDatabase.class).to(ContextDatabase.class);
    }
}
