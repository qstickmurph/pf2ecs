package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import pf2ecs.model.PfItem;
import pf2ecs.model.Action;
//import pf2ecs.model.Spell;

/** The Action class holds all the information about each action including its description, any relevant scenario type, and more
 *
 * @author Quinn Murphey
 * @author David Gellhausen
 * @author Jim Richmond
 * @author Alexander Lomeli-Azoubel
 * @since 03/26/2021
 */
public class Inventory {    
	
	/** The items in the inventory */
    private ArrayList<PfItem> items;
    
    /** The items equipped */
    private ArrayList<PfItem> equipped;
    
    /** The items invested */
    private ArrayList<PfItem> invested;
    
    /** The items readied */
    private ArrayList<PfItem> readied;
    
    /** The amount of pp */
    private int pp;
    
    /** The amount of gp */
    private int gp;
    
    /** The amount of sp */
    private int sp;
    
    /** The amount of cp */
    private int cp;
    
    /** Constructor Method
     *  
     */
    public Inventory(){
        this.items = new ArrayList<>();
        this.equipped = new ArrayList<>();
        this.invested = new ArrayList<>();
        this.readied = new ArrayList<>();
        this.pp = 0;
        this.gp = 0;;
        this.sp = 0;
        this.cp = 0;
    }

    /** 
     * Reads a json file containing a feat and creates that Feat
     * @param file (File)
     */
    public static Inventory fromFile(File file){
        Gson gson = new Gson();
        try(Reader reader = new FileReader(file)){
            return gson.fromJson(reader, Inventory.getClass());
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (JsonParseException e) { 
            e.printStackTrace();
        }
        return new Inventory();
    }

    /**
     * Reads a JsonObject and creates that Feat
     * @param json (JsonObject)
     */
    public static Inventory fromJson(JsonObject json){
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, Inventory.getClass());
        } catch(JsonParseException e){
            e.printStackTrace();
        }
        return new Inventory();
    }
    
    /**
     * Exports the character sheet as a json file
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
     * Turns this feat into a JsonObject
     */
    public JsonObject toJson(){
        return null;
    }

    /** 
     * Returns this.items
     *  @return this.items (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getItems(){
        return this.items;
    }

    /** 
     * Adds item to this.items
     * @param item (String)
     */
    
    public void addItem(PfItem pfItem){
    	this.items.add(pfItem);
    }
    
    /** 
     * Removes item from this.items
     * @param item (String)
     */
    public void removeItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.items.remove(pfItem);
    	}
    }

    /** 
     * Returns this.equipped
     *  @return this.equipped (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getEquipped(){
        return this.equipped;
    }
    
    /** 
     * Adds item to this.equipped and removes item from this.items
     * @param item (String)
     */
    public void equipItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.equipped.add(pfItem);
    		this.items.remove(pfItem);
    	}
    }

    /** 
     * Removes item from this.equipped and adds item to this.items
     * @param item (String)
     */
    public void unequipItem(PfItem pfItem){
    	if(this.equipped.contains(pfItem)){
    		this.items.add(pfItem);
    		this.equipped.remove(pfItem);
    	}
    }
    
    /** 
     * Returns this.invested
     *  @return this.invested (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getInvested(){
        return this.invested;
    }
    
    /** 
     * Adds item to this.invested and this.equipped and removes item from this.items
     * @param item (String)
     */
    public void investItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.invested.add(pfItem);
    		this.equipped.add(pfItem);
    		this.items.remove(pfItem);
    	}
    }
    
    /** 
     * Removes item from this.invested and this.equipped and adds item to this.items
     * @param item (String)
     */
    public void uninvestItem(PfItem pfItem){
    	if(this.invested.contains(pfItem)){
    		this.items.add(pfItem);
    		this.invested.remove(pfItem);
    		this.equipped.remove(pfItem);
    	}
    }
    
    /** 
     * Returns this.readied
     *  @return this.readied (ArrayList<PfItem>)
     */
    public ArrayList<PfItem> getReadied(){
        return this.readied;
    }
    
    /** 
     * Adds item to this.readied and removes item from this.items
     * @param item (String)
     */
    public void readyItem(PfItem pfItem){
    	if(this.items.contains(pfItem)){
    		this.readied.add(pfItem);
    		this.items.remove(pfItem);
    	}
    }

    /** 
     * Removes item from this.readied and adds item to this.items
     * @param item (String)
     */
    public void unreadyItem(PfItem pfItem){
    	if(this.readied.contains(pfItem)){
    		this.items.add(pfItem);
    		this.readied.remove(pfItem);
    	}
    }
    
	/**
	 * Getter for this.money.
	 * @return Returns this.money
	 */
	public String getMoney(){
		money = Integer.toString(pp) + "pp " + Integer.toString(gp) + "gp " + Integer.toString(sp) + "sp " + Integer.toString(cp) + "cp";
		return money;
	}
	
	/**
	 * Setter for this.pp.
	 * @param pp (int) Sets this.pp to pp 
	 */
	public void setPp(int pp){
		this.pp = pp;
	}
	
	/**
	 * Setter for this.gp.
	 * @param gp (int) Sets this.gp to gp 
	 */
	public void setGp(int gp){
		this.gp = gp;
	}
	
	/**
	 * Setter for this.sp.
	 * @param sp (int) Sets this.sp to sp
	 */
	public void setSp(int sp){
		this.sp = sp;
	}
	
	/**
	 * Setter for this.cp.
	 * @param cp (int) Sets this.cp to cp 
	 */
	public void setCp(int cp){
		this.cp = cp;
	}

}
