import java.util.Scanner;
/**
 * The player class represents objects of Player 
 *
 * @author Kwinn Danforth
 * @version 1.0.01
 */
public class Player
{
    private String symbol;
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String symbol)
    {
        this.symbol = symbol;
    }
    
    /**
     * This method returns the symbol of the player.
     *
     *@return the symbol of the player
     */
    public String getSymbol()
    {
        return this.symbol;
    }
    
    /**
     * This method takes the players chosen spot and sends it to be checked. If good will call changSpot method of the board to mark it.
     *
     *@return the coordinates of the valid spot chosen by the player
     */
    public int[] chooseSpot()
    {
    boolean goodChoice = false;
    String spot = "";
        while(!goodChoice){
            System.out.println("Enter the number of the spot you choose.");
            spot = scanner.nextLine();
            if(checkSpot(spot)){
                goodChoice = true; 
            }
        }
    return getCoordinates(spot);
    }
    
    /**
     * This method takes the players chosen spot and returns weather or not it is a valid choice 
     *
     * @return   boolean if spot is valid or not.
     */
    public boolean checkSpot(String spot)
    {
        if(Integer.parseInt(spot) > 0 && Integer.parseInt(spot) < 10){
            return true;
        }else{
            System.out.println("That is not a valid spot number try again!");
            return false;
        }
    }
    
    /**
     * This method takes the spot number and returns the coordinates of the spot.
     *
     * @return The x coordinate and the y coordinate of the spot
     */
    public int[] getCoordinates(String spot)
    {
        int x = 0;
        int y = 0;
        
        if(Integer.parseInt(spot) == 1){
            x = 0;
            y = 0;
        }
        
        if(Integer.parseInt(spot) == 2){
            x = 0;
            y = 1;
        }
        
        if(Integer.parseInt(spot) == 3){
            x = 0;
            y = 2;
        }
        
        if(Integer.parseInt(spot) == 4){
            x = 1;
            y = 0;
        }
        
        if(Integer.parseInt(spot) == 5){
            x = 1;
            y = 1;
        }
        
        if(Integer.parseInt(spot) == 6){
            x = 1;
            y = 2;
        }
        
        if(Integer.parseInt(spot) == 7){
            x = 2;
            y = 0;
        }
        
        if(Integer.parseInt(spot) == 8){
            x = 2;
            y = 1;
        }
        
        if(Integer.parseInt(spot) == 9){
            x = 2;
            y = 2;
        }
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }
}
