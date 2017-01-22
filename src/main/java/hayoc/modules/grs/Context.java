package hayoc.modules.grs;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayo on 19/01/2017.
 */
public class Context {

    private static char[] ABC = new char[26];
    private static char[] abc = new char[26];

    static {
        int k = 0;
        for(int i = 0; i < ABC.length; i++){
            ABC[i] = (char)(65 + (k++));
        }

        k = 0;
        for(int i = 0; i < abc.length; i++){
            abc[i] = (char)(97 + (k++));
        }
    }

    private List<Concept> concepts;

    private ThoughtBase createThoughtBase() {
        ThoughtBase tb = new ThoughtBase();
        List<Thought> thoughts = new ArrayList<>();
        BiMap<String, Concept> predicateMap = HashBiMap.create();
        BiMap<String, Concept> constantMap = HashBiMap.create();
        BiMap<String, Concept> variableMap = HashBiMap.create();

        int individuals = 0;
        int collections = 0;
        int variables = 0;

        for (Concept concept : concepts) {
            for (Concept property : concept.getProperties()) {
                StringBuffer proposition = new StringBuffer();

                if (concept.getType().equals(Type.INDIVIDUAL)) {
                    collections = appendPredicate(predicateMap, collections, property, proposition);
                    individuals = appendConstant(constantMap, individuals, concept, proposition);
                } else {
                    proposition.append("∀");
                    variables = appendVariable(variableMap, variables, concept, proposition);
                    String variable = String.valueOf(proposition.charAt(proposition.length()-1));
                    proposition.append("(");

                    collections = appendPredicate(predicateMap, collections, concept, proposition);
                    proposition.append(variable);

                    proposition.append(" > ");
                    collections = appendPredicate(predicateMap, collections, property, proposition);
                    proposition.append(variable);

                    proposition.append(")");
                }

                Thought thought = new Thought();
                thought.setProposition(proposition.toString());
                thoughts.add(thought);
            }
        }

        tb.setThoughts(thoughts);
        tb.setPredicateMap(predicateMap);
        return tb;
    }

    private int appendConstant(BiMap<String, Concept> map, int tracker, Concept concept, StringBuffer proposition) {
        boolean exists = map.containsValue(concept);
        String toPut = exists ? map.inverse().get(concept) : String.valueOf(tracker);
        proposition.append(toPut);
        if (!exists) {
            map.put(String.valueOf(tracker), concept);
            tracker++;
        }
        return tracker;
    }

    private int appendPredicate(BiMap<String, Concept> map, int tracker, Concept concept, StringBuffer proposition) {
        boolean exists = map.containsValue(concept);
        String toPut =  exists ? map.inverse().get(concept) : String.valueOf(ABC[tracker]);
        proposition.append(toPut);
        if (!exists) {
            map.put(String.valueOf(ABC[tracker]), concept);
            tracker++;
        }
        return tracker;
    }

    private int appendVariable(BiMap<String, Concept> map, int tracker, Concept concept, StringBuffer proposition) {
        boolean exists = map.containsValue(concept);
        String toPut =  exists ? map.inverse().get(concept) : String.valueOf(abc[tracker]);
        proposition.append(toPut);
        if (!exists) {
            map.put(String.valueOf(abc[tracker]), concept);
            tracker++;
        }
        return tracker;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }
}
