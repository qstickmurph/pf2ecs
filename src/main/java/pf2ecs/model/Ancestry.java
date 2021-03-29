package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/** The Ancestry class holds all the information about character ancestry including its hitpoints, attribute bonuses, and more.
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class Ancestry {

	/** The name of the ancestry */
	private String name;
	
	/** The hitpoints of the ancestry */
	private int hitpoints;
	
	/** The attribute bonuses of the ancestry */
	private Hashtable<Attribute, Integer> attributeBonuses;
	
	/** The traits of the ancestry */
	private HashSet<String> traits;
	
	/** The features of the ancestry */
	private HashSet<String> features;
	
	/** The heritages of the ancestry */
	private HashSet<Heritage> heritages;
	
	/** The feats of the ancestry */
	private HashSet<Feat> feats;
	
	/** The size of the ancestry */
	private Size size;
	
	/** 
     *  Empty Constructor Method
     */
    public Ancestry(){
    	this.name = "";
    	this.hitpoints = 0;
    	this.attributeBonuses = new Hashtable<>();
    	this.traits = new HashSet<>();
    	this.features = new HashSet<>();
    	this.heritages = new HashSet<>();
    	this.feats = new HashSet<>();
    	this.size = null;
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     *
     */
    public static Ancestry fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Ancestry.getClass());
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e){
            e.printStackTrace();
        }
        return new Ancestry();
    }

    /**
     * Reads a JsonObject and creates that Feat
     * @param json (JsonObject)
     */
    public static Ancestry fromJson(JsonObject json){
        try{
            Gson gson = new Gson();
            return gson.fromJson(json, Ancestry.getClass());
        }catch (JsonParseException e){
            e.printStackTrace();
        }
        return new Ancestry();
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
     * Returns this.hitpoints
     *  @return this.hitpoints (int)
     */
    public int getHitpoints(){
        return this.hitpoints;
    }

    /** 
     * Sets this.hitpoints
     * @param hitpoints (int)
     */
    public void setHitpoints(int hitpoints){
        this.hitpoints = hitpoints;
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
	 * Removes trait from this.traits if present.
	 * @param trait (String)
	 */
    public void removeTrait(String trait){
        if(this.traits.contains(trait)){
            this.traits.remove(trait);
        }
    }
    
    /**
	 * Getter for this.attributeBonuses.
	 * @return Returns this.attributeBonuses.
	 */
	public Hashtable<Attribute, Integer> getAttributeBonuses(){
		return this.attributeBonuses;
	}
	
	/**
	 * Setter for this.attributeBonuses.
	 * @param attributeBonuses (Hashtable<Attribute, Integer>)
	 */
	public void setAttributeBonuses(Hashtable<Attribute, Integer> attributeBonuses){
		this.attributeBonuses = attributeBonuses;
	}
	
	/**
	 * Adds attribute and bonus to this.attributeBonuses.
	 * @param attribute (Attribute) bonus (Integer)
	 */
    public void addAtributeBonus(Attribute attribute, Integer bonus){
    	this.attributeBonuses.put(attribute, bonus);
    }

	/**
	 * Removes bonus of an attribute from this.attributeBonuses.
	 * @param attribute (Attribute)
	 */
    public void removeAttributeBonus(Attribute attribute){
    	this.attributeBonuses.remove(attribute);
    }
    
    /**
	 * Getter for this.features.
	 * @return Returns this.features.
	 */
	public HashSet<String> getFeatures(){
		return this.features;
	}

	/**
	 * Setter for this.features.
	 * @param features (HashSet<Feat>)
	 */
	public void setFeatures(HashSet<String> features){
		this.features = features;
	}
    
	/**
	 * Adds feature to this.features.
	 * @param feature (Feat) 
	 */
    public void addFeature(String feature){
        this.features.add(feature);
    }

	/**
	 * Removes feature from this.features if present.
	 * @param feature (Feat)
	 */
    public void removeFeature(String feature){
        if(this.features.contains(feature)){
            this.features.remove(feature);
        }
    }
    
    /**
	 * Getter for this.feats.
	 * @return Returns this.feats.
	 */
	public HashSet<Feat> getFeats(){
		return this.feats;
	}

	/**
	 * Setter for this.feats.
	 * @param feats (HashSet<Feat>)
	 */
	public void setFeats(HashSet<Feat> feats){
		this.feats = feats;
	}
    
	/**
	 * Adds feat to this.features.
	 * @param feat (Feat) 
	 */
    public void addFeats(Feat feat){
        this.feats.add(feat);
    }

	/**
	 * Removes feat from this.feats if present.
	 * @param feat (Feat)
	 */
    public void removeFeat(Feat feat){
        if(this.feats.contains(feat)){
            this.feats.remove(feat);
        }
    }
    
    /**
	 * Getter for this.heritages.
	 * @return Returns this.heritages.
	 */
	public HashSet<Heritage> getHeritages(){
		return this.heritages;
	}

	/**
	 * Setter for this.heritages.
	 * @param heritages (HashSet<Heritage>)
	 */
	public void setHeritages(HashSet<Heritage> heritages){
		this.heritages = heritages;
	}
    
	/**
	 * Adds heritage to this.heritages.
	 * @param heritage (Heritage) 
	 */
    public void addHeritage(Heritage heritage){
        this.heritages.add(heritage);
    }

	/**
	 * Removes heritage from this.heritages if present.
	 * @param heritage (Heritage)
	 */
    public void removeHeritage(Heritage heritage){
        if(this.heritages.contains(heritage)){
            this.heritages.remove(heritage);
        }
    }
    
    /** 
     * Returns this.size
     * @return this.size (Size)
     */
    public Size getSize(){
        return this.size;
    }

    /** 
     * Sets this.size
     * @param size (Size)
     */
    public void setSize(Size size){
        this.size = size;
    }
}
