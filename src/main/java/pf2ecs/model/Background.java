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
import pf2ecs.model.Feat;

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
	private ArrayList<String> abilityBoosts;
	
	/** The proficiency bonuses of the background */
	private Hashtable<String, Proficiency> proficiencies;

    private Feat feat;
	
	/** 
     *  Empty Constructor Method
     */
    public Background(){
    	this.name = "";
        this.description = "";
        this.abilityBoosts = new ArrayList<>();
        this.proficiencies = new Hashtable<>();
        this.feat = new Feat();
    }

    /** 
     * Reads a json file containing a background and creates that Background 
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
	 * Getter for this.abilityBoosts.
	 * @return Returns this.abilityBoosts.
	 */
	public ArrayList<String> getAbilityBoosts(){
		return this.abilityBoosts;
	}
	
	/**
	 * Setter for this.abilityBoosts.
	 * @param abilityBoosts (ArrayList<String>)
	 */
	public void setAbilityBoosts(ArrayList<String> abilityBoosts){
		this.abilityBoosts = abilityBoosts;
	}
	
	/**
	 * Adds ability and bonus to this.abilityBoosts.
	 * @param ability (Ability)
	 */
    public void addAbilityBonus(String ability){
    	this.abilityBoosts.add(ability);
    }

	/**
	 * Removes bonus of an ability from this.abilityBoosts.
	 * @param ability (String)
	 */
    public void removeAbilityBonus(String ability){
    	this.abilityBoosts.remove(ability);
    }
    
    /**
	 * Getter for this.proficiencies.
	 * @return Returns this.proficiencies.
	 */
	public Hashtable<String, Proficiency> getProficiencies(){
		return this.proficiencies;
	}
    
    /**
	 * Getter for this.proficiencies.
	 * @return Returns this.proficiencies.
	 */
	public Proficiency getProficiency(String prof){
        if(this.proficiencies.containsKey(prof)){
            return this.proficiencies.get(prof);
        }else {
            return Proficiency.UNTRAINED;
        }
	}
	/**
	 * Setter for this.proficiencies.
	 * @param proficiencies (Hashtable<String, Proficiency>)
	 */
	public void setProficiencies(Hashtable<String, Proficiency> proficiencies){
		this.proficiencies = proficiencies;
	}
	
	/**
	 * Adds proficiency and bonus to this.proficiencies.
	 * @param skill (String) bonus (Proficiency)
	 */
    public void addProficiencyBonus(String skill, Proficiency bonus){
    	this.proficiencies.put(skill, bonus);
    }

	/**
	 * Removes proficiency bonus of an skill from this.proficiencies.
	 * @param skill (String)
	 */
    public void removeProficiencyBonus(String skill){
    	this.proficiencies.remove(skill);
    }
    
    /**
     * Getter for this.feat
     */
    public Feat getFeat(){
        return this.feat;
    }
    
    /**
     * Setter for this.feat
     * @param feat (Feat)
     */
    public void setFeat(Feat feat){
        this.feat = feat;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
