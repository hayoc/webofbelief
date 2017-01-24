package hayoc.modules.grs;

import hayoc.setup.GuiceJUnitRunner;
import hayoc.setup.TestModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
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
    public void setup() {
        context = ContextTestUtils.givenContext();
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

        System.out.println(Arrays.toString(thoughts.toArray()));
        System.out.println(Arrays.toString(thoughtBase.getConstantMap().entrySet().toArray()));
        System.out.println(Arrays.toString(thoughtBase.getPredicateMap().entrySet().toArray()));
        System.out.println(Arrays.toString(thoughtBase.getVariableList().toArray()));
    }

}
