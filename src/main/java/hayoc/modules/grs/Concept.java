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

    public Concept() {};

    public Concept(String identifier, String value, Type type, String context) {
        this.identifier = identifier;
        this.value = value;
        this.type = type;
        this.context = context;
    }

    public Concept(String value) {
        this.value = value;
    }


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
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        Concept concept = (Concept) obj;
        return concept.identifier.equals(this.identifier);
    }

    @Override
    public int hashCode() {
        return identifier == null ? super.hashCode() : identifier.hashCode();
    }
}
