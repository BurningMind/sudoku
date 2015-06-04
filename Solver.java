public class Solver {

    private Board board;

    private int current_x = 0;
    private int current_y = 0;

    private boolean lastBacktrack = false;

    Solver(Board b) {
        board = b;
    }

    private boolean isValid ( int x, int y, int num ) {
        // First we check in the column
        for (int i = 0; i < Board.SIZE; i++) {
            if (i == y)
                continue; // Jump to next iteration if we are on our cell, ignoring any further instruction

            if (board.getNumber(x, i) == num)
                return false;
        }


        // Then we check the rows
        for (int i = 0; i < Board.SIZE; i++) {
            if (i == x)
                continue; // Jump to next iteration if we are on our cell, ignoring any further instruction

            if (board.getNumber(i, y) == num)
                return false;
        }

        // Finally, we check the squares
        final int square_x = x / (int)Math.sqrt(Board.SIZE);
        final int square_y = y / (int)Math.sqrt(Board.SIZE);

        final int start_x = square_x * (int)Math.sqrt(Board.SIZE);
        final int start_y = square_y * (int)Math.sqrt(Board.SIZE);

        final int end_x = (square_x + 1) * (int)Math.sqrt(Board.SIZE);
        final int end_y = (square_y + 1) * (int)Math.sqrt(Board.SIZE);

        for (int i = start_x; i < end_x; i++) {
            for (int j = start_y; j < end_y; j++) {
                if (x == i && y == j)
                    continue; // Jump to next iteration if we are one our cell, ignoring any further instruction

                if (board.getNumber(i, j) == num)
                    return false;
            }
        }

        return true; // We never returned false, hence we can safely return true
    }

    private boolean isEmpty ( int x, int y ) {
        return (board.getNumber(x, y) == 0);
    }

    public boolean nextStep () {
        if (board.isConst(current_x, current_y)) {
            if (lastBacktrack)
                return backtrack();
            lastBacktrack = false;

            return advanceCursor();
        } else {
            lastBacktrack = false;
            if (board.getNumber(current_x, current_y) == 0) {
                board.setNumber(current_x, current_y, board.getNumber(current_x, current_y) + 1);
                return false;
            }

            if (isValid(current_x, current_y, board.getNumber(current_x, current_y)))
                return advanceCursor();
            else {
                if (board.getNumber(current_x, current_y) == Board.SIZE) {
                    lastBacktrack = true;
                    return backtrack();
                } else
                    board.setNumber(current_x, current_y, board.getNumber(current_x, current_y) + 1);
            }
        }

        return false;
    }

    private boolean advanceCursor() {
        if (current_x == Board.SIZE - 1) {
            if (current_y == Board.SIZE - 1)
                return true;

            current_x = 0;
            current_y++;
        } else {
            current_x++;
        }

        return false;
    }

    private boolean backtrack() {
        if (current_x == 0) {
            if (current_y == 0)
                return true;

            current_x = Board.SIZE - 1;
            current_y--;
        } else {
            current_x--;
        }

        return false;
    }

    public Board getBoard () {
        return board;
    }
}
