package hayoc.old.knowledge.beanz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hayoc on 24/05/2016.
 */
public class Belief {

    private String id;
    private String connective;
    private String subject;
    private String predicate;

    private List<String> contexts;
    private Map<String, Float> relevant;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConnective() {
        return connective;
    }

    public void setConnective(String connective) {
        this.connective = connective;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public List<String> getContexts() {
        if (contexts == null)
            return new ArrayList<>();
        return contexts;
    }

    public void setContexts(List<String> contexts) {
        this.contexts = contexts;
    }

    public Map<String, Float> getRelevant() {
        if (relevant == null)
            return new HashMap<>();
        return relevant;
    }

    public void setRelevant(Map<String, Float> relevant) {
        this.relevant = relevant;
    }
}
