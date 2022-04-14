package ru.job4j.chess.firuges.black;

import junit.framework.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenBlackBishopC8() {
        BishopBlack bb1 = new BishopBlack(Cell.C8);
        Cell rsl = bb1.position();
        Cell expected = Cell.C8;
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenCopy() {
        BishopBlack bb1 = new BishopBlack(Cell.C8);
        BishopBlack bb2 = (BishopBlack) bb1.copy(Cell.G4);
        Cell rsl = bb2.position();
        Cell expected = Cell.G4;
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenWay() {
        BishopBlack bb1 = new BishopBlack(Cell.C1);
        Cell[] rsl = bb1.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        for (int i = 0; i < rsl.length; i++) {
            Assert.assertEquals(rsl[i], expected[i]);
        }

    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenValidationDiagonal() {
        BishopBlack bb1 = new BishopBlack(Cell.C1);
        bb1.way(Cell.C2);
    }


}