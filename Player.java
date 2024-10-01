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
     * Return player's current score.
     * @return score.
     */
    public int score() {
        return score;
    }

    /**
     * Roll a 6-sided die for player's turn.
     * @return a number between 1 and 6.
     */
    public int rollDie() {
        return rand.nextInt(6) + 1;
    }

    /**
     * Indicate if user player can do the bonus, which allows them to manually choose a spot to
     * fill their name.
     * @return true if it can do the bonus or false if cannot.
     */
    public boolean doBonus() {
        return rand.nextInt(100) < 10;
    }

    /**
     * Return a String statement of the player's name
     * @return player's name
     */
    @Override
    public String toString() {
        return name;
    }
}
