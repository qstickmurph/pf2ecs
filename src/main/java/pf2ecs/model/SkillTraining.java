package pf2ecs.model;

public enum SkillTraining{
    UNTRAINED(0),
    TRAINED(2),
    EXPERT(4),
    MASTER(6),
    LEGENDARY(8);

    public final int label;

    private SkillTraining(int label){
        this.label = label;
    }
}
