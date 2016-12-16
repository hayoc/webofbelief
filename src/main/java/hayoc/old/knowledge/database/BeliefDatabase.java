package hayoc.old.knowledge.database;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import hayoc.old.knowledge.beanz.Belief;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

/**
 * Created by hayoc on 29/05/2016.
 */
public class BeliefDatabase implements AbstractBeliefDatabase {

    private OObjectDatabaseTx database;

    @Inject
    public BeliefDatabase(WoBDatabase woBDatabase) {
        database = woBDatabase.getDatabase();
        database.getEntityManager().registerEntityClass(Belief.class);
    }

    @Override
    public Belief query(String id) {
        for (Belief belief : database.browseClass(Belief.class)) {
            if (StringUtils.equals(belief.getId(), id)) {
                return belief;
            }
        }
        return null;
    }

    @Override
    public Belief save(Belief belief) {
        return database.save(belief);
    }

    @Override
    public void delete(Belief belief) {
        database.delete(belief);
    }

    @Override
    public void close() {
        if (!database.isClosed())
            database.close();
    }
}
