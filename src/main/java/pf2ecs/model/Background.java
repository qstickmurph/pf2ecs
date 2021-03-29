package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import pf2ecs.model.Attribute;
import pf2ecs.model.SkillTraining;

/** The Background class holds all the information about character background including its description, attribute bonuses, and proficiency bonuses
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class Background {

	/** The name of the background */
	private String name;
	
	/** The description of the background */
	private String description;
	
	/** The attribute bonuses of the background */
	private Hashtable<Attribute, Integer> attributeBonuses;
	
	/** The proficiency bonuses of the background */
	private Hashtable<String, SkillTraining> proficiencyBonuses;
	
	/** 
     *  Empty Constructor Method
     */
    public Background(){
    	this.name = "";
        this.description = "";
        this.attributeBonuses = new Hashtable<>();
        this.proficiencyBonuses = new Hashtable<>();
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     *
     */
    public static Background fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Background.getClass());
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e){
            e.printStackTrace();
        }
        return new Background();
    }

    /**
     * Reads a JsonObject and creates that Feat
     * @param json (JsonObject)
     */
    public static Background fromJson(JsonObject json){
        try{
            Gson gson = new Gson();
            return gson.fromJson(json, Background.getClass());
        }catch (JsonParseException e){
            e.printStackTrace();
        }
        return new Background();
    }

    /**
     * Prints and saves this Feat as a json file
     * @param file (File)
     */
    public void save(File file){
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

	/** Json read
     *  
     *  @param json (JsonObject)
     */
    public void readJson(JsonObject json){
    	if(json.has("name")){
            // Put name from json into this.name
            this.name = json.get("name").getAsString();
        }

        if(json.has("description")){
            // Put description from json into this.description 
            this.description = json.get("description").getAsString();
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
	 * Getter for this.attributeBonuses.
	 * @return Returns this.attributeBonuses.
	 */
	public Hashtable<Attribute, Integer> getAttributeBonuses(){
		return this.attributeBonuses;
	}
	
	/**
	 * Setter for this.attributeBonuses.
	 * @param attributeBonuses (Hashtable<Attribute, Integer>)
	 */
	public void setAttributeBonuses(Hashtable<Attribute, Integer> attributeBonuses){
		this.attributeBonuses = attributeBonuses;
	}
	
	/**
	 * Adds attribute and bonus to this.attributeBonuses.
	 * @param attribute (Attribute) bonus (Integer)
	 */
    public void addAtributeBonus(Attribute attribute, Integer bonus){
    	this.attributeBonuses.put(attribute, bonus);
    }

	/**
	 * Removes bonus of an attribute from this.attributeBonuses.
	 * @param attribute (Attribute)
	 */
    public void removeAttributeBonus(Attribute attribute){
    	this.attributeBonuses.remove(attribute);
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
}
