package pf2ecs.model;

public enum Proficiency{
    UNTRAINED(0),
    TRAINED(2),
    EXPERT(4),
    MASTER(6),
    LEGENDARY(8);

    public final int bonus;

    private Proficiency(int bonus){
        this.bonus= bonus;
    }
}
