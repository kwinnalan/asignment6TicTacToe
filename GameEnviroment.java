import java.util.Scanner;

/**
 * The Game Enviroment creates the enviroment where our game of tic-tac-toe is played
 *
 * @author Kwinn Danforth
 * @version 1.0.01
 */
public class GameEnviroment
{
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Scanner scanner = new Scanner(System.in);
    private String numPlayers;
    private int whosTurn;
    private int turnCount;
    private String winState;

    
    /**
     * Constructor for objects of class GameEnviroment
     */
    public GameEnviroment()
    {
        this.board = new Board();
        this.player1 = new Player("X");
        this.player2 = new Player("O");
        this.whosTurn = 2;
        this.winState = "C";
        this.turnCount = 0;
        printIntro();
        selectNumOfPlayers();
        play();
    }
    
    /**
     * This method will print an introduction for the game
     */
    public void printIntro()
    {
        System.out.println("This is a game of Tic-Tac-Toe!");
    }
    
    /**
     * This method lets the user choose 1 or 2 players
     */
    public void selectNumOfPlayers()
    {
        boolean goodChoice = false;
        while(!goodChoice){
            System.out.println("Enter 1 for one player or 2 for two players.");
            this.numPlayers = scanner.nextLine();
                if(Integer.parseInt(this.numPlayers) == 1 || Integer.parseInt(this.numPlayers) == 2){
                    goodChoice = true; 
                }else{
                    System.out.println("You must enter a valid input (1 or 2)");
                }
            }
    }
    
    /**
     * This method loops through the game play while the win state is set to continue
     */
    public void play()
    {
        boolean isTaken = false;
        while(winState == "C"){
            if(!isTaken){
                changeTurn();
                printSpace(25);
                this.board.printBoardEnum();
                printSpace(1);
                this.board.printBoard();
                System.out.println("Player " + whosTurn +" it is your turn!");
            }
            if(whosTurn == 1){
                    isTaken = this.board.markSpot(player1.chooseSpot(), player1.getSymbol());
            }else{
                if(Integer.parseInt(this.numPlayers) == 2){
                    isTaken = this.board.markSpot(player2.chooseSpot(), player2.getSymbol());
                }else{
                    computerSelect();
                }
            }
            checkBoard();
        }
        if(winState == "W"){
            printSpace(25);
            this.board.printBoardEnum();
            printSpace(1);
            this.board.printBoard();
            System.out.println("Congrats! Player " + whosTurn + ", you have won!");
        }
        if(winState == "D"){
            printSpace(25);
            this.board.printBoardEnum();
            printSpace(1);
            this.board.printBoard();
            System.out.println("Sorry, no one has won and we are out of spots... Its a cats game!");
        }
    }
    
    /**
     * This method changes which players turn it is
     */
    public void changeTurn()
    {
        this.whosTurn = this.whosTurn == 1 ? 2 : 1;
        this.turnCount++;
    }
    
