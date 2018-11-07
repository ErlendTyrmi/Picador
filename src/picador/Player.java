package picador;

public class Player {
    private String name;
    private String position = "zero";

    public Player(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }
    public String getPosition(){
        return position;
    }
}
