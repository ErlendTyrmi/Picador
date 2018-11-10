package Machine;

import picador.ControlFreak;

public class Game {
    private Player[] players;
    private final String[] playerNames = {"Hund", "Kat", "Bil", "Skib"};
    private String currentFieldText;
    private Turn turn;
    private int diceA, diceB, cash, newPosition;
    private boolean won = false;
    private DanishText text = new DanishText();
    private Board board = new Board();
    private Dice dice = new Dice();

    public Game() {
        // TODO: This function does nothing!
       // Main responsibility is passing updated info to Controller, and making data classes.
        //ControlFreak freaky = new ControlFreak();

        System.out.println("Game started");
        System.out.println(DanishText.greeting);
    }

    void start(){
        // Is this necessary?
        // Make players dog cat? Good idea. UI can update corresponding img only!
        //Player dog = new Player("dog");
        //Player cat = new Player("cat");
        //Player car = new Player("car");
        //Player boat = new Player("boat");
    }

    public void playTurn(int currentPlayerIndex){
        diceA = dice.roll();
        diceB = dice.roll();
        players[currentPlayerIndex].move(diceA, diceB);
        newPosition = players[currentPlayerIndex].getPosition();

        // More stuff will come.
    }

    public String getText(){
        return currentFieldText;
    }

    public Player[] getPlayers(){
        return players;
    }

    public int getDiceA(){
        return diceA;
    }
    public int getDiceB(){
        return diceB;
    }
}
