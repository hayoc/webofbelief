package hayoc.modules.grs;

import java.util.List;
import java.util.Map;

/**
 * Created by Hayo on 22/01/2017.
 */
public class ThoughtBase {

    private List<Thought> thoughts;
    private Map<String, Concept> predicateMap;
    private Map<String, Concept> constantMap;
    private Map<String, Concept> variableMap;

    public List<Thought> getThoughts() {
        return thoughts;
    }

    public void setThoughts(List<Thought> thoughts) {
        this.thoughts = thoughts;
    }

    public Map<String, Concept> getPredicateMap() {
        return predicateMap;
    }

    public void setPredicateMap(Map<String, Concept> predicateMap) {
        this.predicateMap = predicateMap;
    }

    public Map<String, Concept> getVariableMap() {
        return variableMap;
    }

    public void setVariableMap(Map<String, Concept> variableMap) {
        this.variableMap = variableMap;
    }

    public Map<String, Concept> getConstantMap() {
        return constantMap;
    }

    public void setConstantMap(Map<String, Concept> constantMap) {
        this.constantMap = constantMap;
    }
}
