package test;

import org.junit.Assert;
import org.junit.Test;
import player.Player;
import player.PlayerManager;

public class PlayerManagerTest {

    PlayerManager PM = new PlayerManager(100);
    Player p1 = new Player("SirLawrence", 1500);
    Player p2 = new Player("Octy", 1999);

    @Test
    public void test_PlayerManger() {
        Assert.assertEquals(100, PM.quantityOfPlayers);
    }

    @Test
    public void test_AddPlayer_1() {
        Assert.assertFalse(PM.listOfPlayers.contains(p1));
        Assert.assertTrue(PM.quantityOfPlayers == 100);
    }


    @Test
    public void test_AddPlayer_2() throws Exception {
        PM.addPlayer(p2);
        Assert.assertTrue(PM.listOfPlayers.contains(p2));
        Assert.assertTrue(PM.quantityOfPlayers == 101);
    }

    @Test(expected = Exception.class)
    public void test_AddPlayer_3() throws Exception {
        PM.addPlayer(p2);
        PM.addPlayer(p2);
        Assert.assertTrue(PM.listOfPlayers.contains(p2));
        Assert.assertTrue(PM.quantityOfPlayers == 101);
    }

    @Test(expected = Exception.class)
    public void test_RemovePlayer_1() throws Exception {
        PM.removePlayer(p1);
        Assert.assertFalse(PM.listOfPlayers.contains(p1));
        Assert.assertTrue(PM.quantityOfPlayers == 100);
    }

    @Test
    public void test_RemovePlayer_2() throws Exception {
        PM.addPlayer(p2);
        PM.removePlayer(p2);
        Assert.assertFalse(PM.listOfPlayers.contains(p2));
        Assert.assertTrue(PM.quantityOfPlayers == 100);
    }

}
