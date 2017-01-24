package hayoc.modules.grs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayo on 24/01/2017.
 */
public class ContextTestUtils {

    public static Context givenContext() {
        Context context = new Context();
        List<Concept> concepts = new ArrayList<>();

        Concept socrates = new Concept("c1_socrates", "Socrates", Type.INDIVIDUAL, "c1");
        socrates.setProperties(getSocratesProperties());
        concepts.add(socrates);

        Concept human = new Concept("c1_human", "human", Type.COLLECTION, "c1");
        human.setProperties(getHumanProperties());
        concepts.add(human);

        context.setConcepts(concepts);
        return context;
    }

    private static List<Concept> getSocratesProperties() {
        List<Concept> properties = new ArrayList<>();
        properties.add(new Concept("c1_human", "human", Type.COLLECTION, "c1"));
        properties.add(new Concept("male"));
        properties.add(new Concept("beard"));
        return properties;
    }

    private static List<Concept> getHumanProperties() {
        List<Concept> properties = new ArrayList<>();
        properties.add(new Concept("mortal"));
        properties.add(new Concept("biped"));
        return properties;
    }
}
