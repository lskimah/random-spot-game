/**
 * Game Interface for methods in RunGame.
 * @author lskim
 */
public interface Game {
    void start();
    boolean endGame();
    void continueTurn();
    void printScore(Player user, Player computer);
}
