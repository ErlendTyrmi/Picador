package Machine;

public class Square {
    private int price;
    private String title, description, type;
    private Player owner;

    Square(int price, String title, String description, String type, Player owner){
        this.price = price;
        this.title = title;
        this.description = description;
        this.type = type;
        this.owner = owner;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

}
