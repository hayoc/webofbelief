package hayoc.old.knowledge.database;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import hayoc.old.knowledge.beanz.Context;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

/**
 * Created by hayoc on 29/05/2016.
 */
public class ContextDatabase implements AbstractContextDatabase {

    private OObjectDatabaseTx database;

    @Inject
    public ContextDatabase(WoBDatabase woBDatabase) {
        database = woBDatabase.getDatabase();
        database.getEntityManager().registerEntityClass(Context.class);
    }

    @Override
    public Context query(String id) {
        for (Context context : database.browseClass(Context.class)) {
            if (StringUtils.equalsIgnoreCase(context.getId(), id)) {
                return context;
            }
        }
        return null;
    }

    @Override
    public Context save(Context context) {
        return database.save(context);
    }

    @Override
    public void delete(Context context) {
        database.delete(context);
    }

    @Override
    public void close() {

    }
}
