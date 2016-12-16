package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Context;
import hayoc.old.knowledge.database.AbstractContextDatabase;

import java.util.Map;

/**
 * Created by Hayo on 24/07/2016.
 */
public class MockContextDatabase implements AbstractContextDatabase {

    private Map<String, Context> mockedDb;

    @Override
    public Context query(String id) {
        if (mockedDb == null) {
            mockedDb = MockDatabase.getMockedContexts();
        }
        return mockedDb.get(id);
    }

    @Override
    public Context save(Context context) {
        MockDatabase.getContexts().put(context.getId(), context);
        return context;    }

    @Override
    public void delete(Context context) {
        MockDatabase.getContexts().remove(context.getId());
    }

    @Override
    public void close() {

    }
}
