package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EditorController implements Initializable {

    //configure the object where I will have symbols, brief interpretation, caption and a picture

    @FXML
    private TextArea briefInterpretationObject;

    @FXML
    private TextArea captionObject;

    @FXML
    private TextArea symbolsObject;

    private Cartoon cartoon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setCartoon(Cartoon cartoon) {
        this.cartoon = cartoon;

        this.refreshForm();
    }

    public void refreshForm() {
        briefInterpretationObject.setText(cartoon.getBriefInterpretation());
        captionObject.setText(cartoon.getCaption());
        symbolsObject.setText(cartoon.getSymbols());
    }

    //All the objects I have in my TitlePage.fxml scene
    @FXML
    public Button homeButton;

    @FXML
    public AnchorPane EditorPane;

    @FXML
    public Button backButton;

    @FXML
    public Button saveButton;


    //All the ACTIONS I will perform with each of my objects up above and in my Edb vitor.fxml file;scene
    @FXML
    public void EditorHomeButton(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewMainMenuParent = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
        Scene viewMainMenuScene = new Scene(viewMainMenuParent);

        //This line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewMainMenuScene);
        window.show();
    }

    @FXML
    public void EditorBackButton(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewMainMenuParent = FXMLLoader.load(getClass().getResource("../FXML/EditListMode.fxml"));
        Scene viewMainMenuScene = new Scene(viewMainMenuParent);

        //This line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewMainMenuScene);
        window.show();
    }

    @FXML
    public void clickSaveButton(ActionEvent event) throws IOException {
        this.cartoon.setCaption(captionObject.getText());
        this.cartoon.setBriefInterpretation(briefInterpretationObject.getText());
        this.cartoon.setSymbols(symbolsObject.getText());

        this.cartoon.saveToTextFile();
    }
}