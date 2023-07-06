public class Crossbowman extends Archer {
    private final int d8 = archer_stat_roll();

    public Crossbowman() {
        this.attack_range = 12;
        this.movement_points = 8;
        this.health_points = roll_d8() + 6;
        this.defence = roll_d8() + 2;
        this.luck = 2;
        this.initiation = roll_d8() + 4;
        this.projectile_quantity = 5;
        this.attack = roll_d8() + 2;
    }

    @Override
    public String toString() {
        return "Crossbowman{" +
                "projectile_quantity=" + projectile_quantity +
                ", attack_range=" + attack_range +
                ", health_points=" + health_points +
                ", movement_points=" + movement_points +
                ", attack=" + attack +
                ", defence=" + defence +
                ", initiation=" + initiation +
                ", luck=" + luck +
                '}';
    }

    private int roll_d8() {
        return d8;
    }
}
