package hayoc.modules.grs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayo on 14/12/2016.
 */
public class Concept {

    private String identifier;
    private String value;
    private Type type;
    private String context;

    private List<Concept> properties = new ArrayList<>();

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Concept> getProperties() {
        return properties;
    }

    public void setProperties(List<Concept> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Concept {");
        sb.append(" identifier: " + identifier);
        sb.append(" | context: " + context);
        if (!properties.isEmpty()) {
            sb.append("| properties: ");
        }
        for (Concept property : properties) {
            sb.append(property.getIdentifier() + ",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
