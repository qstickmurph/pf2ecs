package pf2ecs.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pf2ecs.model.Attribute;
import pf2ecs.model.Alignment;
import pf2ecs.model.Scenario;
import pf2ecs.model.SkillTraining;
import pf2ecs.model.Size;
import pf2ecs.model.PfClass;
import pf2ecs.model.Ancestry;
import pf2ecs.model.Skill;
import pf2ecs.model.Background;
//import pf2ecs.model.Spell;
import pf2ecs.model.Action;
import pf2ecs.model.Inventory;
import pf2ecs.model.Feat;

/** The CharacterSheet class holds all the information about a character
  *
  * @author Quinn Murphey
  * @author David Gellhausen
  * @author Jim Richmond
  * @author Alexander Lomeli-Azoubel
  * @since 03/26/2021
  */
public class CharacterSheet {
    /** Holds the name of the character */
    private String name;

    /** The Ancestry object of the character */
    private Ancestry ancestry;

    /** The PfClass object of the character */
    private PfClass pfClass;

    /** The Background object of the character */
    private Background background;

    /** The character's inventory */
    private Inventory inventory;

    /** The actions the player has */
    private HashSet<Action> actions;

    /** The feats the player has */
    private HashSet<Feat> feats;

    /** The character's xp */
    private int xp;

    /** The character's level */
    private int level;

    /** The character's size */
    private Size size;

    /** The diety of the character */
    private String diety;

    /** The character's alignment */
    private Alignment alignment;

    /** The hero points of the character */
    private int heroPoints;

    /** The character's attributes */
    private Hashtable<Attribute, Integer> attributes;

    /** The character's proficiencies */
    private Hashtable<String, Integer> proficiencies;

    /** The ac of the character */
    private int ac;

    /** The character's maxHp */
    private int maxHp;

    /** The character's current hp*/
    private int hp;

    /** The character's temporary hp */
    private int tempHp;

    /** The character's speed */
    private String speed;

    /** The language the character knows */
    private String languages;

    /**
     * Constructor Method default
     *
     * @param name (String)
     */
    public CharacterSheet(){
        this.name = "";
        this.ancestry = new Ancestry();
        this.pfClass = new PfClass();
        this.background = new Background();
        this.inventory = new Inventory();
        this.actions = new HashSet<>();
        this.feats = new HashSet<>();
        this.xp = 0;
        this.level = 1;
        this.size = Size.MEDIUM;
        this.diety = "";
        this.alignment = Alignment.N;
        this.heroPoints = 0;
        
        this.attributes = new Hashtable<>();
        this.attributes.put(Attribute.STR, 10);
        this.attributes.put(Attribute.DEX, 10);
        this.attributes.put(Attribute.CON, 10);
        this.attributes.put(Attribute.INT, 10);
        this.attributes.put(Attribute.WIS, 10);
        this.attributes.put(Attribute.CHA, 10);

        this.proficiencies = new Hashtable<>();
        this.ac = 0;
        this.maxHp = 0;
        this.hp = 0;
        this.tempHp = 0;
        this.speed = "";
        this.languages = "";
    }

