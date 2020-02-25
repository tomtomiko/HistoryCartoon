package Classes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/TitlePage.fxml"));
        primaryStage.setTitle("History Game");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        /*
        Stage stage = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage.setTitle("Show yourself22");
        stage.setScene(new Scene(root2, 600, 400));
        stage.show();
        */

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
