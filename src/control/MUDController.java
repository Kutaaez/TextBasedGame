package control;

import entitites.*;
import factory.FantasyMUDFactory;

import java.util.List;
import java.util.Scanner;

/**
 * control.MUDController (Skeleton):
 * A simple controller that reads player input and orchestrates
 * basic commands like look around, move, pick up items,
 * check inventory, show help, etc.
 */
public class MUDController {

    private final Player player;
    private Room currentRoom;
    private Room previousRoom;
    FantasyMUDFactory fantasyMUDFactory = new FantasyMUDFactory();
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
            System.out.println("Welcome the low text based game!\nPlease select the genre of the room. Sci-Fi or Fantasy.\nType 'help' for a list of commands");
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
            case "fantasy":
                currentRoom = (Room) fantasyMUDFactory.createRoom();
                break;
            case "look":
                lookAround();
                break;
            case "attack":
                attackNPC();
                break;

            case "talk":
                talkToNPC(argument);
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
        currentRoom.describe();
    }

    /**
     * Move the player in a given direction (forward, back, left, right).
     */
    private void move(String direction) {
        switch (direction) {
            case "forward":
                System.out.println("You move forward into the next room.");
                if(currentRoom != null){
                    previousRoom = currentRoom;
                }
                currentRoom = (Room) fantasyMUDFactory.createRoom();
                break;
            case "back":
                if(currentRoom != null){
                    System.out.println("You move back to the previous room.");
                    currentRoom = previousRoom;
                }
                break;
            case "left":
                System.out.println("You turn left and walk into a new space.");
                if(currentRoom != null){
                    previousRoom = currentRoom;
                }
                currentRoom = (Room) fantasyMUDFactory.createRoom();

                break;
            case "right":
                System.out.println("You turn right and find a new area.");
                if(currentRoom != null){
                    previousRoom = currentRoom;
                }
                currentRoom = (Room) fantasyMUDFactory.createRoom();
                break;
            default:
                System.out.println("Invalid direction. Try 'forward', 'back', 'left', or 'right'.");
        }
    }
    public void attackNPC(){
        System.out.println("You are MONSTER!");

        currentRoom.removeNPC(currentRoom.getRoomNPCs().get(0));
    }
    public void talkToNPC(String npcName) {
        List<NPC>npcs = currentRoom.getRoomNPCs();

        boolean npcFound = false;
        for (NPC npc : npcs) {
            if (npc.getNpcName().equalsIgnoreCase(npcName)) {
                npcFound = true;
                System.out.println("You talk to " + npc.getNpcName() + ".");
                npc.speak();
                break;
            }
        }

        if (!npcFound) {
            System.out.println("There's no NPC by the name '" + npcName + "' in this room.");
        }
    }
    /**
     * Pick up an item (e.g. "pick up sword").
     */
    private void pickUp(String itemName) {
        List<Item> roomItems = currentRoom.getRoomItems();

        for (Item item : roomItems) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("You pick up the " + item.getItemName() + ".");
                player.addItemToInventory(item);
                roomItems.remove(item);
                return;
            }
        }

        System.out.println("There is no " + itemName + " in the room.");
    }

    /**
     * Check the player's inventory.
     */
    private void checkInventory() {

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
        System.out.println("talk <NPC> - Talk to the NPC in the room");
        System.out.println("move <forward|back|left|right> - Move in a direction.");
        System.out.println("pick up <item> - Pick up an item.");
        System.out.println("inventory - List the items you are carrying.");
        System.out.println("help - Show this help message.");
        System.out.println("quit / exit - End the game.");
        System.out.println("attack - you can attack npc, but I strongly advise against doing so at the moment... ");

    }
}