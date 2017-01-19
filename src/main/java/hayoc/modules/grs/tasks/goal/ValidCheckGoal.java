package hayoc.modules.grs.tasks.goal;

import hayoc.modules.grs.Thought;
import hayoc.modules.grs.tasks.result.Result;

/**
 * Created by Hayo on 18/01/2017.
 */
public class ValidCheckGoal implements Goal {

    private Thought thought;

    @Override
    public Result execute() {
        return null;
    }

    public Thought getThought() {
        return thought;
    }

    public void setThought(Thought thought) {
        this.thought = thought;
    }
}
