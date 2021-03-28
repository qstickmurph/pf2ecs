package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import pf2ecs.model.Action;
import pf2ecs.model.Attribute;
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
    private Hashtable<Attribute, Integer> attributeBonuses;

    /** The proficiency bonuses of the feat*/
    private Hashtable<String, SkillTraining> proficiencyBonuses;

    /** The actions the feat gives */
    private HashSet<Action> actions;

    /** The choices of the feat */
    private HashSet<Feat> choices;

//    private HashSet<Spell> spells = new HashSet<Spells>;
    
    /** 
     * Empty Constructor Method
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
     * Json Reader Constructor Method
     *
     * Parses the feat JsonObject into a Feat object
     * @param json (JsonObject)
     */
    public Feat(JsonObject json){
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
        this.readJson(json);
    }
    
    /**
     * Reads a JsonObject and applies that object to the Feat
     * @param json (JsonObject)
     */
    public void readJson(JsonObject json){
        if(json.has("name")){
            // Put name from json into this.name
            this.name = json.get("name").getAsString();
        }

        if(json.has("level")){
            // Put level from json into this.level 
            this.level = json.get("level").getAsInt();
        }

        if(json.has("traits")){
            // Read the array of Strings 
            JsonArray traitsArray = (JsonArray) json.get("traits");
            for(int i = 0; i < traitsArray.size(); i++){ // put each trait into this.traits
                this.traits.add(traitsArray.get(i).getAsString());
            }
        }
        
        if(json.has("prerequisites")){
            // Read the array of Strings
            JsonArray prerequisitesArray = (JsonArray) json.get("prerequisites");
            for(int i = 0; i < prerequisitesArray.size(); i++){ // put each prerequisite into this.prerequisites
                this.prerequisites.add(prerequisitesArray.get(i).getAsString());
            }
        }
        
        if(json.has("multiple")){
            // Put multiple from json into this.multiple
            this.multiple = Boolean.parseBoolean(json.get("multiple").getAsString());
        }

        if(json.has("ability_boosts")){
            // Read the array of Strings
            JsonArray attributeBonusesArray = (JsonArray) json.get("ability_boosts");
            for(int i = 0; i< attributeBonusesArray.size(); i++){
                // Get next String
                String str = attributeBonusesArray.get(i).getAsString();

                // Set attribute based on str
                Attribute attribute = Attribute.STR;
                switch(str){
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

                if(attributeBonuses.contains(attribute)){ // if already has a bonus on this attribute increment it by 1
                    this.attributeBonuses.put(attribute, this.attributeBonuses.get(attribute) + 1);
                }else{ // else set to 1
                    this.attributeBonuses.put(attribute, 1);
                }
            }
        }

        if(json.has("profiencies")){
            // Read the array of Strings
            JsonArray proficiencyBonusesArray = (JsonArray) json.get("proficiencies");
            for(int i = 0; i < proficiencyBonusesArray.size(); i++){
                // Get next String and split it at '='
                String[] stringArray = (proficiencyBonusesArray.get(i).getAsString()).split("=");

                SkillTraining bonus = SkillTraining.UNTRAINED;
                switch(stringArray[1].charAt(0)){ // set the skill bonus accordingly
                    case 't':
                    case 'T':
                        bonus = SkillTraining.TRAINED;
                        break;
                    case 'e':
                    case 'E':
                        bonus = SkillTraining.EXPERT;
                        break;
                    case 'm':
                    case 'M':
                        bonus = SkillTraining.MASTER;
                        break;
                    case 'l':
                    case 'L':
                        bonus = SkillTraining.LEGENDARY;
                        break;
                }

                // put it into proficiencyBonuses
                this.proficiencyBonuses.put(stringArray[0], bonus);
            }
        }

        if(json.has("actions")){
            // Read the array of Strings
            JsonArray actionsArray = (JsonArray) json.get("actions");
            for(int i = 0; i < actionsArray.size(); i++){
                // Parse action JsonObject
                JsonObject actionJson = (JsonObject) actionsArray.get(i);

                // Create new action based on JsonObject
                Action action = new Action(actionJson);

                // Add action to this.actions
                this.actions.add(action);
            }
        }

        /*
        if(json.has("spells"){
            // Read the array of Strings
            spellsArray = (JsonArray) json.get("spells");
            while(spellsArray.hasNext()){
                // Parse action JsonObject
                JsonObject spellJson = (JsonObject) spellArray.next();

                // Create new spell based on JsonObject
                Spell spell = new Spell(spellJson);

                // Add action to this.actions
                this.spells.add(spell);
            }
        } */
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
	public Hashtable<Attribute, Integer> getAttributeBonuses(){
		return this.attributeBonuses;
	}

	/**
	 * Setter for this.attributeBonuses.
	 * @param name Sets this.attributeBonuses to attributeBonuses
	 */
	public void setAttributeBonuses(Hashtable<Attribute, Integer> attributeBonuses){
		this.attributeBonuses = attributeBonuses;
	}

    /**
	 * Adds attribute, bonus to this.attributeBonuses.
	 * @param attribute (Attribute) 
	 * @param bonus (Integer) 
	 */
    public void addAttributeBonus(Attribute attribute, Integer bonus){
        this.attributeBonuses.put(attribute, bonus);
    }

	/**
	 * Removes attribute from this.attributeBonuses if present.
	 * @param attribute (Attribute)
	 */
    public void removeAttributeBonus(Attribute attribute){
        if(this.attributeBonuses.contains(attribute)){
            this.attributeBonuses.remove(attribute);
        }
    }

    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses
	 */
	public Hashtable<String, SkillTraining> getProficiencyBonuses(){
		return this.proficiencyBonuses;
	}

	/**
	 * Setter for this.proficiencyBonuses.
	 * @param name Sets this.proficiencyBonuses to proficiencyBonuses */
	public void setProficiencyBonuses(Hashtable<String, SkillTraining> proficiencyBonuses){
		this.proficiencyBonuses = proficiencyBonuses;
	}

    /**
	 * Adds proficiency, bonus to this.proficiencyBonuses.
	 * @param proficiency (String) 
	 * @param bonus (Integer) 
	 */
    public void addProficiencyBonus(String proficiency, SkillTraining bonus){
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
