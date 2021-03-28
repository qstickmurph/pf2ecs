package pf2ecs.controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import pf2ecs.model.CharacterSheet;
import pf2ecs.model.Attribute;

public class CharacterSheetController {
    
    // GUI controls defined in FXML and used by the controller's code
    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private Label characterNameLabel;

    @FXML
    private Label playerNameLabel;

    @FXML
    private Label ancestryLabel;

    @FXML
    private Label backgroundLabel;

    @FXML
    private Label classLabel;

    @FXML
    private Label acLabel;

    @FXML
    private Label maxHpLabel;

    @FXML
    private TextField hpTextField;

    @FXML
    private TextField tempHpTextField;

    @FXML
    private Label levelLabel;

    @FXML
    private TextField xpTextField;

    @FXML
    private TextField heroPointsTextField;
    
    @FXML
    private Label strengthScoreLabel;

    @FXML
    private Label dexterityScoreLabel;

    @FXML
    private Label constitutionScoreLabel;

    @FXML
    private Label intelligenceScoreLabel;

    @FXML
    private Label wisdomScoreLabel;

    @FXML
    private Label charismaScoreLabel;

    @FXML
    private Label strengthModLabel;

    @FXML
    private Label dexterityModLabel;

    @FXML
    private Label constitutionModLabel;

    @FXML
    private Label intelligenceModLabel;

    @FXML
    private Label wisdomModLabel;

    @FXML
    private Label charismaModLabel;


    private CharacterSheet characterSheet;

    @FXML
    public void saveMenuItemPressed(ActionEvent event) {
        this.characterSheet.saveJson();
    }

    // called by FXMLLoader to initialize the controller
    public void initialize(){
        characterSheet = new CharacterSheet();
        
        // Initialize label and textField values
        characterNameLabel.setText(characterSheet.getName());
        playerNameLabel.setText("Quinn Murphey");
        ancestryLabel.setText(characterSheet.getAncestry().getName());
        backgroundLabel.setText(characterSheet.getBackground().getName());
        classLabel.setText(characterSheet.getPfClass().getName());
        acLabel.setText(String.valueOf(characterSheet.getAc()));
        maxHpLabel.setText(String.valueOf(characterSheet.getMaxHp()));
        hpTextField.setText(String.valueOf(characterSheet.getHp()));
        tempHpTextField.setText(String.valueOf(characterSheet.getTempHp()));
        levelLabel.setText(String.valueOf(characterSheet.getLevel()));
        xpTextField.setText(String.valueOf(characterSheet.getXp()));
        heroPointsTextField.setText(String.valueOf(characterSheet.getHeroPoints()));
        
        strengthScoreLabel.setText(String.valueOf(characterSheet.getAttributeScore(Attribute.STR)));
        dexterityScoreLabel.setText(String.valueOf(characterSheet.getAttributeScore(Attribute.DEX)));
        constitutionScoreLabel.setText(String.valueOf(characterSheet.getAttributeScore(Attribute.CON)));
        intelligenceScoreLabel.setText(String.valueOf(characterSheet.getAttributeScore(Attribute.INT)));
        wisdomScoreLabel.setText(String.valueOf(characterSheet.getAttributeScore(Attribute.WIS)));
        charismaScoreLabel.setText(String.valueOf(characterSheet.getAttributeScore(Attribute.CHA)));

        strengthModLabel.setText(String.valueOf(characterSheet.getAttributeMod(Attribute.STR)));
        dexterityModLabel.setText(String.valueOf(characterSheet.getAttributeMod(Attribute.DEX)));
        constitutionModLabel.setText(String.valueOf(characterSheet.getAttributeMod(Attribute.CON)));
        intelligenceModLabel.setText(String.valueOf(characterSheet.getAttributeMod(Attribute.INT)));
        wisdomModLabel.setText(String.valueOf(characterSheet.getAttributeMod(Attribute.WIS)));
        charismaModLabel.setText(String.valueOf(characterSheet.getAttributeMod(Attribute.CHA)));
    }
}
