package pf2ecs.model;

import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/** The Subclass class holds all the information about subclass including its description and feats.
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class Subclass {

	/** The name of the subclass */
	private String name;
	
	/** The description of the subclass */
	private String description;
	
	/** The feats of the subclass */
	private HashSet<Feat> feats;
	
	/** 
     * Constructor Method
     */
    public Subclass(){
        this.name = "";
        this.description = "";
	    this.feats = new HashSet<>();
    }

    /** 
     * Reads a json file containing a class and creates that SubClass 
     * @param file (File)
     */
    public static SubClass fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, SubClass.getClass());
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new SubClass();
    }

    /**
     * Reads a JsonObject and creates that SubClass 
     * @param json (JsonObject)
     */
    public static SubClass fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, SubClass.getClass());
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new SubClass();
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
     * Turns this SubClass into a JsonObject
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
}
