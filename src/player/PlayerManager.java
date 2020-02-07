package player;

import java.util.ArrayList;
import java.util.Random;

public class PlayerManager {
    public int quantityOfPlayers;
    public ArrayList<Player> listOfPlayers = new ArrayList<>();
    public boolean notEmpty = true;

    /*
        Constructor; generates a list of players of given size
     */
    public PlayerManager(int n) {
        for (int i=1; i<=n; i++) {
            this.listOfPlayers.add(this.generatePlayer());
        }

        this.quantityOfPlayers = this.listOfPlayers.size();
        System.out.println(String.format("Size of player list: %d", this.quantityOfPlayers));
    }
    /*
        Generates a single player with random name & rating
        @return: Player
     */
    public Player generatePlayer() {
        int rating = generateRating();
        String name = "Ghazna".concat(Integer.toString(new Random().nextInt(30)));
        Player player = new Player(name, rating);
        return player;
    }
    /*
        Generates random rating from 1000 - 2000
        @return: int rating
     */
    private int generateRating() {
        int rating = 1000;
        int r = new Random().nextInt((1000 - 0) + 1);
        rating += r;
        System.out.println(String.format("Rating: %s", rating));
        return rating;
    }

    /*
        Adds given player;
        @throws: Exception if player already in the list
     */
    public void addPlayer(Player p) throws Exception{
        if (!this.listOfPlayers.contains(p)) {
            this.listOfPlayers.add(p);
            this.quantityOfPlayers++;
            System.out.println(String.format("%s has been added!", p.name));
        } else {
            throw new Exception(String.format("Player %s ALREADY EXISTS in the list!", p.name));
        }

    }

    public void removePlayer(Player p) throws Exception {
        if (this.listOfPlayers.contains(p)) {
            this.listOfPlayers.remove(p);
            this.quantityOfPlayers--;
            System.out.println(String.format("%s has been removed!", p.name));
        } else {
            throw new Exception(String.format("Player %s DOES NOT EXIST in the list!", p.name));
        }
    }


}
