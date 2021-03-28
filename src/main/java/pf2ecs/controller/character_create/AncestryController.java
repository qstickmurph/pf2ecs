package pf2ecs.controller.character_create;

import java.util.ArrayList;
import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;

import pf2ecs.model.Ancestry;

public class AncestryController{

    @FXML
    private ChoiceBox<String> AncestryChoiceBox;

    @FXML
    private ChoiceBox<String> AbilityChoiceBox;

    @FXML
    private ChoiceBox<String> HeritageChoiceBox;

    @FXML
    private ChoiceBox<String> AncestryFeatChoiceBox;

    @FXML
    private ImageView AncestryImage;

    @FXML
    private Button nextButton;

    @FXML
    void ancestryChoiceBoxChosen(InputMethodEvent event) {
        System.out.println("Chosen");
    }

    @FXML
    void abilityChoiceBoxChosen(InputMethodEvent event) {
    }

    @FXML
    void featChoiceBoxChosen(InputMethodEvent event) {

    }

    @FXML
    void heritageChoiceBoxChosen(InputMethodEvent event) {

    }
    
    @FXML
    void nextButtonPressed(ActionEvent event) {

    }
    
    public void initialize(){
        ArrayList<Ancestry> ancestries= new ArrayList<>();
        ArrayList<String> ancestryNames = new ArrayList<>();

        File file = new File("jsonFiles/ancestries/dwarf.json");
        if(file != null){
            Ancestry ancestry = Ancestry.fromFile(file);
            ancestries.add(ancestry);
            ancestryNames.add(ancestry.getName());
        }

        /*try{

        } catch(IOException e){
            e.printStackTrace();
        }
        Ancestry ancestry = Ancestry.readFile("");*/
        ObservableList<String> obsList = FXCollections.observableArrayList(ancestryNames);
        AncestryChoiceBox.setItems(obsList);

        AbilityChoiceBox = new ChoiceBox(FXCollections.observableArrayList("First", "Second", "Third"));

        HeritageChoiceBox = new ChoiceBox(FXCollections.observableArrayList("First", "Second", "Third"));

        AncestryFeatChoiceBox = new ChoiceBox(FXCollections.observableArrayList("First", "Second", "Third"));

   
        AncestryChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                System.out.print("Chosen");
          });

    }
}
