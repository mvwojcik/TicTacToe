package pl.mvwojcik.tictactoe.webapp;

import pl.mvwojcik.tictactoe.desktopApp.utils.BoardUtils;
import pl.mvwojcik.tictactoe.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class BoardTest {

  Board board;
  int a;
  int b;

  @BeforeEach
  public void initBoard3x3() {
    this.a = 3;
    this.b = 3;
    this.board = new Board(a, b);
  }

  @Test
  public void constructorTest() {
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        assertEquals(this.board.get(i, j), '.');
      }
    }
  }

  @Test
  public void settingFieldsTest() {
    int z = 0;
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        this.board.set(j, i);
        if (z % 2 == 0) {
          assertEquals(this.board.get(j, i), 'O');
        } else {
          assertEquals(this.board.get(j, i), 'X');
        }
        z++;
      }
    }
  }

  @Test
  public void scenario1() {
    this.board.set(0, 0);
    this.board.set(0, 1);
    this.board.set(1, 1);
    this.board.set(1, 0);
    this.board.set(2, 2);
    BoardUtils.printBoard(this.board.getBoard(), a, b);
    assertFalse(this.board.checkDiagonal('X'));
    assertFalse(this.board.checkDiagonal2('X'));
    assertFalse(this.board.checkDiagonal2('O'));
    assertFalse(this.board.checkColumns());
    assertFalse(this.board.checkRows());
    assertFalse(this.board.checkDiagonals2());


    assertTrue(this.board.checkDiagonal('O'));
    assertTrue(this.board.checkDiagonals());
    assertTrue(this.board.checkAll());

    assertEquals(this.board.getWhoWin(),"WIN_O");

  }

  @Test
  public void scenario2() {
    this.board.set(0, 0);
    this.board.set(1, 0);
    this.board.set(0, 1);
    this.board.set(2, 0);
    this.board.set(0, 2);
    BoardUtils.printBoard(this.board.getBoard(), a, b);
    assertFalse(this.board.checkDiagonal('X'));
    assertFalse(this.board.checkDiagonal2('X'));
    assertFalse(this.board.checkDiagonal2('O'));
    assertFalse(this.board.checkRows());
    assertFalse(this.board.checkDiagonals2());


    assertTrue(this.board.checkColumns());
    assertEquals(this.board.getWhoWin(),"WIN_O");
    assertTrue(this.board.checkAll());

  }

  @Test
  public void scenario3() {
    this.a=4;
    this.b=4;
    this.board = new Board(a,b);

    this.board.set(1, 0);
    this.board.set(0, 0);
    this.board.set(2, 0);
    assertFalse(this.board.checkAll());
    this.board.set(2, 1);
    this.board.set(3, 0);
    assertFalse(this.board.checkDiagonal('X'));
    assertFalse(this.board.checkDiagonal2('X'));
    assertFalse(this.board.checkDiagonal2('O'));
    assertFalse(this.board.checkDiagonals2());
    assertFalse(this.board.checkColumns());



    assertTrue(this.board.checkRows());
    assertEquals(this.board.getWhoWin(),"WIN_O");
    assertTrue(this.board.checkAll());
  }

  @Test
  public void scenarioDraw() {
    this.a=4;
    this.b=4;
    this.board = new Board(a,b);
    assertFalse(this.board.checkAll());
    this.board.set(0,0);
    this.board.set(0,1);
    this.board.set(0,2);
    this.board.set(1,1);
    this.board.set(2,1);
    this.board.set(3,0);
    this.board.set(2,0);
    this.board.set(1,0);
    this.board.set(1,2);
    assertFalse(this.board.checkAll());
    this.board.set(2,2);
    this.board.set(3,1);
    this.board.set(3,2);
    this.board.set(3,3);
    this.board.set(2,3);
    this.board.set(1,3);
    this.board.set(0,3);

    assertFalse(this.board.checkDiagonal('X'));
    assertFalse(this.board.checkDiagonal2('X'));
    assertFalse(this.board.checkDiagonal2('O'));
    assertFalse(this.board.checkDiagonals2());
    assertFalse(this.board.checkColumns());
    assertFalse(this.board.checkRows());
    assertFalse(this.board.checkAll());

    assertEquals(this.board.getWhoWin(),"DRAW");

    assertThrows(IllegalArgumentException.class,()->this.board.set(2,2));
    assertThrows(IllegalArgumentException.class,()->this.board.set(1,2));
    assertThrows(IllegalArgumentException.class,()->this.board.set(2,3));
    BoardUtils.printBoard(this.board.getBoard(), a, b);

  }
}
