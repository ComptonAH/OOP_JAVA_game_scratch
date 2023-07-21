package smth.Units;

import java.util.*;

public class Monk extends Unit {
    private final int d6 = magic_stat_roll();
    protected int mana_points, spell_quantity, ability_points;

    public Monk(String name, int x, int y) {
        this.state = states.get(0);
        this.name = name;
        this.attack_range = 7;
        this.movement_points = 8;
        this.max_hp = roll_d6() + 6;
        this.cur_hp = max_hp;
        this.defence = roll_d6();
        this.luck = 1;
        this.initiation = roll_d6() + 9;
        this.attack = roll_d6() + 2;
        this.ability_points = roll_d6() + 4;
        this.mana_points = 16;
        this.spell_quantity = 5;
        coordinates = new Coordinates(x, y);
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
                ", coordinates=" + "[" + coordinates.X + ", " + coordinates.Y + "]" +
                '}';
    }

    private int roll_d6() {
        return d6;
    }

    public void step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam) {
        cur_hp = getHP();
        if (!getState().equals(states.get(2))) {
            if (checkMP() >= 4) {
                this.mana_points -= 4;
                healing(allyTeam);
            } else {
                moveToAndAttack(enemyTeam);
            }
        }
    }

    private int healing(ArrayList<Unit> allyteam) {
        allyteam.sort(Comparator.comparingInt(o -> o.cur_hp));
        Unit ally;
        for (int i = 0; i < allyteam.size(); i++) {
            if (allyteam.get(i).cur_hp > 0 && allyteam.get(i).cur_hp != allyteam.get(i).max_hp){
                ally = allyteam.get(i);
                if (ally.cur_hp != 0) {
                    int HP_before_healing = ally.cur_hp;
                    ally.cur_hp += 6;
                    if (ally.cur_hp > ally.max_hp) {
                        ally.cur_hp = ally.max_hp;
                    }
                    System.out.printf("Monk healed %s from %d to %d.%n", ally.name, HP_before_healing, ally.cur_hp);
                    return ally.cur_hp;
                }
                break;
            }
        }
        return cur_hp;
    }

    public String getInfo(){
        return super.getInfo();
    }
    private int checkMP() {
        return this.mana_points;
    }
}
