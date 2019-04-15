package pl.mvwojcik.tictactoe.consoleapp;


import pl.mvwojcik.tictactoe.desktopApp.utils.BoardUtils;
import pl.mvwojcik.tictactoe.model.Board;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting the game");
        System.out.println("O player starts");

        Board board;
        int a;
        int b;
        if (args.length != 0) {
            a = Integer.valueOf(args[0]);
            b = Integer.valueOf(args[1]);
            board = new Board(a, b);
        }
        else {
            board = new Board(3, 3);
            a=3;
            b=3;
        }
        Scanner reader = new Scanner(System.in);
        BoardUtils.printBoard(board.getBoard(),a,b);
        System.out.println();
        getInput(board, reader, a , b);

    }

    private static void getInput(Board board, Scanner reader, int a, int b) {
        while (reader.hasNext()) {
            try {
                try {
                    String input = reader.next();
                    Scanner s = new Scanner(input).useDelimiter("\\s*,\\s*");
                    int x = s.nextInt();
                    int y = s.nextInt();

                    board.set(x, y);
                } catch (IllegalArgumentException ignored) {
                }
            } catch (IllegalArgumentException | NoSuchElementException ignored ) {
            }
            BoardUtils.printBoard(board.getBoard(),a,b);

            checkResult(board);
            System.out.println();

        }
    }
    private static void checkResult(Board board) {
        if (board.checkAll()) {
            System.out.println(board.getWhoWin());
        }
        if (board.checkBoard()) {
            System.out.println(board.getWhoWin());
        }
    }
}
