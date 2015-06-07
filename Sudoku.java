public class Sudoku {

    public static void main (String[] args ) {
        Board.SIZE = Integer.parseInt(args[0]);
        Generator.DIFFICULTY difficulty = Generator.DIFFICULTY.EASY;
        if (args[1].contains("MEDIUM")) {
            difficulty = Generator.DIFFICULTY.MEDIUM;
        } else if (args[1].contains("HARD")) {
            difficulty = Generator.DIFFICULTY.HARD;
        } else if (args[1].contains("EXTREME")) {
            difficulty = Generator.DIFFICULTY.EXTREME;
        }

        Generator gen = new Generator();
        Board b = gen.generateSudoku(difficulty);

        System.out.println();

        System.out.print(b);

        Solver solver = new Solver(b);
        solver.solveBoard();

        System.out.print(b);
    }
}
