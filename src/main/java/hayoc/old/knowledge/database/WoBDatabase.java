package hayoc.old.knowledge.database;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import javax.inject.Singleton;

/**
 * Created by hayoc on 1/06/2016.
 */
@Singleton
public class WoBDatabase  {

    private OObjectDatabaseTx database;

    public WoBDatabase() {
        database = new OObjectDatabaseTx("remote:localhost/webofbelief").open("admin", "admin");
        database.getEntityManager().registerEntityClasses("hayoc.old.knowledge.beanz");
    }

    public OObjectDatabaseTx getDatabase() {
        return database;
    }

    public void setDatabase(OObjectDatabaseTx database) {
        this.database = database;
    }
}
