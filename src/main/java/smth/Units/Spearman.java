package smth.Units;

import java.util.ArrayList;

public class Spearman extends Unit {
    private final int d10 = melee_stat_roll();
    protected int armor, resistance;

    public Spearman(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.movement_points = 6;
        this.max_hp = roll_d10() + 7;
        this.cur_hp = max_hp;
        this.defence = roll_d10() + 2;
        this.luck = 2;
        this.initiation = roll_d10() + 6;
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
                ", coordinates=" + "[" + coordinates.X + ", " + coordinates.Y + "]" +
                '}';
    }

    private int roll_d10() {
        return d10;
    }
    public void step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        cur_hp = getHP();
        if (!getState().equals(states.get(2))) {
            moveToAndAttack(enemyTeam);
        }
    }

    public String getInfo(){
        return super.getInfo();
    }
}
