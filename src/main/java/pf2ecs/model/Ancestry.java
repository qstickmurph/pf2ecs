package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

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
	private HashSet<Feat> features;
	
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
    
	/** Json Constructor Method
     *  
     *  @param json (JsonObject)
     */
    public Ancestry(JsonObject json){
    	this.name = "";
    	this.hitpoints = 0;
    	this.attributeBonuses = new Hashtable<>();
    	this.traits = new HashSet<>();
    	this.features = new HashSet<>();
    	this.heritages = new HashSet<>();
    	this.feats = new HashSet<>();
    	this.size = null;
    	this.readJson(json);
    }

	/** Json read
     *  
     *  @param json (JsonObject)
     */
    public void readJson(JsonObject json){
    	if(json.has("name")){
            // Put name from json into this.name
            this.name = json.get("name").getAsString();
        }

        if(json.has("hitpoints")){
            // Put hitpoints from json into this.hitpoints 
            this.hitpoints = json.get("hitpoints").getAsInt();
        }
        
        if(json.has("ability_boosts")){
            // Read the array of Strings
            JsonArray attributeBonusesArray = (JsonArray) json.get("ability_boosts");
            for(int i = 0; i< attributeBonusesArray.size(); i++){
                // Get next String
                String str = attributeBonusesArray.get(i).getAsString();

                // Set attribute based on str
                Attribute attribute = Attribute.STR;
                switch(str){
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

                if(attributeBonuses.contains(attribute)){ // if already has a bonus on this attribute increment it by 1
                    this.attributeBonuses.put(attribute, this.attributeBonuses.get(attribute) + 1);
                }else{ // else set to 1
                    this.attributeBonuses.put(attribute, 1);
                }
            }
        }
        
        if(json.has("traits")){
            // Read the array of Strings 
            JsonArray traitsArray = (JsonArray) json.get("traits");
            for(int i = 0; i < traitsArray.size(); i++){ // put each trait into this.traits
                this.traits.add(traitsArray.get(i).getAsString());
            }
        }
        
        if(json.has("features")){
            // Read the array of Strings
            JsonArray featuresArray = (JsonArray) json.get("features");
            for(int i = 0; i < featuresArray.size(); i++){
                // Parse feat JsonObject
                JsonObject featureJson = (JsonObject) featuresArray.get(i);

                // Create new feat based on JsonObject
                Feat feature = new Feat(featureJson);

                // Add feat to this.features
                this.features.add(feature);
            }
        }
        
        if(json.has("heritages")){
            // Read the array of Strings
            JsonArray heritagesArray = (JsonArray) json.get("heritages");
            for(int i = 0; i < heritagesArray.size(); i++){
                // Parse heritage JsonObject
                JsonObject heritageJson = (JsonObject) heritagesArray.get(i);

                // Create new heritage based on JsonObject
                Heritage heritage = new Heritage(heritageJson);

                // Add heritage to this.heritagesx
                this.heritages.add(heritage);
            }
        }
        
        if(json.has("ancestry_feats")){
            // Read the array of Strings
            JsonArray featsArray = (JsonArray) json.get("ancestry_feats");
            for(int i = 0; i < featsArray.size(); i++){
                // Parse feat JsonObject
                JsonObject featJson = (JsonObject) featsArray.get(i);

                // Create new feat based on JsonObject
                Feat feat = new Feat(featJson);

                // Add feat to this.feats
                this.feats.add(feat);
            }
        }
        
        if(json.has("size")){
            // Read the size attribute
             String size = json.get("size").getAsString();

                // Set size based on TINY
                Size characterSize = Size.TINY;
                switch(size){
                    case "tiny":
                        characterSize = Size.TINY;
                        break;
                    case "small":
                        characterSize = Size.SMALL;
                        break;
                    case "medium":
                        characterSize = Size.MEDIUM;
                        break;
                    case "large":
                        characterSize = Size.LARGE;
                        break;
                    case "huge":
                        characterSize = Size.HUGE;
                        break;
                    case "gargantum":
                        characterSize = Size.GARGANTUAN;
                        break;
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
	public HashSet<Feat> getFeatures(){
		return this.features;
	}

	/**
	 * Setter for this.features.
	 * @param features (HashSet<Feat>)
	 */
	public void setFeatures(HashSet<Feat> features){
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
