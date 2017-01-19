package hayoc.modules.grs;

import java.util.Map;

/**
 * Created by Hayo on 01/01/2017.
 */
public class Thought {

    private String proposition;
    private Map<String, Concept> variableConstantMap;

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public Map<String, Concept> getVariableConstantMap() {
        return variableConstantMap;
    }

    public void setVariableConstantMap(Map<String, Concept> variableConstantMap) {
        this.variableConstantMap = variableConstantMap;
    }
}
