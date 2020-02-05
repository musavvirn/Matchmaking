
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;

public class Player {
    public String name;
    public int elo;
    public Set<String> maps = new HashSet();
    public ArrayList<Integer> tgMode = new ArrayList();
    public String mapPriority;

    public Player (String name, int elo) {
        this.name = name;
        this.elo = elo;
    }

    public void setMaps(Set<String> maps) {
        this.maps = maps;
    }

    public void setTgMode(ArrayList<Integer> tgMode) {
        this.tgMode = tgMode;
    }

    public void setMapPriority(String mapPriority) {
        try {
            if (this.maps.contains(mapPriority)) {
                this.mapPriority = mapPriority;
                System.out.println("MAP PRIORITY SET: " +mapPriority);
            } else {
                System.out.println("MAP NOT FOUND IN MAP LIST CHOSEN ...!");

            }
        } catch (Exception e) {
            System.out.println("**EXCEPTION**");
        }
    }
}