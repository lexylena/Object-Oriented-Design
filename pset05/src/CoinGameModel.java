import java.util.ArrayList;
import java.util.List;

/**
 * An interface for playing a coin game. The rules of a particular coin game will be implemented by
 * classes that implement this interface.
 */
public interface CoinGameModel {

  /**
   * Gets the number of players in the currently in the game.
   *
   * @return the number of players currently in the game
   */
  int playerCount();

  /**
   * Increases the number of players currently in the game by 1
   */
  void addPlayer(String newPlayer);

  /**
   * Gets the number of turns played in this game.
   *
   * @return int the number of turns played in this game
   */
  int turnCount();

  /**
   * Increases the number of turns played in this game by 1.
   */
  void incrTurnCount();

  /**
   * Gets the player id of the player whose turn it is.
   *
   * @return the id of the player whose turn it is
   */
  int activePlayer();

  /**
   * Gets the size of the board (the number of squares)
   *
   * @return the board size
   */
  int boardSize();

  /**
   * Gets the number of coins.
   *
   * @return the number of coins
   */
  int coinCount();

  /**
   * Gets the (zero-based) position of coin number {@code coinIndex}.
   *
   * @param coinIndex which coin to look up
   * @return the coin's position
   * @throws IllegalArgumentException if there is no coin with the requested index
   */
  int getCoinPosition(int coinIndex);

  /**
   * Returns whether the current game is over. The game is over if there are no valid moves.
   *
   * @return whether the game is over
   */
  boolean isGameOver();

  /**
   *
   * Moves coin {@code coinIndex} to position {@code newPosition}, if the requested move is legal.
   * Throws {@code IllegalMoveException} if the requested move is illegal, which can happen in
   * several ways:
   *
   * <ul> <li>There is no coin with the requested index.</li> <li>The new position is occupied by
   * another coin.</li> <li>There is some other reason the move is illegal, as specified by the
   * concrete game.</li> </ul>
   *
   * <p><strong>PRECONDITION: </strong> This method may not be called if isGameOver()
   * returns true. This method must always call incrTurnCount if a legal move is made.</p>
   *
   * @param coinIndex   which coin to move (numbered from the left)
   * @param newPosition where to move it to
   * @throws CoinGameModel.IllegalMoveException the move is illegal
   */
  void move(int coinIndex, int newPosition);

  /**
   * The exception thrown by {@code move} when the requested move is illegal.
   *
   * <p>(Implementation Note: Implementing this interface doesn't require "implementing" the {@code
   * IllegalMoveException} class. Nesting a class within an interface is a way to strongly associate
   * that class with the interface, which makes sense here because the exception is intended to be
   * used specifically by implementations and clients of this interface.)
   */
  static class IllegalMoveException extends IllegalArgumentException {

    /**
     * Constructs a illegal move exception with no description.
     */
    public IllegalMoveException() {
      super();
    }

    /**
     * Constructs a illegal move exception with the given description.
     *
     * @param msg the description
     */
    public IllegalMoveException(String msg) {
      super(msg);
    }
  }
}
