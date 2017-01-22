package hayoc.modules.grs.tasks.result;

/**
 * Created by Hayo on 20/01/2017.
 */
public class ClassicalTruthResult implements Result {

    private boolean valid;

    public ClassicalTruthResult (boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