    public static PfClass fromJson(JsonObject json){
        Gson gson = new Gson();
        return gson.fromJson(json, PfClass.class);
    }
/*   
    /
     * Reads a JsonObject and applies the changes to the CharacterSheet object
     * @param json (JsonObject)
     /
    public void readJson(JsonObject json){
        if(json.has("name")){
            // Put name from json into this.name
            this.name = json.get("name").getAsString();
        }

        this.ancestry.readJson(json);
        this.pfClass.readJson(json);
        this.background.readJson(json);
        this.inventory.readJson(json);
        
        if(json.has("actions")){
            // Read the array of actions
            JsonArray actionsArray = (JsonArray) json.get("actions");
            for(int i = 0; i < actionsArray.size(); i++){
                // create JsonObject from actionsArray
                JsonObject actionJson = (JsonObject) actionsArray.get(i);

                // create Action from actionJson
                Action action = new Action(actionJson);

                // add action to this.actions
                this.actions.add(action);
            }

        }

        if(json.has("feats")){
            // Read the array of feats 
            JsonArray featsArray = (JsonArray) json.get("feats");
            for(int i = 0; i < featsArray.size(); i++){
                // create JsonObject from featsArray
                JsonObject featJson = (JsonObject) featsArray.get(i);

                // create Feat from featJson
                Feat feat = new Feat(featJson);

                // add feat to this.feats
                this.feats.add(feat);
            }

        }

        if(json.has("xp")){
            // Put xp from json into this.xp
            this.xp = json.get("xp").getAsInt();
        }

        if(json.has("level")){
            // Put level from json into this.level 
            this.level = json.get("level").getAsInt();
        }

        if(json.has("size")){
            // Put size from json into this.size
            String sizeString = json.get("size").getAsString();
            Size size = this.size;
            switch(sizeString){
                case "tiny":
                    size = Size.TINY;
                    break;
                case "small":
                    size = Size.SMALL;
                    break;
                case "medium":
                    size = Size.MEDIUM;
                    break;
                case "large":
                    size = Size.LARGE;
                    break;
                case "huge":
                    size = Size.HUGE;
                    break;
                case "gargantuan":
                    size = Size.GARGANTUAN;
                    break;
            }
            this.size = size;
        }

        if(json.has("alignment")){
            // Put alignment from json into this.alignment
            String alignmentString = json.get("alignment").getAsString();
            Alignment alignment = this.alignment;
            switch(alignmentString){
                case "lg":
                    alignment = Alignment.LG;
                    break;
                case "ng":
                    alignment = Alignment.NG;
                    break;
                case "cg":
                    alignment = Alignment.CG;
                    break;
                case "ln":
                    alignment = Alignment.LN;
                    break;
                case "n":
                    alignment = Alignment.N;
                    break;
                case "cn":
                    alignment = Alignment.CN;
                    break;
                case "le":
                    alignment = Alignment.LE;
                    break;
                case "ne":
                    alignment = Alignment.NE;
                    break;
                case "ce":
                    alignment = Alignment.CE;
                    break;
            }

            this.alignment = alignment;
        }

        if(json.has("diety")){
            // Put diety from json into this.diety
            this.diety = json.get("diety").getAsString();
        }

        if(json.has("heroPoints")){
            // Put level from json into this.level 
            this.heroPoints = json.get("heroPoints").getAsInt();
        }

        if(json.has("attributes")){
            JsonArray attributesArray = (JsonArray) json.get("attributes");

            for(int i = 0; i < attributesArray.size(); i++){
                // Get next String
                String[] stringArray = attributesArray.get(i).getAsString().split("=");

                // Set attribute based on stringArray 
                Attribute attribute = Attribute.STR;
                switch(stringArray[0]){
                    case "strength":
                        attribute = Attribute.STR;
                        break;
                    case "dexterity":
                        attribute = Attribute.DEX;
                        break;
                    case "constitution":
                        attribute = Attribute.CON;
                        break;
                    case "intelligence":
                        attribute = Attribute.INT;
                        break;
                    case "wisdom":
                        attribute = Attribute.WIS;
                        break;
                    case "charisma":
                        attribute = Attribute.CHA;
                        break;
                }
                
                int score = Integer.parseInt(stringArray[1]);

                this.attributes.put(attribute, score);
            }
        }

        if(json.has("ac")){
            // Put level from json into this.level 
            this.ac = json.get("ac").getAsInt();
        }

        if(json.has("maxHp")){
            // Put maxHp from json into this.maxHp
            this.maxHp = json.get("maxHp").getAsInt();
        }

        if(json.has("hp")){
            // Put hp from json into this.hp
            this.hp = json.get("hp").getAsInt();
        }

        if(json.has("tempHp")){
            // Put tempHp from json into this.tempHp
            this.tempHp = json.get("tempHp").getAsInt();
        }

        if(json.has("speed")){
            // Put speed from json into this.speed
            this.speed= json.get("speed").getAsString();
        }
        
        if(json.has("languages")){
            // Put languages from json into this.languages
            this.languages = json.get("languages").getAsString();
        }
    }
  */  
    /**
     * Exports the character sheet as a json file
     */
    public void saveJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            File directory = new File("character_sheets");
            if (! directory.exists()){
                directory.mkdir();
            }

