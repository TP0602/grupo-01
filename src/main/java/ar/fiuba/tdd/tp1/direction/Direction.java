package ar.fiuba.tdd.tp1.direction;

import ar.fiuba.tdd.tp1.cell.Cell;

/**
 * Created by juanma on 25/09/16.
 */
public interface Direction {
    public Cell getNextCell(Cell cell);
}