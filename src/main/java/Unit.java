import java.util.*;

public abstract class Unit implements InGameInterface {
    protected int movement_points, attack, defence, initiation, luck, attack_range;
    protected int health_points;
    protected String name;
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
    public String getInfo() {
        return name;
    }
//    Первое решение с лишними методами и переменными
//    public String distanceToClosestUnit(ArrayList<Unit> enemyTeam) {
//        int unitX = this.getX();
//        int unitY = this.getY();
//        Double min_dist = null;
//        Map<Double, String> dist_list = new TreeMap<>();
//        for (int i = 0; i < enemyTeam.size(); i++) {
//            Unit enemy = enemyTeam.get(i);
//            String enemyName = enemy.name;
//            int enemyX = enemy.getX();
//            int enemyY = enemy.getY();
//            Double dist = Math.sqrt(Math.pow(Math.subtractExact(unitX, enemyX), 2) + Math.pow(Math.subtractExact(unitY, enemyY), 2));
//            if (i == 0) {
//                min_dist = dist;
//            } else if (dist < min_dist) {
//                min_dist = dist;
//            }
//            dist_list.put(dist, enemyName);
//        }
//        return dist_list.get(min_dist) + " " + min_dist;
//    }

    public String distanceToNearestEnemy(ArrayList<Unit> enemyTeam) {
        Double min_dist = null;
        Map<Double, String> dist_list = new TreeMap<>();
        for (int i = 0; i < enemyTeam.size(); i++) {
            String enemyName = enemyTeam.get(i).name;
            Double dist = Math.sqrt(Math.pow(Math.subtractExact(this.coordinates.X, enemyTeam.get(i).coordinates.X), 2) +
                    Math.pow(Math.subtractExact(this.coordinates.Y, enemyTeam.get(i).coordinates.Y), 2));
            if (i == 0) {
                min_dist = dist;
            } else if (dist < min_dist) {
                min_dist = dist;
            }
            dist_list.put(dist, enemyName);
        }
        return dist_list.get(min_dist) + " " + min_dist;
    }
}