            File file = new File("character_sheets/character_sheet.json");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Heyo");
            //gson.toJson(this, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Getter for this.name
     * @return this.name (String)
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Setter for this.name
     * @param name (String)
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Getter for this.ancestry
     * @return this.ancestry (Ancestry)
     */
    public Ancestry getAncestry(){
        return this.ancestry;
    }

    /**
     * Setter for this.ancestry
     * @param ancestry (Ancestry)
     */
    public void setAncestry(Ancestry ancestry){
        this.ancestry = ancestry;
    }
    
    /**
     * Getter for this.pfClass
     * @return this.pfClass (PrClass)
     */
    public PfClass getPfClass(){
        return this.pfClass;
    }

    /**
     * Settter for this.PfClass
     * @param pfClass (PfClass)
     */
    public void setPfClass(PfClass pfClass){
        this.pfClass = pfClass;
    }

    /**
     * Getter for this.background
     * @return this.background (Background)
     */
    public Background getBackground(){
        return this.background;
    }
    
    /**
     * Setter for this.background
     * @param background (Background)
     */
    public void setBackground(Background background){
        this.background = background;
    }

    /**
     * Getter for this.inventory
     * @return this.inventory (Inventory)
     */
    public Inventory getInventory(){
        return this.inventory;
    }
    
    /**
     * Setter for this.inventory
     * @param inventory (Inventory)
     */
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    
    /**
     * Getter for this.actions
     * @return this.actions (HashSet<Action>)
     */
    public HashSet<Action> getActions(){
        return this.actions;
    }
    
    /**
     * Setter for this.actions
     * @param actions (HashSet<Action>)
     */
    public void setActions(HashSet<Action> actions){
        this.actions = actions;
    }
    
    /**
     * Adds an action to this.actions
     * @param action (Action)
     */
    public void addAction(Action action){
        this.actions.add(action);
    }
    
    /**
     * Removes an action from this.actions;
     * @param action (Action)
     */
    public void removeAction(Action action){
        if(this.actions.contains(action)){
            this.actions.remove(action);
        }
    }

    /**
     * Getter for this.feats
     * @return this.feats (HashSet<Feat>)
     */
    public HashSet<Feat> getFeats(){
        return this.feats;
    }
    
    /**
     * Setter for this.feats
     * @param feats (HashSet<Feat> feats)
     */
    public void setFeats(HashSet<Feat> feats){
        this.feats = feats;
    }
    
    /**
     * Adds a feat to this.feats
     * @param feat (Feat)
     */
    public void addFeat(Feat feat){
        this.feats.add(feat);
    }

    /**
     * Removes a feat from this.feats
     * @param feat (Feat)
     */
    public void removeFeat(Feat feat){
        if(this.feats.contains(feat)){
            this.feats.remove(feat);
        }
    }

    /**
     * Getter for this.xp
     * @return this.xp (int)
     */
    public int getXp(){
        return this.xp;
    }

    /**
     * Setter for this.xp;
     * @param xp (int)
     */
    public void setXp(int xp){
        this.xp = xp;
    }

    /**
     * Getter for this.level
     * @return this.getLevel (int)
     */
    public int getLevel(){
        return this.level;
    }
    
    /**
     * Setter for this.level
     * @param level (int)
     */
    public void setLevel(int level){
        this.level = level;
    }

    /**
     * Getter for this.size
     * @return this.size (Size)
     */
    public Size getSize(){
        return this.size;
    }

    /**
     * Setter for this.size
     * @param size (Size)
     */
    public void setSize(Size size){
        this.size = size;
    }

    /**
     * Getter for this.diety
     * @return this.diety (String)
     */
    public String getDiety(){
        return this.diety;
    }

