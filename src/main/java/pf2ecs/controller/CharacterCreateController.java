package pf2ecs.controller;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;

import pf2ecs.model.Ability;
import pf2ecs.model.Alignment;
import pf2ecs.model.Ancestry;
import pf2ecs.model.Background;
import pf2ecs.model.Feat;
import pf2ecs.model.Heritage;
import pf2ecs.model.PfClass;
import pf2ecs.model.PfItem;
import pf2ecs.model.Skill;
import pf2ecs.model.Subclass;

public class CharacterCreateController {
    @FXML
    private GridPane abilityBoostsGrid;
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
    private ChoiceBox<PfClass> classChoiceBox;
    @FXML
    private Label classDescription;
    @FXML
    private Label classKeyAbility;
    @FXML
    private Label classHitPoints;
    @FXML
    private Label classPerception;
    @FXML
    private Label classClassDC;
    @FXML
    private Label classUnarmoredDefense;
    @FXML
    private Label classLightArmor;
    @FXML
    private Label classMediumArmor;
    @FXML
    private Label classHeavyArmor;
    @FXML
    private Label classMartialWeapons;
    @FXML
    private Label classSimpleWeapons;
    @FXML
    private Label classUnarmedAttacks;
    @FXML
    private Label classFortitude;
    @FXML
    private Label classReflex;
    @FXML
    private Label classWill;
    @FXML
    private Label classSkills;
    @FXML
    private Tab subclassTab;
    @FXML
    private Label subclassTypeDescription;
    @FXML
    private Label subclassDescription;
    @FXML
    private ChoiceBox<Subclass> subclassChoiceBox;
    @FXML
    private Tab classFeaturesTab;
    @FXML
    private GridPane classFeaturesGrid;
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

    // Non FXML javafx nodes
    private ChoiceBox<Feat> classLevel1Feat = new ChoiceBox<>();;
    private Label classLevel1FeatDescription = new Label();
    private RowConstraints expandingRowConstraints = new RowConstraints();

    // Non FXML variables
    private ArrayList<Ancestry> ancestries;
    private ArrayList<Background> backgrounds;
    private ArrayList<PfClass> pfClasses;
    private ArrayList<Skill> skills;
    private ArrayList<PfItem> pfItems;

    @FXML
    void overviewTabSelected(ActionEvent event) {

    }

    @FXML
    void createCharacterButtonPressed(ActionEvent event) {

    }

