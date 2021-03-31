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
import pf2ecs.model.Subclass;
import pf2ecs.model.Feat;

/** The Class class holds all the information about class including its hitpoints, key attribute, and more.
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class PfClass {
	/** The name of the class */
	private String name;
	
	/** The hitpoints of the class */
	private int hitpoints;
	
	/** The keyAbility of the class */
	private Ability keyAbility;
	
	/** The proficiency bonuses of the class */
	private Hashtable<String, Proficiency> proficiencyBonuses;
	
	/** The number of free skills of the class */
	private int freeSkills;
	
	/** The subclasses of the class */
	private HashSet<Subclass> subclasses;
	
	/** The features of the class */
	private ArrayList<Feat> features;

	/** Wheter the class gets a feat at level 1 */
    private boolean level1Feat;

	/**  
     *  Empty Constructor Method
     */
    public PfClass(){
        this.name = "";
        this.hitpoints = 0;
    	this.keyAbility = null;
    	this.proficiencyBonuses = new Hashtable<>();
    	this.freeSkills = 0;
    	this.subclasses = new HashSet<>();
    	this.features = new ArrayList<>();
    }

    /** 
     * Reads a json file containing a class and creates that PfClass 
     * @param file (File)
     */
    public static PfClass fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, PfClass.class);
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new PfClass();
    }

    /**
     * Reads a JsonObject and creates that PfClass 
     * @param json (JsonObject)
     */
    public static PfClass fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, PfClass.class);
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new PfClass();
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
     * Turns this PfClass into a JsonObject
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
     * Returns this.hitpoints
     *  @return this.hitpoints (int)
     */
    public int getHitPoints(){
        return this.hitpoints;
    }

    /** 
     * Sets this.hitpoints
     * @param hitpoints (int)
     */
    public void setHitPoints(int hitpoints){
        this.hitpoints = hitpoints;
    }
    
    /** 
     * Returns this.keyAbility
     * @return this.keyAbility (Ability)
     */
    public Ability getKeyAbility(){
        return this.keyAbility;
    }

    /** 
     * Sets this.keyAbility
     * @param keyAbility (Ability)
     */
    public void setKeyAbility(Ability keyAbility){
        this.keyAbility = keyAbility;
    }
    
    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses.
	 */
	public Hashtable<String, Proficiency> getProficiencyBonuses(){
		return this.proficiencyBonuses;
	}
	
    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses.
	 */
	public Proficiency getProficiencyBonus(String prof){
        if(this.proficiencyBonuses.containsKey(prof)){
            return this.proficiencyBonuses.get(prof);
        }else {
            return Proficiency.UNTRAINED;
        }
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
    
    /** 
     * Returns this.freeSkills
     * @return this.freeSkills (int)
     */
    public int getFreeSkills(){
        return this.freeSkills;
    }

    /** 
     * Sets this.freeSkills
     * @param freeSkills (int)
     */
    public void setFreeSkills(int freeSkills){
        this.freeSkills = freeSkills;
    }
    
    /**
	 * Getter for this.subclasses.
	 * @return Returns this.subclasses.
	 */
	public HashSet<Subclass> getSubclasses(){
		return this.subclasses;
	}

	/**
	 * Setter for this.subclasses.
	 * @param subclasses (HashSet<Subclass>)
	 */
	public void setSubclasses(HashSet<Subclass> subclasses){
		this.subclasses = subclasses;
	}
    
	/**
	 * Adds subclass to this.subclasses.
	 * @param subclass (Subclass) 
	 */
    public void addSubclass(Subclass subclass){
        this.subclasses.add(subclass);
    }

	/**
	 * Removes subclass from this.subclasses if present.
	 * @param subclass (Subclass)
	 */
    public void removeSubclass(Subclass subclass){
        if(this.subclasses.contains(subclass)){
            this.subclasses.remove(subclass);
        }
    }
    
    /**
	 * Getter for this.features.
	 * @return Returns this.features.
	 */
	public ArrayList<Feat> getFeatures(){
		return this.features;
	}

	/**
	 * Setter for this.features.
	 * @param features (ArrayList<Feat>)
	 */
	public void setFeatures(ArrayList<Feat> features){
		this.features = features;
	}
    
	/**
	 * Adds feature to this.features.
	 * @param feature (Feat) 
	 */
    public void addFeature(Feat feature){
        this.features.add(feature);
    }

	/**
	 * Removes feature from this.features if present.
	 * @param feature (Feat)
	 */
    public void removeFeature(Feat feature){
        if(this.features.contains(feature)){
            this.features.remove(feature);
        }
    }

    @Override
    public String toString(){
        return this.name;
    }
}
