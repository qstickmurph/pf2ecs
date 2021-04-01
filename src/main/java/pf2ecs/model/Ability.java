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

    public static Ability toAbility(String str){
        switch( str.toUpperCase() ){
            case "STRENGTH":
                return Ability.STR;
            case "DEXTERITY":
                return Ability.DEX;
            case "CONSTITUTION":
                return Ability.CON;
            case "INTELLIGENCE":
                return Ability.INT;
            case "WISDOM":
                return Ability.WIS;
            case "CHARISMA":
                return Ability.CHA;
        }
        return STR;       
    }

    public String toString(){
        switch( this ){
            case STR:
                return "Strength";
            case DEX:
                return "Dexterity";
            case CON:
                return "Constitution";
            case INT:
                return "Intelligence";
            case WIS:
                return "Wisdom";
            case CHA:
                return "Charisma";
            default:
                return "Free";
        }
    }
}
