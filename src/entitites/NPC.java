package entitites;

import java.util.Random;

public class NPC implements IGameEntity {
    public String getNpcName() {
        return npcName;
    }

    public String getNpcDescription() {
        return npcDescription;
    }

    public String[] getNpcDialogue() {
        return npcDialogue;
    }

    private String npcName;
        private String npcDescription;
        private String[] npcDialogue;

    public NPC(String npcName, String npcDescription, String[] npcDialogue) {
        this.npcName = npcName;
        this.npcDescription = npcDescription;
        this.npcDialogue = npcDialogue;
    }

    @Override
    public void describe() {
        System.out.println(npcName + " - " + npcDescription);
    }
    public void speak() {
        Random random = new Random();
        String response = npcDialogue[random.nextInt(npcDialogue.length)];
        System.out.println(npcName + " says: " + response);
    }
    public String toString() {
        return npcName + " ";
    }

}
