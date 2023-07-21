package smth.Units;

import java.util.ArrayList;

public class Peasant extends Unit {
    private final int d10 = melee_stat_roll();
    protected int armor, resistance;

    public Peasant(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.movement_points = 9;
        this.max_hp = roll_d10() + 8;
        this.cur_hp = max_hp;
        this.defence = roll_d10();
        this.luck = 1;
        this.initiation = roll_d10() + 2;
        this.attack = roll_d10() + 2;
        this.armor = roll_d10();
        this.resistance = roll_d10();
        this.attack_range = 1;
        coordinates = new Coordinates(x,y);
    }

    private int roll_d10() {
        return d10;
    }

    @Override
    public String toString() {
        return "Peasant{" +
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
            if (this.state.equals(states.get(1))) {
                this.state = states.get(0);
                System.out.printf("Peasant's state has been changed from %s to %s%n", states.get(1), this.state);
            }
        }
    }

    public String getInfo(){
        return super.getInfo();
    }
}