    /**
     * Setter for this.diety
     * @param diety (String)
     */
    public void setDiety(String diety){
        this.diety = diety;
    }

    /**
     * Getter for this.alignment
     * @return alignment (Alignment)
     */
    public Alignment getAlignment(){
        return this.alignment;
    }

    /**
     * Setter for this.alignment
     * @param alignment (Alignment)
     */
    public void setAlignment(Alignment alignment){
        this.alignment = alignment;
    }

    /**
     * Getter for this.heroPoints
     * @return this.heroPoints (int)
     */
    public int getHeroPoints(){
        return this.heroPoints;
    }

    /**
     * Setter for this.heroPoints
     * @param heroPoints (int)
     */
    public void setHeroPoints(int heroPoints){
        this.heroPoints = heroPoints;
    }

    /**
     * Getter for this.attributes
     * @return this.attributes (Hashtable<Attribute, Integer>
     */
    public Hashtable<Attribute, Integer> getAttributes(){
        return this.attributes;
    }
    
    /**
     * @param attribute (Attribute)
     * @return score (int) 
     */
    public int getAttributeScore(Attribute attribute){
        return (int) this.attributes.get(attribute);
    }
    
    /**
     * @param attribute (Attribute)
     * @return mod (int)
     */
    public int getAttributeMod(Attribute attribute){
        return (int) (this.attributes.get(attribute) - 10)/2;
    }

    /**
     * Setter for this.attributes
     * @param attribute (Attribute)
     * @param bonus (int)
     */
    public void setAttributes(Hashtable<Attribute, Integer> attributes){
        this.attributes = attributes;
    }

    /**
     * Sets a attribute
     * @param attribute (Attribute)
     * @param bonus (Integer)
     */
    public void setAttribute(Attribute attribute, Integer bonus){
        this.attributes.put(attribute, bonus);
    }

    /**
     * Getter for this.proficiencies
     * @return this.proficiencies (Hashtable<String, Integer>)
     */
    public Hashtable<String, Integer> getProficiencies(){
        return this.proficiencies;
    }

    /**
     * Setter for this.proficiencies
     * @param proficiencies (Hashtable<String, Integer>)
     */
    public void setProficiencies(Hashtable<String, Integer> proficiencies){
        this.proficiencies = proficiencies;
    }

    /**
     * Sets a proficiency bonus
     * @param proficiency (String)
     * @param bonus (Integer)
     */
    public void setProficiency(String proficiency, Integer bonus){
        this.proficiencies.put(proficiency, bonus);
    }

    /**
     * Getter for this.ac
     * @return this.ac (int)
     */
    public int getAc(){
        return this.ac;
    }

    /**
     * Setter for this.ac
     * @param ac (int)
     */
    public void setAc(int ac){
        this.ac = ac;
    }

    /**
     * Getter for this.maxHp
     * @return this.maxHp (int)
     */
    public int getMaxHp(){
        return this.maxHp;
    }

    /**
     * Getter for this.hp
     * @return hp (int)
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * Setter for this.hp
     * @param hp (int)
     */
    public void setHp(int hp){
        this.hp = hp;
    }

    /**
     * Getter for this.tempHp
     * @return tempHp (int)
     */
    public int getTempHp(){
        return this.tempHp;
    }

    /**
     * Setter for this.tempHp
     * @param tempHp (int)
     */
    public void setTempHp(){
        this.tempHp = tempHp;
    }

    /**
     * Getter for this.speed;
     * @return this.speed (String)
     */
    public String getSpeed(){
        return this.speed;
    }

    /**
     * Getter for this.speed;
     * @return speed (String)
     */
    public void getSpeed(String speed){
        this.speed = speed;
    }

    /**
     * Getter for this.languages
     * @return this.languages (String)
     */
    public String getLanguages(){
        return this.languages;
    }

    /**
     * Setter for this.languages
     * @param languages (String)
     */
    public void setLanguages(String languages){
        this.languages = languages;
    }
}
