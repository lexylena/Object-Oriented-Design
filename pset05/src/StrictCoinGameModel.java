import java.util.ArrayList;
import java.util.List;

/**
 * You don't need to implement this class or any concrete subclasses for pset04.
 */
public final class StrictCoinGameModel implements CoinGameModel {
  // (Exercise 2) Declare the fields needed to support the methods in
  // the interface you’ve designed:

  /**
   * mBoard represents the state of the board.
   */
  protected List<Boolean> mBoard = new ArrayList<Boolean>();

  /**
   * represents the total number of players currently in the game;
   */
  protected List<String> mPlayers = new ArrayList<String>();

  /**
   * represents the total number turns played so far in the game
   */
  protected int mTurnCount;

  /**
   * numCoins represents the number of coins on the baord.
   */
  protected int mCoinCount;

  // (Exercise 3) Describe, as precisely as you can, your
  // representation’s class invariants:
  // INVARIANT: numPlayers >= 1;
  // INVARIANT: mTurnCount >= 0;
  // INVARIANT: The move(int, int) method may not be called if isGameOver() returns true
  // INVARIANT: The move(int, int) method must always call incrTurnCount on a legal move
  // INVARIANT: The move(int, int) method may never call addPlayer()
  // INVARIANT: The addPlayer() method may only increment number of players by 1
  // INVARIANT: incrTurnCount may only be called within the move(int,int) method
  // INVARIANT: The mBoard string must not be null and must have a length greater than 1
  // INVARIANT: The mBoard string may only contain '-' and 'O' characters


  /**
   * Constructs a StrictCoinGameModel using a Builder.
   *
   * @param builder a legal builder used to create a CoinGameInstance
   */
  public StrictCoinGameModel(Builder builder) {
    this.mBoard = builder.mBoard;
    this.mCoinCount = builder.mCoinCount;
    this.mPlayers = builder.mPlayers;
    this.mTurnCount = 0;
  }

  @Override
  public int playerCount() {
    return mPlayers.size();
  }

  @Override
  public void addPlayer(String newPlayer) {
    mPlayers.add(newPlayer);
  }

  @Override
  public int turnCount() {
    return mTurnCount;
  }

  @Override
  public void incrTurnCount() {
    mTurnCount++;
  }

  @Override
  public int activePlayer() {
    return 0;
  }

  @Override
  public int boardSize() {
    return mBoard.size();
  }

  @Override
  public int coinCount() {
    return mCoinCount;
  }

  @Override
  public int getCoinPosition(int coinIndex) {
    return 0;
  }

  @Override
  public boolean isGameOver() {
    for (int position = 0; position < mCoinCount; position++) {
      if (mBoard.get(position) == false) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void move(int coinIndex, int newPosition) {
  }

  public static class Builder {
    // INVARIANT: numPlayers >= 1;
    // INVARIANT: The mBoard string must not be null and must have a length greater than 1.
    // INVARIANT: The mBoard string may only contain '-' and 'O' characters.

    /**
     * The state of the board.
     */
    private List<Boolean> mBoard = new ArrayList<Boolean>();

    /**
     * The number of players currently in the game.
     */
    protected List<String> mPlayers = new ArrayList<String>();

    /**
     * numCoins represents the number of coins on the baord.
     */
    protected int mCoinCount;

    /**
     * Constructs a new Builder with default field parameters.
     */
    public Builder() {
      mBoard.add(false);
      mBoard.add(true);
      mBoard.add(true);

      mCoinCount = mBoard.size();

      mPlayers.add("Alexander");
      mPlayers.add("Alexis");
    }

    /**
     * Mutates the existing board to match the mBoard parameter if it is legal.
     *
     * <p><strong>PRECONDITION:</strong> The mBoard string must not be null and must have a length
     * greater than 0. </p>
     * <p><strong>PRECONDITION:</strong> The mBoard string may only contain '-' and 'O' characters.
     * </p>
     * @param mBoard The board layout the user is trying to set the game to
     * @throws java.lang.IllegalArgumentException if the string is null, has a length less than 1
     * or if the board contains any characters other than '-' or 'O'
     *
     * @return {@code Builder} a Builder with the updated mBoard field
     */
    public Builder mBoard(String mBoard) {
      if (isLegalBoard(mBoard)) {
        this.mBoard.clear();
        for (int i = 0; i < mBoard.length(); i++) {
          if (mBoard.charAt(i) == 'O') {
            this.mBoard.add(true);
            this.mCoinCount++;
          } else {
            this.mBoard.add(false);
          }
        }
      }
      return this;
    }

    /**
     * Creates a Builder that will build a StrictCoinGameModel with the specified number of players
     * if the value is legal.
     *
     * <p><strong>PRECONDITION:</strong> numPlayers greater than or equal to 1 </p>
     *
     * @param mPlayers The list of players playing the game
     * @return {@code Builder} a Builder with the updated mBoard field
     * @throws java.lang.IllegalArgumentException if the number of players is less than 1
     */
    public Builder mPlayers(String... mPlayers) {
      for(String player : mPlayers) {
        this.mPlayers.add(player);
      }
      return this;
    }

    /**
     * Creates a StrictCoinGameModel based off the builder.
     *
     * @return {@code StrictCoingGameModel} a StrictCoinGameModel with fields that
     * match the Builder specifications
     */
    public StrictCoinGameModel build() {
      return new StrictCoinGameModel(this);
    }
  }

  /**
   * Returns whether the proposed board is legal. The board is not legal if any character other
   * than 'O' or '-' are within the string.
   *
   * @param board the board in question
   * @return whether the board contains legal characters
   * @throws IllegalArgumentException the board is illegal
   */
  protected static boolean isLegalBoard(String board) {
    // INVARIANT: board only contains '-' or 'O' and board.size() > 0
    if (null == board || board.isEmpty()) {
      throw new IllegalArgumentException("Board must have at least one space");
    }
    for (char ch : board.toCharArray()) {
      if (!(ch == 'O' || ch == '-')) {
        throw new IllegalArgumentException("Board may only contain 'O' and '-'");
      }
    }
    return true;
  }

  /**
   * Prints the current state of the board as a string with '-' representing open spaces
   * and 'O' representing occupied spaces
   *
   * @return a string representing the board layout
   */
  @Override
  public String toString() {
    String boardString = "";
    for (boolean bool : mBoard) {
      if (bool) {
        boardString += 'O';
      } else {
        boardString += '-';
      }
    }
    return boardString;
  }

  /**
   * Gets the name of the player
   *
   * @param playerIndex which player's name to look up
   * @return The name of the player
   * @throws IllegalArgumentException ifa player does not exist
   */
  public String getPlayer(int playerIndex) {
    if(0 <= playerIndex && playerIndex < boardSize()){
      return mPlayers.get(playerIndex);
    }
    throw new IllegalArgumentException("Player " + playerIndex + " does not exist");
  }
}
