import java.util.ArrayList;

public class Rogue extends Unit {
    protected int armor, resistance;
    private final int d10 = melee_stat_roll();
    public Rogue(String name, int x, int y) {
        this.name = name;
        this.movement_points = 16;
        this.max_hp = roll_d10() + 3;
        this.cur_hp = max_hp;
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
                ", health_points=" + max_hp +
                ", movement_points=" + movement_points +
                ", attack=" + attack +
                ", defence=" + defence +
                ", initiation=" + initiation +
                ", luck=" + luck +
                '}';
    }

    public Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        return distanceToNearestEnemy(enemyTeam);
    }

    @Override
    public String getInfo() {
        return "Rogue";
    }
}
