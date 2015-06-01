public class Solver {

    private Board board;
    
    Solver(Board b) {
        board = b;
    }
    
    private boolean isValid ( int x, int y, int num ) {

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
