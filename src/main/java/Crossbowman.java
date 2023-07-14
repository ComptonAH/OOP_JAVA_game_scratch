import java.util.ArrayList;

public class Crossbowman extends Unit {
    private final int d8 = archer_stat_roll();
    protected int projectile_quantity;

    public Crossbowman(String name, int x, int y) {
        this.name = name;
        this.attack_range = 12;
        this.movement_points = 8;
        this.max_hp = roll_d8() + 6;
        this.cur_hp = max_hp;
        this.defence = roll_d8() + 2;
        this.luck = 2;
        this.initiation = roll_d8() + 4;
        this.projectile_quantity = 5;
        this.attack = roll_d8() + 2;
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
                '}';
    }

    private int roll_d8() {
        return d8;
    }

    @Override
    public Unit step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        cur_hp = checkHP();
        projectile_quantity = checkProjectiles();
        if (cur_hp <= 0) {
            System.out.println("This character is dead");
        } else if (projectile_quantity <= 0) {
            System.out.println("This character has no projectiles");
        } else {
            Unit enemy = super.distanceToNearestEnemy(enemyTeam);
            int HP_until_attack = enemy.cur_hp;
            System.out.printf("You dealt %s damage to %s. Enemy's HP until the attack: %s, afterward: %s%n", doDamage(enemy), enemy.name, HP_until_attack, enemy.cur_hp);
            System.out.println(this.projectile_quantity);
            if (this.hasPeasant(allyTeam)) {
                this.projectile_quantity -= 1;
                System.out.println(this.projectile_quantity);
            } else {
                System.out.println("You have a peasant in your team. He supplied you an arrow");
                System.out.println(this.projectile_quantity);
            }

        }
        return null;
    }


    public String getInfo() {
        return "Crossbowman";
    }

    public int doDamage(Unit enemy) {
        enemy.cur_hp = enemy.cur_hp - this.attack;
        return this.attack;
    }

    private int checkProjectiles() {
        return Math.max(this.projectile_quantity, 0);
    }

    private int checkHP() {
        return Math.max(this.cur_hp, 0);
    }

    private Boolean hasPeasant(ArrayList<Unit> ally_team) {
        for (Unit unit : ally_team) {
            if (unit.toString().equals("Peasant")) {
                return true;
            }
        }
        return false;
    }

}
