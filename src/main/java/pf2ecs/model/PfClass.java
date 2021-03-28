package pf2ecs.model;

import java.util.HashSet;
import java.util.Hashtable;

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
	
	/** The keyAttribute of the class */
	private Attribute keyAttribute;
	
	/** The proficiency bonuses of the class */
	private Hashtable<String, SkillTraining> proficiencyBonuses = new Hashtable<String, SkillTraining>();
	
	/** The number of free skills of the class */
	private int freeSkills;
	
	/** The subclasses of the class */
	private HashSet<Subclass> subclasses = new HashSet<Subclass>();
	
	/** The features of the class */
	private HashSet<Feat> features = new HashSet<Feat>();

	/** Constructor Method
     *  
     *  @param name (String) The name of the ancestry
     */
    public PfClass(String name){
        this.name = name;
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
     * Returns this.keyAttribute
     * @return this.keyAttribute (Attribute)
     */
    public Attribute getKeyAttribute(){
        return this.keyAttribute;
    }

    /** 
     * Sets this.keyAttribute
     * @param keyAttribute (Attribute)
     */
    public void setKeyAttribute(Attribute keyAttribute){
        this.keyAttribute = keyAttribute;
    }
    
    /**
	 * Getter for this.proficiencyBonuses.
	 * @return Returns this.proficiencyBonuses.
	 */
	public Hashtable<String, SkillTraining> getProficiencyBonuses(){
		return this.proficiencyBonuses;
	}
	
	/**
	 * Setter for this.proficiencyBonuses.
	 * @param proficiencyBonuses (Hashtable<String, SkillTraining>)
	 */
	public void setProficiencyBonuses(Hashtable<String, SkillTraining> proficiencyBonuses){
		this.proficiencyBonuses = proficiencyBonuses;
	}
	
	/**
	 * Adds proficiency and bonus to this.proficiencyBonuses.
	 * @param skill (String) bonus (SkillTraining)
	 */
    public void addProficiencyBonus(String skill, SkillTraining bonus){
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
}
