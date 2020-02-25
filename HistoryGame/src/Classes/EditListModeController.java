package Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.naming.PartialResultException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class EditListModeController implements Initializable {
    //All the objects I have in my TitlePage.fxml scene
    @FXML
    public Button homeButton;

    @FXML
    public AnchorPane EditListModePane;

    @FXML
    public Button openEditorButton;

    @FXML
    public Pane pane;

    public ArrayList<Cartoon> cartoons;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cartoons = new ArrayList<Cartoon>();

        cartoons.add(new Cartoon("c1", "s1", "b1", "../Classes/Images/TheHarmonyGuys.png"));
        cartoons.add(new Cartoon("c2", "s2", "b2", "../Classes/Images/TheHarmonyGuys.png"));
        cartoons.add(new Cartoon("c3", "s3", "b3", "../Classes/Images/TheHarmonyGuys.png"));
        cartoons.add(new Cartoon("c4", "s4", "b4", "../Classes/Images/TheHarmonyGuys.png"));
        cartoons.add(new Cartoon("c5", "s5", "b5", "../Classes/Images/TheHarmonyGuys.png"));
        cartoons.add(new Cartoon("c6", "s6", "b6", "../Classes/Images/TheHarmonyGuys.png"));

        GridPane gridPane = new GridPane();

        for (int i = 0; i < cartoons.size(); i++) {
            Cartoon cartoon = cartoons.get(i);

            Button button = new Button();
            button.setText(cartoon.getImageName());

            button.setOnAction(e -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Editor.fxml"));

                    Parent root = (Parent) loader.load();

                    EditorController editorController = loader.getController();
                    editorController.setCartoon(cartoon);

                    Scene viewMainMenuScene = new Scene(root);

                    Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    window.setScene(viewMainMenuScene);
                    window.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            gridPane.add(button, 0, i);
        }

        pane.getChildren().add(gridPane);
    }

    //All the ACTIONS I will perform with each of my objects up above and in my .fxml file;scene
    @FXML
    public void EditListModeButton(ActionEvent event) throws IOException {
        // Button was clicked, do something…

        Parent viewMainMenuParent = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
        Scene viewMainMenuScene = new Scene(viewMainMenuParent);

        //This line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewMainMenuScene);
        window.show();


    }

    @FXML
    public void OpenEditorButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Editor.fxml"));

        Parent root = (Parent) loader.load();

        EditorController editorController = loader.getController();

        Scene viewMainMenuScene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewMainMenuScene);
        window.show();


        // Button was clicked, do something…

        /*
        Parent viewMainMenuParent = FXMLLoader.load(getClass().getResource("../FXML/Editor.fxml"));
        Scene viewMainMenuScene = new Scene(viewMainMenuParent);


        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewMainMenuScene);
        window.show();
        */
    }

}
