package hayoc.modules.grs.tasks.goal;

import com.google.inject.Guice;
import com.google.inject.Injector;
import hayoc.modules.grs.Concept;
import hayoc.modules.grs.Context;
import hayoc.modules.grs.Thought;
import hayoc.modules.grs.tasks.result.ClassicalTruthResult;
import hayoc.modules.grs.tasks.result.Result;
import hayoc.raisin.common.SyntaxException;
import hayoc.raisin.common.rules.RuleUtilities;
import hayoc.raisin.common.search.TableauxSearch;
import hayoc.raisin.predicate.classical.PredicateClassicalLogic;
import hayoc.raisin.setup.RaisinModule;

import java.util.List;

/**
 * Created by Hayo on 18/01/2017.
 */
public class ValidCheckGoal implements Goal {

    private RuleUtilities predicateUtilities;
    private TableauxSearch tableauxSearch;

    private Thought thought;
    private List<Context> contexts;
    private List<Concept> concepts;

    public ValidCheckGoal(RuleUtilities ruleUtilities, TableauxSearch tableauxSearch) {
        this.predicateUtilities = ruleUtilities;
        this.tableauxSearch = tableauxSearch;
    }

    @Override
    public Result execute() {
        RaisinModule module = new RaisinModule();
        Injector injector = Guice.createInjector(module);

        boolean valid = injector.getInstance(PredicateClassicalLogic.class).prove(thought.getProposition());
        return new ClassicalTruthResult(valid);
    }

    private boolean prove(String goal) {
        try {
            goal = predicateUtilities.negate(goal);
        } catch (SyntaxException e) {
            return false;
        }

        return tableauxSearch.start(goal);
    }

    public Thought getThought() {
        return thought;
    }

    public void setThought(Thought thought) {
        this.thought = thought;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }
}
