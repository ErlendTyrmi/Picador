package picador;

public class Street extends Field {
    private String owner;
    private int price;

    public Street(String name, int number, int price){
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public String buyStreet(int number, String owner){
        this.owner = owner;
        return message;
    }

}
