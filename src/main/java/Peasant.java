public class Peasant extends MeleeClass {
    private final int d10 = melee_stat_roll();


    public Peasant() {
        this.movement_points = 9;
        this.health_points = roll_d10() + 5;
        this.defence = roll_d10();
        this.luck = 1;
        this.initiation = roll_d10() + 3;
        this.attack = roll_d10() + 2;
        this.armor = roll_d10();
        this.resistance = roll_d10();
    }

    private int roll_d10() {
        return d10;
    }

    @Override
    public String toString() {
        return "Peasant{" +
                "armor=" + armor +
                ", resistance=" + resistance +
                ", health_points=" + health_points +
                ", movement_points=" + movement_points +
                ", attack=" + attack +
                ", defence=" + defence +
                ", initiation=" + initiation +
                ", luck=" + luck +
                '}';
    }
}
