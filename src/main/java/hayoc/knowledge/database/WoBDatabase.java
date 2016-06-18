package hayoc.knowledge.database;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import javax.inject.Singleton;

/**
 * Created by hayoc on 1/06/2016.
 */
@Singleton
public class WoBDatabase  {

    private OObjectDatabaseTx database;

    public WoBDatabase() {
        database = new OObjectDatabaseTx("plocal:localhost/webofbelief").open("admin", "admin");
    }

    public OObjectDatabaseTx getDatabase() {
        return database;
    }

    public void setDatabase(OObjectDatabaseTx database) {
        this.database = database;
    }
}
