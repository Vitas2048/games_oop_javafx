package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void occupied()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.E3));
        logic.move(Cell.C1, Cell.E3);
    }

    @Test(expected = FigureNotFoundException.class)
    public void notFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.E3));
        logic.move(Cell.C2, Cell.E3);
    }

}