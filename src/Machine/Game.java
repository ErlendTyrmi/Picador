package Machine;

public class Game {
    //private Player[] players;
    private final String[] playerNames = {"Hund", "Kat", "Bil", "Skib"};
    private String currentSquareType, currentSquareOwnerName;
    private Turn turn;
    private int diceRoll, cash, newPosition, winnerIndex;
    private boolean youBoughtStreet = false, youPaidRent = false, youOwnStreet = false, chance;
    private Board board = new Board();
    private Dice dice = new Dice();
    private Player currentPlayer;
    private Square currentSquare;
    private Street adjacentStreet;

    public Game(Player[] players) {
        //this.players = players;
    }

    public void playTurn(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        diceRoll = dice.roll();
        currentPlayer.move(diceRoll);
        newPosition = currentPlayer.getPosition();

        doBoardActions();
    }

    private void doBoardActions() {
        //Check for has passed Start status.
        if (currentPlayer.hasPassedStart()) {
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
        if (currentSquareType.equals("street")) {
            // Casting is everything.
            currentSquareOwnerName = ((Street) currentSquare).getOwner().getName();

            // Decide owner of adjacent street. (One of them will always be a street.)
            if (board.getSquares((currentPlayer.getPosition() - 1)).getType().equals("street")) {
                System.out.println("Street before");
                adjacentStreet = (Street) board.getSquares((currentPlayer.getPosition() - 1));

            } else {
                adjacentStreet = (Street) board.getSquares((currentPlayer.getPosition() + 1));
                System.out.println("Street after");
            }
            System.out.println("currentSquareOwnerName: " + currentSquareOwnerName + " adjacentStreet.getOwner: " + adjacentStreet.getOwner().getName());

            if (currentSquareOwnerName.equals("Banken")) {
                ((Street) currentSquare).setOwner(currentPlayer);
                youBoughtStreet = true;
                System.out.println(currentSquare.getTitle() + " is now owned by " + currentPlayer.getName());

            } else if (currentSquareOwnerName.equals(currentPlayer.getName())) {
                System.out.println(currentPlayer.getName() + " already owns " + currentSquare.getTitle());
                youOwnStreet = true;

            } else if (adjacentStreet.getOwner().getName().equals(currentSquareOwnerName)) {
                // If next or previous has same owner name, double price!
                System.out.println("This street is double price.");
                adjacentStreet.setPrice(adjacentStreet.getPrice() * 2);
                ((Street) currentSquare).setPrice(currentSquare.getPrice() * 2);
                ((Street) currentSquare).getOwner().setMoney(-currentSquare.getPrice());
                youPaidRent = true;

            } else {

                ((Street) currentSquare).getOwner().setMoney(-currentSquare.getPrice());
                System.out.println(((Street) currentSquare).getOwner().getName() + "'s account incremented to " +
                        ((Street) currentSquare).getOwner().getMoney());
                youPaidRent = true;

            }
        }

        if (currentSquareType.equals("toPrison")) {
            System.out.println(currentPlayer.getName() + " is in prison");
            currentPlayer.setInPrison(true);

        } else if (currentSquareType.equals("chance")) {
            System.out.println(currentPlayer.getName() + ", you got a chance card!");
            chance = true;
            handleChanceCard();

        }

        // Pay last to avoid going broke when you land on your own street.
        currentPlayer.setMoney(board.getSquares(currentPlayer.getPosition()).getPrice());


    }

    private void handleChanceCard() {
        System.out.println("Handling chance card...");
    }

    public void findWinnerIndex(Player[] players) {
        // Cycles through players and returns winner
        System.out.println("findWinnerIndex has been called");
        int highestSum = 0;
        winnerIndex = 0;

        for (int i = 0; i < players.length; i++) {
            if (players[i].getMoney() > highestSum) {
                highestSum = players[i].getMoney();
                winnerIndex = i;

            }
        }
        System.out.println(players[winnerIndex].getName() + " won the game with " + highestSum + " points!");
    }

    public int getDiceA() {
        return diceRoll;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public String getCurrentSquareType() {
        return currentSquareType;
    }

    public boolean isMoneyPaid() {
        if (youPaidRent || youBoughtStreet) {
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

    public String getCurrentSquareOwnerName() {
        return currentSquareOwnerName;
    }

    public int getWinnerIndex() {
        return winnerIndex;
    }
}
