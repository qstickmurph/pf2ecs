package pf2ecs.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;

import pf2ecs.model.Ancestry;
import pf2ecs.model.Background;
import pf2ecs.model.PfClass;
import pf2ecs.model.Skill;
import pf2ecs.model.PfItem;

public class CharacterCreateController {
    @FXML
    private Tab ancestryTab;
    @FXML
    private ChoiceBox<Ancestry> ancestryChoiceBox;
    @FXML
    private Label ancestryDescription;
    @FXML
    private ChoiceBox<String> ancestryFeatChoiceBox;
    @FXML
    private Label ancestryFeatDescription;
    @FXML
    private Label ancestryHitPoints;
    @FXML
    private Label ancestrySize;
    @FXML
    private Label ancestrySpeed;
    @FXML
    private Label ancestryLanguages;
    @FXML
    private Label ancestryAbilityBoosts;
    @FXML
    private Label ancestryAbilityFlaws;
    @FXML
    private Label ancestryTraits;
    @FXML
    private Label ancestryFeatures;
    @FXML
    private Tab heritageBackgroundTab;
    @FXML
    private ChoiceBox<String> heritageChoiceBox;
    @FXML
    private Label heritageDescription;
    @FXML
    private ChoiceBox<String> backgroundChoiceBox;
    @FXML
    private Label backgroundDescription;
    @FXML
    private Label backgroundAbilityBoosts;
    @FXML
    private Label backgroundProficiencies;
    @FXML
    private Label backgroundFeat;
    @FXML
    private Label backgroundFeatDescription;
    @FXML
    private Tab classTab;
    @FXML
    private ChoiceBox<String> classChoiceBox;
    @FXML
    private Label classDescription;
    @FXML
    private Label classKeyAbility;
    @FXML
    private Label classHitPoints;
    @FXML
    private Tab classFeaturesTab;
    @FXML
    private GridPane classFeaturesGrid;
    @FXML
    private ChoiceBox<String> classLevel1Feat;
    @FXML
    private Label classLevel1FeatDescription;
    @FXML
    private Tab abilityScoresTab;
    @FXML
    private Label strength;
    @FXML
    private Label dexterity;
    @FXML
    private Label constitution;
    @FXML
    private Label intelligence;
    @FXML
    private Label wisdom;
    @FXML
    private Label charisma;
    @FXML
    private Tab skillsTab;
    @FXML
    private Tab spellsTab;
    @FXML
    private Tab equipmentTab;
    @FXML
    private Tab descriptionTab;
    @FXML
    private TextField charactedName;
    @FXML
    private TextField playerName;
    @FXML
    private TextField diety;
    @FXML
    private TextField gender;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private ChoiceBox<?> alignmentChoiceBox;
    @FXML
    private TextField hair;
    @FXML
    private TextField skin;
    @FXML
    private TextField eyes;
    @FXML
    private TextField age;
    @FXML
    private TextArea personalityTraits;
    @FXML
    private TextArea ideals;
    @FXML
    private TextArea bonds;
    @FXML
    private TextArea flaws;
    @FXML
    private TextArea appearanceContinued;
    @FXML
    private Tab notesTab;
    @FXML
    private Tab overviewTab;
    @FXML
    private Button createCharacterButton;
    @FXML
    private Label overviewStrength;
    @FXML
    private Label overviewDexterity;
    @FXML
    private Label overviewConstitution;
    @FXML
    private Label overviewIntelligence;
    @FXML
    private Label overviewWisdom;
    @FXML
    private Label overviewCharisma;
    @FXML
    private Label overviewFortitude;
    @FXML
    private Label overviewReflex;
    @FXML
    private Label overviewWill;
    @FXML
    private Label overviewPerception;
    @FXML
    private GridPane overviewSkillsGrid;
    @FXML
    private Label overviewHitPoints;
    @FXML
    private Label overviewWorth;
    @FXML
    private Label overviewClass;
    @FXML
    private Label overviewAncestry;
    @FXML
    private Label overviewClassFeat;
    @FXML
    private Label overviewBackground;
    @FXML
    private Label overviewAncestryFeat;
    @FXML
    private Label overviewHeritage;

    // Non FXML variables
    private ArrayList<Ancestry> ancestries;
    private ArrayList<Background> backgrounds;
    private ArrayList<PfClass> classes;
    private ArrayList<Skill> skills;
    private ArrayList<PfItem> items;

    void abilityScoresTabSelected() {

    }

    void ancestryTabSelection() {

    }

    void classFeaturesTabSelected() {

    }

    void classTabSelected() {

    }

    void descriptionTabSelected() {

    }

    void heritageBackgroundTabSelected() {

    }

    void notesTabSelected() {

    }

    void overviewTabSelected() {

    }

    void skillsTabSelected() {

    }

    void spellsTabSelected() {

    }

    @FXML
    void createCharacterButtonPressed(ActionEvent event) {

    }

    private void ancestryChosen(){
        
    }

    public void initialize(){
        this.ancestries = new ArrayList<>();
        this.backgrounds = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.items = new ArrayList<>();
        File dir;
        File file;

        // Read ancestry files

        file = new File("data/ancestries/dwarf.json");
        ArrayList<String> ancestryNames = new ArrayList<>();
        if(file != null){
            Ancestry ancestry = Ancestry.fromFile(file);
            ancestries.add(ancestry);
        }
        
        ObservableList<Ancestry> obsList = FXCollections.observableArrayList(ancestries);
        this.ancestryChoiceBox.setItems(obsList);

        this.ancestryChoiceBox.setOnAction((event) -> {
                Ancestry ancestry = ancestryChoiceBox.getSelectionModel().getSelectedItem();
                this.ancestryHitPoints.setText(String.valueOf(ancestry.getHitPoints()));
          }); 
   
        /*this.ancestryChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                Ancestry ancestry = ancestryChoiceBox.getSelectionModel().getSelectedItem();
                this.ancestryHitPoints.setText(String.valueOf(ancestry.getHitPoints()));
          }); */
      
        // Read background files
        // Read class files
        // Read skill files
        // Read item files
    }
}

