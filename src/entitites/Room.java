package entitites;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room implements IGameEntity {
    private String roomName;
    private String roomDescription;
    private List<Item> roomItems;
    private List<NPC> roomNPCs;

    public List<NPC> getRoomNPCs() {
        return roomNPCs;
    }

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomItems = new ArrayList<>();
        this.roomNPCs = new ArrayList<>();
    }

    public List<Item> getRoomItems() {
        return roomItems;
    }



    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }


    @Override
    public void describe() {
        System.out.println( "You in the " + roomName + "  " + roomDescription + "\n there is in this room " + listItems() + "\n " + listNPCs() );
    }
    public void addItem(Item item ){
        roomItems.add(item);
    }
    public void addNPC(NPC npc ){
        roomNPCs.add(npc);
    }
    public void removeNPC(NPC npc){
        roomNPCs.remove(npc);
    }
    public void removeItem(Item item){
        roomItems.remove(item);
    }
    public String listItems(){
        return roomItems.isEmpty() ? "No items here. " : "there is such a thing " + roomItems.toString();
    }
    public String listNPCs(){
        return roomNPCs.isEmpty() ? "\nMONSTER, YOU KILLED THE ONLY NPC IN THIS ROOM!\nHE HAD A FAMILY, CHILDREN!\n " : "and there are some " + roomNPCs.toString();
    }
}
