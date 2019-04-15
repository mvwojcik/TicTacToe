package pl.mvwojcik.tictactoe.desktopApp.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLManager {
    public static final String GAMESCENEPATH = "/fxml/GameScene.fxml";
    public static final String MAINSCENEPATH = "/fxml/MainScene.fxml";


    static Stage stage;

    public FXMLManager(Stage stage) {
        this.stage = stage;
    }

    private static FXMLLoader fxmlLoader(String path) {
        FXMLLoader loader = new FXMLLoader(FXMLManager.class.getClass().getResource(path));
      //  loader.setResources(ResourceBundle.getBundle("bundles.msgs"));
        // tutaj ustawia sie resources bundles loader.setresources
        return loader;
    }

    public static Scene changeScene(String path) throws IOException {
        Parent parent = fxmlLoader(path).load();

        return new Scene(parent);
    }

    public static void setStage(Stage stage, String path) throws IOException {
        stage.setScene(changeScene(path));
        stage.setTitle("TicTacToe");
        stage.show();
    }
    public static Stage getStage() {
        return stage;
    }


}
