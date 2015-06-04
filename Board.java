public class Board {

    final static public int SIZE = 9; // Must be a squared number

    private int [][] boardNumbers = new int [SIZE][SIZE];
    private boolean [][] boardConst = new boolean [SIZE][SIZE];

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
