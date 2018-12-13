package Machine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class cardControllerTest {
    cardController croupier = new cardController();
    ArrayList<ChanceCard> drawPile = croupier.drawPile;
    ArrayList<ChanceCard> discardPile = croupier.discardPile;
    ChanceCard[] allCards = croupier.allCards;


    @Test
    void contructorTest(){
        // Test constructor and shuffle, console log to see if it makes sense
        StringBuilder printAllCards = new StringBuilder();
        for (int i = 0; i < allCards.length; i++){
            printAllCards.append("\n"+ i + ": " + allCards[i].getCardName());

        }
        System.out.println("allCards:" + printAllCards);

        StringBuilder printDrawPile = new StringBuilder();
        for (int i = 0; i < allCards.length; i++){
            printDrawPile.append("\n"+ i + ": " + drawPile.get(i).getCardName());

        }
        System.out.println("\nNow the drawPile (shuffled):" + printDrawPile);

        assertEquals(drawPile.size(), allCards.length);

    }
    @Test
    void getCardTest() {
        // Test for drawCard
        System.out.println("\nDrawing ALL cards and checking discard pile size:");
        for (int i = 0; i < allCards.length; i++) {
            int previousSize = discardPile.size();
            ChanceCard currentCard = (croupier.getCard());
            if (currentCard.getCardName() == allCards[0].getCardName()){
                System.out.println(currentCard.getCardName() + " should not increase the size.");
            } else {
                assert(discardPile.contains(currentCard));
            }
            System.out.println("discardPile size: " + discardPile.size());
            // Assert: if card is get out of jail, test that discardPile did not increase:
            if (currentCard.getCardName() == allCards[0].getCardName()){
                assertEquals(previousSize, discardPile.size());

            }
        }
    }
    @Test
    void reshuffleTest(){
        // pick all cards + 1 to turn the pile
        System.out.println("\nChecking if the pile turns over when empty:");
        for (int i = 0; i < allCards.length + 1; i++){
            croupier.getCard();
        }
        System.out.println("drawPile size: " + drawPile.size());
        System.out.println("discardPile size: " + discardPile.size());

        assertEquals(drawPile.size(), (allCards.length - 2)); // -get out of jail + the card last picked
        assertEquals(discardPile.size(), 1); // Because I know it's not get out of jail

    }
}