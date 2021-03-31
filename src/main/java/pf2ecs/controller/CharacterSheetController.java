package pf2ecs.controller;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import pf2ecs.model.CharacterSheet;
import pf2ecs.model.Ability;
import pf2ecs.model.Alignment;
import pf2ecs.model.Size;
import pf2ecs.model.Skill;

public class CharacterSheetController {
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem openMenuItem;
    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private Label characterName;
    @FXML
    private Label ancestryAndHeritage;
    @FXML
    private Label background;
    @FXML
    private Label classLabel;
    @FXML
    private Label diety;
    @FXML
    private Label size;
    @FXML
    private Label level;
    @FXML
    private Label alignment;
    @FXML
    private Label strengthLabel;
    @FXML
    private Label strengthScore;
    @FXML
    private Label strengthMod;
    @FXML
    private Label dexterityLabel;
    @FXML
    private Label constitutionLabel;
    @FXML
    private Label intelligenceLabel;
    @FXML
    private Label wisdomLabel;
    @FXML
    private Label charismaLabel;
    @FXML
    private Label dexterityScore;
    @FXML
    private Label constitutionScore;
    @FXML
    private Label intelligenceScore;
    @FXML
    private Label wisdomScore;
    @FXML
    private Label charismaScore;
    @FXML
    private Label dexterityMod;
    @FXML
    private Label constitutionMod;
    @FXML
    private Label wisdomMod;
    @FXML
    private Label intelligenceMod;
    @FXML
    private Label charismaMod;
    @FXML
    private Label classDcLabel;
    @FXML
    private Label classDc;
    @FXML
    private Label classKeyAbility;
    @FXML
    private Label fortitudeLabel;
    @FXML
    private Label fortitudeMod;
    @FXML
    private Label reflexLabel;
    @FXML
    private Label willLabel;
    @FXML
    private Label reflexMod;
    @FXML
    private Label willMod;
    @FXML
    private Label perceptionMod;
    @FXML
    private Label perceptionLabel;
    @FXML
    private Label savingThrowsLabel;
    @FXML
    private AnchorPane skillsAnchorPane;
    @FXML
    private GridPane skillsGridPane;
    @FXML
    private Label languagesLabel;
    @FXML
    private Label languages;
    @FXML
    private Label maxHp;
    @FXML
    private Label maxHpLabel;
    @FXML
    private TextField hp;
    @FXML
    private TextField tempHp;
    @FXML
    private TextField xp;
    @FXML
    private Label speed;
    @FXML
    private Label feetLabel;
    @FXML
    private TextArea movementTypes;
    @FXML
    private Label dyingLabel;
    @FXML
    private Label woundedLabel;
    @FXML
    private TextField dying;
    @FXML
    private TextField wounded;
    @FXML
    private TextArea resistances;
    @FXML
    private Label resistancesLabel;
    @FXML
    private Label immunitiesLabel;
    @FXML
    private TextArea immunities;
    @FXML
    private Label conditionsLabel;
    @FXML
    private TextArea conditions;
    @FXML
    private AnchorPane actionsAnchorPane;
    @FXML
    private GridPane actionsGridPane;
    @FXML
    private ToolBar actionsToolBar;
    @FXML
    private AnchorPane featsAnchorPage;
    @FXML
    private ToolBar featsToolBar;
    @FXML
    private GridPane featsGridPane;
    @FXML
    private AnchorPane inventoryAnchorPane;
    @FXML
    private ToolBar inventoryToolBar;
    @FXML
    private GridPane inventoryGridPane;
    @FXML
    private AnchorPane descriptionAnchorPane;
    @FXML
    private ToolBar descriptionToolBar;
    @FXML
    private GridPane descriptionGridPane;
    @FXML
    private TextField heroPoints;

    private CharacterSheet characterSheet;
    final FileChooser fileChooser = new FileChooser();

    @FXML
    void openMenuItemPressed(ActionEvent event) {
        fileChooser.setTitle("Open");
        File file = fileChooser.showOpenDialog(menuBar.getScene().getWindow());
        if(file != null)
            this.characterSheet = CharacterSheet.fromFile(file);
        this.updateFields();
    }

    @FXML
    void saveMenuItemPressed(ActionEvent event) {
        fileChooser.setTitle("Save");
        File file = fileChooser.showSaveDialog(menuBar.getScene().getWindow());
        if(file != null)
            this.characterSheet.save(file);
    }

    public void fillGrids(){
        // Skills
        
        // Clear old
        while(skillsGridPane.getRowConstraints().size() > 0){
            skillsGridPane.getRowConstraints().remove(0);
        }
        
        // Add new
        File dir = new File("data/skills");
        File[] files = dir.listFiles();
        if( files != null){
            for(File file : files){
                Skill skill = Skill.fromFile(file);
                Label label = new Label();
                label.setText(skill.getName());
                this.skillsGridPane.add(label, 1, this.skillsGridPane.getRowCount() + 1);
            }
        }

        // Actions
        // Feats
        // Spells
        //
    }

