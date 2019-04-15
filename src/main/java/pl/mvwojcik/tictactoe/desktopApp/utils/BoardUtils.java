package pl.mvwojcik.tictactoe.desktopApp.utils;

public class BoardUtils {

    public static String player1 ="";
    public static String player2="";
    public static int a;
    public static int b;
    public final static void printBoard(final char[][]board, int a,int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
