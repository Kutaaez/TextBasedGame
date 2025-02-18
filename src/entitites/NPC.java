package entitites;

public class NPC implements IGameEntity {
    private String npcName;
    private String npcDescription;

    public NPC(String name, String description) {
        this.npcName = name;
        this.npcDescription = description;
    }

    @Override
    public void describe() {
        System.out.println(npcName + " - " + npcDescription);
    }
}
