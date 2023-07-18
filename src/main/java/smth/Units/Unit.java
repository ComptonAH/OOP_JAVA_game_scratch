package smth.Units;

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
        return Math.max(this.cur_hp, 0);
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
            return doDamage(new_enemy, enemyTeam);
        }
        return this.attack;
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
        ArrayList<Unit> units = new ArrayList<>(dist_list.values());
        int count = 0;
        while (units.get(count).cur_hp <= 0) {
            if (units.get(count).cur_hp > 0) {
                return units.get(count);
            }
            count++;
        }
        return units.get(count);
    }
}

