package hayoc.grs;

/**
 * Created by Hayo on 14/12/2016.
 */
public class WOBConcept {

    private String identifier;
    private String description;
    private String context;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("WOBConcept {");
        sb.append(" identifier: " + identifier);
        sb.append(" | description: " + description);
        sb.append(" | context: " + context);
        sb.append("}");
        return sb.toString();
    }
}
