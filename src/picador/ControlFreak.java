package picador;

import Machine.DanishText;
import Machine.Game;
import Machine.Player;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;

public class ControlFreak {
    private AudioClip dice = new AudioClip(getClass().getResource("dice.wav").toExternalForm());
    private AudioClip dogSound = new AudioClip(getClass().getResource("bark.wav").toExternalForm());
    private AudioClip catSound = new AudioClip(getClass().getResource("meow.wav").toExternalForm());
    private AudioClip carSound = new AudioClip(getClass().getResource("car.wav").toExternalForm());
    private AudioClip boatSound = new AudioClip(getClass().getResource("boat.wav").toExternalForm());
    private AudioClip moneySound = new AudioClip(getClass().getResource("money.wav").toExternalForm());
    private PauseTransition waitForIt = new PauseTransition(Duration.millis(1050));
    private int chosenField, numberOfPLayers, fortune, turnIndex;
    private Game game;
    private boolean won = false, yesButtonClicked = false, noButtonClicked = false,
            dogChosen = false, catChosen = false, carChosen = false, boatChosen = false;
    private Player currentPlayer;
    private Player[] players;
    @FXML
    private ImageView diceViewA, diceViewB, dogToken, catToken, carToken, boatToken;
    @FXML
    private ImageView[] tokens;
    @FXML
    private Button okButton, yesButton, noButton;
    @FXML
    private CheckBox dogCheckBox, catCheckBox, carCheckBox, boatCheckBox;
    @FXML
    private CheckBox[] checkBoxes = {dogCheckBox, catCheckBox, carCheckBox, boatCheckBox};
    @FXML
    private StackPane zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen,
    fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyone, twentytwo, twentythree;
    @FXML
    private StackPane[] squares = {zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen,
            fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyone, twentytwo, twentythree};
    @FXML
    private Label dogMoney, catMoney, carMoney, boatMoney;
    @FXML
    private HBox dogMoneyBox, catMoneyBox, carMoneyBox, boatMoneyBox;
    @FXML
    private HBox buttonBox, rightTrueBox, characterChoiceBox, characterChoiceImageBox;
    @FXML
    private VBox messageBox;
    @FXML
    private FlowPane card;
    @FXML
    private ImageView[] pieces;
    @FXML
    private Text gameText;


    /************************************************
     * Controller handles GUI and controls the show
     ***********************************************/

