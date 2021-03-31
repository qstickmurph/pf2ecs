package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;

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
import pf2ecs.model.Proficiency;

/** The Background class holds all the information about character background including its description, ability bonuses, and proficiency bonuses
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
	
	/** The ability bonuses of the background */
	private ArrayList<String> abilityBonuses;
	
	/** The proficiency bonuses of the background */
	private Hashtable<String, Proficiency> proficiencyBonuses;
	
	/** 
     *  Empty Constructor Method
     */
    public Background(){
    	this.name = "";
        this.description = "";
        this.abilityBonuses = new ArrayList<>();
        this.proficiencyBonuses = new Hashtable<>();
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     *
     */
    public static Background fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Background.class);
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
            return gson.fromJson(json, Background.class);
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
	 * Getter for this.abilityBonuses.
	 * @return Returns this.abilityBonuses.
	 */
	public ArrayList<String> getAbilityBonuses(){
		return this.abilityBonuses;
	}
	
	/**
	 * Setter for this.abilityBonuses.
	 * @param abilityBonuses (ArrayList<String>)
	 */
	public void setAbilityBonuses(ArrayList<String> abilityBonuses){
		this.abilityBonuses = abilityBonuses;
	}
	
	/**
	 * Adds ability and bonus to this.abilityBonuses.
	 * @param ability (Ability)
	 */
    public void addAbilityBonus(String ability){
    	this.abilityBonuses.add(ability);
    }

	/**
	 * Removes bonus of an ability from this.abilityBonuses.
	 * @param ability (String)
	 */
    public void removeAbilityBonus(String ability){
    	this.abilityBonuses.remove(ability);
    }
    
    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses.
	 */
	public Hashtable<String, Proficiency> getProficiencyBonuses(){
		return this.proficiencyBonuses;
	}
	
	/**
	 * Setter for this.proficiencyBonuses.
	 * @param proficiencyBonuses (Hashtable<String, Proficiency>)
	 */
	public void setProficiencyBonuses(Hashtable<String, Proficiency> proficiencyBonuses){
		this.proficiencyBonuses = proficiencyBonuses;
	}
	
	/**
	 * Adds proficiency and bonus to this.proficiencyBonuses.
	 * @param skill (String) bonus (Proficiency)
	 */
    public void addProficiencyBonus(String skill, Proficiency bonus){
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
