package Machine;

public class Round {
    // Represents one round played. New players and accounts every fucking time.
    private ControlFreak controlFreak = new ControlFreak();
    private Player[] players;
    private boolean won;
    private int diceA, diceB;
    private String streetInfo, chanceCard;
    private Dice dice;
    private Board board;


    Round(Player[] players, int cash){
        this.players = players;
        dice = new Dice();
        board = new Board();
    }

    void playTurn(Player player){
        diceA = dice.roll();
        diceB = dice.roll();
        // move player on model board
        // read boardinfo
        // use boardinfo method

        controlFreak.setResults(diceA, diceB, streetInfo, chanceCard, won);
        //if ( check if playerisBroke){
            won = false;
        // } else{
        //  won = true;
        // }
    }

}
