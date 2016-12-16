package hayoc.old.knowledge.database;

import hayoc.old.knowledge.beanz.Belief;

/**
 * Created by Hayo on 22/07/2016.
 */
public interface AbstractBeliefDatabase {
    public abstract Belief query(String id);

    public Belief save(Belief belief);

    public void delete(Belief belief);

    public void close();
}
