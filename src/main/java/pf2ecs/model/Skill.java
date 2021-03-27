package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
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
	private HashSet<Action> untrainedActions = new HashSet<Action>();
	
	/** The trained actions of a skill */
	private HashSet<Action> trainedActions = new HashSet<Action>();
	
	/** Constructor Method
     *  
     *  @param name (String) The name of the skill
     */
    public Skill(String name){
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
