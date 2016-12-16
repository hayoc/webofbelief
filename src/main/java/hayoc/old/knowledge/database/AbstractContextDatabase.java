package hayoc.old.knowledge.database;

import hayoc.old.knowledge.beanz.Context;

/**
 * Created by Hayo on 22/07/2016.
 */
public interface AbstractContextDatabase {
    Context query(String id);

    Context save(Context context);

    void delete(Context context);

    void close();
}
