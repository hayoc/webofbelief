package hayoc.knowledge.database;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import hayoc.knowledge.Context;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

/**
 * Created by hayoc on 29/05/2016.
 */
public class ContextDatabase implements AbstractDatabase {

    private OObjectDatabaseTx database;

    @Inject
    public ContextDatabase(WoBDatabase woBDatabase) {
        database = woBDatabase.getDatabase();
        database.getEntityManager().registerEntityClass(Context.class);
    }

    @Override
    public Context query(String id) {
        for (Context context : database.browseClass(Context.class)) {
            if (StringUtils.equals(context.getId(), id)) {
                return context;
            }
        }
        return null;
    }

    @Override
    public <T> T store(T object) {
        return null;
    }

    @Override
    public void close() {

    }
}
