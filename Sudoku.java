import java.util.Scanner;

public class Sudoku {

    public static void main (String[] args ) {
        if (args.length < 2) {
            System.out.println("Not enough arguments.");
            return;
        }

        if (args[0].contains("generate")) {
            if (args.length != 3) {
                System.out.println("Invalid argument count.");
                return;
            }

            Board.SIZE = Integer.parseInt(args[1]);
            Generator.DIFFICULTY difficulty;

            if (args[2].contains("EASY")) {
                difficulty = Generator.DIFFICULTY.EASY;
            } else if (args[2].contains("MEDIUM")) {
                difficulty = Generator.DIFFICULTY.MEDIUM;
            } else if (args[2].contains("HARD")) {
                difficulty = Generator.DIFFICULTY.HARD;
            } else if (args[2].contains("EXTREME")) {
                difficulty = Generator.DIFFICULTY.EXTREME;
            } else {
                System.out.println("Invalid difficulty.");
                return;
            }

            Generator gen = new Generator();
            Board b = gen.generateSudoku(difficulty);

            System.out.println();

            System.out.print(b);

            if (args[0].contains("solve")) {
                Solver solver = new Solver(b);
                solver.solveBoard();

                System.out.print(b);
            } else if (args[0].contains("check")){
                boolean wrong = true;
                Board board= new Board();
                while(wrong) {
                    wrong = false;
                    board= typeBoard(b);
                    Solver solver = new Solver (b);
                    solver.solveBoard();

                    for (int j = 0; j < Board.SIZE && !wrong; j++) {
                        for (int k = 0; k < Board.SIZE && !wrong; k++) {
                            if (b.getNumber(j, k) != board.getNumber(j, k)){
                                System.out.println ("Invalid Solution");
                                wrong = true;
                            }
                        }
                    }
                }

                System.out.print(board);

                System.out.println("Correct Solution! :D");
            }
        } else if (args[0].contains("solve")) {
            if (args.length != 2) {
                System.out.println("Invalid argument count.");
                return;
            }

            Board.SIZE = Integer.parseInt(args[1]);

            Board b = new Board();
            b = typeBoard(b);

            System.out.print("Solving... ");

            Solver solver = new Solver(b);
            solver.solveBoard();

            System.out.println("Solved!");

            System.out.print(b);
        } else {
            System.out.println("Invalid command.");
            return;
        }
    }

    public static Board typeBoard(Board b) {
        Board board = new Board(b);

        Scanner scanner = new Scanner(System.in);

        int x = 0;
        int y = 0;
        while (true) {
            if (!board.isConst(x, y)) {
                board.setNumber(x, y, 10);
                System.out.print(board);
                System.out.print("Enter the next number (0 if empty):");
                int number = scanner.nextInt();
                if (number> Board.SIZE){
                    System.out.println("Illegal value, must be less than"+Board.SIZE);
                    continue;
                }
                board.setNumber(x, y, number);
            }

            if (x == Board.SIZE - 1) {
                if (y == Board.SIZE - 1) {
                    break;
                }

                y++;
                x = 0;
            } else {
                x++;
            }
        }

        return board;
    }
}
