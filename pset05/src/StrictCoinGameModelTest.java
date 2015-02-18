import org.junit.Test;

import static org.junit.Assert.*;

public class StrictCoinGameModelTest {

  @Test
  public void testDefaultBuilder() throws Exception {
    StrictCoinGameModel testGame = new StrictCoinGameModel.Builder().build();
    assertEquals("-OO", testGame.toString());
    assertEquals(3, testGame.coinCount());
    assertEquals("Alexander", testGame.getPlayer(0));
    assertEquals("Alexis", testGame.getPlayer(1));
  }

  @Test
  public void testPlayerCount() throws Exception {
    assertEquals(2, new StrictCoinGameModel.Builder().build().playerCount());
  }

  @Test
  public void testAddPlayer() throws Exception {
    StrictCoinGameModel testGame = new StrictCoinGameModel.Builder().build();
    testGame.addPlayer("Steve");
    assertEquals(3, testGame.playerCount());
  }

  public void testTurnCount() throws Exception {

  }

  @Test
  public void testIncrTurnCount() throws Exception {
    StrictCoinGameModel testGame = new StrictCoinGameModel.Builder().build();
    assertEquals(0, testGame.turnCount());
    testGame.incrTurnCount();
    assertEquals(1, testGame.turnCount());
  }

  public void testActivePlayer() throws Exception {
    StrictCoinGameModel testGame = new StrictCoinGameModel.Builder().build();

  }

  public void testBoardSize() throws Exception {

  }

  public void testCoinCount() throws Exception {

  }

  public void testGetCoinPosition() throws Exception {

  }

  public void testIsGameOver() throws Exception {

  }

  public void testMove() throws Exception {

  }

  public void testIsLegalBoard() throws Exception {

  }

  public void testToString() throws Exception {

  }

  public void testGetPlayer() throws Exception {

  }
}