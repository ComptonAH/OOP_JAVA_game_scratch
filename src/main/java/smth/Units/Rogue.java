package smth.Units;

import java.util.ArrayList;

public class Rogue extends Unit {
    protected int armor, resistance;
    private final int d10 = melee_stat_roll();

    public Rogue(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.movement_points = 9;
        this.max_hp = roll_d10() + 7;
        this.cur_hp = max_hp;
        this.defence = roll_d10();
        this.luck = 3;
        this.initiation = roll_d10() + 9;
        this.attack = roll_d10() + 2;
        this.armor = roll_d10() + 1;
        this.resistance = roll_d10() + 2;
        this.attack_range = 1;
        coordinates = new Coordinates(x, y);
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
                ", coordinates=" + "[" + coordinates.X + ", " + coordinates.Y + "]" +
                '}';
    }

    public void step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        cur_hp = getHP();
        if (!getState().equals(states.get(2))) {
            moveToAndAttack(enemyTeam);
        }
    }

    @Override
    public String getInfo(){
        return super.getInfo();
    }
}
