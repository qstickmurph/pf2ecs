package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayList;
//import pf2ecs.model.Item;
//import pf2ecs.model.Action;
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
    private ArrayList<String> items = new ArrayList<String>();
    
    /** The items equipped */
    private ArrayList<String> equipped = new ArrayList<String>();
    
    /** The items invested */
    private ArrayList<String> invested = new ArrayList<String>();
    
    /** The items readied */
    private ArrayList<String> readied = new ArrayList<String>();
    
    /** The amount of pp */
    private int pp;
    
    /** The amount of gp */
    private int gp;
    
    /** The amount of sp */
    private int sp;
    
    /** The amount of cp */
    private int cp;
    
    /** The amount of total money */
    private String money;
    
    /** Constructor Method
     *  
     *  @param name (ArrayList<String>) The list of items
     */
    public Inventory(ArrayList<String> items){
        this.items = items;
    }
    
    /** 
     * Returns this.items
     *  @return this.items (ArrayList<String>)
     */
    public ArrayList<String> getItems(){
        return this.items;
    }

    /** 
     * Adds item to this.items
     * @param item (String)
     */
    
    public void addItem(String pf2ecs.model.Item){
    	this.items.add(pf2ecs.model.Item);
    }
    
    /** 
     * Removes item from this.items
     * @param item (String)
     */
    public void removeItem(String pf2ecs.model.Item){
    	if(this.items.contains(pf2ecs.model.Item)){
    		this.items.remove(pf2ecs.model.Item);
    	}
    }

    /** 
     * Returns this.equipped
     *  @return this.equipped (ArrayList<String>)
     */
    public ArrayList<String> getEquipped(){
        return this.equipped;
    }
    
    /** 
     * Adds item to this.equipped and removes item from this.items
     * @param item (String)
     */
    public void equipItem(String pf2ecs.model.Item){
    	if(this.items.contains(pf2ecs.model.Item)){
    		this.equipment.add(pf2ecs.model.Item);
    		this.items.remove(pf2ecs.model.Item);
    	}
    }

    /** 
     * Removes item from this.equipped and adds item to this.items
     * @param item (String)
     */
    public void unequipItem(String pf2ecs.model.Item){
    	if(this.equipped.contains(pf2ecs.model.Item)){
    		this.items.add(pf2ec.model.Item);
    		this.equipment.remove(pf2ecs.model.Item);
    	}
    }
    
    /** 
     * Returns this.invested
     *  @return this.invested (ArrayList<String>)
     */
    public ArrayList<String> getInvested(){
        return this.invested;
    }
    
    /** 
     * Adds item to this.invested and this.equipped and removes item from this.items
     * @param item (String)
     */
    public void investItem(String pf2ecs.model.Item){
    	if(this.items.contains(pf2ecs.model.Item)){
    		this.invested.add(pf2ecs.model.Item);
    		this.equipment.add(pf2ecs.model.Item);
    		this.items.remove(pf2ecs.model.Item);
    	}
    }
    
    /** 
     * Removes item from this.invested and this.equipped and adds item to this.items
     * @param item (String)
     */
    public void uninvestItem(String pf2ecs.model.Item){
    	if(this.invested.contains(pf2ecs.model.Item)){
    		this.items.add(pf2ec.model.Item);
    		this.invested.remove(pf2ecs.model.Item);
    		this.equipped.remove(pf2ecs.model.Item);
    	}
    }
    
    /** 
     * Returns this.readied
     *  @return this.readied (ArrayList<String>)
     */
    public ArrayList<String> getReadied(){
        return this.readied;
    }
    
    /** 
     * Adds item to this.readied and removes item from this.items
     * @param item (String)
     */
    public void readyItem(String pf2ecs.model.Item){
    	if(this.items.contains(pf2ecs.model.Item)){
    		this.readied.add(pf2ecs.model.Item);
    		this.items.remove(pf2ecs.model.Item);
    	}
    }

    /** 
     * Removes item from this.readied and adds item to this.items
     * @param item (String)
     */
    public void unreadyItem(String pf2ecs.model.Item){
    	if(this.readied.contains(pf2ecs.model.Item)){
    		this.items.add(pf2ec.model.Item);
    		this.readied.remove(pf2ecs.model.Item);
    	}
    }
    
	/**
	 * Getter for this.money.
	 * @return Returns this.money
	 */
	public String getMoney(){
		money = Integer.toString(pp) + "pp " + Integer.toString(gp) + "gp " + Integer.toString(sp) + "sp " + Integer.toString(cp) + "cp";
		return this.money;
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
