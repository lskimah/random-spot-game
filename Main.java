/**
 * Main class for random-race.
 * @author lskim
 */
import java.util.Scanner;

public class Main {
    /**
     *  Main method to run entire program.
     * @param args arguments part of main method.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Output direction
        System.out.println("random-spot-game:\nUser(you) and computer compete by rolling a 6-side die to select " +
                        "which of the 6 spots to add their name to it.\nThere is a small chance that the user can select "
                + "which spot to add their name.\n\n" + "1. User always goes first and then the computer\n2. Each " +
                "player rolls a die\n3. One point is given if adding a name to the spot was successful\n4. User will be" +
                " asked if they want to exit the game after each turn\n---------\n");

        System.out.print("Enter your name: ");
        String userName = scan.nextLine();

        // Create and start game
        Player user = new Player(userName);
        RunGame game = new RunGame(user);

        game.start();
    }
}
