package pf2ecs.controller;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import pf2ecs.model.CharacterSheet;

public class BlankController{

    @FXML
    private MenuItem newCharacterSheetMenuButton;

    @FXML
    private MenuItem openMenuButton;

    @FXML
    private MenuItem saveMenuButton;

    @FXML
    private MenuItem quitMenuButton;

    @FXML
    private MenuItem editCharaterMenuButton;

    @FXML
    private MenuItem levelUpMenuButton;

    @FXML
    private MenuItem aboutMenuButton;

    @FXML
    private MenuItem gitHubMenuButton;

    @FXML
    private ImageView image;

    final FileChooser fileChooser = new FileChooser();

    @FXML
    void aboutMenuButtonPressed(ActionEvent event) {

    }

    @FXML
    void editCharaterMenuButtonPressed(ActionEvent event) {

    }

    @FXML
    void gitHubMenuButtonPressed(ActionEvent event) {

    }

    @FXML
    void levelUpMenuButtonPressed(ActionEvent event) {

    }

    @FXML
    void newCharacterSheetMenuButtonPressed(ActionEvent event) {
        try{
            Stage stage = (Stage) image.getScene().getWindow();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pf2ecs/view/Character_Create.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Character Creator");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch( IOException e ){
            e.printStackTrace();
        }

    }

    @FXML
    void openMenuButtonPressed(ActionEvent event) {
        try{
            fileChooser.setTitle("Open");
            CharacterSheet characterSheet;
            Stage stage = (Stage) image.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);
            
            if(file != null){
                characterSheet = CharacterSheet.fromFile(file);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/pf2ecs/view/Character_Sheet.fxml"));
                CharacterSheetController csc = new CharacterSheetController(characterSheet);
                loader.setController(csc);

                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setTitle("Pathfinder 2e Character Sheet");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void quitMenuButtonPressed(ActionEvent event) {

    }

    @FXML
    void saveMenuButtonPressed(ActionEvent event) {

    }

    public void initialize(){

    }

}

