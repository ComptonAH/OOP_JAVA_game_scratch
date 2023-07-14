import java.util.ArrayList;

public class Monk extends Unit {
    private final int d6 = magic_stat_roll();
    protected int mana_points, spell_quantity, ability_points;

    public Monk(String name, int x, int y) {
        this.name = name;
        this.attack_range = 7;
        this.movement_points = 8;
        this.max_hp = roll_d6() + 8;
        this.cur_hp = max_hp;
        this.defence = roll_d6();
        this.luck = 1;
        this.initiation = roll_d6() + 3;
        this.attack = roll_d6() + 2;
        this.ability_points = roll_d6() + 4;
        this.mana_points = roll_d6() + 6;
        this.spell_quantity = 5;
        coordinates = new Coordinates(x,y);
    }

    @Override
    public String toString() {
        return "Monk{" +
                "mana_points=" + mana_points +
                ", spell_quantity=" + spell_quantity +
                ", ability_points=" + ability_points +
                ", attack_range=" + attack_range +
                ", health_points=" + max_hp +
                ", movement_points=" + movement_points +
                ", attack=" + attack +
                ", defence=" + defence +
                ", initiation=" + initiation +
                ", luck=" + luck +
                '}';
    }

    private int roll_d6() {
        return d6;
    }

    public Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        return distanceToNearestEnemy(enemyTeam);
    }

    public String getInfo(){
        return "Monk";
    }
}
