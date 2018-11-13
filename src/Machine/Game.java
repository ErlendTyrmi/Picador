package Machine;

public class Game {
    private Player[] players;
    private final String[] playerNames = {"Hund", "Kat", "Bil", "Skib"};
    private String currentFieldText;
    private Turn turn;
    private int diceRoll, cash, newPosition;
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
        diceRoll = dice.roll();
        currentPlayer.move(diceRoll);
        newPosition = currentPlayer.getPosition();
        // Long one: Get price of square at currentPlayer's position;
        currentPlayer.setMoney(board.getSquares(currentPlayer.getPosition()).getPrice());

        doBoardActions(currentPlayer);
    }

    private void doBoardActions(Player currentPlayer){
        //Check for has passed Start status and reset
        if (currentPlayer.hasPassedStart()){
            currentPlayer.setMoney(-1);
        }
        // Get the type of player's current position
        String currentSquareType = board.getSquares(currentPlayer.getPosition()).getType();

        // Check is it's a street


        if (currentSquareType.equals("goToPrison")){
            System.out.println(currentPlayer.getName() + " is in prison");
            currentPlayer.setInPrison(true);
            // TODO: Implement prison after getting text in UI!
        } else if (currentSquareType.equals("chance")){
            System.out.println(currentPlayer.getName() + ", you got a chance card!");
        }


    }

    public String getText(){
        return currentFieldText;
    }

    public Player[] getPlayers(){
        return players;
    }

    public int getDiceA(){
        return diceRoll;
    }
}
