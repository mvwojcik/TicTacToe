package pl.mvwojcik.tictactoe.desktopApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.mvwojcik.tictactoe.desktopApp.utils.FXMLManager;

import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLManager manager = new FXMLManager(stage);
        FXMLManager.setStage(stage, FXMLManager.MAINSCENEPATH);

    }

  public static void main(String[] args) {

    launch(args);
  }
}
