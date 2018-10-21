package picador;

import javafx.animation.PauseTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller{

    // Dice
    AudioClip dice = new AudioClip(getClass().getResource("dice.wav").toExternalForm());
    PauseTransition waitForIt = new PauseTransition(Duration.millis(1050));
    public ImageView diceViewA, diceViewB;

    public void rolldice(MouseEvent mouseEvent) {
        int a = (int) (Math.random() * 6 + 1);
        int b = (int) (Math.random() * 6 + 1);
        int diceShifterA = a * 100 - 100;
        int diceShifterB = b * 100 - 100;
        diceViewA.setViewport(new Rectangle2D(600, 0, 100, 170));
        diceViewB.setViewport(new Rectangle2D(600, 0, 100, 170));
        System.out.println("dice clicked!");
        dice.play();
        waitForIt.setOnFinished(e -> {
            diceViewA.setViewport(new Rectangle2D(diceShifterA, 0, 100, 170));
            diceViewB.setViewport(new Rectangle2D(diceShifterB, 0, 100, 170));
        });
        waitForIt.play();
    }

    // Set piece on board
    public void setPiece(Player player, Field field){
    }

    // Show text (cards, buy-button and other text in centre of board)
    public VBox messages = new VBox();
    Text message;
    public FlowPane card;

    public void showText(String text){
        message = new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        card = new FlowPane(message);
    }

    // When someone clicked the button
    public void buttonClick(){
        // Action depends on situation buy, pay or just OK.
    }

    // Set account info for players (monopoly money)
    public TextField dogMoney, catMoney, carMoney, boatMoney;

    public void setMoney(String playerName, int fortune){
        if (playerName.equals("dog")){
            dogMoney.setText(Integer.toString(fortune));
        } else if (playerName.equals("cat")){
            catMoney.setText(Integer.toString(fortune));
        } else if (playerName.equals("car")){
            carMoney.setText(Integer.toString(fortune));
        }else if (playerName.equals("boat")){
            boatMoney.setText(Integer.toString(fortune));
        } else {
            System.out.println("Error. Player unknown.");
        }
    }


    // Set "owned by"-token
    public void setOwned(Player player, int field){

        switch (field){
            // Field needs a name that corresponds with fxml. Start = 0.
            // Place player image on field
        }

    }
}
