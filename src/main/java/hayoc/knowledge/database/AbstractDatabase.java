package hayoc.knowledge.database;

import com.orientechnologies.orient.core.db.OPartitionedDatabasePool;
import com.orientechnologies.orient.object.db.OObjectDatabasePool;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import com.orientechnologies.orient.object.db.OObjectDatabaseTxPooled;

import java.util.List;

/**
 * Created by hayoc on 29/05/2016.
 */
public interface AbstractDatabase {

    public abstract <T> T query(String id);

    public <T> T store(T object);

    public void close();

}
