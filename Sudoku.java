public class Sudoku {

    public static void main (String[] args ) {
        Board board = new Board();
        board.setNumber(0, 0, 3);
        board.setConst(0, 0, true);

        board.setNumber(1, 0, 4);
        board.setConst(1, 0, true);

        board.setNumber(2, 0, 1);
        board.setConst(2, 0, true);

        board.setNumber(1, 1, 2);
        board.setConst(1, 1, true);

        board.setNumber(2, 2, 2);
        board.setConst(2, 2, true);

        board.setNumber(1, 3, 1);
        board.setConst(1, 3, true);

        board.setNumber(2, 3, 4);
        board.setConst(2, 3, true);

        board.setNumber(3, 3, 3);
        board.setConst(3, 3, true);

        Solver solver = new Solver(board);

        while (!solver.nextStep()) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {}

            for (int i = 0; i < 50; i++)
                System.out.println();

            Board b = solver.getBoard();

            for (int i = 0; i < Board.SIZE; i++) {
                System.out.println("_______________");
                for (int j = 0; j < Board.SIZE; j++) {
                    System.out.print(b.getNumber(j, i) + " | ");
                }
                System.out.println();
            }
        }
    }

}
