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
        this.computer = new Player("Computer");
        this.board = new Board();
    }

    /**
     * Start the random race game.
     */
    public void start() {
        while (true) {
            // Print current scoreboard and game board
            printScore(user, computer);
            System.out.println("--CURRENT BOARD--\n" + board);

            // Check for bonus turn for the user
            int playerRoll;
            if (user.doBonus()) {
                System.out.print("BONUS- Enter an available spot to fill in (1-6): ");
                playerRoll = SCAN.nextInt();

                // Player's chosen spot is defaulted to spot #1 if they didn't input correctly
                if (playerRoll < 1 || playerRoll > 6) {
                    System.out.println("Invalid input. Defaulting " + user + " roll to 1");
                    playerRoll = 1;
                }
                System.out.println("\n");
                SCAN.nextLine();

            } else {
                // User player roll a die, no bonus turn
                playerRoll = user.rollDie();
                System.out.println(user + " rolled a " + playerRoll);
            }

            // Add user player's name to a spot if can and update score
            if (board.addSpot(playerRoll, user.toString())) {
                System.out.println("Added " + user + " to spot " + playerRoll);
                user.addScore(1);

            } else {
                System.out.println("Spot " + playerRoll + " is already taken.");
            }

            // Check if board is full to end game or not
            if (endGame()) {
                break;
            }

            // Computer rolls a die
            int computerRoll = computer.rollDie();
            System.out.println("\n" + computer + " rolled a " + computerRoll);

            // Add computer's name to a spot if it can and update score
            if (board.addSpot(computerRoll, computer.toString())) {
                System.out.println("Added " + computer + " to spot " + computerRoll);
                computer.addScore(1);

            } else {
                System.out.println("Spot " + computerRoll + " is already taken.");
            }

            // Check if board is full to end game or not
            if (endGame()) {
                break;
            }

            System.out.println("\n--UPDATED BOARD--\n" + board);

            // User enters anything to go to next turn
            continueTurn();
            System.out.println("------------------------------------");
        }
    }

    /**
     * Check if the board is full and ask the player if they want to continue.
     * @return true if user wants to end the game or false to continue the game.
     */
    public boolean endGame() {
        if (board.isFull()) {
            System.out.println(board);
            System.out.println("\nROUND OVER - Board is full.");

            System.out.print("Do you want to play another game? (enter yes or no): ");
            String choice = SCAN.nextLine().trim().toLowerCase();

            // End game if the user doesn't want to continue
            if (choice.equals("no")) {
                System.out.println("Game ended.");
                return true;

            } else {
                board.reset();
            }
        }

        return false;
    }

    /**
     * Pause the game before continuing to the next turn so that each turn is output one by one.
     */
    public void continueTurn() {
        System.out.print("\nEnter anything to continue to the next turn: ");
        SCAN.nextLine();
        System.out.println("\n");
    }

    /**
     * Print the current score for both players.
     * @param user the user player.
     * @param computer the computer player.
     */
    public void printScore(Player user, Player computer) {
        System.out.println("\n" + user + " score: " + user.score() + " | " + computer + " score: " + computer.score());
    }
}
