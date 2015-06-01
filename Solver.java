public class Solver {

    private Board board;
    
    Solver(Board b) {
        board = b;
    }
    
    private boolean isValid ( int x, int y, int num ) {
        // First we check in the column
        for (int i = 0; i < Board.SIZE; i++) {
            if (i == y)
                continue; // Jump to next iteration if we are one our cell, ignoring any further instruction
                
            if (board.getNumber(x, i) == num)
                return false;
        }
        
        
        // Then we check the rows
        for (int i = 0; i < Board.SIZE; i++) {
            if (i == x)
                continue; // Jump to next iteration if we are one our cell, ignoring any further instruction
                
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
                    
                if (board.getNumber(x, y) == num)
                    return false;
            }
        }
        
        return true; // We never returned false, hence we can safely return true
    }

    private boolean isEmpty ( int x, int y ) {
        return (board.getNumber(x, y) == 0);
    }

    public void nextStep () {
        
    }
    
    public Board getBoard () {
        return board;
    }
}
