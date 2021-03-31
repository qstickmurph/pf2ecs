package pf2ecs.model;

import java.util.ArrayList;
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

/** The Ancestry class holds all the information about character ancestry including its hitpoints, ability bonuses, and more.
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

    /** The description of this ancestry */
    private String description;
	
	/** The hitpoints of the ancestry */
	private int hitpoints;
	
	/** The ability bonuses of the ancestry */
	private ArrayList<String> abilityBoosts;
	
	/** The ability flaws of the ancestry */
	private ArrayList<String> abilityFlaws;

	/** The languages the ancestry knows */
	private ArrayList<String> languages;
	
	/** The traits of the ancestry */
	private ArrayList<String> traits;
	
	/** The features of the ancestry */
	private ArrayList<Feat> features;
	
	/** The heritages of the ancestry */
	private ArrayList<Heritage> heritages;
	
	/** The feats of the ancestry */
	private ArrayList<Feat> feats;
	
	/** The size of the ancestry */
	private Size size;

    /** The default speed of the ancestry */
    private String speed;
	
	/** 
     *  Empty Constructor Method
     */
    public Ancestry(){
    	this.name = "";
    	this.description = "";
    	this.hitpoints = 0;
    	this.abilityBoosts = new ArrayList<>();
    	this.abilityFlaws = new ArrayList<>();
	    this.languages = new ArrayList<>();
    	this.traits = new ArrayList<>();
    	this.features = new ArrayList<>();
    	this.heritages = new ArrayList<>();
    	this.feats = new ArrayList<>();
    	this.size = null;
        this.speed = "0 ft";
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     *
     */
    public static Ancestry fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Ancestry.class);
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
            return gson.fromJson(json, Ancestry.class);
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
	 * Getter for this.description.
	 * @return Returns this.description
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * Setter for this.description.
	 * @param name Sets this.description to description 
	 */
	public void setDescription(String description){
		this.description = description;
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
	 * Getter for this.traits.
	 * @return Returns this.traits.
	 */
	public ArrayList<String> getTraits(){
		return this.traits;
	}

	/**
	 * Setter for this.traits.
	 * @param traits (ArrayList<String>)
	 */
	public void setTraits(ArrayList<String> traits){
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
	 * Getter for this.abilityBoosts.
	 * @return Returns this.abilityBoosts.
	 */
	public ArrayList<String> getAbilityBoosts(){
		return this.abilityBoosts;
	}
	
	/**
	 * Setter for this.abilityBoosts.
	 * @param abilityBoosts (ArrayList<String>)
	 */
	public void setAbilityBoosts(ArrayList<String> abilityBoosts){
		this.abilityBoosts = abilityBoosts;
	}
	
	/**
	 * Adds ability and bonus to this.abilityBoosts.
	 * @param ability (Ability)
	 */
    public void addAbilityBonus(String ability){
    	this.abilityBoosts.add(ability);
    }

	/**
	 * Removes bonus of an ability from this.abilityBoosts.
	 * @param ability (String)
	 */
    public void removeAbilityBonus(String ability){
    	this.abilityBoosts.remove(ability);
    }

    /**
	 * Getter for this.abilityFlaws.
	 * @return Returns this.abilityFlaws.
	 */
	public ArrayList<String> getAbilityFlaws(){
		return this.abilityFlaws;
	}
	
	/**
	 * Setter for this.abilityFlaws.
	 * @param abilityFlaws (ArrayList<String>)
	 */
	public void setAbilityFlaws(ArrayList<String> abilityFlaws){
		this.abilityFlaws = abilityFlaws;
	}
	
	/**
	 * Adds ability and bonus to this.abilityFlaws.
	 * @param ability (String)
	 */
    public void addAbilityFlaw(String ability){
    	this.abilityFlaws.add(ability);
    }

	/**
	 * Removes bonus of an ability from this.abilityBoosts.
	 * @param ability (String)
	 */
    public void removeAbilityFlaw(String ability){
    	this.abilityFlaws.remove(ability);
    }

    /**
	 * Getter for this.languages.
	 * @return Returns this.features.
	 */
	public ArrayList<String> getLanguages(){
		return this.languages;
	}

	/**
	 * Setter for this.languages.
	 * @param languages (ArrayList<String>)
	 */
	public void setLanguages(ArrayList<String> languages){
		this.languages = languages;
	}
    
	/**
	 * Adds feature to this.languages.
	 * @param languages (String) 
	 */
    public void addLanguage(String language){
        this.languages.add(language);
    }

	/**
	 * Removes language from this.languages if present.
	 * @param language (String)
	 */
    public void removeLanguage(String language){
        if(this.languages.contains(language)){
            this.languages.remove(language);
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
    
    /**
	 * Getter for this.feats.
	 * @return Returns this.feats.
	 */
	public ArrayList<Feat> getFeats(){
		return this.feats;
	}

	/**
	 * Setter for this.feats.
	 * @param feats (ArrayList<Feat>)
	 */
	public void setFeats(ArrayList<Feat> feats){
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
	public ArrayList<Heritage> getHeritages(){
		return this.heritages;
	}

	/**
	 * Setter for this.heritages.
	 * @param heritages (ArrayList<Heritage>)
	 */
	public void setHeritages(ArrayList<Heritage> heritages){
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

	/**
	 * Getter for this.speed.
	 * @return Returns this.speed.
	 */
	public String getSpeed(){
		return this.speed;
	}

	/**
	 * Setter for this.speed.
	 * @param speed (String)
	 */
	public void setSpeed(String speed){
		this.speed = speed;
	}
    
    @Override
    public String toString(){
        return this.name;
    }
}
