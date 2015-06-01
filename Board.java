public class Board {

    final static public int SIZE = 4; // Must be a squared number

    private int [][] boardNumbers = new int [SIZE][SIZE];
    
    public void setNumber ( int x, int y, int num ) {
        boardNumbers[y][x] = num;
    }
    
    public int getNumber ( int x, int y ) {
        return boardNumbers[y][x];
    }
    
    public void eraseNumber ( int x, int y ) {
        setNumber(x, y, 0);
    }

    
/* Exception, out of bounds, 10 */
 
}

