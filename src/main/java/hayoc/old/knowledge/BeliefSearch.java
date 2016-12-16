package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Belief;
import hayoc.old.knowledge.beanz.Context;
import hayoc.old.knowledge.database.AbstractBeliefDatabase;
import org.apache.commons.collections4.MapUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hayoc on 1/06/2016.
 */
public class BeliefSearch {

    @Inject
    private AbstractBeliefDatabase beliefDatabase;

    public List<Belief> getBeliefs(Context context, float relevance) {
        List<Belief> beliefs = new ArrayList<Belief>();

        for (String contextBelief : context.getBeliefs()) {
            Belief innerBelief = beliefDatabase.query(contextBelief);
            beliefs.add(innerBelief);
            beliefs.addAll(getRelevantBeliefs(innerBelief, relevance, 1));
        }

        return beliefs;
    }

    private List<Belief> getRelevantBeliefs(Belief innerBelief, float minRelevance, int depth) {
        List<Belief> beliefs = new ArrayList<Belief>();

        if (MapUtils.isEmpty(innerBelief.getRelevant()))
            return beliefs;

        for (Map.Entry<String, Float> entry : innerBelief.getRelevant().entrySet()) {
            if(entry.getValue() / depth >= minRelevance) {
                Belief belief = beliefDatabase.query(entry.getKey());
                beliefs.add(belief);
                beliefs.addAll(getRelevantBeliefs(belief, minRelevance, depth+1));
            }
        }

        return beliefs;
    }


}
