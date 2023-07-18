package smth.Units;

import java.util.ArrayList;

public class Rogue extends Unit {
    protected int armor, resistance;
    private final int d10 = melee_stat_roll();

    public Rogue(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.movement_points = 10;
        this.max_hp = roll_d10() + 4;
        this.cur_hp = max_hp;
        this.defence = roll_d10();
        this.luck = 3;
        this.initiation = roll_d10() + 9;
        this.attack = roll_d10() + 6;
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
        return "smth.Units.Rogue{" +
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

    public Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        double X = this.coordinates.X;
        double Y = this.coordinates.Y;
        Unit enemy = distanceToNearestEnemy(enemyTeam);
        double dist_to_enemy = Math.sqrt(Math.pow(enemy.coordinates.X, 2) +
                                        Math.pow(enemy.coordinates.Y, 2));
        if (dist_to_enemy > 0 && dist_to_enemy <= 2) {
            int HP_until_attack = enemy.cur_hp;
            System.out.printf("smth.Units.Rogue dealt %s damage to %s. Enemy's HP until the attack: %s, afterward: %s%n", doDamage(enemy, enemyTeam), enemy.name, HP_until_attack, enemy.cur_hp);
        } else {
            System.out.printf("smth.Units.Rogue changed position from [%s,%s] to [%s,%s].%n", X,Y, enemy.coordinates.X, enemy.coordinates.Y);
        }
        return null;
    }

    @Override
    public String getInfo(){
        return super.getInfo();
    }
}