    private void updateClassFeatures(){
        PfClass pfClass = classChoiceBox.getSelectionModel().getSelectedItem();
        if(pfClass == null)
            return;

        this.classFeaturesGrid.setVgap(15);
        // Clear grid
        while(classFeaturesGrid.getRowConstraints().size() > 0){
            this.classFeaturesGrid.getRowConstraints().remove(0);
        }
        this.classFeaturesGrid.getChildren().clear();

        // Place level 1 feat if applicable
        if( pfClass.level1Feat ){
            this.classFeaturesGrid.getRowConstraints().add(expandingRowConstraints);
            this.classFeaturesGrid.add(this.classLevel1Feat, 0, 0);
            this.classLevel1FeatDescription.getStyleClass().add("description");
            this.classFeaturesGrid.add(this.classLevel1FeatDescription, 1, 0);
            ArrayList<Feat> featsList = new ArrayList<>();
            for( Feat feat : pfClass.getFeats() ){
                if( feat.getLevel() <= 1 ){
                    featsList.add(feat);
                }
            }
            ObservableList<Feat> obsFeatsList = FXCollections.observableArrayList(featsList);
            this.classLevel1Feat.setItems(obsFeatsList);

            this.classLevel1Feat.setOnAction((event) -> {
                classLevel1FeatChosen();
            }); 
        }
    
        // Place all other first level class features 
        for( Feat feat : pfClass.getFeatures() ){
            if(feat.getLevel() <= 1){
                    this.classFeaturesGrid.getRowConstraints().add(expandingRowConstraints);
                    int row = this.classFeaturesGrid.getRowCount();
                if( feat.getChoices().isEmpty() ){
                    Label label = new Label();
                    label.setText(feat.getName() + ": ");
                    this.classFeaturesGrid.add(label, 0, row);

                    label = new Label();
                    label.getStyleClass().add("description");
                    label.setText(feat.getDescription());
                    this.classFeaturesGrid.add(label, 1, row);
                } else{
                    ChoiceBox<Feat> featChoiceBox = new ChoiceBox<>();
                    Label label = new Label();

                    this.classFeaturesGrid.add(featChoiceBox, 0, row);
                    this.classFeaturesGrid.add(label, 1, row);

                    ObservableList<Feat> obsChoiceList = FXCollections.observableArrayList(feat.getChoices());
                    featChoiceBox.setItems(obsChoiceList);

                    featChoiceBox.setOnAction((event) -> {
                        Feat choice = featChoiceBox.getSelectionModel().getSelectedItem();
                        if( choice != null )
                            label.setText(choice.getDescription());
                    });
                }
            }
        }

        // Place first level subclass feats
        Subclass subclass = subclassChoiceBox.getSelectionModel().getSelectedItem();
        if( subclass != null ){
            for( Feat feat : subclass.getFeatures() ){
                if(feat.getLevel() <= 1){
                    this.classFeaturesGrid.getRowConstraints().add(expandingRowConstraints);
                    int row = this.classFeaturesGrid.getRowCount();
                    if( feat.getChoices().isEmpty() ){
                        Label label = new Label();
                        label.setText(feat.getName() + ": ");
                        this.classFeaturesGrid.add(label, 0, row);

                        label = new Label();
                        label.setText(feat.getDescription());
                        label.getStyleClass().add("description");
                        this.classFeaturesGrid.add(label, 1, row);
                    } else{
                        ChoiceBox<Feat> featChoiceBox = new ChoiceBox<>();
                        Label label = new Label();

                        this.classFeaturesGrid.add(featChoiceBox, 0, row);
                        this.classFeaturesGrid.add(label, 1, row);

                        ObservableList<Feat> obsChoiceList = FXCollections.observableArrayList(feat.getChoices());
                        featChoiceBox.setItems(obsChoiceList);

                        featChoiceBox.setOnAction((event) -> {
                            Feat choice = featChoiceBox.getSelectionModel().getSelectedItem();
                            if( choice != null )
                                label.setText(choice.getDescription());
                        });
                    }
                }
            }
        }
    }

    private void ancestryChosen(){
        Ancestry ancestry = ancestryChoiceBox.getSelectionModel().getSelectedItem();
        if(ancestry== null)
            return;
        
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
        this.ancestryFeatChoiceBox.getSelectionModel().clearSelection();
        this.ancestryFeatChoiceBox.setItems(obsFeatsList);
        
        ArrayList<Heritage> ancestryHeritages = new ArrayList<>();
        for(Heritage heritage : ancestry.getHeritages()){
            ancestryHeritages.add(heritage);
        }
        ObservableList<Heritage> obsHeritageList = FXCollections.observableArrayList(ancestryHeritages);
        this.heritageChoiceBox.setItems(obsHeritageList);

        // Update ability scores tab
        ArrayList<String> abilities = ancestry.getAbilityBoosts();
        int col = 1;
        for( String ability : abilities ){
            if( col > 5 )
                break;
            ChoiceBox<Ability> abilityChoiceBox = new ChoiceBox<Ability>();
            this.abilityBoostsGrid.add(abilityChoiceBox, col, 0);
            ArrayList<Ability> abilityList = new ArrayList<>();
            for( String substring : ability.split("/") ){
                abilityList.add(Ability.toAbility(substring));
            }
            ObservableList<Ability> obsAbilityList = FXCollections.observableArrayList(abilityList);
            abilityChoiceBox.setItems(obsAbilityList);
            if( abilityList.size() == 1 )
                abilityChoiceBox.getSelectionModel().selectFirst();
            col += 1;
        }
        abilities = ancestry.getAbilityFlaws();
        col = 1;
        for( String ability : abilities ){
            if( col > 5 )
                break;
            ChoiceBox<Ability> abilityChoiceBox = new ChoiceBox<Ability>();
            this.abilityBoostsGrid.add(abilityChoiceBox, col, 1);
            ArrayList<Ability> abilityList = new ArrayList<>();
            for( String substring : ability.split("/") ){
                abilityList.add(Ability.toAbility(substring));
            }
            ObservableList<Ability> obsAbilityList = FXCollections.observableArrayList(abilityList);
            abilityChoiceBox.setItems(obsAbilityList);
            if( abilityList.size() == 1 )
                abilityChoiceBox.getSelectionModel().selectFirst();

            col += 1;
        }

        this.heritageBackgroundTab.setDisable(false);
    }

