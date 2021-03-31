package pf2ecs.model;

public enum Proficiency{
    UNTRAINED(0,"Untrained"),
    TRAINED(2,"Trained"),
    EXPERT(4,"Expert"),
    MASTER(6,"Master"),
    LEGENDARY(8,"Legendary");

    public final int bonus;
    public final String label;

    private Proficiency(int bonus, String label){
        this.bonus= bonus;
        this.label = label;
    }
}
