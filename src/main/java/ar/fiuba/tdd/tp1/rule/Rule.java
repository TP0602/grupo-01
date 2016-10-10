package ar.fiuba.tdd.tp1.rule;

import ar.fiuba.tdd.tp1.set.Graph;


/*  */
public abstract class Rule {
    String value;

    public Rule(String value) {
        this.value = value;
    }

    /* Return True if the graph is compatible with the Rule */
    public abstract boolean check(Graph graph);

}
