/**
 * Main class for random-race.
 * @author lskim
 */
import java.util.Scanner;

public class Main {

    /**
     *  Main method.
     * @param args arguments part of main method.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String userName = scan.nextLine();

        // Create and start game
        Player user = new Player(userName);
        RunGame game = new RunGame(user);

        game.start();
    }
}
