package hayoc.database;

import hayoc.grs.WOBConcept;

import java.io.IOException;

/**
 * Created by Hayo on 14/12/2016.
 */
public interface WOBDatabase {

    boolean open();
    void put(WOBConcept concept) throws IOException;
    Object get(String identifier) throws IOException;
}
