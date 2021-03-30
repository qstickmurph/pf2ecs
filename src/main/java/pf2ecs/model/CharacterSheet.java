package pf2ecs.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import pf2ecs.model.Ability;
import pf2ecs.model.Alignment;
import pf2ecs.model.Scenario;
import pf2ecs.model.Proficiency;
import pf2ecs.model.Size;
import pf2ecs.model.PfClass;
import pf2ecs.model.Ancestry;
import pf2ecs.model.Skill;
import pf2ecs.model.Background;
//import pf2ecs.model.Spell;
import pf2ecs.model.Action;
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

	/** The items in the inventory */
    private ArrayList<PfItem> items;
    
    /** The items equipped */
    private ArrayList<PfItem> equipped;
    
    /** The items invested */
    private ArrayList<PfItem> invested;
    
    /** The items readied */
    private ArrayList<PfItem> readied;
    
    /** The amount of pp */
    private int pp;
    
    /** The amount of gp */
    private int gp;
    
    /** The amount of sp */
    private int sp;
    
    /** The amount of cp */
    private int cp;

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
    private Hashtable<Ability, Integer> attributes;

    /** The character's proficiencies */
    private Hashtable<String, Proficiency> proficiencies;

    /** The character's proficiency item bonuses */
    private Hashtable<String, Integer> itemBonuses;

    /** The character's proficiency circumstance bonuses */
    private Hashtable<String, Integer> circumstanceBonuses;

    /** The ac of the character */
    private int ac;

    /** The character's maxHp */
    private int maxHp;

    /** The character's current hp*/
    private int hp;

    /** The character's temporary hp */
    private int tempHp;

    /** The character's dying condition */
    private int dying;

    /** The character's wouded condition */
    private int wounded;

    /** The character's speed */
    private String speed;

    /** The language the character knows */
    private String languages;

    /**
     * Constructor Method 
     * Creates an empty CharacterSheet with all values initialized.
     */
    public CharacterSheet(){
        this.name = "";
        this.ancestry = new Ancestry();
        this.pfClass = new PfClass();
        this.background = new Background();

        this.items = new ArrayList<PfItem>();
        this.equipped = new ArrayList<PfItem>();
        this.invested = new ArrayList<PfItem>();
        this.readied = new ArrayList<PfItem>();
        this.pp = 0;
        this.gp = 0;
        this.sp = 0;
        this.cp = 0;

        this.actions = new HashSet<>();
        this.feats = new HashSet<>();
        this.xp = 0;
        this.level = 1;
        this.size = Size.MEDIUM;
        this.diety = "";
        this.alignment = Alignment.N;
        this.heroPoints = 0;
        
        this.attributes = new Hashtable<>();
        this.attributes.put(Ability.STR, 10);
        this.attributes.put(Ability.DEX, 10);
        this.attributes.put(Ability.CON, 10);
        this.attributes.put(Ability.INT, 10);
        this.attributes.put(Ability.WIS, 10);
        this.attributes.put(Ability.CHA, 10);

        this.proficiencies = new Hashtable<>();
        this.ac = 0;
        this.maxHp = 0;
        this.hp = 0;
        this.tempHp = 0;
        this.speed = "";
        this.languages = "";
    }   

    public static CharacterSheet fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, CharacterSheet.class);
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new CharacterSheet();
    }

    public static CharacterSheet fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, CharacterSheet.class);
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new CharacterSheet();
    }
    /**
     * Exports the character sheet as a json file
     */
    public void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            File directory = new File("character_sheets");
            if (! directory.exists()){
                directory.mkdir();
            }

            File file = new File("character_sheets/character_sheet.json");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            //writer.write("Heyo");
            gson.toJson(this, writer);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Exports the character sheet as a json file
     */
    public void save(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            //writer.write("Heyo");
            gson.toJson(this, writer);
            writer.close();
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
     * Returns this.items
     *  @return this.items (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getItems(){
        return this.items;
    }

    /** 
     * Adds item to this.items
     * @param item (String)
     */
    
    public void addItem(PfItem pfItem){
    	this.items.add(pfItem);
    }
    
    /** 
     * Removes item from this.items
     * @param item (String)
     */
    public void removeItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.items.remove(pfItem);
    	}
    }

    /** 
     * Returns this.equipped
     *  @return this.equipped (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getEquipped(){
        return this.equipped;
    }
    
    /** 
     * Adds item to this.equipped and removes item from this.items
     * @param item (String)
     */
    public void equipItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.equipped.add(pfItem);
    		this.items.remove(pfItem);
    	}
    }

    /** 
     * Removes item from this.equipped and adds item to this.items
     * @param item (String)
     */
    public void unequipItem(PfItem pfItem){
    	if(this.equipped.contains(pfItem)){
    		this.items.add(pfItem);
    		this.equipped.remove(pfItem);
    	}
    }
    
    /** 
     * Returns this.invested
     *  @return this.invested (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getInvested(){
        return this.invested;
    }
    
    /** 
     * Adds item to this.invested and this.equipped and removes item from this.items
     * @param item (String)
     */
    public void investItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.invested.add(pfItem);
    		this.equipped.add(pfItem);
    		this.items.remove(pfItem);
    	}
    }
    
    /** 
     * Removes item from this.invested and this.equipped and adds item to this.items
     * @param item (String)
     */
    public void uninvestItem(PfItem pfItem){
    	if(this.invested.contains(pfItem)){
    		this.items.add(pfItem);
    		this.invested.remove(pfItem);
    		this.equipped.remove(pfItem);
    	}
    }
    
    /** 
     * Returns this.readied
     *  @return this.readied (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getReadied(){
        return this.readied;
    }
    
    /** 
     * Adds item to this.readied and removes item from this.items
     * @param item (String)
     */
    public void readyItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.readied.add(pfItem);
    		this.items.remove(pfItem);
    	}
    }

    /** 
     * Removes item from this.readied and adds item to this.items
     * @param item (String)
     */
    public void unreadyItem(PfItem pfItem){
    	if(this.readied.contains(pfItem)){
    		this.items.add(pfItem);
    		this.readied.remove(pfItem);
    	}
    }
    
	/**
	 * Getter for this.money.
	 * @return Returns this.money
	 */
	public String getMoney(){
		String money = Integer.toString(pp) + "pp " + Integer.toString(gp) + "gp " + Integer.toString(sp) + "sp " + Integer.toString(cp) + "cp";
		return money;
	}
	
	/**
	 * Setter for this.pp.
	 * @param pp (int) Sets this.pp to pp 
	 */
	public void setPp(int pp){
		this.pp = pp;
	}
	
	/**
	 * Setter for this.gp.
	 * @param gp (int) Sets this.gp to gp 
	 */
	public void setGp(int gp){
		this.gp = gp;
	}
	
	/**
	 * Setter for this.sp.
	 * @param sp (int) Sets this.sp to sp
	 */
	public void setSp(int sp){
		this.sp = sp;
	}
	
	/**
	 * Setter for this.cp.
	 * @param cp (int) Sets this.cp to cp 
	 */
	public void setCp(int cp){
		this.cp = cp;
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
     * @return this.attributes (Hashtable<Ability, Integer>
     */
    public Hashtable<Ability, Integer> getAbilitys(){
        return this.attributes;
    }
    
    /**
     * @param attribute (Ability)
     * @return score (int) 
     */
    public int getAbilityScore(Ability attribute){
        return (int) this.attributes.get(attribute);
    }
    
    /**
     * @param attribute (Ability)
     * @return mod (int)
     */
    public int getAbilityMod(Ability attribute){
        return (int) (this.attributes.get(attribute) - 10)/2;
    }

    /**
     * Setter for this.attributes
     * @param attribute (Ability)
     * @param bonus (int)
     */
    public void setAbilitys(Hashtable<Ability, Integer> attributes){
        this.attributes = attributes;
    }

    /**
     * Sets a attribute
     * @param attribute (Ability)
     * @param bonus (Integer)
     */
    public void setAbility(Ability attribute, Integer bonus){
        this.attributes.put(attribute, bonus);
    }

    /**
     * Getter for this.proficiencies
     * @return this.proficiencies (Hashtable<String, Proficiency>)
     */
    public Hashtable<String, Proficiency> getProficiencies(){
        return this.proficiencies;
    }

    /**
     * Returns the value of this.proficiencies.get(proficiency)
     * @param proficiency (String)
     */
    public Proficiency getProficiency(String proficiency){
        if (this.proficiencies.contains(proficiency)){
            return this.proficiencies.get(proficiency);
        }else{
            return Proficiency.UNTRAINED;
        }
    }

    /**
     * Returns the calculated proficiency modifier of a prof
     * @param proficiency (String)
     */
    public int getProficiencyMod(String proficiency){
        if (this.proficiencies.contains(proficiency)){
            return (this.proficiencies.get(proficiency).bonus + level);
        }else{
            return 0;
        }
    }

    /**
     * Setter for this.proficiencies
     * @param proficiencies (Hashtable<String, Proficiency>)
     */
    public void setProficiencies(Hashtable<String, Proficiency> proficiencies){
        this.proficiencies = proficiencies;
    }

    /**
     * Sets a proficiency bonus
     * @param proficiency (String)
     * @param bonus (Proficiency)
     */
    public void setProficiency(String proficiency, Proficiency bonus){
        this.proficiencies.put(proficiency, bonus);
    }
    
    /**
     * Getter for this.itemBonuses
     * @return this.itemBonuses (Hashtable<String, Proficiency>)
     */
    public Hashtable<String, Integer> getItemBonuses(){
        return this.itemBonuses;
    }

    /**
     * Returns the total item bonus for a proficiency
     * @param proficiency (String)
     */
    public Integer getItemBonus(String proficiency){
        if (this.itemBonuses.contains(proficiency)){
            return this.itemBonuses.get(proficiency);
        }else{
            return 0;
        }
    }

    /**
     * Setter for this.itemBonuses
     * @param itemBonuses (Hashtable<Proficiency, Integer>)
     */
    public void setItemBonuses(Hashtable<String, Integer> itemBonuses){
        this.itemBonuses = itemBonuses;
    }

    /**
     * Sets an item bonus
     * @param proficiency (String)
     * @param bonus (Integer)
     */
    public void setItemBonus(String proficiency, Integer bonus){
        this.itemBonuses.put(proficiency, bonus);
    }

    /**
     * Getter for this.circumstanceBonuses
     * @return this.circumstanceBonuses (Hashtable<String, Integer>)
     */
    public Hashtable<String, Integer> getCircumstanceBonuses(){
        return this.circumstanceBonuses;
    }

    /**
     * Returns the total circumstance bonus for a proficiency
     * @param proficiency (String)
     */
    public int getCircumstanceBonus(String proficiency){
        if (this.circumstanceBonuses.contains(proficiency)){
            return this.circumstanceBonuses.get(proficiency);
        }else{
            return 0;
        }
    }

    /**
     * Setter for this.circumstanceBonuses
     * @param circumstanceBonuses (Hashtable<String, Integer>)
     */
    public void setCircumstanceBonuses (Hashtable<String, Integer> circumstanceBonuses){
        this.circumstanceBonuses = circumstanceBonuses;
    }

    /**
     * Sets a proficiency bonus
     * @param proficiency (String)
     * @param bonus (Integer)
     */
    public void setCircumstanceBonus(String proficiency, Integer bonus){
        this.circumstanceBonuses.put(proficiency, bonus);
    }

    /**
     * Returns the total modifier for a proficiency
     * @param proficiency (String)
     */
    public int getTotalBonus(String proficiency){
        int profBonus = 0;
        int itemBonus = 0;
        int circumBonus = 0;

        if(this.proficiencies.contains(proficiency) && this.proficiencies.get(proficiency) != Proficiency.UNTRAINED){
            profBonus = this.level + this.proficiencies.get(proficiency).bonus;
        }
        if(this.itemBonuses.contains(proficiency)){
            profBonus = this.itemBonuses.get(proficiency);
        }
        if(this.circumstanceBonuses.contains(proficiency)){
            profBonus = this.circumstanceBonuses.get(proficiency);
        }

        return 10 + profBonus + itemBonus + circumBonus;

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

	/**
	 * Getter for this.dying.
	 * @return Returns this.dying.
	 */
	public int getDying(){
		return this.dying;
	}

	/**
	 * Setter for this.dying.
	 * @param dying Sets this.dying to dying 
	 */
	public void setDying(int dying){
		this.dying = dying;
	}

	/**
	 * Getter for this.wounded.
	 * @return Returns this.wounded
	 */
	public int getWounded(){
		return this.wounded;
	}

	/**
	 * Setter for this.wounded.
	 * @param wounded Sets this.wounded to wounded
	 */
	public void setWounded(int wounded){
		this.wounded = wounded;
	}

    public int getAcDexCap(){
        int min = Integer.MAX_VALUE;
        for(PfItem item : this.equipped){
            if(item.getAcDexCap() < min){
                min = item.getAcDexCap();
            }
        }
        return min;
    }
}
