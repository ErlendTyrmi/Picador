package Machine;

import java.util.ArrayList;
import java.util.Collections;

public class cardController {

    ChanceCard[] allCards;
    ArrayList<ChanceCard> drawPile = new ArrayList<ChanceCard>();
    ArrayList<ChanceCard> discardPile = new ArrayList<ChanceCard>();

    cardController(){
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
        shuffleCards();

    }
    public void shuffleCards(){
        Collections.shuffle(drawPile);

    }
    public ChanceCard getCard(){
        // Turn pile and shuffle if needed
        if (drawPile.isEmpty()){
            drawPile.addAll(discardPile);
            discardPile.clear();
            shuffleCards();

        }
         // Pick up card
        ChanceCard cardPickedUp = drawPile.get(0);

        // Move card to discard if not "Get out of jail" (Remember to add to discard when played)
        if (!drawPile.get(0).equals(allCards[0])){
            discardPile.add(drawPile.get(0));
        }
        // Removing the card from drawPile
        drawPile.remove(0);

        return cardPickedUp;  // Pick up card

    }

    public void useCard(){
        // Maybe let cardManager do some work, could use move, show and pay in game/UIManager?

    }
}