    public ControlFreak() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
    }

    public void initialize() {
        // Difference between this and constructor: this loads after fxml!
        settings();
    }

    private void settings() {
        game = new Game();
        showPlayerChoice(); // Long and complicated function below
    }

    private void playTurn() {
        currentPlayer = players[turnIndex];
        System.out.println("playGame method called.");
            game.playTurn(currentPlayer);
            movePiece(currentPlayer, currentPlayer.getPosition());
            turnIndex++;
            if (turnIndex <= numberOfPLayers){
                turnIndex = 0;
            }
            // TODO write method to move them MAke one that moves instantly first, then add steps
    }

    // Set Dice in UI:
    public void rolldice(MouseEvent mouseEvent) {
        // This seems to work!
        System.out.println("dice clicked!");
        playTurn();
        int diceShifterA = game.getDiceA() * 100 - 100;
        int diceShifterB = game.getDiceB() * 100 - 100;
        diceViewA.setViewport(new Rectangle2D(600, 0, 100, 170));
        diceViewB.setViewport(new Rectangle2D(600, 0, 100, 170));
        dice.play();
        waitForIt.setOnFinished(e -> {
            diceViewA.setViewport(new Rectangle2D(diceShifterA, 0, 100, 170));
            diceViewB.setViewport(new Rectangle2D(diceShifterB, 0, 100, 170));
        });
        waitForIt.play();
    }


    // Move piece on board
    public void movePiece(Player player, int squareNumber) {
        // remove game piece from previous
       getSquare(squareNumber).getChildren().add(tokens[turnIndex]);
    }

    // Show text (cards, buy-button and other text in centre of board)

    public void showText(String text) {
        yesButtonClicked = false;
        gameText.setText(text);
        rightTrueBox.setVisible(true);
        card.setVisible(true);

    }

    public void showPlayerChoice() {
        gameText.setText(DanishText.choosePiece);
        characterChoiceImageBox.setVisible(true);
        dogToken.setOnMouseClicked(e->{dogCheckBox.setSelected(true);dogSound.play();});
        catToken.setOnMouseClicked(e->{catCheckBox.setSelected(true);catSound.play();});
        carToken.setOnMouseClicked(e->{carCheckBox.setSelected(true);carSound.play();});
        boatToken.setOnMouseClicked(e->{boatCheckBox.setSelected(true);boatSound.play();});
        characterChoiceBox.setVisible(true);
        buttonBox.setVisible(true);
        okButton.setText("Start");
        card.setVisible(true);
        // When Start clicked:
        okButton.setOnAction(e->{
            card.setVisible(false);
            characterChoiceImageBox.setVisible(false);
            characterChoiceBox.setVisible(false);
            buttonBox.setVisible(false);

            numberOfPLayers = 0;
            if (dogCheckBox.isSelected()){
                zero.getChildren().add(dogToken);
                dogChosen = true;
                numberOfPLayers++;
            }
            if (catCheckBox.isSelected()){
                zero.getChildren().add(catToken);
                catChosen = true;
                numberOfPLayers++;
            }
            if (carCheckBox.isSelected()){
                zero.getChildren().add(carToken);
                carChosen = true;
                numberOfPLayers++;
            }
            if (boatCheckBox.isSelected()){
                zero.getChildren().add(boatToken);
                boatChosen = true;
                numberOfPLayers++;
            }

            // In case none selected: Cat
            if (numberOfPLayers == 0){
                zero.getChildren().add(catToken);
                catChosen = true;
                numberOfPLayers++;
                }

            players = new Player[numberOfPLayers];
            tokens = new ImageView[numberOfPLayers];

            int i = 0;
            if (dogChosen){
                players[i] = new Player("Hund");
                tokens[i] = dogToken;
                i++;
            }
            if (catChosen){
                players[i] = new Player("Kat");
                tokens[i] = catToken;
                i++;
            }
            if (carChosen){
                players[i] = new Player("Bil");
                tokens[i] = carToken;
                i++;
            }
            if (boatChosen){
                players[i] = new Player("Båd");
                tokens[i] = boatToken;
            }

            if (players.length == 4){
                fortune = 16;
            } else if (players.length == 3){
                fortune = 18;
            } else {
                fortune = 20;
            }
            for (Player x : players){
                setMoney(x.getName(), fortune);
            }

            turnIndex = (int)(Math.random()*numberOfPLayers);
            System.out.println("Starting with player " + turnIndex + ".");

            System.out.println("All is set up. Let the games begin!");
        });

    }

    // Set account info for players (monopoly money)

    // First time players money is updated, their money field becomes visible.
    public void setMoney(String playerName, int fortune) {
        if (playerName.equals("Hund")) {
            dogMoney.setText(Integer.toString(fortune));
            dogMoneyBox.setVisible(true);
        } else if (playerName.equals("Kat")) {
            catMoney.setText(Integer.toString(fortune));
            catMoneyBox.setVisible(true);
        } else if (playerName.equals("Bil")) {
            carMoney.setText(Integer.toString(fortune));
            carMoneyBox.setVisible(true);
        } else if (playerName.equals("Båd")) {
            boatMoney.setText(Integer.toString(fortune));
            boatMoneyBox.setVisible(true);
        } else {
            System.out.println("Error. Player unknown.");
        }
    }

    // Set "owned by"-token
    public void setOwned(Player player, int field) {
        switch (field) {
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

    public void setChosenField() {
        //game.board[player.getCurrentSquare].hide(pieces[playersTurn])
        //board.squares[chosenField].show(pieces[playersTurn])
    }

    // Translating square index to respective stackpanes
    private StackPane getSquare(int x){
        StackPane name;
        switch(x){
            case 1:
                name = one;
                break;
            case 2:
                name = two;
                break;
            case 3:
                name = three;
                break;
            case 4:
                name = four;
                break;
            case 5:
                name = five;
                break;
            case 6:
                name = six;
                break;
            case 7:
                name = seven;
                break;
            case 8:
                name = eight;
                break;
            case 9:
                name = nine;
                break;
            case 10:
                name = ten;
                break;
            case 11:
                name = eleven;
                break;
            case 12:
                name = twelve;
                break;
            case 13:
                name = thirteen;
                break;
            case 14:
                name = fourteen;
                break;
            case 15:
                name = fifteen;
                break;
            case 16:
                name = sixteen;
                break;
            case 17:
                name = seventeen;
                break;
            case 18:
                name = eighteen;
                break;
            case 19:
                name = nineteen;
                break;
            case 20:
                name = twenty;
                break;
            case 21:
                name = twentyone;
                break;
            case 22:
                name = twentytwo;
                break;
            case 23:
                name = twentythree;
                break;
            default:
                name = zero;
        }
        return name;
    }


    // Getting Button clicks

    public void mainButtonClick() {
        card.setVisible(false);
        card.getChildren().removeAll();
        yesButtonClicked = true;
    }

    public void yesButtonClick(ActionEvent actionEvent) {
        card.setVisible(false);
        card.getChildren().removeAll();
        yesButtonClicked = true;
    }

    public void noButtonClick(ActionEvent actionEvent) {
        card.setVisible(false);
        card.getChildren().removeAll();
        noButtonClicked = true;
    }

    public void playDogSound(MouseEvent mouseEvent) {
        dogSound.play();
    }

    public void playCatSound(MouseEvent mouseEvent) {
        catSound.play();
    }

    public void playCarSound(MouseEvent mouseEvent) {
        carSound.play();
    }

    public void playBoatSound(MouseEvent mouseEvent) {
        boatSound.play();
    }
}

