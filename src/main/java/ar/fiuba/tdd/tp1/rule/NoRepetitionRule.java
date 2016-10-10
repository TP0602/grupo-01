package ar.fiuba.tdd.tp1.rule;

import ar.fiuba.tdd.tp1.cell.Cell;
import ar.fiuba.tdd.tp1.set.Graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucas on 10/10/16.
 */
public class NoRepetitionRule extends Rule {

    public NoRepetitionRule(String value) {
        super(value);
    }

    public boolean check(Graph graph) {
        Collection<Cell> cells = graph.getCells();

        boolean validRule = true;
        Set<Integer> cellSet = new HashSet<>();
        for (Cell cell : cells) {
            if (!cellSet.add(Integer.parseInt(cell.getData()))) {   //TODO: CHEQUEAR QUE CON CERO NO SEA VALIDO
                validRule = false;
            }
        }
        return validRule;
    }
}