    private void backgroundChosen(){
        Background background = backgroundChoiceBox.getSelectionModel().getSelectedItem();
        if( background == null )
            return;

        this.backgroundDescription.setText(background.getDescription());

        String abilityBoosts = "";
        for (String ability : background.getAbilityBoosts()) {
            abilityBoosts += ability.substring(0,1).toUpperCase() + ability.substring(1) + ", ";
        }
        this.backgroundAbilityBoosts.setText(abilityBoosts.substring(0, abilityBoosts.length() - 2));

        String skills = "";
        Enumeration enu = background.getProficiencies().keys();
        while( enu.hasMoreElements() ){
            String proficiency = (String) enu.nextElement();
            String[] split = proficiency.split(":");
            if(  split[0].equals("skills") ){
                if( split[1].equals("lore") ){
                    skills += background.getProficiency(proficiency).label + " in " + split[2].substring(0,1).toUpperCase() + split[2].substring(1) + " " + split[1].substring(0,1).toUpperCase() + split[1].substring(1) + ", ";
                }else{
                    skills += background.getProficiency(proficiency).label + " in " + split[1].substring(0,1).toUpperCase() + split[1].substring(1) + ", ";
                }
            }
        }
        this.backgroundProficiencies.setText(skills.substring(0, skills.length() - 2));

        this.backgroundFeat.setText(background.getFeat().getName());

        this.backgroundFeatDescription.setText(background.getFeat().getDescription());

        this.classTab.setDisable(false);

    }

    private void classChosen(){
        PfClass pfClass = classChoiceBox.getSelectionModel().getSelectedItem();
        if(pfClass == null)
            return;

        // Fill labels with class information
        this.classDescription.setText(pfClass.getDescription());

        this.classKeyAbility.setText(pfClass.getKeyAbility().label);

        this.classHitPoints.setText(String.valueOf(pfClass.getHitPoints()));

        this.classPerception.setText(pfClass.getProficiency("saving_throws:perception").label);

        this.classFortitude.setText(pfClass.getProficiency("saving_throws:fortitude").label);

        this.classReflex.setText(pfClass.getProficiency("saving_throws:reflex").label);

        this.classWill.setText(pfClass.getProficiency("saving_throws:will").label);

        // Build string of skill proficiencies

        String skills = "";
        Enumeration enu = pfClass.getProficiencies().keys();
        while( enu.hasMoreElements() ){
            String proficiency = (String) enu.nextElement();
            String[] split = proficiency.split(":");
            if(  split[0].equals("skills") ){
                skills += pfClass.getProficiency(proficiency).label + " in " + split[1].substring(0,1).toUpperCase() + split[1].substring(1) + ", ";
            } }
        this.classSkills.setText(skills.substring(0, skills.length() - 2));

        this.classUnarmedAttacks.setText(pfClass.getProficiency("attacks:unarmed_attacks").label);

        this.classSimpleWeapons.setText(pfClass.getProficiency("attacks:simple_weapons").label);

        this.classMartialWeapons.setText(pfClass.getProficiency("attacks:matrial_weapons").label);

        this.classUnarmoredDefense.setText(pfClass.getProficiency("armor:unarmored_defense").label);

        this.classLightArmor.setText(pfClass.getProficiency("armor:light_armor").label);

        this.classMediumArmor.setText(pfClass.getProficiency("armor:medium_armor").label);

        this.classHeavyArmor.setText(pfClass.getProficiency("armor:heavy_armor").label);

        this.classClassDC.setText(pfClass.getProficiency("class_dc").label);

        this.updateClassFeatures();       



        // Enable subclass tab if applicable, else enable class_features tab
        if( pfClass.hasSubclass() ){
            this.subclassTab.setDisable(false);
            this.classFeaturesTab.setDisable(true);

            this.subclassTypeDescription.setText(pfClass.getSubclassTypeDescription());
            ArrayList<Subclass> subclassList = new ArrayList<>();
            for( Subclass subclass : pfClass.getSubclasses() ){
                subclassList.add(subclass);
            }

            ObservableList<Subclass> obsSubclassList = FXCollections.observableArrayList(subclassList);
            this.subclassChoiceBox.setItems(obsSubclassList);

            this.subclassChoiceBox.setOnAction((event) -> {
                subclassChosen();
            }); 
        }else {
            this.subclassTab.setDisable(true);
            this.classFeaturesTab.setDisable(false);
            this.abilityScoresTab.setDisable(false);
        }
    }

