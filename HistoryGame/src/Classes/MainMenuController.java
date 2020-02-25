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



public class MainMenuController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //All the objects I have in my TitlePage.fxml scene
    @FXML
    public Button learnmodelistButton;

    @FXML
    public Button editlistButton;

    @FXML
    public Button testmodelistButton;

    @FXML
    public AnchorPane MainMenuPane;



    //All the ACTIONS I will perform with each of my objects up above and in my TitlePage.fxml file;scene
    @FXML
    public void LearnModeListButton(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewLearnModeListParent = FXMLLoader.load(getClass().getResource("../FXML/LearnModeList.fxml"));
        Scene  viewLearnModeScene = new Scene(viewLearnModeListParent);

        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewLearnModeScene);
        window.show();

    }

    @FXML
    public void TestModeListButton(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewTestModeListParent = FXMLLoader.load(getClass().getResource("../FXML/TestModeList.fxml"));
        Scene  viewTestModeScene = new Scene(viewTestModeListParent);

        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewTestModeScene);
        window.show();

    }

    @FXML
    public void EditListModeButton(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewEditListModeParent = FXMLLoader.load(getClass().getResource("../FXML/EditListMode.fxml"));
        Scene  viewEditListModeScene = new Scene(viewEditListModeParent);

        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewEditListModeScene);
        window.show();

    }
}
