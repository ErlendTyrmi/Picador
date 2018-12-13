package Machine;

import java.util.ArrayList;
import java.util.Collections;

public class ChanceController {

    ChanceCard[] allCards;
    ArrayList<ChanceCard> drawPile = new ArrayList<ChanceCard>();
    ArrayList<ChanceCard> discardPile = new ArrayList<ChanceCard>();

    ChanceController(){
        // Constructor makes the deck and shuffles it to a draw pile.
        allCards = new ChanceCard[11];

        allCards[0] = new ChanceCard("Get out of Jail");
        allCards[1] = new ChanceCard("Green");
        allCards[2] = new ChanceCard("Won the lottery");
        allCards[3] = new ChanceCard("Blue");
        allCards[4] = new ChanceCard("Red");
        allCards[5] = new ChanceCard("Orange");
        allCards[6] = new ChanceCard("Payday");
        allCards[7] = new ChanceCard("You pay taxes");
        allCards[8] = new ChanceCard("Purple");
        allCards[9] = new ChanceCard("Yellow");
        allCards[10] = new ChanceCard("Brown");

        for (int i = 0; i < allCards.length; i++){
            drawPile.add(allCards[i]);
        }

        Collections.shuffle(drawPile);

    }


    public ChanceCard getCard(){
        // Pick up card
        if (drawPile.isEmpty()){
            drawPile.clone(discardPile)discardPile;
        }
        ChanceCard cardPickedUp = drawPile.get(0);

        // Move card to discard 0 if not "Get out of jail" (Remember to add to discard when played)
        if (!drawPile.get(0).equals(allCards[0])){
            discardPile.add(0, drawPile.get(0));
        }
        // Removing the card from drawPile
        drawPile.remove(0);

        return cardPickedUp;
    }

    // Should actions be dealt with here to ease the job for game and UIManager?
    // Switch statement for allCards could call "move" and "reward" methods in game, and/or UIManager
}
