/**
 * RaceGame class to run the game.
 * @author lskim
 */
import java.util.Scanner;

public class RunGame implements Game {
    private Player user;
    private Player computer;
    private Board board;
    public static final Scanner SCAN = new Scanner(System.in);

    /**
     * Constructor to initialize each player and board.
     * @param user the Player object for the user player.
     */
    public RunGame(Player user) {
        this.user = user;
        computer = new Player("Computer");
        board = new Board();
    }

    /**
     * Start the random race game.
     */
    public void start() {
        while (true) {
            // Print current score board
            printScore(user, computer);

            int playerRoll = user.rollDie();

            // Output user player's die roll
            System.out.println(user + " rolled a " + playerRoll);

            // Player gets a point if they can add their name to a spot
            if (board.addSpot(playerRoll, user.toString())) {
                System.out.println("Added " + user + " to spot " + playerRoll);
                user.addScore(1);

            } else {
                System.out.println("Spot " + playerRoll + " is already taken.");
            }

            // Check if board is full to ask for another game or not
            if (endGame()) {
                break;
            }

            // Computer's turn after user player
            int computerRoll = computer.rollDie();
            System.out.println(computer + " rolled a " + computerRoll);

            // Computer gets a point if they can add their name to a spot
            if (board.addSpot(computerRoll, computer.toString())) {
                System.out.println("Added " + computer + " to spot " + computerRoll);
                computer.addScore(1);

            } else {
                System.out.println("Spot " + computerRoll + " is already taken.");
            }

            // Check if board is full to ask for another game or not
            if (endGame()) {
                break;
            }

            System.out.println(board);

            // User enters anything to continue next turn
            continueTurn();
            System.out.println("------------------------------------");
        }
    }

    /**
     * Check if the board is full to end game or not depending on user's choice.
     * @return true if the board is full, false otherwise.
     */
    public boolean endGame() {
        if (board.isFull()) {
            System.out.println(board);
            System.out.println("\nRound over- Board is full.");

            System.out.print("Do you want to play another game? (enter yes or no): ");
            String choice = SCAN.nextLine().trim().toLowerCase();

            // End game if user doesn't want to play again
            if (choice.equals("no")) {
                System.out.println("Game ended.");
                return true;
            } else {
                board.reset();
            }
        }

        System.out.println("\n");
        return false;
    }

    /**
     * Pause the game before continuing to next turn so that each turn is outputted one by one.
     */
    public void continueTurn() {
        System.out.print("\nEnter anything to continue next turn: ");
        String turn = SCAN.nextLine();
        System.out.println("\n");
    }

    public void printScore(Player user, Player computer) {
        System.out.println("\n" + user + " score: " + user.score() + " | " + computer + " score: " + computer.score());
    }
}