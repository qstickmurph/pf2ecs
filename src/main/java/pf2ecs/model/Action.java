package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
//import pf2ecs.model.Action;
//import pf2ecs.model.Spell;

/** The Action class holds all the information about each action including its description, any relevant scenario type, and more
 *
 * @author Quinn Murphey
 * @author David Gellhausen
 * @author Jim Richmond
 * @author Alexander Lomeli-Azoubel
 * @since 03/26/2021
 */
public class Action {
    
    /** 
     *
     */
    private String name;
    //private Scenario scenario;
    private HashSet<String> traits = new HashSet<String>();
    private HashSet<String> requirements = new HashSet<String>();
    private String description;
    private String time;
    private String trigger;
    
    /** Constructor Method
     *  
     *  @param name (String) The name of the action
     */
    public Action(String name){
        this.name = name;
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
