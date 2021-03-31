package pf2ecs.model;

public enum Ability{
    STR("STR"),
    DEX("DEX"),
    CON("CON"),
    INT("INT"),
    WIS("WIS"),
    CHA("CHA");

    public final String label;

    private Ability(String label){
        this.label = label;
    }
}
