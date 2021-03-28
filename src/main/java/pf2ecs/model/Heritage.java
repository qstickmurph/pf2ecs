package pf2ecs.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	/** Constructor Method
     *  
     *  @param name (String) The name of the heritage
     */
    public Heritage(String name){
        this.name = name;
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
