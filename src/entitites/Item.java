package entitites;

public class Item implements  IGameEntity{
    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
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
