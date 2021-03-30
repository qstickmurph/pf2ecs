package pf2ecs.model;

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

import pf2ecs.model.Action;
import pf2ecs.model.Ability;
//import pf2ecs.model.Spell;


/** The Feat class holds all the information about each feat including its description, any relevant actions or spells, and more
 *
 * @author Quinn Murphey
 * @author David Gellhausen
 * @author Jim Richmond
 * @author Alexander Lomeli-Azoubel
 * @since 03/26/2021
 */
public class Feat {
    
    /** The name of the feat*/
    private String name;

    /** The level of the feat*/
    private int level;

    /** The traits of the feat*/
    private HashSet<String> traits;

    /** The prerequisites of the feat*/
    private HashSet<String> prerequisites;

    /** The description of the feat*/
    private String description;

    /** Whether the feat can be taken multiple times*/
    private boolean multiple;

    /** The attribute bonuses of the feat*/
    private Hashtable<Ability, Integer> attributeBonuses;

    /** The proficiency bonuses of the feat*/
    private Hashtable<String, Proficiency> proficiencyBonuses;

    /** The actions the feat gives */
    private HashSet<Action> actions;

    /** The possible feat choices of this feat */
    private HashSet<Feat> choices;

    /** The Spells the feat give */
//    private HashSet<Spell> spells = new HashSet<Spells>;
    
    /** 
     * Constructor Method
     * Creates an empty Feat
     */
    public Feat(){
        // First, go delete any of the variable initialization that we did earlier (Ex = new Hashtable<String, Integer>)
        // Second, initialize them in this constructor function
        this.name = "";
        this.level = 0;
        this.traits = new HashSet<>();
        this.prerequisites = new HashSet<>();
        this.description = "";
        this.multiple = false;
        this.attributeBonuses = new Hashtable<>();
        this.proficiencyBonuses = new Hashtable<>();
        this.actions = new HashSet<>();
        this.choices = new HashSet<>();
    }
 
