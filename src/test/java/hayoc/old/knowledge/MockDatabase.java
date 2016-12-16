package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Belief;
import hayoc.old.knowledge.beanz.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hayoc on 5/06/2016.
 */
public class MockDatabase {

    private static Map<String, Belief> beliefs = new HashMap<>();
    private static Map<String, Context> contexts = new HashMap<>();

    public static Map<String, Belief> getMockedBeliefs() {
        Belief belief1 = new Belief();
        belief1.setId("belief1");
        Map<String, Float> relevant1 = new HashMap<>();
        relevant1.put("belief2", 0.5f);
        relevant1.put("belief3", 0.9f);
        belief1.setRelevant(relevant1);
        beliefs.put(belief1.getId(), belief1);

        Belief belief2 = new Belief();
        belief2.setId("belief2");
        Map<String, Float> relevant2 = new HashMap<>();
        relevant2.put("belief4", 0.2f);
        belief2.setRelevant(relevant2);
        beliefs.put(belief2.getId(), belief2);

        Belief belief3 = new Belief();
        belief3.setId("belief3");
        Map<String, Float> relevant3 = new HashMap<>();
        relevant3.put("belief5", 1.0f);
        belief3.setRelevant(relevant3);
        beliefs.put(belief3.getId(), belief3);

        Belief belief4 = new Belief();
        belief4.setId("belief4");
        beliefs.put(belief4.getId(), belief4);

        Belief belief5 = new Belief();
        belief5.setId("belief5");
        beliefs.put(belief5.getId(), belief5);

        return beliefs;
    }

    public static Map<String, Context> getMockedContexts() {
        return contexts;
    }

    public static Map<String, Context> getContexts() {
        return contexts;
    }

    public static void setContexts(Map<String, Context> contexts) {
        MockDatabase.contexts = contexts;
    }

    public static Map<String, Belief> getBeliefs() {
        return beliefs;
    }

    public static void setBeliefs(Map<String, Belief> beliefs) {
        MockDatabase.beliefs = beliefs;
    }
}
