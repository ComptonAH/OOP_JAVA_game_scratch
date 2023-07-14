import java.util.ArrayList;

public class Spearman extends Unit {
    private final int d10 = melee_stat_roll();
    protected int armor, resistance;

    public Spearman(String name, int x, int y) {
        this.name = name;
        this.movement_points = 12;
        this.max_hp = roll_d10() + 8;
        this.cur_hp = max_hp;
        this.defence = roll_d10() + 2;
        this.luck = 2;
        this.initiation = roll_d10() + 5;
        this.attack = roll_d10() + 5;
        this.armor = roll_d10() + 2;
        this.resistance = roll_d10();
        this.attack_range = 2;
        coordinates = new Coordinates(x,y);
    }

    @Override
    public String toString() {
        return "Spearman{" +
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

    private int roll_d10() {
        return d10;
    }
    public Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        return distanceToNearestEnemy(enemyTeam);
    }

    public String getInfo(){
        return "Spearman";
    }
}
