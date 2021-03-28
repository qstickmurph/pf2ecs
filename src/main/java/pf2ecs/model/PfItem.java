package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;
//import pf2ecs.model.Item;
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
public class PfItem {
	
	/** The name of the item */
	private String name;
	
	/** The level of the item */
	private int level;
	
	/** The traits of the item */
	private HashSet<String> traits = new HashSet<String>();
	
	/** The price of the item */
	private double price;
	
	/** The description of the item */
	private String description;
	
	/** The actions to use the item */
	private HashSet<Action> actions = new HashSet<Action>();
	
	/** The runes on the item */
	private HashSet<Rune> runes = new HashSet<Rune>();
	
	/** Whether item needs to be invested */
	private boolean requireInvest;
    
    /** Constructor Method
     *  
     *  @param name (String) The name of the item
     */
    public PfItem(String name){
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
     * Returns this.level
     *  @return this.level (int)
     */
    public int getLevel(){
        return this.level;
    }

    /** 
     * Sets this.level
     * @param level (int)
     */
    public void setLevel(int level){
        this.level = level;
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
     * Returns this.price
     *  @return this.price (double)
     */
    public double getPrice(){
        return this.price;
    }

    /** 
     * Sets this.price
     * @param price (double)
     */
    public void setPrice(double price){
        this.price = price;
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
	 * Getter for this.actions.
	 * @return Returns this.actions.
	 */
	public HashSet<Action> getActions(){
		return this.actions;
	}
	
	/**
	 * Setter for this.actions.
	 * @param actions (HashSet<Action>)
	 */
	public void setActions(HashSet<Action> actions){
		this.actions = actions;
	}
    
	/**
	 * Adds action to this.actions.
	 * @param action (Action) 
	 */
    public void addAction(Action action){
        this.actions.add(action);
    }

	/**
	 * Removes action from this.actions if present.
	 * @param action (HashSet<Action>)
	 */
    public void removeAction(Action action){
        if(this.actions.contains(action)){
            this.actions.remove(action);
        }
    }
    
    /**
	 * Getter for this.runes.
	 * @return Returns this.runes.
	 */
	public HashSet<Rune> getRunes(){
		return this.runes;
	}
	
	/**
	 * Setter for this.runes.
	 * @param runes (HashSet<Rune>)
	 */
	public void setRunes(HashSet<Rune> runes){
		this.runes = runes;
	}
    
	/**
	 * Adds rune to this.runes.
	 * @param rune (Rune) 
	 */
    public void addRune(Rune rune){
        this.runes.add(rune);
    }

	/**
	 * Removes rune from this.runes if present.
	 * @param rune (HashSet<Rune>)
	 */
    public void removeRune(Rune rune){
        if(this.runes.contains(rune)){
            this.runes.remove(rune);
        }
    }
    
    /** 
     * Returns this.requireInvest
     *  @return this.requireInvest (boolean)
     */
    public boolean getRequiresInvest(){
        return this.requireInvest;
    }

    /** 
     * Sets this.requireInvest
     * @param requireInvest (boolean)
     */
    public void setRequiredInvest(boolean requireInvest){
        this.requireInvest = requireInvest;
    }
}
