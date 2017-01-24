package hayoc.modules.grs;

/**
 * Created by Hayo on 01/01/2017.
 */
public class Thought {

    private String proposition;

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return proposition;
    }
}
