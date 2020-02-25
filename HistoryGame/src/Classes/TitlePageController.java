package Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class TitlePageController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //All the objects I have in my TitlePage.fxml scene
    @FXML
    public Button startButton;

    @FXML
    public AnchorPane AnchorPaneStart;


    //All the ACTIONS I will perform with each of my objects up above and in my TitlePage.fxml file;scene
    @FXML
    public void ButtonStart(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewMainMenuParent = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
        Scene viewMainMenuScene = new Scene(viewMainMenuParent);

        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewMainMenuScene);
        window.show();


    }
}
