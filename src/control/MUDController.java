package control;

import entitites.Item;
import entitites.Player;

import java.util.Scanner;

/**
 * control.MUDController (Skeleton):
 * A simple controller that reads player input and orchestrates
 * basic commands like look around, move, pick up items,
 * check inventory, show help, etc.
 */
public class MUDController {

    private final Player player;

    /**
     * Constructs the controller with a reference to the current player.
     */
    public MUDController(Player player) {
        this.player = player;
    }

    /**
     * Main loop method that repeatedly reads input from the user
     * and dispatches commands until the game ends.
     */
    public void runGameLoop() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome the low text based game! Type 'help' for a list of commands");
        boolean running = true;
        while (running) {
            System.out.println("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            running = handleInput(input);
        }
        System.out.println("Game stopped");
        scanner.close();
    }

    /**
     * Handle a single command input (e.g. 'look', 'move forward', 'pick up sword').
     */
    public boolean handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                if (argument.startsWith("up ")) {
                    pickUp(argument.substring(3));
                } else {
                    System.out.println("Invalid pick up command. Use 'pick up <item>'.");
                }
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                return false;
            default:
                System.out.println("Unknown command. Type 'help' for a list of commands.");
        }
        return true;
    }

    /**
     * Look around the current room: describe it and show items/NPCs.
     */
    private void lookAround() {
        System.out.println("You are in a dark, eerie room. There are mysterious items scattered around.");
    }

    /**
     * Move the player in a given direction (forward, back, left, right).
     */
    private void move(String direction) {
        switch (direction) {
            case "forward":
                System.out.println("You move forward into the next room.");
                break;
            case "back":
                System.out.println("You move back to the previous room.");
                break;
            case "left":
                System.out.println("You turn left and walk into a new space.");
                break;
            case "right":
                System.out.println("You turn right and find a new area.");
                break;
            default:
                System.out.println("Invalid direction. Try 'forward', 'back', 'left', or 'right'.");
        }
    }

    /**
     * Pick up an item (e.g. "pick up sword").
     */
    private void pickUp(String itemName) {
        Item item = new Item(itemName);
        System.out.println("You pick up the " + item + ".");
        player.addItemToInventory(item);
    }

    /**
     * Check the player's inventory.
     */
    private void checkInventory() {
        System.out.println("Player inventory: " + player.getPlayerInventory());
        if (player.getPlayerInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying: " + player.getPlayerInventory());
        }
    }

    /**
     * Show help commands
     */
    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Describe the current room.");
        System.out.println("move <forward|back|left|right> - Move in a direction.");
        System.out.println("pick up <item> - Pick up an item.");
        System.out.println("inventory - List the items you are carrying.");
        System.out.println("help - Show this help message.");
        System.out.println("quit / exit - End the game.");
    }
}