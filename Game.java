/**
 * Game Interface for methods related to game.
 * @author lskim
 */
public interface Game {
    void start();
    boolean endGame();
    void continueTurn();
    void printScore(Player user, Player computer);
}
