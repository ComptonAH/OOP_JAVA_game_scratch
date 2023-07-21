package smth.Units;

import java.util.ArrayList;

public class Crossbowman extends Unit {
    private final int d8 = archer_stat_roll();
    protected int projectile_quantity;

    public Crossbowman(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.attack_range = 10;
        this.movement_points = 8;
        this.max_hp = roll_d8() + 6;
        this.cur_hp = max_hp;
        this.defence = roll_d8() + 2;
        this.luck = 2;
        this.initiation = roll_d8() + 9;
        this.projectile_quantity = 5;
        this.attack = roll_d8();
        coordinates = new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return "Crossbowman{" +
                "projectile_quantity=" + projectile_quantity +
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

    private int roll_d8() {
        return d8;
    }

    @Override
    public void step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        if (!getState().equals(states.get(2))) {
            if (getHP() <= 0) {
                System.out.println("This character is dead");
            } else if (checkProjectiles() <= 0) {
                moveToAndAttack(enemyTeam);
            } else {
                Unit enemy = super.distanceToNearestEnemy(enemyTeam);
                int HP_until_attack = enemy.cur_hp;
                System.out.printf("Crossbowman dealt %s damage to %s. Enemy's HP until the attack: %s, afterward: %s%n", doDamage(enemy, enemyTeam), enemy.name, HP_until_attack, enemy.cur_hp);
                if (!this.hasPeasant(allyTeam)) {
                    this.projectile_quantity -= 1;
                } else {
                    System.out.println("You have a peasant in your team. He supplied you an arrow.");
                }
            }
        }
    }


    public String getInfo() {
        return String.format("%s arr: %d ", super.getInfo(), this.projectile_quantity);
    }

    private int checkProjectiles() {
        return Math.max(this.projectile_quantity, 0);
    }

    private Boolean hasPeasant(ArrayList<Unit> ally_team) {
        for (Unit unit : ally_team) {
            if (unit.name.equals("Peasant")) {
                if (unit.cur_hp > 0) {
                    if (unit.state.equals(unit.states.get(0))) {
                        unit.state = states.get(1);
                        System.out.printf("Peasant's state has been changed from %s to %s%n", states.get(0), unit.state);
                        return true;
                    } else {
                        System.out.println("Your peasant is busy. Projectile quantity -1.");
                        return false;
                    }
                } else {
                    System.out.println("Your peasant is dead");
                    return false;
                }
            }
        }
        System.out.println("You have no peasant in your team. Projectile quantity -1.");
        return false;
    }

}
