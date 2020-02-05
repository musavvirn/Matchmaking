package player;

import enums.PlayerStateEnum;
import enums.TiersEnum;

import java.util.Random;

public class Player {
    private int playerId;
    private String name;
    private int rating;
    private TiersEnum tier;
    private PlayerStateEnum playerState;

    public Player(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.playerState = PlayerStateEnum.ONLINE;
        setTier();

        Random r = new Random();
        String id = "";

        for (int i=0; i<8; i++) {
            id = id.concat(String.valueOf(r.nextInt(9)));
        }
        this.playerId = Integer.parseInt(id);
        System.out.println(String.format("Player created: %s, ID: %s, Rating: %s., Tier: %s, Status: %s",
                this.name, this.playerId, this.rating, this.tier, this.playerState));
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

    public static void main(String[] args) {
        Player Ghazna = new Player("Ghazna", 1200);
        System.out.println(Ghazna.adjustRating(600));
        System.out.println(Ghazna.tier);

    }
}
