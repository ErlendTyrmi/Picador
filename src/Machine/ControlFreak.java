package Machine;

import javafx.fxml.FXMLLoader;
import picador.Main;

public class ControlFreak {
    private Player[] players;
    private Round round;
    private int cash, currentPlayerIndex;
    boolean won = false;

    public ControlFreak() {
        runRound();
    }

    private void runRound() {

        // TODO: Get players to move on a gui board, add rest later
        // Reset GUI?
        // Ask players to pick pieces: Dog Cat Car Boat 0, 1, 2, 3
        // Make players
        // Put them on GUI Board

        // Start round with right amount of cash, Round (cash, players)
        round = new Round(players, cash);

        while (!won) {
            // 1 Set right player (random) Remember if currentPlayerIndex = players.length: currentPlayerIndex = 0
            // 2 Ask to roll dice with message and currentPlayerIndex corresponding name
            // 3 play a turn (in Round) (player dice)
            round.playTurn(players[currentPlayerIndex]);
            // 4 Get results from Round, round runs return results vie returnResults.
            // 5 Show dice with delay!
            // 6 Show message to GUI
            // 7 Get reaction to square from round
            // 8 If chance card or prison card, run methods in game
            // 9 Update gui to match decision?
            // 8 Show updated Account

            // Check for winner (round has info)


        }
    }

    private void showWinner(){
        // If winner:
        // Show final scene with option to play again, starting runRound
        // Show current player to GUI with winnertext
        // runRound
    }

    void setResults(int diceA, int diceB, String streetinfo, String chanceCard, boolean won){
        // dice, streetinfo, chancecard,
    }
}
