package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

/** The Class class holds all the information about class including its hitpoints, key attribute, and more.
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class PfClass {

	/** The name of the class */
	private String name;
	
	/** The hitpoints of the class */
	private int hitpoints;
	
	/** The keyAttribute of the class */
	private Attribute keyAttribute;
	
	/** The proficiency bonuses of the class */
	private Hashtable<String, SkillTraining> proficiencyBonuses;
	
	/** The number of free skills of the class */
	private int freeSkills;
	
	/** The subclasses of the class */
	private HashSet<Subclass> subclasses;
	
	/** The features of the class */
	private HashSet<Feat> features;

	/**  
     *  Empty Constructor Method
     */
    public PfClass(){
        this.name = "";
        this.hitpoints = 0;
    	this.keyAttribute = null;
    	this.proficiencyBonuses = new Hashtable<>();
    	this.freeSkills = 0;
    	this.subclasses = new HashSet<>();
    	this.features = new HashSet<>();
    }
    
	/** Json Constructor Method
     *  @param json (JsonObject)
     */
    public PfClass(JsonObject json){
    	this.name = "";
        this.hitpoints = 0;
    	this.keyAttribute = null;
    	this.proficiencyBonuses = new Hashtable<>();
    	this.freeSkills = 0;
    	this.subclasses = new HashSet<>();
    	this.features = new HashSet<>();
    	this.readJson(json);
    }

	/** Json read
     *  
     *  @param json (JsonObject)
     */
    public void readJson(JsonObject json){
    	if(json.has("name")){
            // Put name from json into this.name
            this.name = json.get("name").getAsString();
        }

    	if(json.has("hitpoints")){
            // Put hitpoints from json into this.hitpoints 
            this.hitpoints = json.get("hitpoints").getAsInt();
        }
    	
    	if(json.has("key_ability")){
            // Read the key attribute
             String keyAbility = json.get("key_ability").getAsString();

                // Set attribute based on str
                Attribute attribute = Attribute.STR;
                switch(keyAbility){
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

                
                this.keyAttribute = attribute;              
                
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
    	
    	if(json.has("free_skills")){
            // Put free skills from json into this.freeSkills 
            this.freeSkills = json.get("free_skills").getAsInt();
        }
    	
    	if(json.has("subclasses")){
            // Read the array of Strings
            JsonArray subclassesArray = (JsonArray) json.get("subclasses");
            for(int i = 0; i < subclassesArray.size(); i++){
                // Parse subclass JsonObject
                JsonObject subclassJson = (JsonObject) subclassesArray.get(i);

                // Create new subclass based on JsonObject
                Subclass subclass = new Subclass(subclassJson);

                // Add subclass to this.subclasses
                this.subclasses.add(subclass);
            }
        }
    	
    	if(json.has("features")){
            // Read the array of Strings
            JsonArray featuresArray = (JsonArray) json.get("features");
            for(int i = 0; i < featuresArray.size(); i++){
                // Parse feat JsonObject
                JsonObject featureJson = (JsonObject) featuresArray.get(i);

                // Create new feat based on JsonObject
                Feat feature = new Feat(featureJson);

                // Add feat to this.features
                this.features.add(feature);
            }
        }
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
     * Returns this.hitpoints
     *  @return this.hitpoints (int)
     */
    public int getHitpoints(){
        return this.hitpoints;
    }

    /** 
     * Sets this.hitpoints
     * @param hitpoints (int)
     */
    public void setHitpoints(int hitpoints){
        this.hitpoints = hitpoints;
    }
    
    /** 
     * Returns this.keyAttribute
     * @return this.keyAttribute (Attribute)
     */
    public Attribute getKeyAttribute(){
        return this.keyAttribute;
    }

    /** 
     * Sets this.keyAttribute
     * @param keyAttribute (Attribute)
     */
    public void setKeyAttribute(Attribute keyAttribute){
        this.keyAttribute = keyAttribute;
    }
    
    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses.
	 */
	public Hashtable<String, SkillTraining> getProficiencyBonuses(){
		return this.proficiencyBonuses;
	}
	
	/**
	 * Setter for this.proficiencyBonuses.
	 * @param proficiencyBonuses (Hashtable<String, SkillTraining>)
	 */
	public void setProficiencyBonuses(Hashtable<String, SkillTraining> proficiencyBonuses){
		this.proficiencyBonuses = proficiencyBonuses;
	}
	
	/**
	 * Adds proficiency and bonus to this.proficiencyBonuses.
	 * @param skill (String) bonus (SkillTraining)
	 */
    public void addProficiencyBonus(String skill, SkillTraining bonus){
    	this.proficiencyBonuses.put(skill, bonus);
    }

	/**
	 * Removes proficiency bonus of an skill from this.proficiencyBonuses.
	 * @param skill (String)
	 */
    public void removeProficiencyBonus(String skill){
    	this.proficiencyBonuses.remove(skill);
    }
    
    /** 
     * Returns this.freeSkills
     * @return this.freeSkills (int)
     */
    public int getFreeSkills(){
        return this.freeSkills;
    }

    /** 
     * Sets this.freeSkills
     * @param freeSkills (int)
     */
    public void setFreeSkills(int freeSkills){
        this.freeSkills = freeSkills;
    }
    
    /**
	 * Getter for this.subclasses.
	 * @return Returns this.subclasses.
	 */
	public HashSet<Subclass> getSubclasses(){
		return this.subclasses;
	}

	/**
	 * Setter for this.subclasses.
	 * @param subclasses (HashSet<Subclass>)
	 */
	public void setSubclasses(HashSet<Subclass> subclasses){
		this.subclasses = subclasses;
	}
    
	/**
	 * Adds subclass to this.subclasses.
	 * @param subclass (Subclass) 
	 */
    public void addSubclass(Subclass subclass){
        this.subclasses.add(subclass);
    }

	/**
	 * Removes subclass from this.subclasses if present.
	 * @param subclass (Subclass)
	 */
    public void removeSubclass(Subclass subclass){
        if(this.subclasses.contains(subclass)){
            this.subclasses.remove(subclass);
        }
    }
    
    /**
	 * Getter for this.features.
	 * @return Returns this.features.
	 */
	public HashSet<Feat> getFeatures(){
		return this.features;
	}

	/**
	 * Setter for this.features.
	 * @param features (HashSet<Feat>)
	 */
	public void setFeatures(HashSet<Feat> features){
		this.features = features;
	}
    
	/**
	 * Adds feature to this.features.
	 * @param feature (Feat) 
	 */
    public void addFeature(Feat feature){
        this.features.add(feature);
    }

	/**
	 * Removes feature from this.features if present.
	 * @param feature (Feat)
	 */
    public void removeFeature(Feat feature){
        if(this.features.contains(feature)){
            this.features.remove(feature);
        }
    }
}
