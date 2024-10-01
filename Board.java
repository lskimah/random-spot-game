/**
 * Board class to initialize and change game board after each turn.
 * @author lskim
 */
import java.util.Arrays;

public class Board {
    private String[] spots;
    private final int SIZE = 6;

    /**
     * Board constructor to initialize board with 6 spots.
     */
    public Board() {
        spots = new String[SIZE];
    }

    /**
     * Add player's name to a spot if it's available.
     * @param spot spot to be considered for adding name.
     * @param player player's name.
     * @return true if adding player's name was successful or false if not.
     */
    public boolean addSpot(int spot, String player) {
        if (spots[spot-1] == null) {
            spots[spot-1] = player;
            return true;
        }

        return false;
    }

    /**
     * Count the number of spots with player's name on the board.
     * @param playerName player's name.
     * @return count of number of spots with player's name.
     */
    public int getPlayerOccurrence(String playerName) {
        int count = 0;
        for (String spot : spots) {
            if (playerName.equals(spot)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Check if board is full to end round.
     * @return true if full or false if not full.
     */
    public boolean isFull() {
        for (String spot : spots) {
            if (spot == null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reset the board by making all spots null.
     */
    public void reset() {
        Arrays.fill(spots, null);
    }

    /**
     * Return a String representation of the current board.
     * @return current board statement.
     */
    @Override
    public String toString() {
        String toReturn = "Current Board:\n";

        for (String name : spots) {
            toReturn += name + " | ";
        }
        return toReturn;
    }
}
