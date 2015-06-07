public class Sudoku {

    public static void main (String[] args ) {

        Board.SIZE = Integer.parseInt(args[0]);

        // board.setNumber(0, 0, 1);
        // board.setConst(0, 0, true);
        // board.setNumber(5, 0, 7);
        // board.setConst(5, 0, true);
        // board.setNumber(7, 0, 9);
        // board.setConst(7, 0, true);
        //
        // board.setNumber(1, 1, 3);
        // board.setConst(1, 1, true);
        // board.setNumber(4, 1, 2);
        // board.setConst(4, 1, true);
        // board.setNumber(8, 1, 8);
        // board.setConst(8, 1, true);
        //
        // board.setNumber(2, 2, 9);
        // board.setConst(2, 2, true);
        // board.setNumber(3, 2, 6);
        // board.setConst(3, 2, true);
        // board.setNumber(6, 2, 5);
        // board.setConst(6, 2, true);
        //
        // board.setNumber(2, 3, 5);
        // board.setConst(2, 3, true);
        // board.setNumber(3, 3, 3);
        // board.setConst(3, 3, true);
        // board.setNumber(6, 3, 9);
        // board.setConst(6, 3, true);
        //
        // board.setNumber(1, 4, 1);
        // board.setConst(1, 4, true);
        // board.setNumber(4, 4, 8);
        // board.setConst(4, 4, true);
        // board.setNumber(8, 4, 2);
        // board.setConst(8, 4, true);
        //
        // board.setNumber(0, 5, 6);
        // board.setConst(0, 5, true);
        // board.setNumber(5, 5, 4);
        // board.setConst(5, 5, true);
        //
        // board.setNumber(0, 6, 3);
        // board.setConst(0, 6, true);
        // board.setNumber(7, 6, 1);
        // board.setConst(7, 6, true);
        //
        // board.setNumber(1, 7, 4);
        // board.setConst(1, 7, true);
        // board.setNumber(8, 7, 7);
        // board.setConst(8, 7, true);
        //
        // board.setNumber(2, 8, 7);
        // board.setConst(2, 8, true);
        // board.setNumber(6, 8, 3);
        // board.setConst(6, 8, true);

        Generator gen = new Generator();
        Board b = gen.generateSudoku(Generator.DIFFICULTY.EASY);

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

    //     while (!solver.nextStep()) {
    //         compteur++;
    //         // try {
    //         //     Thread.sleep(25);
    //         // } catch (Exception e) {}
    //
    //         double pourcentage = (compteur / 23930039.0) * 100.0;
    //         //System.out.println(" Etape numero : " + compteur );
    //         if (compteur % 10000 == 0)
    //             System.out.printf("\r%f %% effectues", pourcentage);
    //     }
    //
    //     double pourcentage = (compteur / 23930039.0) * 100.0;
    //     System.out.printf("\r%f %% effectues", pourcentage);
    //     System.out.println();
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
