package Test;

import Machine.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceTest {

    @Test
    public void roll() {
        Dice john = new Dice();
        int[] tæller;
        tæller = new int[6];

        for (int i = 0; i < 60000; i++)
            tæller[john.roll() - 1]++;
        for (int i = 0; i < 6 ; i++)
            assertEquals(true, tæller[i] > 9600 && tæller[i] < 10400);

    }

}
