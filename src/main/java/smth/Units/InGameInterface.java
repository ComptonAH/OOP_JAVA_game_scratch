package smth.Units;

import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<Unit> allyTeam, ArrayList<Unit> enemyTeam);
    String getInfo();
}
