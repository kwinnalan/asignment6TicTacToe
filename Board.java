
/**
 * This class creates the board object that our TicTacToe game will be played on.
 *
 * @author Kwinn Danforth
 * @version 1.0.01
 */
public class Board
{
    enum SpotState
    {
        X,
        O,
        Empty
    }
    private final String[][] board;
    private final SpotState[][] boardEnum;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        boardEnum = new SpotState[3][3];
        board = new String[3][3];
        for(int i = 0; i < 3; i++){
            board[0][i] = "" + (i + 1);
            boardEnum[0][i] = SpotState.Empty;
        }
        for(int i = 0; i < 3; i++){
            board[1][i] = "" + (i + 4);
            boardEnum[1][i] = SpotState.Empty;
        }
        for(int i = 0; i < 3; i++){
            board[2][i] = "" + (i + 7);
            boardEnum[2][i] = SpotState.Empty;
        }
    }

    /**
     * This method is used to change a spot on the board
     *
     * @param coordinates, the coordinates for the spot as well as the symbol to replace the spot with.
     */
    public boolean markSpot(int[] coordinates, String symbol)
    {
        if(board[coordinates[0]][coordinates[1]] != "X" && board[coordinates[0]][coordinates[1]] != "O"){
            board[coordinates[0]][coordinates[1]] = symbol;
            boardEnum[coordinates[0]][coordinates[1]] = SpotState.valueOf(symbol);
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
     * This method is used to print the board with Enums to the screen
     *
     */
    public void printBoardEnum()
    {
        String x, y, z, a, b, c, d, e, f;
        a = (boardEnum[0][0] != SpotState.Empty) ? "    " : "";
        b = (boardEnum[1][0] != SpotState.Empty) ? "    " : "";
        c = (boardEnum[2][0] != SpotState.Empty) ? "    " : "";

        x = (boardEnum[0][1] != SpotState.Empty) ? "    " : "";
        y = (boardEnum[1][1] != SpotState.Empty) ? "    " : "";
        z = (boardEnum[2][1] != SpotState.Empty) ? "    " : "";

        d = (boardEnum[0][2] != SpotState.Empty) ? "    " : "";
        e = (boardEnum[1][2] != SpotState.Empty) ? "    " : "";
        f = (boardEnum[2][2] != SpotState.Empty) ? "    " : "";

        System.out.println(boardEnum[0][0] + a + " | " + x + boardEnum[0][1] + " | " + d + boardEnum[0][2]);
        System.out.println("----- + ----- + -----");
        System.out.println(boardEnum[1][0] + b + " | " + y + boardEnum[1][1] + " | " + e + boardEnum[1][2]);
        System.out.println("----- + ----- + -----");
        System.out.println(boardEnum[2][0] + c + " | " + z + boardEnum[2][1] + " | " + f + boardEnum[2][2]);
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

    /**
     * This method is used to get the value of a spot on the board of enums
     *
     *@param x and y coordinates for the spot
     */
    public SpotState getBoardEnum(int x, int y)
    {
        return boardEnum[x][y];
    }
}
