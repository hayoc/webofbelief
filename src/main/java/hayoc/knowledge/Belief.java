package hayoc.knowledge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hayoc on 24/05/2016.
 */
public class Belief {

    private String id;
    private String representation;

    private List<Context> contexts;
    private Map<String, Float> relevant;

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

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    public Map<String, Float> getRelevant() {
        return relevant;
    }

    public void setRelevant(Map<String, Float> relevant) {
        this.relevant = relevant;
    }

    public void addRelevant(String id, Float relevance) {
        if (relevant == null)
            relevant = new HashMap<String, Float>();
        relevant.put(id, relevance);
    }
}
