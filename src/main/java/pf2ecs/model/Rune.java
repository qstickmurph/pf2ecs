package pf2ecs.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;
//import pf2ecs.model.Item;
//import pf2ecs.model.Action;
//import pf2ecs.model.Spell;

/** The Rune class holds all the information about each rune including its description, traits, and more
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class Rune {
	
	/** The name of the rune */
	private String name;
	
	/** The level of the rune */
	private int level;
	
	/** The traits of the rune */
	private HashSet<String> traits = new HashSet<String>();
	
	/** The price of the rune in gold pieces */
	private double price;
	
	/** The description of the rune */
	private String description;
	
	/** Whether the rune is fundamental */
	private boolean fundamental;
    
	/** The actions for the rune */
	private HashSet<Action> actions = new HashSet<Action>();
	
    /** Constructor Method
     *  
     */
    public Rune(){
        this.name = "";
        this.level = 0;
        this.traits = new HashSet<String>();
        this.price = 0.0;
        this.description = "";
        this.fundamental = false;
        this.actions = new HashSet<Action>();
    }

    /** 
     * Reads a json file containing a class and creates that Rune 
     * @param file (File)
     */
    public static Rune fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Rune.getClass());
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new Rune();
    }

    /**
     * Reads a JsonObject and creates that Rune 
     * @param json (JsonObject)
     */
    public static Rune fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, Rune.getClass());
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new Rune();
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
     * Turns this Rune into a JsonObject
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
	 * @param trait (Action) 
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
     * Returns this.fundamental
     * @return this.fundamental (boolean)
     */
    public boolean getFundamental() {
    	return this.fundamental;
    }
    
    /**
	 * Setter for this.fundamental.
	 * @param fundamental (boolean) Sets this.fundamental to fundamental 
	 */
    public void setFundamental(boolean fundamental) {
    	this.fundamental = fundamental;
    }
}
