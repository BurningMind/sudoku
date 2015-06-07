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

        for (int i = 0; i < Board.SIZE; i++) {

            if (i%((int)Math.sqrt(Board.SIZE))==0) {
                afficherLigne(true);
            } else {
                afficherLigne(false);
            }

            for (int j = 0; j < Board.SIZE; j++) {
                if(j%((int)Math.sqrt(Board.SIZE))==0) {
                    System.out.print("| ");
                } else {
                    System.out.print("  ");
                }

                if (b.getNumber(j,i) == 0 ) {
                    System.out.print("  ");
                }
                else {
                    System.out.print(b.getNumber(j, i) + " ");
                }
            }
            System.out.println("|");
        }
        afficherLigne(true);

        Solver solver = new Solver(b);
        int compteur = 0;
    }

    public static void afficherLigne(boolean show) {
        for ( int j = 0; j < Board.SIZE; j++) {
            if (show) {
                if ( j%((int)Math.sqrt(Board.SIZE))==0 ) {
                    System.out.print("+---");
                } else {
                    System.out.print("----");
                }
            } else {
                if ( j%((int)Math.sqrt(Board.SIZE))==0 ) {
                    System.out.print("|   ");
                } else {
                    System.out.print("    ");
                }
            }
        }

        if (show) {
            System.out.println("+");
        } else {
            System.out.println("|");
        }
    }
}
