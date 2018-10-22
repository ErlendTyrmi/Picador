package picador;

import javafx.animation.PauseTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        System.out.println("dice clicked!");
        int diceShifterA = a * 100 - 100;
        int diceShifterB = b * 100 - 100;
        diceViewA.setViewport(new Rectangle2D(600, 0, 100, 170));
        diceViewB.setViewport(new Rectangle2D(600, 0, 100, 170));
        dice.play();
        waitForIt.setOnFinished(e -> {
            diceViewA.setViewport(new Rectangle2D(diceShifterA, 0, 100, 170));
            diceViewB.setViewport(new Rectangle2D(diceShifterB, 0, 100, 170));
        });
        waitForIt.play();
    }

    // Set piece on board
    public void setPiece(Player player, Field field){
        // remove monopoly-dog.png (cat/car/boat) from previous
        // show monopoly-dog.png at field(getName) Names: zer0, one, two...twentythree
    }

    // Show text (cards, buy-button and other text in centre of board)
    public VBox messages = new VBox();
    Text message;
    public FlowPane card;

    public void showText(String text){
        message = new Text(text);
        card = new FlowPane(message);
    }

    // When someone clicked the button
    public Button mainButton;
    public void mainButtonClick(){
        card.setVisible(false); // The button does nothing else, all actions are default.
    }

    // Set account info for players (monopoly money)
    public Label dogMoney, catMoney, carMoney, boatMoney;
    public HBox dogMoneyBox, catMoneyBox, carMoneyBox, boatMoneyBox;

    public void setMoney(String playerName, int fortune){
        if (playerName.equals("dog")){
            dogMoney.setText(Integer.toString(fortune));
            dogMoneyBox.setOpacity(1);
        } else if (playerName.equals("cat")){
            catMoney.setText(Integer.toString(fortune));
            catMoneyBox.setOpacity(1);
        } else if (playerName.equals("car")){
            carMoney.setText(Integer.toString(fortune));
            carMoneyBox.setOpacity(1);
        }else if (playerName.equals("boat")){
            boatMoney.setText(Integer.toString(fortune));
            boatMoneyBox.setOpacity(1);
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

    // The following is for implementing chance cards where the player can pick a field (street-type)!
    private String chosenField;
    //private StackPane one, two, four, five, seven, eight, ten, eleven, thirteen, fourteen, sixteen,
    //seventeen, nineteen, twenty, twentytwo, twentythree;
    public void fieldOneChosen(MouseEvent mouseEvent) {
        System.out.println("Field one chosen!");
        chosenField = "one";
    }
    public void fieldTwoChosen(MouseEvent mouseEvent) {
        System.out.println("Field two chosen!");
        chosenField = "two";
    }
    public void fieldFourChosen(MouseEvent mouseEvent) {
        System.out.println("Field four chosen!");
        chosenField = "four";
    }
    public void fieldFiveChosen(MouseEvent mouseEvent) {
        System.out.println("Field five chosen!");
        chosenField = "five";
    }
    public void fieldSevenChosen(MouseEvent mouseEvent) {
        System.out.println("Field seven chosen!");
        chosenField = "seven";
    }
    public void fieldEightChosen(MouseEvent mouseEvent) {
        System.out.println("Field eight chosen!");
        chosenField = "eight";
    }
    public void fieldTenChosen(MouseEvent mouseEvent) {
        System.out.println("Field ten chosen!");
        chosenField = "ten";
    }
    public void fieldElevenChosen(MouseEvent mouseEvent) {
        System.out.println("Field eleven chosen!");
        chosenField = "eleven";
    }
    public void fieldThirteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field thirteen chosen!");
        chosenField = "thirteen";
    }
    public void fieldFourteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field fourteen chosen!");
        chosenField = "fourteen";
    }
    public void fieldSixteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field fifteen chosen!");
        chosenField = "fifteen";
    }
    public void fieldSeventeenChosen(MouseEvent mouseEvent) {
        System.out.println("Field seventeen chosen!");
        chosenField = "seventeen";
    }
    public void fieldNineteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field nineteen chosen!");
        chosenField = "nineteen";
    }
    public void fieldTwentyChosen(MouseEvent mouseEvent) {
        System.out.println("Field twenty chosen!");
        chosenField = "twenty";
    }
    public void fieldTwentytwoChosen(MouseEvent mouseEvent) {
        System.out.println("Field twentytwo chosen!");
        chosenField = "twentytwo";
    }
    public void fieldTwentythreeChosen(MouseEvent mouseEvent) {
        System.out.println("Field twentythree chosen!");
        chosenField = "twentythree";
    }
}
