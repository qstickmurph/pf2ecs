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

import pf2ecs.model.Scenario;

/** The Action class holds all the information about each action including its description, any relevant scenario type, and more
 *
 * @author Quinn Murphey
 * @author David Gellhausen
 * @author Jim Richmond
 * @author Alexander Lomeli-Azoubel
 * @since 03/26/2021
 */
public class Action {
    
    /** Holds the name of the Action */
    private String name;

    /** Holds the traits of the Action */
    private HashSet<String> traits;

    /** Holds the requirements of the Action */
    private String requirements;

    /** Holds the description of the Action */
    private String description;

    /** Holds the time the Action takes to do*/
    private String time;

    /** Holds the trigger of the Action */
    private String trigger;

    /** The proficiency bonus to be used in calculation */
    private String proficiency;
    
    /** Constructor Method
     *  
     */
    public Action(){
        this.name = "";
        this.traits = new HashSet<>();
        this.requirements = "";
        this.description = "";
        this.time = "";
        this.trigger = "";
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     * @param file (File)
     */
    public static Action fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Action.class);
        } catch (IOException e) { 
            e.printStackTrace();
        }catch (JsonParseException e){
            e.printStackTrace();
        }
        return new Action();

    }

    /**
     * Reads a JsonObject and creates that Feat
     * @param json (JsonObject)
     */
    public static Action fromJson(JsonObject json){
        try{
            Gson gson = new Gson();
            return gson.fromJson(json, Action.class);
        }catch (JsonParseException e){
            e.printStackTrace();
        }
        return new Action();
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
     * Getter for this.time
     * @return Returns this.time
     */
    public String getTime(){
    	return this.time;
    }
    
    /**
     * Setter for this.time
     * @param time (String) Sets this.time to time
     */
    public void setTime(String time){
    	this.time = time;
    }
    
    /**
     * Getter for this.trigger
     * @return Returns this.trigger
     */
    public String getTrigger(){
    	return this.trigger;
    }
    
    /**
     * Setter for this.trigger
     * @param trigger (String) Sets this.trigger to trigger
     */
    public void setTrigger(String trigger){
    	this.trigger = time;
    }
    
    /**
	 * Getter for this.requirements.
	 * @return Returns this.requirements.
	 */
	public String getRequirements(){
		return this.requirements;
	}

	/**
	 * Setter for this.requirements.
	 * @param requrements (HashSet<String>)
	 */
	public void setRequirements(String requirements){
		this.requirements = requirements;
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

    @Override
    public String toString(){
        return this.name;
    }
}
