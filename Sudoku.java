public class Sudoku {

    public static void main (String[] args ) {
        Board board = new Board();
        board.setNumber(4, 0, 3);
        board.setConst(4, 0, true);
        board.setNumber(5, 0, 7);
        board.setConst(5, 0, true);
        board.setNumber(6, 0, 6);
        board.setConst(6, 0, true);

        board.setNumber(3, 1, 6);
        board.setConst(3, 1, true);
        board.setNumber(7, 1, 9);
        board.setConst(7, 1, true);

        board.setNumber(2, 2, 8);
        board.setConst(2, 2, true);
        board.setNumber(8, 2, 4);
        board.setConst(8, 2, true);

        board.setNumber(1, 3, 9);
        board.setConst(1, 3, true);
        board.setNumber(8, 3, 1);
        board.setConst(8, 3, true);

        board.setNumber(0, 4, 6);
        board.setConst(0, 4, true);
        board.setNumber(8, 4, 9);
        board.setConst(8, 4, true);

        board.setNumber(0, 5, 3);
        board.setConst(0, 5, true);
        board.setNumber(7, 5, 4);
        board.setConst(7, 5, true);

        board.setNumber(0, 6, 7);
        board.setConst(0, 6, true);
        board.setNumber(6, 6, 8);
        board.setConst(6, 6, true);

        board.setNumber(1, 7, 1);
        board.setConst(1, 7, true);
        board.setNumber(5, 7, 9);
        board.setConst(5, 7, true);

        board.setNumber(2, 8, 2);
        board.setConst(2, 8, true);
        board.setNumber(3, 8, 5);
        board.setConst(3, 8, true);
        board.setNumber(4, 8, 4);
        board.setConst(4, 8, true);

        Solver solver = new Solver(board);

        while (!solver.nextStep()) {
            // try {
            //     Thread.sleep(10);
            // } catch (Exception e) {}
            //
            // System.out.println();




        }
        Board b = solver.getBoard();
        for (int i = 0; i < Board.SIZE; i++) {
            System.out.println("___________________________________");
            for (int j = 0; j < Board.SIZE; j++) {
                System.out.print(b.getNumber(j, i) + " | ");
            }
            System.out.println();
        }
    }

}
