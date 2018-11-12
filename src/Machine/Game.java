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

    public void playTurn(Player currentPlayer){
        diceA = dice.roll();
        diceB = dice.roll();
        currentPlayer.move(diceA, diceB);
        newPosition = currentPlayer.getPosition();

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
