import java.util.ArrayList;

public class Rogue extends Unit {
    protected int armor, resistance;
    private final int d10 = melee_stat_roll();
    public Rogue(String name, int x, int y) {
        this.name = name;
        this.movement_points = 16;
        this.health_points = roll_d10() + 3;
        this.defence = roll_d10();
        this.luck = 3;
        this.initiation = roll_d10() + 6;
        this.attack = roll_d10() + 6;
        this.armor = roll_d10() + 1;
        this.resistance = roll_d10() + 2;
        this.attack_range = 1;
        coordinates = new Coordinates(x,y);
    }

    private int roll_d10() {
        return d10;
    }

    @Override
    public String toString() {
        return "Rogue{" +
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

    @Override
    public void step(ArrayList<Unit> units) {
        System.out.println(distanceToNearestEnemy(units));
    }

    @Override
    public String getInfo() {
        return "Rogue";
    }
}
