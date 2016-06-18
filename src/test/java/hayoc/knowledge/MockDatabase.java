package hayoc.knowledge;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hayoc on 5/06/2016.
 */
public class MockDatabase {

    public static Map<String, Belief> getMockedBeliefs() {
        Map<String, Belief> db = new HashMap<String, Belief>();

        Belief belief1 = new Belief();
        belief1.setId("belief1");
        belief1.addRelevant("belief2", 0.5f);
        belief1.addRelevant("belief3", 0.9f);
        db.put(belief1.getId(), belief1);

        Belief belief2 = new Belief();
        belief2.setId("belief2");
        belief2.addRelevant("belief4", 0.2f);
        db.put(belief2.getId(), belief2);

        Belief belief3 = new Belief();
        belief3.setId("belief3");
        belief3.addRelevant("belief5", 1.0f);
        db.put(belief3.getId(), belief3);

        Belief belief4 = new Belief();
        belief4.setId("belief4");
        db.put(belief4.getId(), belief4);

        Belief belief5 = new Belief();
        belief5.setId("belief5");
        db.put(belief5.getId(), belief5);

        return db;
    }
}
