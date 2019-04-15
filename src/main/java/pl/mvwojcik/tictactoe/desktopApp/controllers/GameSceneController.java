package pl.mvwojcik.tictactoe.desktopApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import pl.mvwojcik.tictactoe.desktopApp.utils.BoardUtils;
import pl.mvwojcik.tictactoe.desktopApp.utils.FXMLManager;
import pl.mvwojcik.tictactoe.model.Board;

import java.io.IOException;

import static pl.mvwojcik.tictactoe.desktopApp.utils.FXMLManager.GAMESCENEPATH;
import static pl.mvwojcik.tictactoe.desktopApp.utils.FXMLManager.MAINSCENEPATH;

public class GameSceneController {

  Board board;
  Image circleImg = new Image(getClass().getResourceAsStream("/img/circle.png"));
  Image xmarkImg = new Image(getClass().getResourceAsStream("/img/xmark.png"));

  @FXML private GridPane gridPane;

  @FXML private Label player1;

  @FXML private Label player2turn;

  @FXML private Label player2;

  @FXML private Label player1turn;

  @FXML private Label player1Won;

  @FXML private Label player2Won;

  @FXML private Label draw;

  @FXML
  void initialize() {
    board = new Board(3, 3);
    player1.setText(BoardUtils.player1);
    player2.setText(BoardUtils.player2);
    //player1.setVisible(true);
    //player2.setVisible(true);
    player1turn.setVisible(true);
    player2turn.setVisible(false);
    player2Won.setVisible(false);
    player1Won.setVisible(false);
    draw.setVisible(false);
  }

  @FXML
  void clickOnAction(ActionEvent event) {
    Integer a = gridPane.getColumnIndex((Button) event.getSource());
    Integer b = gridPane.getRowIndex((Button) event.getSource());

    if (a == null) {
      a = 0;
    }
    if (b == null) {
      b = 0;
    }
   // System.out.println(a + "," + b);
    char whosTurn = board.getWhosTurn();
    this.board.set(a, b);
    System.out.println(whosTurn);
    if (whosTurn == 'O') {
      ((Button) event.getSource()).setGraphic(new ImageView(circleImg));
      ((Button) event.getSource()).setDisable(true);
      player1turn.setVisible(false);
      player2turn.setVisible(true);
    } else {
      ((Button) event.getSource()).setGraphic(new ImageView(xmarkImg));
      ((Button) event.getSource()).setDisable(true);
      player1turn.setVisible(true);
      player2turn.setVisible(false);
    }

    if (board.checkAll()||board.checkBoard()) {
      this.player2turn.setVisible(false);
      this.player1turn.setVisible(false);
      if (board.getWhoWin().equals(board.OWIN)) {
        this.player1Won.setVisible(true);
      } else if (board.getWhoWin().equals(board.XWIN)){
        this.player2Won.setVisible(true);
      }
      else if (board.getWhoWin().equals("DRAW")) {
          this.draw.setVisible(true);
      }
    }
  }

  @FXML
  void cofnijOnAction(ActionEvent event) {
      try {
          FXMLManager.setStage(FXMLManager.getStage(),MAINSCENEPATH);
      } catch (IOException e) {
          e.printStackTrace();
      }

  }

  @FXML
  void restart(ActionEvent event) {
      try {
          FXMLManager.setStage(FXMLManager.getStage(),GAMESCENEPATH);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  @FXML
  void wyjdzOnAction(ActionEvent event) {
FXMLManager.getStage().close();
  }
}
