package pf2ecs.model;

public enum Size{
    TINY("Tiny"),
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large"),
    HUGE("Huge"),
    GARGANTUAN("Gargantuan");

    public String label;

    private Size(String label){
        this.label = label;
    }
}
