package Machine;

public class Street extends Square {
    private Player owner;
    private String color;

    Street(int price, String title, String description, String type, String color, Player owner) {
        super(price, title, description, type);
        this.color = color;
        this.owner = owner;
    }

    public String getTitle() {
        return super.getTitle();
    }

    public String getDescription() {
        return super.getDescription();
    }

    public String getType() {
        return super.getType();
    }

    public int getPrice() {
        return super.getPrice();
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

}
