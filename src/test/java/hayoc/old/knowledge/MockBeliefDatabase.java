package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Belief;
import hayoc.old.knowledge.database.AbstractBeliefDatabase;

import java.util.Map;

/**
 * Created by hayoc on 5/06/2016.
 */
public class MockBeliefDatabase implements AbstractBeliefDatabase {

    private Map<String, Belief> mockedDb;

    @Override
    public Belief query(String id) {
        if (mockedDb == null) {
            mockedDb = MockDatabase.getMockedBeliefs();
        }
        return mockedDb.get(id);
    }

    @Override
    public Belief save(Belief belief) {
        MockDatabase.getBeliefs().put(belief.getId(), belief);
        return belief;
    }

    @Override
    public void delete(Belief belief) {
        MockDatabase.getBeliefs().remove(belief.getId());
    }

    @Override
    public void close() {

    }
}
