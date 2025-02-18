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
    private boolean running;

    /**
     * Constructs the controller with a reference to the current player.
     */
    public MUDController(Player player) {
        this.player = player;
        this.running = true;

        // Initialize fields here (if needed)
    }

    /**
     * Main loop method that repeatedly reads input from the user
     * and dispatches commands until the game ends.
     */
    public void runGameLoop() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome the low text based game! Type 'help' for a list of commands");
        while (running) {
            System.out.println("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }
        System.out.println("Game stopped");
        scanner.close();
        // TODO: Implement a loop that:
        // 1) Prints a prompt (e.g., "> ")
        // 2) Reads user input
        // 3) Calls handleInput(input)
        // 4) Terminates when 'running' is set to false
    }

    /**
     * Handle a single command input (e.g. 'look', 'move forward', 'pick up sword').
     */
    public void handleInput(String input) {
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
                running = false;
                break;
            default:
                System.out.println("Unknown command. Type 'help' for a list of commands.");
        }
    }

    /**
     * Look around the current room: describe it and show items/NPCs.
     */
    private void lookAround() {
        // TODO: Print information about the player's current room
        System.out.println("You are in a dark, eerie room. There are mysterious items scattered around.");
    }

    /**
     * Move the player in a given direction (forward, back, left, right).
     */
    private void move(String direction) {
        // TODO: Attempt to move to the next room in the given direction
        //       If there's no room in that direction, print an error message
        //       If successfully moved, describe the new room
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
    private void pickUp(Item arg) {
        // TODO:
        // 1) Parse out the item name if 'arg' starts with "up "
        // 2) Check if that item exists in the current room
        // 3) Remove from room, add to player's inventory
        if (arg == null) {
            System.out.println("You need to specify an item to pick up.");
        } else {
            System.out.println("You pick up the " + arg + ".");
            player.addItemToInventory(arg);
        }
    }

    /**
     * Check the player's inventory.
     */
    private void checkInventory() {
        System.out.println("Player inventory: " + player.getPlayerInventory());
        // TODO: List the items in the player's inventory
        //       If no items, indicate that the inventory is empty
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
        // TODO: Print a list of available commands and brief instructions
    }

    /**
     * (Optional) Add any other methods (e.g., attack, open door, talk, etc.)
     * if you want to extend the game logic further.
     */
}
