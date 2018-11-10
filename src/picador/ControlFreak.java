package picador;

import Machine.Game;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlFreak {
    private AudioClip dice = new AudioClip(getClass().getResource("dice.wav").toExternalForm());
    private PauseTransition waitForIt = new PauseTransition(Duration.millis(1050));
    private Text message;
    private int chosenField;
    @FXML
    private ImageView diceViewA, diceViewB;
    @FXML
    private Label dogMoney, catMoney, carMoney, boatMoney;
    @FXML
    private HBox dogMoneyBox, catMoneyBox, carMoneyBox, boatMoneyBox;
    @FXML
    private VBox messages;
    @FXML
    private FlowPane card;
    @FXML
    private ImageView[] pieces;
    @FXML
    private Text gameText;
    Game game;

    /************************************************
     * Controller handles GUI and controls the show
     ***********************************************/

    public ControlFreak() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        settings();

    }

    private void settings(){
        game = new Game();
        gameText.setText("Jarra");

    }

    // TODO make players and put on start. Look at MAchine for inspiration
    // TODO write method to move them MAke one that moves instantly first, then add steps
    // TODO write method to communicate with game, and ask for info back Getters Setters

    // Set Dice in UI:
    public void rolldice(MouseEvent mouseEvent) {
        // Move dice to other class
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
    public void setPiece(Player player, String fieldNumber){
        // remove game piece from previous
        // put game piece in fieldNumber;
    }

    // Show text (cards, buy-button and other text in centre of board)

    public void showText(String text){
        //card.setVisible(true);
        //message = new Text("text");
        //card.getChildren().add(message);
        //gameText.setText(text);
    }

    // When someone clicked the button
    public Button mainButton;
    public void mainButtonClick() {
        // The button does nothing else, all actions are default.
        //card.setVisible(false);
        gameText.setText("Ouch");
        // Start Machine Controller, initializer sets the wheels in motion
    }

    // Set account info for players (monopoly money)

    // First time players money is updated, their money field becomes visible.
    public void setMoney(String playerName, int fortune){
        if (playerName.equals("dog")){
            dogMoney.setText(Integer.toString(fortune));
            dogMoneyBox.setVisible(true);
        } else if (playerName.equals("cat")){
            catMoney.setText(Integer.toString(fortune));
            catMoneyBox.setVisible(true);
        } else if (playerName.equals("car")){
            carMoney.setText(Integer.toString(fortune));
            carMoneyBox.setVisible(true);
        }else if (playerName.equals("boat")){
            boatMoney.setText(Integer.toString(fortune));
            boatMoneyBox.setVisible(true);
        } else {
            System.out.println("Error. Player unknown.");
        }
    }

    // Set "owned by"-token
    public void setOwned(Player player, int field){
        switch (field){
            // Field needs a name that corresponds with fxml. Start = zero.
            // Place players "owned"-image on field
        }

    }

    // The following is for implementing chance cards where the player can pick a field (street-type)!

    public void fieldZeroChosen(MouseEvent mouseEvent) {
        System.out.println("Field zero chosen!");
        chosenField = 0;
    }
    public void fieldOneChosen(MouseEvent mouseEvent) {
        System.out.println("Field one chosen!");
        chosenField = 1;
    }
    public void fieldTwoChosen(MouseEvent mouseEvent) {
        System.out.println("Field two chosen!");
        chosenField = 2;
    }
    public void fieldThreeChosen(MouseEvent mouseEvent) {
        System.out.println("Field three chosen!");
        chosenField = 3;
    }
    public void fieldFourChosen(MouseEvent mouseEvent) {
        System.out.println("Field four chosen!");
        chosenField = 4;
    }
    public void fieldFiveChosen(MouseEvent mouseEvent) {
        System.out.println("Field five chosen!");
        chosenField = 5;
    }
    public void fieldSixChosen(MouseEvent mouseEvent) {
        System.out.println("Field six chosen!");
        chosenField = 6;
    }
    public void fieldSevenChosen(MouseEvent mouseEvent) {
        System.out.println("Field seven chosen!");
        chosenField = 7;
    }
    public void fieldEightChosen(MouseEvent mouseEvent) {
        System.out.println("Field eight chosen!");
        chosenField = 8;
    }
    public void fieldNineChosen(MouseEvent mouseEvent) {
        System.out.println("Field nine chosen!");
        chosenField = 9;
    }
    public void fieldTenChosen(MouseEvent mouseEvent) {
        System.out.println("Field ten chosen!");
        chosenField = 10;
    }
    public void fieldElevenChosen(MouseEvent mouseEvent) {
        System.out.println("Field eleven chosen!");
        chosenField = 11;
    }
    public void fieldTwelveChosen(MouseEvent mouseEvent) {
        System.out.println("Field twelve chosen!");
        chosenField = 12;
    }
    public void fieldThirteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field thirteen chosen!");
        chosenField = 13;
    }
    public void fieldFourteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field fourteen chosen!");
        chosenField = 14;
    }
    public void fieldFifteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field fifteen chosen!");
        chosenField = 15;
    }
    public void fieldSixteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field sixteen chosen!");
        chosenField = 16;
    }
    public void fieldSeventeenChosen(MouseEvent mouseEvent) {
        System.out.println("Field seventeen chosen!");
        chosenField = 17;
    }
    public void fieldEighteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field eighteen chosen!");
        chosenField = 18;
    }
    public void fieldNineteenChosen(MouseEvent mouseEvent) {
        System.out.println("Field nineteen chosen!");
        chosenField = 19;
    }
    public void fieldTwentyChosen(MouseEvent mouseEvent) {
        System.out.println("Field twenty chosen!");
        chosenField = 20;
    }
    public void fieldTwentyoneChosen(MouseEvent mouseEvent) {
        System.out.println("Field twentyone chosen!");
        chosenField = 21;
    }
    public void fieldTwentytwoChosen(MouseEvent mouseEvent) {
        System.out.println("Field twentytwo chosen!");
        chosenField = 22;
    }
    public void fieldTwentythreeChosen(MouseEvent mouseEvent) {
        System.out.println("Field twentythree chosen!");
        chosenField = 23;
    }
    public void setChosenField(){
        //game.board[player.getCurrentSquare].hide(pieces[playersTurn])
        //board.squares[chosenField].show(pieces[playersTurn])
    }
}