    /** 
     * Reads a json file containing a feat and creates that Feat
     * @param file (File)
     */
    public static Feat fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Feat.class);
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new Feat();
    }

    /**
     * Reads a JsonObject and creates that Feat
     * @param json (JsonObject)
     */
    public static Feat fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, Feat.class);
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new Feat();
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
     * Turns this feat into a JsonObject
     */
    public JsonObject toJson(){
        return null;
    }
    
    /** 
     * Returns this.name
     *  @return this.name (String)
     */
    public String getName(){
        return this.name;
    }

    /** 
     * Sets this.name
     * @param name (String)
     */
    public void setName(String name){
        this.name = name;
    }

	/**
	 * Getter for this.level.
	 * @return Returns this.level
	 */
	public int getLevel(){
		return this.level;
	}

	/**
	 * Setter for this.level.
	 * @param level (int) Sets this.level to level
	 */
	public void setName(int level){
		this.level= level;
	}
    
	/**
	 * Getter for this.traits.
	 * @return Returns this.traits.
	 */
	public HashSet<String> getTraits(){
		return this.traits;
	}

	/**
	 * Setter for this.traits.
	 * @param traits (HashSet<String>)
	 */
	public void setTraits(HashSet<String> traits){
		this.traits = traits;
	}
    
	/**
	 * Adds trait to this.traits.
	 * @param trait (String) 
	 */
    public void addTrait(String trait){
        this.traits.add(trait);
    }

	/**
	 * Removes trait from this.trait if present.
	 * @param trait (HashSet<String>)
	 */
    public void removeTrait(String trait){
        if(this.traits.contains(trait)){
            this.traits.remove(trait);
        }
    }

    /**
	 * Getter for this.prerequisites.
	 * @return Returns this.prerequisites.
	 */
	public HashSet<String> getPrerequisite(){
		return this.prerequisites;
	}

	/**
	 * Setter for this.prerequisites.
	 * @param prerequisites (HashSet<String>)
	 */
	public void setPrerequisites(HashSet<String> prerequisites){
		this.prerequisites = prerequisites;
	}
    
	/**
	 * Adds prerequisite to this.prerequisite.
	 * @param prerequisite (String) 
	 */
    public void addPrerequisite(String prerequisite){
        this.prerequisites.add(prerequisite);
    }

	/**
	 * Removes prerequisite from this.prerequisite if present.
	 * @param prerequisite (HashSet<String>)
	 */
    public void removePrerequisite(String prerequisite){
        if(this.prerequisites.contains(prerequisite)){
            this.prerequisites.remove(prerequisite);
        }
    }

	/**
	 * Getter for this.description.
	 * @return Returns this.description
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * Setter for this.description.
	 * @param description (String) Sets this.description to description 
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Getter for this.multiple.
	 * @return Returns this.multiple
	 */
	public boolean getMultiple(){
		return this.multiple;
	}

	/**
	 * Setter for this.multiple.
	 * @param name Sets this.multiple to multiple
	 */
	public void setMultiple(boolean multiple){
		this.multiple = multiple;
	}

	/**
	 * Getter for this.attributeBonuses.
	 * @return Returns this.attributeBonuses
	 */
	public Hashtable<Ability, Integer> getAbilityBonuses(){
		return this.attributeBonuses;
	}

	/**
	 * Setter for this.attributeBonuses.
	 * @param name Sets this.attributeBonuses to attributeBonuses
	 */
	public void setAbilityBonuses(Hashtable<Ability, Integer> attributeBonuses){
		this.attributeBonuses = attributeBonuses;
	}

    /**
	 * Adds attribute, bonus to this.attributeBonuses.
	 * @param attribute (Ability) 
	 * @param bonus (Integer) 
	 */
    public void addAbilityBonus(Ability attribute, Integer bonus){
        this.attributeBonuses.put(attribute, bonus);
    }

	/**
	 * Removes attribute from this.attributeBonuses if present.
	 * @param attribute (Ability)
	 */
    public void removeAbilityBonus(Ability attribute){
        if(this.attributeBonuses.contains(attribute)){
            this.attributeBonuses.remove(attribute);
        }
    }

    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses
	 */
	public Hashtable<String, Proficiency> getProficiencyBonuses(){
		return this.proficiencyBonuses;
	}

	/**
	 * Setter for this.proficiencyBonuses.
	 * @param name Sets this.proficiencyBonuses to proficiencyBonuses */
	public void setProficiencyBonuses(Hashtable<String, Proficiency> proficiencyBonuses){
		this.proficiencyBonuses = proficiencyBonuses;
	}

    /**
	 * Adds proficiency, bonus to this.proficiencyBonuses.
	 * @param proficiency (String) 
	 * @param bonus (Integer) 
	 */
    public void addProficiencyBonus(String proficiency, Proficiency bonus){
        this.proficiencyBonuses.put(proficiency, bonus);
    }

	/**
	 * Removes proficiency from this.proficiencyBonuses if present.
	 * @param proficiency (HashSet<String>)
	 */
    public void removeProficiencyBonus(String proficiency){
        if(this.proficiencyBonuses.contains(proficiency)){
            this.proficiencyBonuses.remove(proficiency);
        }
    }

    /**
	 * Getter for this.actions.
	 * @return Returns this.actions
	 */
	public HashSet<Action> getActions(){
		return this.actions;
	}

	/**
	 * Setter for this.actions.
	 * @param actions Sets this.actions to actions*/
	public void setActions(HashSet<Action> actions){
		this.actions= actions;
	}

    /**
	 * Adds action to this.actions.
	 * @param action (Action) 
	 */
    public void addAction(Action action){
        this.actions.add(action);
    }

	/**
	 * Removes action from this.actions if present.
	 * @param action (Action)
	 */
    public void removeAction(Action action){
        if(this.actions.contains(action)){
            this.actions.remove(action);
        }
    }

    /**
	 * Getter for this.choices.
	 * @return Returns this.choices
	 */
	public HashSet<Feat> getChoices(){
		return this.choices;
	}

	/**
	 * Setter for this.choices.
	 * @param choices Sets this.choices to choices*/
	public void setChoices(HashSet<Feat> choices){
		this.choices = choices;
	}

    /**
	 * Adds action to this.choices.
	 * @param choice (Feat) 
	 */
    public void addAction(Feat choice){
        this.choices.add(choice);
    }

	/**
	 * Removes choices from this.proficiencyBonuses if present.
	 * @param choice (Feat)
	 */
    public void removeChoice(Feat choice){
        if(this.choices.contains(choice)){
            this.choices.remove(choice);
        }
    }
}
