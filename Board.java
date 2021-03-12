
/**
 * This class creates the board object that our TicTacToe game will be played on.
 *
 * @author Kwinn Danforth
 * @version 1.0.01
 */
public class Board
{
    private String[][] board;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        board = new String[3][3];
        for(int i = 0; i < 3; i++){
            board[0][i] = "" + (i + 1);
        }
        for(int i = 0; i < 3; i++){
            board[1][i] = "" + (i + 4);
        }
        for(int i = 0; i < 3; i++){
            board[2][i] = "" + (i + 7);
        }
    }

    /**
     * This method is used to change a spot on the board
     *
     * @param  the coordinates for the spot as well as the symbol to replace the spot with.
     */
    public boolean markSpot(int[] coordinates, String symbol)
    {
        if(board[coordinates[0]][coordinates[1]] != "X" && board[coordinates[0]][coordinates[1]] != "O"){
            board[coordinates[0]][coordinates[1]] = symbol;
        }else{
            System.out.println("That spot is already taken! Try again..");
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to print the board to the screen
     *
     */
    public void printBoard()
    {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("- + - + -");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("- + - + -");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
    
    /**
     * This method is used to get the value of a spot on the board
     *
     *@param x and y coordinates for the spot
     */
    public String getBoard(int x, int y)
    {
        return board[x][y];
    }
}
