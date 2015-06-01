public class Board {

    private int [][] boardNumbers = new int [4][4];
    
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

