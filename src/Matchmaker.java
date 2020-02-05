import java.util.*;

public class Matchmaker {
    private ArrayList<Player> pList;
    private int pCount;
    private HashMap<Integer, ArrayList<Player>> eloCat = new HashMap<>();


    public Matchmaker(ArrayList a) {
        this.pList = a;
        System.out.println(pCount);
        setEloCat();
    }

    public void setEloCat() {
        try {
            ArrayList<Player> p1200 = new ArrayList();
            ArrayList<Player> p1400 = new ArrayList();
            ArrayList<Player> p1600 = new ArrayList();

            pList.forEach(player -> {
                if (player.elo < 1200) {
                    p1200.add(player);
                } else if (player.elo < 1400) {
                    p1400.add(player);
                } else {
                    assert (player.elo > 1400 && player.elo <= 1600);
                    p1600.add(player);
                }
            });

            this.eloCat.put(1200, p1200);
            this.eloCat.put(1400, p1400);
            this.eloCat.put(1600, p1600);

        } catch (Exception e) {
            System.out.println("FAILURE !");
        }
    }

    //matching seq:
    // --> elo --> map priority --> map pool --> tgMode

    public void match(Player p) {
        String result = "FAIL";
        Random r = new Random();
        int x;
        Player matchP = null;
        int max;
        boolean isMatched = false;

        //determine elo category of player
        if (p.elo < 1200) {
            max = 1200;
        } else if (p.elo < 1400) {
            max = 1400;
        } else {
            max = 1600;
        }
        ArrayList<Player> matchList = this.eloCat.get(max);
        System.out.println(this.eloCat.get(max).size());

        //get match based on elo category; if elo gap > 50, rematch once more
        matchP = getMatch(p, r, matchP, max);
        if (matchP != null) {
            if ((this.eloCat.get(max).size() > 1) && ((matchP.elo - p.elo) > 50 || (matchP.elo - p.elo) < -50)) {
                matchP = getMatch(p, r, matchP, max);
            }

            int z = this.eloCat.get(max).size();
            ArrayList<Player> l = this.eloCat.get(max);
            l.remove(matchP);
            this.eloCat.replace(max, l);
            assert this.eloCat.get(max).size() < z;


            //get more precise match based on map priority, if set
            //get more precise match based on tgMode (1v1, 2v2 etc)
            //if map prioroty not set, get more precise based on map pool
        }


        if (matchP == null) {
            assert result.equals("FAIL");
        } else {
            result = p.name +", " +p.elo +" X " +matchP.name +", " +matchP.elo;
        }

        System.out.println("MATCH SUCCESS XD.. ");
        System.out.println(result);
    }

    private Player getMatch(Player p, Random r, Player matchP, int max) {

        int x;
        ArrayList<Player> l = this.eloCat.get(max);
        l.remove(p);

        if (this.eloCat.get(max).size() != 0) {
            if (this.eloCat.get(max).size() == 1) {
                matchP = this.eloCat.get(max).get(0);
                System.out.println("ONLY 1 MATCH ><");
            } else {
                x = r.nextInt(this.eloCat.get(max).size());
                matchP = this.eloCat.get(max).get(x);
                while (matchP.equals(p)) {
                    matchP = this.eloCat.get(max).get(x);
                }
            }
            System.out.println("MATCH FOUND: " +matchP.name);
        } else {
            System.out.println("NO MATCH .. " +max );
        }
        return matchP;
    }

    public static void main(String[] args) {
        Player a = new Player("Ghazna", 1350);
        Player b = new Player("Octy", 1362);
        Player c = new Player("Max", 1500);
        Player d = new Player("Jupe", 1599);
        Player e = new Player("Rez", 1463);
        Player f = new Player("KSd", 1421);
        Player g = new Player("Hsuh2", 1572);
        Player h = new Player("Sweed", 1497);
        Player i = new Player("Ash", 1502);
        Player j = new Player("Rzorrr", 1400);
        Player k = new Player("__DS", 1400);


        ArrayList<Player> pp = new ArrayList<Player>();
        pp.add(a);pp.add(b);pp.add(c);pp.add(d);pp.add(e);pp.add(f);pp.add(g);pp.add(h);pp.add(i);pp.add(j);pp.add(k);

        Matchmaker m = new Matchmaker(pp);
        m.match(a);


        Set<String> x = new HashSet<>();
        x.add("Arabia");
        x.add("Arena");
        x.add("Nomad");
        x.add("BF");
        a.setMaps(x);
//        a.setMapPriority("Arena");
        a.setMapPriority("Hideout");
        System.out.println("sadasdas");
    }
}
