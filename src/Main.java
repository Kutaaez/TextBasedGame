package control;

import entitites.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Zharaskhan");
        MUDController gameController = new MUDController(player);
        gameController.runGameLoop();
    }
}
