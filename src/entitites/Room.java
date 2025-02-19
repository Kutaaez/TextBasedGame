package entitites;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room implements IGameEntity {
    private String roomName;
    private String roomDescription;
    private List<Item> roomItems;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomItems = new ArrayList<>();
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
        System.out.println("You in the " + roomName + " be carefull, because this room famous  " + roomDescription + " " + listItems());
    }
    public void addItem(Item item ){
        roomItems.add(item);
    }
    public void removeItem(Item item){
        roomItems.remove(item);
    }
    public String listItems(){
        return roomItems.isEmpty() ? "No items here. " : roomItems.toString();
    }
}
