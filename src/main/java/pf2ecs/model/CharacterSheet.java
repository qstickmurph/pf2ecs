package pf2ecs.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

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
        
    }

    /**
     * Constructor Method making a CharacterSheet from a json file.
     *
     * @param filename (String) This is the String used to create the character sheet.
     */
    public CharacterSheet(String filename){

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
