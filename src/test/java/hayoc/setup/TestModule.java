package hayoc.setup;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import hayoc.knowledge.MockBeliefDatabase;
import hayoc.knowledge.database.AbstractDatabase;

/**
 * Created by hayoc on 1/06/2016.
 */
public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AbstractDatabase.class).to(MockBeliefDatabase.class);
    }
}
