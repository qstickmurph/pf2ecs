package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import java.util.ArrayList;

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
	private Attribute keyAttribute;
	
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
        this.keyAttribute = null;
        this.untrainedActions = new HashSet<>();
        this.trainedActions = new HashSet<>();
    }
    
    /**
     * Json Reader Constructor Method
     *
     * Parses the skill JsonObject into a skill object
     * @param json (JsonObject)
     */
    public Skill(JsonObject json){
    	this.name = "";
        this.description = "";
        this.keyAttribute = null;
        this.untrainedActions = new HashSet<>();
        this.trainedActions = new HashSet<>();
        this.readJson(json);
    }
    
    /**
     * Reads a JsonObject and applies that object to the Skill
     * @param json (JsonObject)
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
        if(json.has("actions")){
            // Read the array of Strings
        	JsonArray actionArrays = (JsonArray) json.get("actions");
        	JsonArray untrainedActionsJson = (JsonArray) actionArrays.get(0);
            JsonArray trainedActionsJson = (JsonArray) actionArrays.get(1);
            for(int i = 0; i < untrainedActionsJson.size(); i++){
                // Parse action JsonObject
                JsonObject actionJson = (JsonObject) untrainedActionsJson.get(i);

                // Create new action based on JsonObject
                Action action = new Action(actionJson);

                // Add action to this.actions
                this.untrainedActions.add(action);
            }
            for(int i = 0; i < trainedActionsJson.size(); i++){
                // Parse action JsonObject
                JsonObject actionJson = (JsonObject) trainedActionsJson.get(i);

                // Create new action based on JsonObject
                Action action = new Action(actionJson);

                // Add action to this.actions
                this.trainedActions.add(action);
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
	 * Getter for this.keyAttribute.
	 * @return Returns this.keyAttribute
	 */
	public Attribute getKeyAttribute(){
		return this.keyAttribute;
	}

	/**
	 * Setter for this.description.
	 * @param keyAttribute (Attribute) Sets this.keyAttribute to keyAttribute 
	 */
	public void setKeyAttribute(Attribute keyAttribute){
		this.keyAttribute = keyAttribute;
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
