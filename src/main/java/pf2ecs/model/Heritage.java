package pf2ecs.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import pf2ecs.model.Feat;

/** The Heritage class holds the description of a character heritage
*
* @author Quinn Murphey
* @author David Gellhausen
* @author Jim Richmond
* @author Alexander Lomeli-Azoubel
* @since 03/26/2021
*/
public class Heritage {

	/** The name of the heritage */
	private String name;
	
	/** The description of the heritage */
	private String description;
	
	/** The description of the heritage */
	private Feat feat;

	/** Constructor Method
     *  
     *  @param name (String) The name of the heritage
     */
    public Heritage(){
        this.name = "";
        this.description = "";
        this.feat = new Feat();
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     *
     */
    public static Heritage fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Heritage.getClass());
        } catch (IOException e) { 
            e.printStackTrace();
            return new Ancestry();
        }
    }

    /**
     * Reads a JsonObject and creates that Feat
     * @param json (JsonObject)
     */
    public static Heritage fromJson(JsonObject json){
        try{
            Gson gson = new Gson();
            return gson.fromJson(json, Heritage.getClass());
        }catch (JsonParseException e){
            e.printStackTrace();
            return new Ancestry();
        }
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
    
	/** Constructor Method
     *  
     *  @param json (String) The name of the background
     */
    public static Heritage fromJson(JsonObject json){
        Gson gson = new Gson(); 
        return gson.fromJson(json, Heritage.class);
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
}
