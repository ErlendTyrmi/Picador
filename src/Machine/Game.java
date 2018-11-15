package Machine;

public class Game {
    //private Player[] players;
    private final String[] playerNames = {"Hund", "Kat", "Bil", "Skib"};
    private String currentSquareType, currentSquareOwner;
    private Turn turn;
    private int diceRoll, cash, newPosition , winnerIndex;
    private boolean youBoughtStreet = false, youPaidRent = false, youOwnStreet = false, chance,  gameOver = false;
    private DanishText text = new DanishText();
    private Board board = new Board();
    private Dice dice = new Dice();
    private Player currentPlayer;
    private Square currentSquare;

    public Game(Player[] players){
        //this.players = players;
    }

    public void playTurn(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        diceRoll = dice.roll();
        currentPlayer.move(diceRoll);
        newPosition = currentPlayer.getPosition();

        doBoardActions();
    }

    private void doBoardActions(){
        //Check for has passed Start status.
        if (currentPlayer.hasPassedStart()){
            currentPlayer.setMoney(-1);
        }
        // Reset street dealing status.
        youBoughtStreet = false;
        youPaidRent = false;
        youPaidRent = false;

        // Get the type of player's current position
        currentSquare = board.getSquares(currentPlayer.getPosition());
        currentSquareType = board.getSquares(currentPlayer.getPosition()).getType();

        System.out.println("Current square is of type: " + currentSquareType);
        // Check is it's a street
        if (currentSquareType.equals("street")){
            // Casting is everything.
            currentSquareOwner = ((Street) currentSquare).getOwner().getName();

            if (currentSquareOwner.equals("Banken")){
                ((Street) currentSquare).setOwner(currentPlayer);
                youBoughtStreet = true;
                System.out.println(currentSquare.getTitle() + " is now owned by " + currentPlayer.getName());
            } else if (currentSquareOwner.equals(currentPlayer.getName())){
                System.out.println(currentPlayer.getName() + " already owns " + currentSquare.getTitle());
                youOwnStreet = true;
            } else {
                ((Street) currentSquare).getOwner().setMoney(- currentSquare.getPrice());
                System.out.println(((Street) currentSquare).getOwner().getName() + "'s account incremented to " +
                        ((Street) currentSquare).getOwner().getMoney());
                youPaidRent = true;
            }
        }

        if (currentSquareType.equals("toPrison")){
            System.out.println(currentPlayer.getName() + " is in prison");
            currentPlayer.setInPrison(true);
        } else if (currentSquareType.equals("chance")){
            System.out.println(currentPlayer.getName() + ", you got a chance card!");
            chance = true;
            handleChanceCard();
        }

        // Pay last to avoid going broke when you land on your own street.
        currentPlayer.setMoney(board.getSquares(currentPlayer.getPosition()).getPrice());


    }

    private void handleChanceCard(){
        System.out.println("Handling chance card...");
    }

    public void findWinnerIndex(Player[] players){
        // Cycles through players and returns winner
        System.out.println("findWinnerIndex has been called");
        int highestSum = 0;
        int winnerIndex = 0;
        for (int i = 0; i < players.length;i++){
            if (players[i].getMoney() > highestSum){
                highestSum = players[i].getMoney();
                winnerIndex = i;
            }
        }
        System.out.println(players[winnerIndex] + " won the game!");
    }

    public int getDiceA(){
        return diceRoll;
    }

    public Square getCurrentSquare(){
        return currentSquare;
    }

    public String getCurrentSquareType(){
        return currentSquareType;
    }

    public boolean isMoneyPaid(){
        if(youPaidRent || youBoughtStreet){
            return true;
        } else {
            return false;
        }
    }

    public boolean youBoughtStreet() {
        return youBoughtStreet;
    }

    public boolean youPaidRent() {
        return youPaidRent;
    }

    public boolean youOwnStreet() {
        return youOwnStreet;
    }

    public String getCurrentSquareOwner() {
        return currentSquareOwner;
    }

    public int getWinnerIndex() {
        return winnerIndex;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
