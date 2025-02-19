package factory;

import entitites.IGameEntity;
import entitites.Item;
import entitites.Room;

import java.util.Random;

public class FantasyMUDFactory  implements IMUDAbstractFactory {

    private String[] fantasyRoomNames = {
            "Hall of legends",
            "Dark Sketches",
            "Eternal storm tower",
            "Whispering woods",
            "Forgotten grove"
    };
    private String[] fantasyRoomDescriptions = {
            "A grand hall filled with ancient books and artifacts, glowing softly in the dim light. ",
            "A room adorned with eerie paintings of mythical creatures and ominous scenes. ",
            "A towering chamber where the winds never cease, filled with enchanted relics and ancient weapons. ",
            "A forest-like room with trees that seem to whisper secrets, surrounded by glowing mushrooms.",
            "A mystical garden with a crystal-clear pond and ancient stones that pulse with magical energy. "
    };
    public Item[] fantasyRoomItems = {
            new Item("Healing Herb", "HEALING_POTION"),
            new Item("Sword of Destiny", "WEAPON"),
            new Item("Gold Coin", "COIN"),
            new Item("Ancient Scroll", "HEALING_POTION"),
            new Item("Mystic Blade", "WEAPON")
    };


    @Override
    public IGameEntity createRoom() {
        Random random = new Random();
        int randomIndex = random.nextInt(fantasyRoomNames.length);
        Room fantasyRoom = new Room(fantasyRoomNames[randomIndex], fantasyRoomDescriptions[randomIndex]);
        fantasyRoom.addItem(fantasyRoomItems[randomIndex]);
        return fantasyRoom;
    }

    @Override
    public IGameEntity createNPC() {
        return null;

    }
}
