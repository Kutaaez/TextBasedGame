package factory;

import entitites.IGameEntity;
import entitites.Item;
import entitites.NPC;
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
    private NPC[] fantasyRoomNPC = {
            new NPC("Guardian of the Grove",
                    "A tall figure with a cloak made of leaves, holding a staff that glows with ancient magic.",
                    new String[]    {
                            "Welcome, adventurer! What brings you to the Grove?",
                            "Beware of the dangers that lurk in the forest.",
                            "The trees have seen much over the years, but even they are not without secrets."
                    }),
            new NPC("Wandering Sorcerer",
                    "A robed figure who speaks in riddles, offering cryptic advice to those who ask.",
                    new String[] {
                            "The path is not always clear, but trust your instincts.",
                            "Beware the shadow that follows you. It might be more than it seems.",
                            "Seek the answers within yourself, for only you can unlock your true power."
                    }),
            new NPC("Ancient Priestess",
                    "An old woman with a mystical aura, her eyes glowing with ancient wisdom.",
                    new String[] {
                            "I have seen many come and go, but none like you. You carry a burden.",
                            "The spirits whisper of an ancient power that awaits you.",
                            "The world is full of illusions, but your heart knows the truth."
                    }),
            new NPC("Mysterious Traveler",
                    "A traveler with a long coat, constantly moving and observing the world around them.",
                    new String[] {
                            "I have walked many roads and seen wonders beyond imagination.",
                            "Do not fear the unknown. It is where true adventure begins.",
                            "Every step you take changes the course of your journey."
                    }),
            new NPC("Enchanted Beast",
                    "A large, magical creature with shimmering fur, radiating an aura of mystery.",
                    new String[] {
                            "You have found me, but few can understand the magic I carry.",
                            "Beware, traveler. The forest is not kind to those who seek power recklessly.",
                            "The stars have shown me your arrival. What is it you seek?"
                    })
    };
//I'm generated dialogue,npc name and description in gpt, I didn't have enough imagination, ahahaha.

    @Override
    public IGameEntity createRoom() {
        Random random = new Random();
        int randomIndex = random.nextInt(fantasyRoomNames.length);
        Room fantasyRoom = new Room(fantasyRoomNames[randomIndex], fantasyRoomDescriptions[randomIndex]);
        fantasyRoom.addItem(fantasyRoomItems[randomIndex]);
        fantasyRoom.addNPC(fantasyRoomNPC[randomIndex]);
        return fantasyRoom;
    }

    @Override
    public IGameEntity createNPC() {
        return null;

    }
}
