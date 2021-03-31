package pf2ecs.controller;

import java.util.Arrays;
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

import pf2ecs.model.Alignment;
import pf2ecs.model.Ancestry;
import pf2ecs.model.Background;
import pf2ecs.model.Feat;
import pf2ecs.model.Heritage;
import pf2ecs.model.PfClass;
import pf2ecs.model.PfItem;
import pf2ecs.model.Skill;

public class CharacterCreateController {
    @FXML
    private Tab ancestryTab;
    @FXML
    private ChoiceBox<Ancestry> ancestryChoiceBox;
    @FXML
    private Label ancestryDescription;
    @FXML
    private ChoiceBox<Feat> ancestryFeatChoiceBox;
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
    private ChoiceBox<Heritage> heritageChoiceBox;
    @FXML
    private Label heritageDescription;
    @FXML
    private ChoiceBox<Background> backgroundChoiceBox;
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
    private ChoiceBox<Feat> classLevel1Feat;
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
    private ChoiceBox<Alignment> alignmentChoiceBox;
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
        Ancestry ancestry = ancestryChoiceBox.getSelectionModel().getSelectedItem();
        
        this.ancestryDescription.setText(ancestry.getDescription());

        this.ancestryHitPoints.setText(String.valueOf(ancestry.getHitPoints()));

        this.ancestrySize.setText(ancestry.getSize().label);

        this.ancestrySpeed.setText(ancestry.getSpeed());

        String languages = "";
        for (String language : ancestry.getLanguages()) {
            languages += language.substring(0,1).toUpperCase() + language.substring(1) + ", ";
        }
        this.ancestryLanguages.setText(languages);
    
        String abilityBoosts = "";
        for (String ability : ancestry.getAbilityBoosts()) {
            abilityBoosts += ability.substring(0,1).toUpperCase() + ability.substring(1) + ", ";
        }
        abilityBoosts = abilityBoosts.substring(0, abilityBoosts.length() - 2);
        this.ancestryAbilityBoosts.setText(abilityBoosts);

        String abilityFlaws= "";
        for (String ability : ancestry.getAbilityFlaws()) {
            abilityFlaws += ability.substring(0,1).toUpperCase() + ability.substring(1) + ", ";
        }
        abilityFlaws= abilityFlaws.substring(0, abilityFlaws.length() - 2);
        this.ancestryAbilityFlaws.setText(abilityFlaws);
        
        String traits= "";
        for (String trait: ancestry.getTraits()) {
            traits += trait.substring(0,1).toUpperCase() + trait.substring(1) + ", ";
        }
        traits = traits.substring(0, traits.length() - 2);
        this.ancestryTraits.setText(traits);

        String features = "";
        for (Feat feature : ancestry.getFeatures()) {
            String featureName = feature.getName();
            features += featureName.substring(0,1).toUpperCase() + featureName.substring(1) + ", ";
        }
        this.ancestryFeatures.setText(features);
        
        ArrayList<Feat> ancestryFeats = new ArrayList<>();
        for(Feat feat : ancestry.getFeats()){
            if(feat.getLevel() == 1){
                ancestryFeats.add(feat);
            }
        }
        ObservableList<Feat> obsFeatsList = FXCollections.observableArrayList(ancestryFeats);
        this.ancestryFeatChoiceBox.setItems(obsFeatsList);
        
        ArrayList<Heritage> ancestryHeritages = new ArrayList<>();
        for(Heritage heritage : ancestry.getHeritages()){
            ancestryHeritages.add(heritage);
        }
        ObservableList<Heritage> obsHeritageList = FXCollections.observableArrayList(ancestryHeritages);
        this.heritageChoiceBox.setItems(obsHeritageList);


    }

    public void initialize(){
        this.ancestries = new ArrayList<>();
        this.backgrounds = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.items = new ArrayList<>();
        File dir;
        File[] files;

        // Read ancestry files

        dir = new File("data/ancestries");
        files = dir.listFiles();
        Arrays.sort(files);
        if( files != null){
            for(File file : files){
                Ancestry ancestry = Ancestry.fromFile(file);
                ancestries.add(ancestry);
            }
        }
        
        ObservableList<Ancestry> obsList = FXCollections.observableArrayList(ancestries);
        this.ancestryChoiceBox.setItems(obsList);

        this.ancestryChoiceBox.setOnAction((event) -> {
            ancestryChosen();
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

