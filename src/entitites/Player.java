package entitites;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private String playerDescription;
    private int playerHealth;


    private List<Item> playerInventory;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerHealth = 100;
        this.playerInventory = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerDescription() {
        return playerDescription;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public List<Item> getPlayerInventory() {
        return playerInventory;
    }
}
