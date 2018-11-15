package Machine;

public class Square {
    protected int price;
    protected String title, description, type;


    Square(int price, String title, String description, String type) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.type = type;
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


}
