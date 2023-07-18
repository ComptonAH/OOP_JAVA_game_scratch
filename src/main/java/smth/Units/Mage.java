package smth.Units;

import java.util.ArrayList;

public class Mage extends Unit {
    private final int d6 = magic_stat_roll();
    protected int mana_points;

    public Mage(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.attack_range = 8;
        this.movement_points = 10;
        this.max_hp = roll_d6() + 6;
        this.cur_hp = max_hp;
        this.defence = roll_d6();
        this.luck = 1;
        this.initiation = roll_d6() + 6;
        this.attack = roll_d6() + 4;
        this.mana_points = roll_d6() + 10;
        coordinates = new Coordinates(x, y);
    }


    @Override
    public String toString() {
        return "smth.Units.Mage{" +
                "mana_points=" + mana_points +
                ", attack_range=" + attack_range +
                ", health_points=" + max_hp +
                ", movement_points=" + movement_points +
                ", attack=" + attack +
                ", defence=" + defence +
                ", initiation=" + initiation +
                ", luck=" + luck +
                ", coordinates=" + "[" + coordinates.X + ", " + coordinates.Y + "]" +
                '}';
    }

    private int roll_d6() {
        return d6;
    }

    @Override
    public Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        Unit enemy = distanceToNearestEnemy(enemyTeam);
        int HP_until_attack = enemy.cur_hp;
        if (checkMP() >= 4) {
            this.mana_points -= 4;
            System.out.printf("smth.Units.Mage dealt %s damage to %s. Enemy's HP until the attack: %s, afterward: %s%n", castSpell(enemy,enemyTeam), enemy.name, HP_until_attack, enemy.cur_hp);
        } else {
            int prev_MP = this.mana_points;
            this.mana_points += 2;
            System.out.printf("smth.Units.Mage restored 2 MP from %d to %d", prev_MP, this.mana_points);
        }
        return null;
    }

    public String getInfo(){
        return String.format("%s MP: %d",super.getInfo(), this.mana_points);
    }

    private int checkMP() {
        return mana_points;
    }

    private int castSpell(Unit enemy, ArrayList<Unit> enemyTeam) {
        return doDamage(enemy, enemyTeam);
    }
}
