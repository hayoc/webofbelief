package hayoc.old.knowledge;

import hayoc.old.knowledge.beanz.Belief;
import hayoc.old.knowledge.beanz.Context;
import hayoc.old.knowledge.database.AbstractBeliefDatabase;
import hayoc.old.knowledge.database.AbstractContextDatabase;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Hayo on 22/07/2016.
 */
public class ContextClassification {

    @Inject
    private AbstractContextDatabase contextDatabase;
    @Inject
    private AbstractBeliefDatabase beliefDatabase;

    public Context classifyBelief(Belief belief) {
        Context context = contextDatabase.query(belief.getPredicate());
        if (context != null)
            modifyContext(context, belief);

        Context newContext = new Context();
        newContext.setId(belief.getPredicate());
        return modifyContext(newContext, belief);
    }

    private Context modifyContext(Context context, Belief belief) {
        List<String> beliefs = context.getBeliefs();
        beliefs.add(belief.getId());
        context.setBeliefs(beliefs);
        context = swapSubjectWithPredicateContext(belief, context);
        contextDatabase.save(context);
        return context;
    }

    private Context swapSubjectWithPredicateContext(Belief subjectBelief, Context predicateContext) {
        Context subjectContext = contextDatabase.query(subjectBelief.getSubject());
        if (subjectContext == null) {
            setNewContextForBeliefs(null, predicateContext);
            return predicateContext;
        }

        List<String> beliefs = predicateContext.getBeliefs();
        beliefs.addAll(subjectContext.getBeliefs());
        predicateContext.setBeliefs(beliefs);
        setNewContextForBeliefs(subjectContext, predicateContext);
        contextDatabase.delete(subjectContext);
        return predicateContext;
    }

    private void setNewContextForBeliefs(Context subjectContext, Context predicateContext) {
        List<String> beliefList = predicateContext.getBeliefs();
        for (String id : beliefList) {
            Belief belief = beliefDatabase.query(id);
            if (belief != null) {
                List<String> contexts = belief.getContexts();
                if (subjectContext != null)
                    contexts.remove(subjectContext.getId());
                contexts.add(predicateContext.getId());
                belief.setContexts(contexts);
                beliefDatabase.save(belief);
            }
        }
    }
}
