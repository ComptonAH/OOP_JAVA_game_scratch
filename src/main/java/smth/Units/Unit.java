package smth.Units;

import smth.AnsiColors;
import smth.Main;

import java.util.*;

public abstract class Unit implements InGameInterface {
    protected int movement_points;
    protected int attack;
    protected int defence;
    public int initiation;
    protected int luck;
    protected int attack_range;
    protected int max_hp, cur_hp;
    public String name;
    public ArrayList<String> states = new ArrayList<>(Arrays.asList("free", "busy", "dead"));
    public String state;
    Coordinates coordinates;

    static int archer_stat_roll() {
        return new Random().nextInt(1, 8);
    }

    static int magic_stat_roll() {
        return new Random().nextInt(1, 6);
    }

    static int melee_stat_roll() {
        return new Random().nextInt(1, 10);
    }

    @Override
    public String getInfo() {
        return String.format("%s  %s ♡: %d ⚔: %s Ar %d In %d",
                this.name, this.getClass().getSimpleName(), this.cur_hp,
                this.attack, this.defence, this.initiation);
    }

    public int getHP() {
        if (this.cur_hp <= 0) {
            this.state = states.get(2);
            return this.cur_hp;
        }
        return this.cur_hp;
    }

    public String getState() {
        return this.state;
    }

    public Double[] getCoords() {
        Double[] coords = new Double[2];
        coords[0] = this.coordinates.X;
        coords[1] = this.coordinates.Y;
        return coords;
    }

    public int doDamage(Unit enemy, ArrayList<Unit> enemyTeam) {
        if (enemy.state.equals(states.get(0))) {
            enemy.cur_hp = enemy.cur_hp - this.attack;
            if (enemy.cur_hp <= 0) {
                enemy.cur_hp = 0;
            }
        } else if (enemy.state.equals(states.get(2))) {
            Unit new_enemy = distanceToNearestEnemy(enemyTeam);
            doDamage(new_enemy, enemyTeam);
        }
        return this.attack;
    }

    public void moveToAndAttack(ArrayList<Unit> enemyTeam) {
        double X = this.coordinates.X;
        double Y = this.coordinates.Y;
        Unit enemy = distanceToNearestEnemy(enemyTeam);
        if (enemy != null) {
            double dist_to_enemy = Math.sqrt(Math.pow(Math.subtractExact((int) this.coordinates.X, (int) enemy.coordinates.X), 2) +
                    Math.pow(Math.subtractExact((int) this.coordinates.Y, (int) enemy.coordinates.Y), 2));
            if (dist_to_enemy > 0 && dist_to_enemy <= 2) {
                int HP_until_attack = enemy.cur_hp;
                System.out.printf("%s dealt %s damage to %s. Enemy's HP until the attack: %s, afterward: %s%n", this.name, doDamage(enemy, enemyTeam), enemy.name, HP_until_attack, enemy.cur_hp);
            } else {
                if (this.getClass().getSimpleName().equals("Rogue") || this.getClass().getSimpleName().equals("Sniper") || this.getClass().getSimpleName().equals("Mage")) {
                    if (enemy.coordinates.Y - this.coordinates.Y > 0) {
                        this.coordinates.Y = enemy.coordinates.Y - this.coordinates.Y;
                    }
                    this.coordinates.X = enemy.coordinates.X - this.coordinates.X;
                    System.out.printf("%s changed position from [%s,%s] to [%s,%s].%n", this.name, X, Y, this.coordinates.X, this.coordinates.Y);
                } else {
                    if (enemy.coordinates.Y - this.coordinates.Y < 0) {
                        this.coordinates.Y = this.coordinates.Y - enemy.coordinates.Y;
                    }
                    this.coordinates.X = this.coordinates.X - (this.coordinates.X - enemy.coordinates.X + 1);
                    System.out.printf("%s changed position from [%s,%s] to [%s,%s].%n", this.name, X, Y, this.coordinates.X, this.coordinates.Y);
                }
            }
        }
    }

    public Unit distanceToNearestEnemy(ArrayList<Unit> enemyTeam) {
        Double min_dist = null;
        Map<Double, Unit> dist_list = new TreeMap<>();
        for (int i = 0; i < enemyTeam.size(); i++) {
            Double dist = Math.sqrt(Math.pow(Math.subtractExact((int) this.coordinates.X, (int) enemyTeam.get(i).coordinates.X), 2) +
                    Math.pow(Math.subtractExact((int) this.coordinates.Y, (int) enemyTeam.get(i).coordinates.Y), 2));
            if (i == 0) {
                min_dist = dist;
            } else if (dist < min_dist) {
                min_dist = dist;
            }
            dist_list.put(dist, enemyTeam.get(i));
        }
        ArrayList<Unit> enemies = new ArrayList<>(dist_list.values());
        for (Unit enemy : enemies) {
            if (enemy.cur_hp > 0) {
                return enemy;
            }
        }
        return null;
    }
}

