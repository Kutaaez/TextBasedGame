package entitites;

public class Room implements IGameEntity {
    private String roomName;
    private String roomDescription;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    @Override
    public void describe() {
        System.out.println("You in the " + roomName + " be carefull, because this room famous about " + roomDescription);
    }
}
