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
import pf2ecs.model.Action;

/** The Skill class holds all the information about skills including its description, key attribute, and more
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class Skill {

	/** The name of the skill */
	private String name;
	
	/** The description of the skill */
	private String description;
	
	/** The key attribute of the skill */
	private Ability keyAbility;
	
	/** The untrained actions of a skill */
	private HashSet<Action> untrainedActions;
	
	/** The trained actions of a skill */
	private HashSet<Action> trainedActions;
	
	/** 
     *  Empty Constructor Method
     */
    public Skill(){
    	this.name = "";
        this.description = "";
        this.keyAbility = null;
        this.untrainedActions = new HashSet<>();
        this.trainedActions = new HashSet<>();
    }

    /** 
     * Reads a json file containing a class and creates that Skill 
     * @param file (File)
     */
    public static Skill fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Skill.class);
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new Skill();
    }

    /**
     * Reads a JsonObject and creates that Skill 
     * @param json (JsonObject)
     */
    public static Skill fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, Skill.class);
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new Skill();
    }
    
    /**
     * Exports the class as a json file
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
     * Turns this Skill into a JsonObject
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
	 * Getter for this.keyAbility.
	 * @return Returns this.keyAbility
	 */
	public Ability getKeyAbility(){
		return this.keyAbility;
	}

	/**
	 * Setter for this.description.
	 * @param keyAbility (Ability) Sets this.keyAbility to keyAbility 
	 */
	public void setKeyAbility(Ability keyAbility){
		this.keyAbility = keyAbility;
	}
	
	/**
	 * Getter for this.untrainedActions.
	 * @return Returns this.untrainedActions.
	 */
	public HashSet<Action> getUntrainedActions(){
		return this.untrainedActions;
	}

	/**
	 * Setter for this.untrainedActions.
	 * @param untrainedActions (HashSet<Action>)
	 */
	public void setUntrainedActions(HashSet<Action> untrainedActions){
		this.untrainedActions = untrainedActions;
	}
    
	/**
	 * Adds action to this.untrainedActions.
	 * @param action (Action) 
	 */
    public void addUntrainedAction(Action action){
        this.untrainedActions.add(action);
    }

	/**
	 * Removes action from this.untrainedActions if present.
	 * @param action (HashSet<Action>)
	 */
    public void removeUntrainedAction(Action action){
        if(this.untrainedActions.contains(action)){
            this.untrainedActions.remove(action);
        }
    }
    
    /**
	 * Getter for this.trainedActions.
	 * @return Returns this.trainedActions.
	 */
	public HashSet<Action> getTrainedActions(){
		return this.trainedActions;
	}

	/**
	 * Setter for this.trainedActions.
	 * @param trainedActions (HashSet<Action>)
	 */
	public void setTrainedActions(HashSet<Action> trainedActions){
		this.trainedActions = trainedActions;
	}
    
	/**
	 * Adds action to this.trainedActions.
	 * @param action (Action) 
	 */
    public void addTrainedAction(Action action){
        this.trainedActions.add(action);
    }

	/**
	 * Removes action from this.trainedActions if present.
	 * @param action (HashSet<Action>)
	 */
    public void removeTrainedAction(Action action){
        if(this.trainedActions.contains(action)){
            this.trainedActions.remove(action);
        }
    }

}
