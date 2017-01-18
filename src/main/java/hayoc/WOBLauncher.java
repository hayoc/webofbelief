package hayoc;

import hayoc.database.ConceptDatabase;
import hayoc.modules.grs.Concept;

import java.io.IOException;

/**
 * Created by Hayo on 13/12/2016.
 */
public class WOBLauncher {

    public static void main(String[] args) throws IOException {
        Concept concept = new Concept();
        concept.setIdentifier("testConcept1");
        concept.setDescription("test description");
        concept.setContext("some context");

        ConceptDatabase database = new ConceptDatabase();
        database.open();
        database.put(concept);
        Concept concept2 = (Concept) database.get(concept.getIdentifier());

        System.out.println(concept2);

    }
}
