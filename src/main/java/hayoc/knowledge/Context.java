package hayoc.knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hayoc on 24/05/2016.
 */
public class Context {

    private String id;
    private String representation;

    private List<String> beliefs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public List<String> getBeliefs() {
        return beliefs;
    }

    public void setBeliefs(List<String> beliefs) {
        this.beliefs = beliefs;
    }

    public void addBelief(String belief) {
        if (beliefs == null)
            beliefs = new ArrayList<String>();
        beliefs.add(belief);
    }
}
