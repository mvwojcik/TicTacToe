package pl.mvwojcik.tictactoe.desktopApp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import pl.mvwojcik.tictactoe.desktopApp.utils.BoardUtils;
import pl.mvwojcik.tictactoe.desktopApp.utils.FXMLManager;

import java.io.IOException;

import static pl.mvwojcik.tictactoe.desktopApp.utils.FXMLManager.*;

public class MainController {

    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private ToggleGroup size;

    @FXML
    void startGameOnAction() {
        BoardUtils.a=((ToggleButton)size.getSelectedToggle()).getText().charAt(0);
        BoardUtils.b=((ToggleButton)size.getSelectedToggle()).getText().charAt(0);
        BoardUtils.player1=player1.getText();
        BoardUtils.player2=player2.getText();
        try {
            FXMLManager.setStage(FXMLManager.getStage(),GAMESCENEPATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
