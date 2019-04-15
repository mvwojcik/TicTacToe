package pl.mvwojcik.tictactoe.model;

public class Board {
  private char[][] board;
  private char whosTurn;
  private final char X = 'X';
  private final char O = 'O';
  public final String XWIN = "WIN_X";
  public final String OWIN = "WIN_O";
  private String whoWin = "DRAW";
  private int sizeA;
  private int sizeB;

  public Board(int a, int b) {
    board = new char[a][b];
    whosTurn = O;
    this.sizeA = a;
    this.sizeB = b;
    //
    for (int i = 0; i < sizeA; i++) {
      for (int j = 0; j < sizeB; j++) {
        board[i][j] = '.';
      }
    }
  }

  public char[][] getBoard() {
    return board;
  }

  public final char get(int x, int y) {
    if (x < 0 || x > sizeA) throw new IllegalArgumentException();
    if (y < 0 || y > sizeB) throw new IllegalArgumentException();
    return this.board[y][x];
  }

  public final void set(int x, int y) {
    // if (whosTurn==move) throw new IllegalArgumentException("PlayerException");
    if (x < 0 || x > sizeA || y < 0 || y > sizeB)
      throw new IllegalArgumentException("less or more");
    if (this.get(x, y) != '.') throw new IllegalArgumentException("Occupied filed");
    this.board[y][x] = whosTurn;

    if (this.whosTurn == O) {
      this.whosTurn = X;
    } else {
      this.whosTurn = O;
    }
  }

  public boolean checkBoard() {
    int z = 0;
    for (int i = 0; i < sizeA; i++) {
      for (int j = 0; j < sizeB; j++) {
        if (this.get(i, j) != '.') {
          z++;
          //  return false;
        }
      }
    }
    return z == sizeA * sizeB;
  }

  public boolean checkRows() {

    for (int i = 0; i < sizeA; i++) {
      for (int j = 0; j < sizeA - 2; j++) {
        if (get(j, i) == X && get(j + 1, i) == X && get(j + 2, i) == X) {
          this.whoWin = this.XWIN;
          return true;
        }
        if (get(j, i) == O && get(j + 1, i) == O && get(j + 2, i) == O) {
          this.whoWin = this.OWIN;
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkColumns() {
    for (int i = 0; i < sizeB; i++) {
      for (int j = 0; j < sizeA - 2; j++) {

        if (get(i, j) == X && get(i, j + 1) == X && get(i, j + 2) == X) {
          this.whoWin = this.XWIN;
          return true;
        }
        if (get(i, j) == O && get(i, j + 1) == O && get(i, j + 2) == O) {
          this.whoWin = this.OWIN;
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkDiagonal(char x) {
    for (int i = 0; i < sizeB - 2; i++) {
      for (int j = 0; j < sizeA - 2; j++) {
        if (get(i, j) == x && get(i + 1, j + 1) == x && get(i + 2, j + 2) == x) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean checkDiagonal2(char x) {

    for (int i = sizeA - 1; i >= 2; i--) {
      for (int j = 0; j < sizeB - 2; j++) {
        if (get(i, j) == x && get(i - 1, j + 1) == x && get(i - 2, j + 2) == x) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkDiagonals2() {
    if (checkDiagonal2(X)) {
      this.whoWin = this.XWIN;
      return true;
    }
    if (checkDiagonal2(O)) {
      this.whoWin = this.OWIN;
      return true;
    }

    return false;
  }

  public boolean checkDiagonals() {
    if (this.checkDiagonal(X)) {
      this.whoWin = this.XWIN;
      return true;
    }
    if (this.checkDiagonal(O)) {
      this.whoWin = this.OWIN;
      return true;
    }
    return false;
  }

  public boolean checkAll() {
    if (checkRows() || checkColumns() || checkDiagonals() || checkDiagonals2()) {
      return true;
    }
    return false;
  }

  public String getWhoWin() {
    return whoWin;
  }

  public char getWhosTurn() {
    return whosTurn;
  }
}
