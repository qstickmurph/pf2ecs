package pf2ecs.model;

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

/** The Subclass class holds all the information about subclass including its description and features.
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
	
	/** The features of the subclass */
	private ArrayList<Feat> features;
	
	/** 
     * Constructor Method
     */
    public Subclass(){
        this.name = "";
        this.description = "";
	    this.features = new ArrayList<>();
    }

    /** 
     * Reads a json file containing a class and creates that Subclass 
     * @param file (File)
     */
    public static Subclass fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Subclass.class);
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new Subclass();
    }

    /**
     * Reads a JsonObject and creates that Subclass 
     * @param json (JsonObject)
     */
    public static Subclass fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, Subclass.class);
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new Subclass();
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
     * Turns this Subclass into a JsonObject
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
	 * Adds feat to this.features.
	 * @param feat (Feat) 
	 */
    public void addFeatures(Feat feat){
        this.features.add(feat);
    }

	/**
	 * Removes feat from this.features if present.
	 * @param feat (Feat)
	 */
    public void removeFeat(Feat feat){
        if(this.features.contains(feat)){
            this.features.remove(feat);
        }
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
