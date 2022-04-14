package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(this.position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = this.position.getX() - dest.getX() > 0 ? -1 : 1;
        int deltaY = this.position.getY() - dest.getY() > 0 ? -1 : 1;
        int x0 = this.position.getX();
        int y0 = this.position.getY();
        for (int index = 0; index < size; index++) {
            x0 = deltaX > 0 ? x0 + 1 : x0 - 1;
            y0 = deltaY > 0 ? y0 + 1 : y0 - 1;
            steps[index] = Cell.findBy(x0, y0);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        int x = source.getX();
        int y = source.getY();
        int x1 = dest.getX();
        int y1 = dest.getY();
        int deltaX = x - x1 > 0 ? -1 : 1;
        int deltaY = y - y1 > 0 ? -1 : 1;
        while (x  >= 0 && x <= 7 && y >= 0 && y <= 8 && y != y1 && x1 != x) {
            x = deltaX > 0 ? x + 1 : x - 1;
            y = deltaY > 0 ? y + 1 : y - 1;
            if (y == y1 && x1 == x) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