    public void updateFields(){
        this.characterName.setText(characterSheet.getName());

        //this.ancestryAndHeritage.setText(characterSheet.getAncestry().getHeritage().getName() + " " + characterSheet().getAncestry().getName());
        this.ancestryAndHeritage.setText(characterSheet.getAncestry().getName());

        this.background.setText(characterSheet.getBackground().getName());

        this.classLabel.setText(characterSheet.getPfClass().getName());

        this.diety.setText(characterSheet.getDiety());

        String sizeString;
        switch(characterSheet.getSize()){
            case TINY:
                sizeString = "Tiny";
                break;
            case SMALL:
                sizeString = "Small";
                break;
            case MEDIUM:
                sizeString = "Medium";
                break;
            case LARGE:
                sizeString = "Large";
                break;
            case HUGE:
                sizeString = "Huge";
                break;
            case GARGANTUAN:
                sizeString = "Gargantuan";
                break;
            default:
                sizeString = "NA";
        }
        this.size.setText(sizeString);

        this.level.setText(String.valueOf(characterSheet.getLevel()));
        
        String alignment;
        switch(characterSheet.getAlignment()){
            case LG:
                alignment = "LG";
                break;
            case NG:
                alignment = "NG";
                break;
            case CG:
                alignment = "CG";
                break;
            case LN:
                alignment = "LN";
                break;
            case N:
                alignment = "N";
                break;
            case CN:
                alignment = "CN";
                break;
            case LE:
                alignment = "LE";
                break;
            case NE:
                alignment = "NE";
                break;
            case CE:
                alignment = "CE";
                break;
            default:
                alignment = "";
        }
        this.alignment.setText(alignment);

        //this.strengthLabel;

        this.strengthScore.setText(String.valueOf(characterSheet.getAbilityScore(Ability.STR)));

        this.strengthMod.setText(String.valueOf(characterSheet.getAbilityMod(Ability.STR)));

        //this.dexterityLabel;
        
        this.dexterityScore.setText(String.valueOf(characterSheet.getAbilityScore(Ability.DEX)));

        this.dexterityMod.setText(String.valueOf(characterSheet.getAbilityMod(Ability.DEX)));

        //this.constitutionLabel;
        
        this.constitutionScore.setText(String.valueOf(characterSheet.getAbilityScore(Ability.CON)));

        this.constitutionMod.setText(String.valueOf(characterSheet.getAbilityMod(Ability.CON)));

        //this.intelligenceLabel;

        this.intelligenceScore.setText(String.valueOf(characterSheet.getAbilityScore(Ability.INT)));

        this.intelligenceMod.setText(String.valueOf(characterSheet.getAbilityMod(Ability.INT)));

        //wisdomLabel;

        this.wisdomScore.setText(String.valueOf(characterSheet.getAbilityScore(Ability.WIS)));

        this.wisdomMod.setText(String.valueOf(characterSheet.getAbilityMod(Ability.WIS)));

        //this.charismaLabel;
        
        this.charismaScore.setText(String.valueOf(characterSheet.getAbilityScore(Ability.CHA)));

        this.charismaMod.setText(String.valueOf(characterSheet.getAbilityMod(Ability.CHA)));

        //this.classDcLabel;
        
        this.classDc.setText(String.valueOf(10 + characterSheet.getTotalBonus("class_dc")));

        this.classKeyAbility.setText(String.valueOf(characterSheet.getPfClass().getKeyAbility()));

        //this.savingThrowsLabel;
        
        //this.fortitudeLabel;
        
        this.fortitudeMod.setText(String.valueOf(characterSheet.getProficiencyMod("saving_throws:fortitude")));

        //this.willLabel;
        
        this.willMod.setText(String.valueOf(characterSheet.getProficiencyMod("saving_throws:will")));

        //this.reflexLabel;
        
        this.reflexMod.setText(String.valueOf(characterSheet.getProficiencyMod("saving_throws:reflex")));
        
        //this.perceptionLabel;

        this.perceptionMod.setText(String.valueOf(characterSheet.getProficiencyMod("saving_throws:perception")));

        //this.languagesLabel;

        this.languages.setText(characterSheet.getLanguages());

        this.maxHp.setText(String.valueOf(characterSheet.getMaxHp()));
        //this.maxHpLabel;
        
        this.hp.setText(String.valueOf(characterSheet.getHp()));

        //this.tempHp.setText(String.valueOf(characterSheet.getTempHp()));

        this.xp.setText(String.valueOf(characterSheet.getXp()));

        this.speed.setText(characterSheet.getSpeed());

        //this.feetLabel;
        
        //this.movementTypes;
        
        //this.dyingLabel;
        
        //this.woundedLabel;
        
        this.dying.setText(String.valueOf(characterSheet.getDying()));

        this.wounded.setText(String.valueOf(characterSheet.getWounded()));

        this.heroPoints.setText(String.valueOf(characterSheet.getHeroPoints()));
        
        //this.resistancesLabel;
        
        //this.resistances.setText(characterSheet.getResistances());

        //this.immunitiesLabel;
        
        //this.immunities.setText(characterSheet.getImmunities());

        //this.conditionsLabel;
        
        //this.conditions.setText(characterSheet.getConditions());
        
        /*actionsAnchorPane;
        actionsGridPane;****************************************
        actionsToolBar;*/

        /*featsAnchorPage;
        featsToolBar;****************************************
        featsGridPane;*/

        /*inventoryAnchorPane;
        inventoryToolBar;****************************************
        inventoryGridPane;*/

        /*descriptionAnchorPane;
        descriptionToolBar;****************************************
        descriptionGridPane;*/

        /*skillsAnchorPane;**************************************** 
        skillsGridPane; */ 
            
    }

    public void setCharacterSheet(CharacterSheet cs){
        this.characterSheet = cs;
    }

    public CharacterSheetController(CharacterSheet characterSheet){
        this.characterSheet = characterSheet;
    }

    // called by FXMLLoader to initialize the controller
    public void initialize(){
        this.fillGrids();
        this.updateFields();
    }
}
