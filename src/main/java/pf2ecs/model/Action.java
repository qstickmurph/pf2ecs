package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

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
    private HashSet<String> traits = new HashSet<String>();

    /** Holds the requirements of the Action */
    private HashSet<String> requirements = new HashSet<String>();

    /** Holds the description of the Action */
    private String description;

    /** Holds the time the Action takes to do*/
    private String time;

    /** Holds the trigger of the Action */
    private String trigger;
    
    /** Constructor Method
     *  
     *  @param name (String) The name of the action
     */
    public Action(){
        this.name = "";
        this.traits = new HashSet<>();
        this.requirements = new HashSet<>();
        this.description = "";
        this.time = "";
        this.trigger = "";
    }

    /**
     * Parse JsonObject into Action Object
     * @param json (JsonObject)
     */
    public Action(JsonObject json){
        this.name = "";
        this.traits = new HashSet<>();
        this.requirements = new HashSet<>();
        this.description = "";
        this.time = "";
        this.trigger = "";
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

        if(json.has("traits")){
            // Read the array of Strings 
            JsonArray traitsArray = (JsonArray) json.get("traits");
            for(int i = 0; i < traitsArray.size(); i++){ // put each trait into this.traits
                this.traits.add(traitsArray.get(i).getAsString());
            }
        }

        if(json.has("requirements")){
            // Read the array of Strings
            JsonArray requirementsArray = (JsonArray) json.get("requirements");
            for(int i = 0; i < requirementsArray.size(); i++){ // put each prerequisite into this.prerequisites
                this.requirements.add(requirementsArray.get(i).getAsString());
            }
        }

        if(json.has("description")){
            // Put description from json into this.description.
            this.description= json.get("description").getAsString();
        }

        if(json.has("time")){
            // Put time from json into this.time.
            this.time = json.get("time").getAsString();
        }

        if(json.has("trigger")){
            // Put trigger from json into this.trigger.
            this.trigger = json.get("trigger").getAsString();
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
	public HashSet<String> getRequirements(){
		return this.requirements;
	}

	/**
	 * Setter for this.requirements.
	 * @param requrements (HashSet<String>)
	 */
	public void setRequirements(HashSet<String> requirements){
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

}
