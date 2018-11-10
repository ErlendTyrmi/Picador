package Machine;

import picador.ControlFreak;

public class Game {
    private Player[] players;
    private final String[] playerNames = {"Hund", "Kat", "Bil", "Skib"};
    private Turn turn;
    private int cash, currentPlayerIndex;
    private boolean won = false;
    private DanishText text = new DanishText();

    public Game() {
       // Main responsibility is passing updated info to Controller, and making data classes.
        //ControlFreak freaky = new ControlFreak();
        System.out.println("Game started");
        System.out.println(text.getGreeting());
    }

    public String getText(){
        return text.getGreeting();
    }
}
