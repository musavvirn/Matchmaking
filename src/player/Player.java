package player;

import enums.PlayerStateEnum;
import enums.TiersEnum;

import java.util.Random;

public class Player {
    public String playerId;
    public String name;
    public int rating;
    public TiersEnum tier;
    public PlayerStateEnum playerState;

    public Player(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.playerState = PlayerStateEnum.ONLINE;
        setTier();

        this.playerId = generatePlayerID();
        System.out.println(String.format("Player created: %s, ID: %s, Rating: %s., Tier: %s, Status: %s",
                this.name, this.playerId, this.rating, this.tier, this.playerState));
    }

    private String generatePlayerID() {
        Random r = new Random();
        String id = "";

        for (int i=0; i<8; i++) {
            id = id.concat(String.valueOf(r.nextInt(9)));
        }

        return id;
    }

    private int generateRating() {
        int rating = 1000;
        int r = new Random().nextInt((1000 - 0) + 1);
        rating += r;
        System.out.println(String.format("Rating: %s", rating));
        return rating;
    }

    public void setState(PlayerStateEnum state) {
        this.playerState = state;
    }

    /*
        Adjusts player rating by adding given amount; Called after exiting a game;
        If final rating is negative, resets to 0;

        @param: amount - can be + or - ;
        @return: int rating;
    */
    public int adjustRating(int amount) {
        this.rating = this.rating + amount;
        if (this.rating < 0) {
            this.rating = 0;
        }
        setTier();
        return this.rating;
    }
    /*
        Sets player into rating tier (out of 5 tiers from @TierEnums); called at constructor and at METHOD @adjustRating;

     */
    private void setTier() {

        if (this.rating > 1800) {
            this.tier = TiersEnum.TIER5;
        } else if (this.rating > 1600) {
            this.tier = TiersEnum.TIER4;
        } else if (this.rating > 1400) {
            this.tier = TiersEnum.TIER3;
        } else if (this.rating > 1200) {
            this.tier = TiersEnum.TIER2;
        } else {
            this.tier = TiersEnum.TIER1;
        }
    }

//    public static void main(String[] args) {
//        Player Ghazna = new Player("Ghazna", 1200);
//        System.out.println(Ghazna.adjustRating(600));
//        System.out.println(Ghazna.tier);
//        Ghazna.generateRating();
//
//    }
}
