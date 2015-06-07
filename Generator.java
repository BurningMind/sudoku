public class Generator {

    private static final int UNICITY_ITERATIONS = 10;

    // public Board generateSudoku () { //degré de difficulté ?
    //
    // }

    public boolean verifyUnicity (Board b ) {
        Board[] boards = new Board[UNICITY_ITERATIONS];

        for ( int i = 0; i< boards.length; i++ ){
            Board board = new Board(b);
            Solver solver = new Solver(board);
            solver.solveBoard();
            boards[i] = board;
        }

        for (int i = 1; i < boards.length; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                for (int k = 0; k < Board.SIZE; k++) {
                    if (boards[i].getNumber(j, k) != boards[0].getNumber(j, k))
                        return false;
                }
            }
        }

        return true;
    }

    // public Board deleteNumber (Board b ) {
    //
    // }

}