    private void subclassChosen(){
        Subclass subclass = subclassChoiceBox.getSelectionModel().getSelectedItem();
        if( subclass == null )
            return;
        
        // Update description of subclass
        this.subclassDescription.setText(subclass.getDescription());

        // Update class features to include subclass features
        this.updateClassFeatures();       

        // Undisable class features tab
        this.classFeaturesTab.setDisable(false);
        this.abilityScoresTab.setDisable(false);
    }


    private void classLevel1FeatChosen(){
        Feat feat = classLevel1Feat.getSelectionModel().getSelectedItem();
        if( feat == null )
            return;

        this.classLevel1FeatDescription.setText(feat.getDescription());
    }

    public void initialize(){
        this.ancestries = new ArrayList<>();
        this.backgrounds = new ArrayList<>();
        this.pfClasses = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.pfItems = new ArrayList<>();

        //this.expandingRowConstraints.setMinHeight(100);
        this.expandingRowConstraints.setPrefHeight(Control.USE_COMPUTED_SIZE);

        File dir;
        File[] files;

        // Ancestry

        dir = new File("data/ancestries");
        files = dir.listFiles();
        Arrays.sort(files);
        if( files != null){
            for(File file : files){
                Ancestry ancestry = Ancestry.fromFile(file);
                ancestries.add(ancestry);
            }
        }
        
        ObservableList<Ancestry> obsAncestryList = FXCollections.observableArrayList(ancestries);
        this.ancestryChoiceBox.setItems(obsAncestryList);

        this.ancestryChoiceBox.setOnAction((event) -> {
            ancestryChosen();
          }); 

        this.ancestryFeatChoiceBox.setOnAction((event) -> {
            if(this.ancestryFeatChoiceBox.getSelectionModel().getSelectedItem() != null){
                this.ancestryFeatDescription.setText(this.ancestryFeatChoiceBox.getSelectionModel().getSelectedItem().getDescription());
            }else{
                this.ancestryFeatDescription.setText("Ancestry Feat Description");
            }
        });

        this.heritageChoiceBox.setOnAction((event) -> {
            if(this.heritageChoiceBox.getSelectionModel().getSelectedItem() != null){
                this.heritageDescription.setText(this.heritageChoiceBox.getSelectionModel().getSelectedItem().getDescription());
            }else{
                this.heritageDescription.setText("Heritage Description");
            }
        });

        // Read background files

        dir = new File("data/backgrounds");
        files = dir.listFiles();
        Arrays.sort(files);
        if( files != null){
            for(File file : files){
                Background background = Background.fromFile(file);
                backgrounds.add(background);
            }
        }

        ObservableList<Background> obsBackgroundList = FXCollections.observableArrayList(backgrounds);
        this.backgroundChoiceBox.setItems(obsBackgroundList);

        this.backgroundChoiceBox.setOnAction((event) -> {
            backgroundChosen();
        });

        // Read class files

        dir = new File("data/classes");
        files = dir.listFiles();
        Arrays.sort(files);
        if( files != null){
            for(File file : files){
                PfClass pfClass = PfClass.fromFile(file);
                pfClasses.add(pfClass);
            }
        }

        ObservableList<PfClass> obsPfClassesList = FXCollections.observableArrayList(pfClasses);
        this.classChoiceBox.setItems(obsPfClassesList);

        this.classChoiceBox.setOnAction((event) -> {
            classChosen();
        });
        // Read skill files
        // Read item files
    }
}

