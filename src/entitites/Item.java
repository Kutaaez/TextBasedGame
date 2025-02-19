package entitites;

import entitites.IGameEntity;

public class Item implements IGameEntity {
    private String itemName;
    private String itemType;

    public Item(String itemName, String itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public void describe() {
        System.out.println("This is " + getItemName());
    }

    @Override
    public String toString() {
        return itemName + " ";
    }
}
