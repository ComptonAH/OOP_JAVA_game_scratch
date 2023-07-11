import java.util.ArrayList;

public class Sniper extends Unit {

    private final int d8 = archer_stat_roll();
    protected int projectile_quantity;

    public Sniper(String name, int x, int y) {
        this.name = name;
        this.attack_range = 9;
        this.movement_points = 10;
        this.health_points = roll_d8() + 4;
        this.defence = roll_d8();
        this.luck = 2;
        this.initiation = roll_d8() + 6;
        this.projectile_quantity = 5;
        this.attack = roll_d8();
        coordinates = new Coordinates(x,y);
    }

    @Override
    public String toString() {
        return "Sniper{" +
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
    @Override
    public void step(ArrayList<Unit> units) {
        System.out.println(distanceToNearestEnemy(units));
    }

    public String getInfo(){
        return "Sniper";
    }
}
