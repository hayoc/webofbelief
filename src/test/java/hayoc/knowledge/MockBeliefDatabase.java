package hayoc.knowledge;

import hayoc.knowledge.database.AbstractDatabase;

import java.util.Map;

/**
 * Created by hayoc on 5/06/2016.
 */
public class MockBeliefDatabase implements AbstractDatabase {

    private Map<String, Belief> mockedDb;

    @Override
    public Belief query(String id) {
        if (mockedDb == null) {
            mockedDb = MockDatabase.getMockedBeliefs();
        }
        return mockedDb.get(id);
    }

    @Override
    public <T> T store(T object) {
        return null;
    }

    @Override
    public void close() {

    }
}
