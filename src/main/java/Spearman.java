public class Spearman extends MeleeClass {
    private final int d10 = melee_stat_roll();
    public Spearman() {
        this.movement_points = 12;
        this.health_points = roll_d10() + 8;
        this.defence = roll_d10() + 2;
        this.luck = 2;
        this.initiation = roll_d10() + 5;
        this.attack = roll_d10() + 5;
        this.armor = roll_d10() + 2;
        this.resistance = roll_d10();
    }

    private int roll_d10() {
        return d10;
    }

    @Override
    public String toString() {
        return "Spearman{" +
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
