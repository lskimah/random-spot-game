/**
 * Player class that implements methods related to player.
 * @author lskim
 */
import java.util.Random;

public class Player {
    private String name;
    private int score;
    private static final Random rand = new Random();

    /**
     * Player constructor to initialize Player object.
     * @param n player's name
     */
    public Player(String n) {
        name = n;
        score = 0;
    }

    /**
     * Add score to player's current score.
     * @param score score to be added to player's current score.
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * Roll a 6-sided die for player's turn.
     * @return a number between 1 and 6.
     */
    public int rollDie() {
        return rand.nextInt(6) + 1;
    }
}
