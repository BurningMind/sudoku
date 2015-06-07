public class Board {

    static public int SIZE = 9; // Must be a squared number

    private int [][] boardNumbers = new int [SIZE][SIZE];
    private boolean [][] boardConst = new boolean [SIZE][SIZE];

    public Board() {

    }

    public Board(Board otherBoard) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                boardNumbers[i][j] = otherBoard.boardNumbers[i][j];
                boardConst[i][j] = otherBoard.boardConst[i][j];
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < Board.SIZE; i++) {
            if (i%((int)Math.sqrt(Board.SIZE))==0) {
                str += addLine(true);
            } else {
                str += addLine(false);
            }

            for (int j = 0; j < Board.SIZE; j++) {
                if(j%((int)Math.sqrt(Board.SIZE))==0) {
                    str += "| ";
                } else {
                    str += "  ";
                }

                if (getNumber(j,i) == 0 ) {
                    str += "  ";
                } else {
                    str += getNumber(j, i) + " ";
                }
            }
            str += "|" + "\n";
        }
        str += addLine(true);

        return str;
    }

    private String addLine(boolean show) {
        String str = "";
        for ( int j = 0; j < Board.SIZE; j++) {
            if (show) {
                if ( j%((int)Math.sqrt(Board.SIZE))==0 ) {
                    str += "+---";
                } else {
                    str += "----";
                }
            } else {
                if ( j%((int)Math.sqrt(Board.SIZE))==0 ) {
                    str += "|   ";
                } else {
                    str += "    ";
                }
            }
        }

        if (show) {
            str += "+" + "\n";
        } else {
            str += "|" + "\n";
        }

        return str;
    }

    public void setNumber ( int x, int y, int num ) {
        boardNumbers[y][x] = num;
    }

    public void setConst( int x, int y, boolean isConstant) {
        boardConst[y][x] = isConstant;
    }

    public int getNumber ( int x, int y ) {
        return boardNumbers[y][x];
    }

    public boolean isConst( int x, int y ) {
        return boardConst[y][x];
    }

    public void eraseNumber ( int x, int y ) {
        setNumber(x, y, 0);
    }


/* Exception, out of bounds, 10 */

}
