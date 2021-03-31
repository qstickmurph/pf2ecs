package pf2ecs.model;

public enum Proficiency{
    UNTRAINED(0,"U"),
    TRAINED(2,"T"),
    EXPERT(4,"E"),
    MASTER(6,"M"),
    LEGENDARY(8,"L");

    public final int bonus;
    public final String acronym;

    private Proficiency(int bonus, String acronym){
        this.bonus= bonus;
        this.acronym = acronym;
    }
}
