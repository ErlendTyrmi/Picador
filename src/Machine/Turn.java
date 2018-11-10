package Machine;

import java.util.Scanner;

public class Turn {
    //
    private Player[] players;
    private boolean won;
    private int diceA, diceB, previousPosition, currentPosition;
    private String streetInfo, chanceCard;
    private Dice dice;
    private Board board;
    private Square currentSquare;

    Scanner input = new Scanner(System.in);


    Turn(){
        dice = new Dice();
        board = new Board();
    }

    void playTurn(Player player) {
        // Checking for prison
        if (player.isInPrison() && !player.hasGetOutOfPrison()) {
            System.out.println(player + "You are in prison. Pass this turn.");
            player.setInPrison(false);
        } else {
            if (player.isInPrison() && player.hasGetOutOfPrison()) {
                System.out.println("You are in prison, but...");
                System.out.println("You've played your 'Out of prison'-card.");
            }

            // 2 Ask to roll dice with message and currentPlayerIndex corresponding name

            System.out.println(player.getName() + ", roll the dice!");
            if (input.hasNextLine()) {
                String foo = input.nextLine();
            }
            // Rolling and reading info from player
            diceA = dice.roll();
            diceB = dice.roll();
            previousPosition = player.getPosition();
            player.setPosition((player.getPosition() + diceA + diceB));
            currentPosition = player.getPosition();
            currentSquare = board.getSquares(player.getPosition());

            if (player.getPosition() == 18) {
                System.out.println("You got caught. Go to prison.");
                player.setInPrison(true);
                player.setPosition(6);
            }
                // sout it!
                System.out.println("Player '" + player.getName() + "' rolled a " + (diceA + diceB) +
                        "\nand moved from position" + previousPosition + " to " + currentPosition + ".");
                System.out.println(player.getName() + " is now at " + currentSquare.getTitle() + ".");
                System.out.println(currentSquare.getDescription());



            //controlFreak.setResults(diceA, diceB, streetInfo, chanceCard, won);
            if (player.isBroke()) {
                won = true;
            }
        }

    }
}