    /**
     * This method will allow the computer to simulate a player2 selection
     */
    public void computerSelect()
    {
        System.out.println(board.getBoard(1,1));
        int[] coordinates = new int[2];
        if(board.getBoard(0,0) == board.getBoard(0,1) && board.getBoard(0,0) == "O" && board.getBoard(0,2) != "X"){
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(0,2) && board.getBoard(0,0) == "O" && board.getBoard(0,1) != "X"){
            coordinates[0] = 0;
            coordinates[1] = 1;
        }else if(board.getBoard(0,1) == board.getBoard(0,2) && board.getBoard(0,1) == "O" && board.getBoard(0,0) != "X"){
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(1,0) == board.getBoard(1,1) && board.getBoard(1,0) == "O" && board.getBoard(1,2) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 2;
        }else if(board.getBoard(1,0) == board.getBoard(1,2) && board.getBoard(1,0) == "O" && board.getBoard(1,1) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(1,1) == board.getBoard(1,2) && board.getBoard(1,1) == "O" && board.getBoard(1,0) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 0;
        }else if(board.getBoard(2,0) == board.getBoard(2,1) && board.getBoard(2,0) == "O" && board.getBoard(2,2) != "X"){                
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(2,0) == board.getBoard(2,2) && board.getBoard(2,0) == "O" && board.getBoard(2,1) != "X"){
            coordinates[0] = 2;
            coordinates[1] = 1;
        }else if(board.getBoard(2,1) == board.getBoard(2,2) && board.getBoard(2,1) == "O" && board.getBoard(2,0) != "X"){                //check for horizonal wins^
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,0) == board.getBoard(1,0) && board.getBoard(0,0) == "O" && board.getBoard(2,0) != "X"){
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,0) == board.getBoard(2,0) && board.getBoard(0,0) == "O" && board.getBoard(1,0) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 0;
        }else if(board.getBoard(2,0) == board.getBoard(1,0) && board.getBoard(0,0) == "O" && board.getBoard(0,0) != "X"){
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(0,1) == board.getBoard(1,1) && board.getBoard(0,1) == "O" && board.getBoard(2,1) != "X"){
            coordinates[0] = 2;
            coordinates[1] = 1;
        }else if(board.getBoard(0,1) == board.getBoard(2,1) && board.getBoard(0,1) == "O" && board.getBoard(1,1) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(2,1) == board.getBoard(1,1) && board.getBoard(2,1) == "O" && board.getBoard(0,1) != "X"){
            coordinates[0] = 0;
            coordinates[1] = 1;
        }else if(board.getBoard(0,2) == board.getBoard(1,2) && board.getBoard(0,2) == "O" && board.getBoard(2,2) != "X"){                 
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(0,2) == board.getBoard(2,2) && board.getBoard(0,2) == "O" && board.getBoard(1,2) != "X"){                   
            coordinates[0] = 1;
            coordinates[1] = 2;
        }else if(board.getBoard(2,2) == board.getBoard(1,2) && board.getBoard(2,2) == "O" && board.getBoard(0,2) != "X"){                //check for vertical wins^
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(1,1) && board.getBoard(0,0) == "O" && board.getBoard(2,2) != "X"){
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(2,2) && board.getBoard(0,0) == "O" && board.getBoard(1,1) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(1,1) == board.getBoard(2,2) && board.getBoard(1,1) == "O" && board.getBoard(0,0) != "X"){
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(0,2) == board.getBoard(1,1) && board.getBoard(0,2) == "O" && board.getBoard(2,0) != "X"){                
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,2) == board.getBoard(2,0) && board.getBoard(0,2) == "O" && board.getBoard(1,1) != "X"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(1,1) == board.getBoard(2,2) && board.getBoard(1,1) == "O" && board.getBoard(0,2) != "X"){               //check for diagonal wins^
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(0,1) && board.getBoard(0,0) == "X" && board.getBoard(0,2) != "O"){
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(0,2) && board.getBoard(0,0) == "X" && board.getBoard(0,1) != "O"){
            coordinates[0] = 0;
            coordinates[1] = 1;
        }else if(board.getBoard(0,1) == board.getBoard(0,2) && board.getBoard(0,1) == "X" && board.getBoard(0,0) != "O"){
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(1,0) == board.getBoard(1,1) && board.getBoard(1,0) == "X" && board.getBoard(1,2) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 2;
        }else if(board.getBoard(1,0) == board.getBoard(1,2) && board.getBoard(1,0) == "X" && board.getBoard(1,1) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(1,1) == board.getBoard(1,2) && board.getBoard(1,1) == "X" && board.getBoard(1,0) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 0;
        }else if(board.getBoard(2,0) == board.getBoard(2,1) && board.getBoard(2,0) == "X" && board.getBoard(2,2) != "O"){                 
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(2,0) == board.getBoard(2,2) && board.getBoard(2,0) == "X" && board.getBoard(2,1) != "O"){
            coordinates[0] = 2;
            coordinates[1] = 1;
        }else if(board.getBoard(2,1) == board.getBoard(2,2) && board.getBoard(2,1) == "X" && board.getBoard(2,0) != "O"){                //check for horizonal blocks^
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,0) == board.getBoard(1,0) && board.getBoard(0,0) == "X" && board.getBoard(2,0) != "O"){
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,0) == board.getBoard(2,0) && board.getBoard(0,0) == "X" && board.getBoard(1,0) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 0;
        }else if(board.getBoard(2,0) == board.getBoard(1,0) && board.getBoard(0,0) == "X" && board.getBoard(0,0) != "O"){
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(0,1) == board.getBoard(1,1) && board.getBoard(0,1) == "X" && board.getBoard(2,1) != "O"){
            coordinates[0] = 2;
            coordinates[1] = 1;
        }else if(board.getBoard(0,1) == board.getBoard(2,1) && board.getBoard(0,1) == "X" && board.getBoard(1,1) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(2,1) == board.getBoard(1,1) && board.getBoard(2,1) == "X" && board.getBoard(0,1) != "O"){
            coordinates[0] = 0;
            coordinates[1] = 1;
        }else if(board.getBoard(0,2) == board.getBoard(1,2) && board.getBoard(0,2) == "X" && board.getBoard(2,2) != "O"){                 
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(0,2) == board.getBoard(2,2) && board.getBoard(0,2) == "X" && board.getBoard(1,2) != "O"){                   
            coordinates[0] = 1;
            coordinates[1] = 2;
        }else if(board.getBoard(2,2) == board.getBoard(1,2) && board.getBoard(2,2) == "X" && board.getBoard(0,2) != "O"){                //check for vertical blocks^
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(1,1) && board.getBoard(0,0) == "X" && board.getBoard(2,2) != "O"){
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(0,0) == board.getBoard(2,2) && board.getBoard(0,0) == "X" && board.getBoard(1,1) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(1,1) == board.getBoard(2,2) && board.getBoard(1,1) == "X" && board.getBoard(0,0) != "O"){
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(0,2) == board.getBoard(1,1) && board.getBoard(0,2) == "X" && board.getBoard(2,0) != "O"){               
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,2) == board.getBoard(2,0) && board.getBoard(0,2) == "X" && board.getBoard(1,1) != "O"){
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(1,1) == board.getBoard(2,2) && board.getBoard(1,1) == "X" && board.getBoard(0,2) != "O"){               //check for diagonal blocks^
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(1,1) != "X" && board.getBoard(1,1) != "O"){                                           //if center is open take center
            coordinates[0] = 1;
            coordinates[1] = 1;
        }else if(board.getBoard(0,0) != "X" && board.getBoard(0,0) != "O"){                                           
            coordinates[0] = 0;
            coordinates[1] = 0;
        }else if(board.getBoard(0,2) != "X" && board.getBoard(0,2) != "O"){                                           
            coordinates[0] = 0;
            coordinates[1] = 2;
        }else if(board.getBoard(2,2) != "X" && board.getBoard(2,2) != "O"){                                           
            coordinates[0] = 2;
            coordinates[1] = 2;
        }else if(board.getBoard(2,0) != "X" && board.getBoard(2,0) != "O"){                                           //if no win, block or center take a corner^
            coordinates[0] = 2;
            coordinates[1] = 0;
        }else if(board.getBoard(0,1) != "X" && board.getBoard(0,1) != "O"){                                           
            coordinates[0] = 0;
            coordinates[1] = 1;
        }else if(board.getBoard(1,0) != "X" && board.getBoard(1,0) != "O"){                                           
            coordinates[0] = 1;
            coordinates[1] = 0;
        }else if(board.getBoard(1,2) != "X" && board.getBoard(1,2) != "O"){                                           
            coordinates[0] = 1;
            coordinates[1] = 2;
        }else if(board.getBoard(2,1) != "X" && board.getBoard(2,1) != "O"){                                           //Select one of the four last spots^
            coordinates[0] = 2;
            coordinates[1] = 1;
        }
        this.board.markSpot(coordinates, this.player2.getSymbol());
    }
    
    /**
     * This method will check the win state of the game
     */
    public void checkBoard()
    {
        if(board.getBoard(0,0) == board.getBoard(0,1) && board.getBoard(0,1) == board.getBoard(0,2)){      //horizontals
            winState = "W";
        }
        else if(board.getBoard(1,0) == board.getBoard(1,1) && board.getBoard(1,1) == board.getBoard(1,2)){      //horizontals
            winState = "W";
        }
        else if(board.getBoard(2,0) == board.getBoard(2,1) && board.getBoard(2,1) == board.getBoard(2,2)){      //horizontals
            winState = "W";
        }
        else if(board.getBoard(0,0) == board.getBoard(1,0) && board.getBoard(1,0) == board.getBoard(2,0)){      //vertical
            winState = "W";
        }
        else if(board.getBoard(0,1) == board.getBoard(1,1) && board.getBoard(1,1) == board.getBoard(2,1)){      //vertical
            winState = "W";
        }
        else if(board.getBoard(0,2) == board.getBoard(1,2) && board.getBoard(1,2) == board.getBoard(2,2)){      //vertical
            winState = "W";
        }
        else if(board.getBoard(0,0) == board.getBoard(1,1) && board.getBoard(1,1) == board.getBoard(2,2)){      //diagonal
            winState = "W";
        }
        else if(board.getBoard(0,2) == board.getBoard(1,1) && board.getBoard(1,1) == board.getBoard(2,0)){      //diagonal
            winState = "W";
        }                           //W = win
    else if(turnCount == 9){
        winState = "D";  
    }                           //D = draw
        else{
            winState = "C"; 
        }                           //C = continue
    }

    /**
     * This method to add some white space on the screen
     *
     * @param n, the number of lines to add of whitespace
     */
    public void printSpace(int n)
    {
        for(int i = 0; i < n; i++){
            System.out.println("\n");
        }
    }
}
