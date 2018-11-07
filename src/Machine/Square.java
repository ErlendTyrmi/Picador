package Machine;

public class Square {
    private int id, price, ownedBy = 0;
    private String title, description, type;

    private enum squareType{
        start, chance, prison, parking, toPrison,
        brown, lightBlue, purple, orange, red, yellow, green, blue

    }

    Square(int price, String title, String description, String type){
        this.price = price;
        this.title = title;
        this.description = description;
        this.type = type;
    }

}
