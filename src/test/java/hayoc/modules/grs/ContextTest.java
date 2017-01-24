package hayoc.modules.grs;

import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hayo on 23/01/2017.
 */
@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({TestModule.class})
public class ContextTest {

    private Context context;

    @Before
    public void givenConcepts() {
        context = new Context();
        List<Concept> concepts = new ArrayList<>();

        Concept socrates = new Concept("c1_socrates", "Socrates", Type.INDIVIDUAL, "c1");
        socrates.setProperties(getSocratesProperties());
        concepts.add(socrates);

        Concept human = new Concept("c1_human", "human", Type.COLLECTION, "c1");
        human.setProperties(getHumanProperties());
        concepts.add(human);

        context.setConcepts(concepts);
    }

    @Test
    public void testCreatingThoughtBase() {
        ThoughtBase thoughtBase = context.createThoughtBase();
        List<Thought> thoughts = thoughtBase.getThoughts();

        assertEquals(5, thoughts.size());
        assertEquals(1, thoughtBase.getConstantMap().size());
        assertEquals(5, thoughtBase.getPredicateMap().size());
        assertEquals(1, thoughtBase.getVariableList().size());

        assertEquals("human", thoughtBase.getPredicateMap().get("A").getValue());

/*        System.out.println(Arrays.toString(thoughts.toArray()));
        System.out.println(Arrays.toString(thoughtBase.getConstantMap().entrySet().toArray()));
        System.out.println(Arrays.toString(thoughtBase.getPredicateMap().entrySet().toArray()));
        System.out.println(Arrays.toString(thoughtBase.getVariableList().toArray()));*/

    }

    private List<Concept> getSocratesProperties() {
        List<Concept> properties = new ArrayList<>();
        properties.add(new Concept("c1_human", "human", Type.COLLECTION, "c1"));
        properties.add(new Concept("male"));
        properties.add(new Concept("beard"));
        return properties;
    }

    private List<Concept> getHumanProperties() {
        List<Concept> properties = new ArrayList<>();
        properties.add(new Concept("mortal"));
        properties.add(new Concept("biped"));
        return properties;
    }
}
