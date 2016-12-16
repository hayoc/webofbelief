package hayoc.old.knowledge.beanz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hayoc on 24/05/2016.
 */
public class Context {

    private String id;
    private List<String> beliefs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getBeliefs() {
        if (beliefs == null)
            return new ArrayList<>();
        return beliefs;
    }

    public void setBeliefs(List<String> beliefs) {
        this.beliefs = beliefs;
    }
}
