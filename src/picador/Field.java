package picador;

public class Field {
    protected String name;
    protected int number; // 0, 1 ... 23
    protected String message;

    // Getters
    public String getName(){
        return name;
    }

    public int getFieldNumber(){
        return number;
    }

    public String getMessage(){return message;}

}
