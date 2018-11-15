package picador;

import Machine.DanishText;
import Machine.Game;
import Machine.Player;
import Machine.Square;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;

import java.awt.*;

public class ControlFreak {
    private AudioClip dice = new AudioClip(getClass().getResource("dice.wav").toExternalForm());
    private AudioClip moneySound = new AudioClip(getClass().getResource("money.wav").toExternalForm());
    private AudioClip fanfare = new AudioClip(getClass().getResource("fanfare.mp3").toExternalForm());
    private AudioClip dogSound = new AudioClip(getClass().getResource("bark.wav").toExternalForm());
    private AudioClip catSound = new AudioClip(getClass().getResource("meow.wav").toExternalForm());
    private AudioClip carSound = new AudioClip(getClass().getResource("car.wav").toExternalForm());
    private AudioClip boatSound = new AudioClip(getClass().getResource("boat.wav").toExternalForm());
    private AudioClip[] tokenSounds;

    private PauseTransition justASec = new PauseTransition(Duration.millis(666));
    private PauseTransition justTwoSec = new PauseTransition(Duration.millis(2000));
    private PauseTransition diceRollPauseTransition = new PauseTransition(Duration.millis(1050)); // Timed especially for dice
    private FadeTransition fadeOut = new FadeTransition(Duration.millis(555));
    private int chosenField, numberOfPLayers, fortune, turnIndex, diceShifterA;
    private Game game;
    private DanishText textBook = new DanishText();
    private boolean won = false, yesButtonClicked = false, noButtonClicked = false,
            dogChosen = false, catChosen = false, carChosen = false, boatChosen = false;
    private Player currentPlayer;
    private Player[] players;
    private Square currentSquare;
    @FXML
    private ImageView diceViewA, dogToken, catToken, carToken, boatToken, messageDogToken, messageCatToken, messageCarToken, messageBoatToken;
    @FXML
    private ImageView[] tokens, messageTokens;
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
    private HBox dogMoneyBox, catMoneyBox, carMoneyBox, boatMoneyBox, diceBox;
    @FXML
    private HBox buttonBox, rightTrueBox, characterChoiceBox, characterChoiceImageBox;
    @FXML
    private VBox messageBox, tokensBox;
    @FXML
    private FlowPane card;
    @FXML
    private ImageView[] pieces;
    @FXML
    private Text gameText;


    /******************************************************************
     *Controller handles GUI and controls the show. It's my God-class.
     ******************************************************************/

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


        // Remove FXML-generated tokens at field zero.
        zero.getChildren().removeAll(dogToken, catToken, carToken, boatToken);
        // Remove the two unused button boxes
        card.getChildren().removeAll(rightTrueBox, tokensBox);

        // Just one more step down, all the action begins!
        showPlayerChoice();
    }

    public void showPlayerChoice() {

        messageDogToken.setOnMouseClicked(e -> {
            dogCheckBox.setSelected(true);
            dogSound.play();
        });
        messageCatToken.setOnMouseClicked(e -> {
            catCheckBox.setSelected(true);
            catSound.play();
        });
        messageCarToken.setOnMouseClicked(e -> {
            carCheckBox.setSelected(true);
            carSound.play();
        });
        messageBoatToken.setOnMouseClicked(e -> {
            boatCheckBox.setSelected(true);
            boatSound.play();
        });
        // Show the card!
        characterChoiceBox.setVisible(true);
        buttonBox.setVisible(true);
        okButton.setText("Start");
        showText(textBook.choosePiece);

        // When Start clicked:
        okButton.setOnAction(e -> {
            card.setVisible(false);
            // Removing redundant boxes, also buttonBox. Clean up after yourself!
            characterChoiceImageBox.getChildren().removeAll(messageDogToken, messageCatToken, messageCarToken, messageBoatToken);
            card.getChildren().removeAll(characterChoiceImageBox, characterChoiceBox, buttonBox);

            numberOfPLayers = 0;
            if (dogCheckBox.isSelected()) {
                //zero.getChildren().add(dogToken);
                dogChosen = true;
                numberOfPLayers++;
            }
            if (catCheckBox.isSelected()) {
                //zero.getChildren().add(catToken);
                catChosen = true;
                numberOfPLayers++;
            }
            if (carCheckBox.isSelected()) {
                //zero.getChildren().add(carToken);
                carChosen = true;
                numberOfPLayers++;
            }
            if (boatCheckBox.isSelected()) {
                //zero.getChildren().add(boatToken);
                boatChosen = true;
                numberOfPLayers++;
            }

            // In case none selected:
            if (numberOfPLayers == 0) {
                catChosen = true;
                numberOfPLayers = 1;
            }

            players = new Player[numberOfPLayers];
            tokens = new ImageView[numberOfPLayers];
            messageTokens = new ImageView[numberOfPLayers];
            tokenSounds = new AudioClip[numberOfPLayers];

            // Setting players' fortune at start!
            if (players.length == 4) {
                fortune = 16;
            } else if (players.length == 3) {
                fortune = 18;
            } else {
                fortune = 6; // TODO: 20
            }

            // Make three arrays with the same index: players, tokens and messageTokens(copy of tokens)
            // I'm making messagetokens so you can show token several places @ the same time!
            int i = 0;
            if (dogChosen) {
                players[i] = new Player("Hund", fortune);
                tokens[i] = dogToken;
                messageTokens[i] = messageDogToken;
                tokenSounds[i] = dogSound;
                i++;
            }
            if (catChosen) {
                players[i] = new Player("Kat", fortune);
                tokens[i] = catToken;
                messageTokens[i] = messageCatToken;
                tokenSounds[i] = catSound;
                i++;
            }
            if (carChosen) {
                players[i] = new Player("Bil", fortune);
                tokens[i] = carToken;
                messageTokens[i] = messageCarToken;
                tokenSounds[i] = carSound;
                i++;
            }
            if (boatChosen) {
                players[i] = new Player("Båd", fortune);
                tokens[i] = boatToken;
                messageTokens[i] = messageBoatToken;
                tokenSounds[i] = boatSound;
            }

            // Making players in Machine.Game
            game = new Game(players);

            for (Player x : players) {
                showMoneyUI(x, fortune);
            }

            turnIndex = (int) (Math.random() * numberOfPLayers);
            System.out.println("Starting with player " + turnIndex + ".");

            diceBox.setVisible(true);
            System.out.println("All is set up. Dice now visible: Let the games begin!");

            // Add players to board
            for (ImageView t : tokens) {
                zero.getChildren().add(t);
            }

            // Showing a message for the first player, and setting up the OK Button to roll the die.
            justASec.setOnFinished(eStart -> {
                tokensBox.getChildren().add(messageTokens[turnIndex]);
                card.getChildren().addAll(tokensBox, buttonBox);
                okButton.setText(textBook.rollDice);
                showText(players[turnIndex].getName() + textBook.firstTurn);
                okButton.setOnAction(eFirstPLayerStart -> {
                    tokensBox.getChildren().remove(messageTokens[turnIndex]);
                    card.getChildren().removeAll(tokensBox, buttonBox); // Sauber machen!
                    card.setVisible(false);

                    tokenSounds[turnIndex].play();

                    rollDice();
                });
            });
            justASec.play();
        });
    }

    // Set Dice in UI:
    public void handleDiceClick(MouseEvent mouseEvent) {
        // Go straight to rollDice, to avoid mouseEvent trouble
        rollDice();
    }

    private void rollDice() {
        // All actions instigated by player dice roll.
        currentPlayer = players[turnIndex];
        System.out.println("dice clicked by " + currentPlayer.getName());

        // Tell game to do it's magic and sout it.
        game.playTurn(currentPlayer);
        System.out.println("playTurn method in game called.");
        System.out.println("Turn index: " + turnIndex);
        System.out.println("Current player: " + currentPlayer.getName());
        System.out.println("Player at turn index= " + players[turnIndex].getName());

        // Set currentField variable
        currentSquare = game.getCurrentSquare();

        // Update UI Dice
        int diceShifterA = game.getDiceA() * 100 - 100;
        diceViewA.setViewport(new Rectangle2D(600, 0, 100, 170));
        dice.play(); // sound
        diceRollPauseTransition.setOnFinished(e -> {
            // Show dice
            diceViewA.setViewport(new Rectangle2D(diceShifterA, 0, 100, 170));
            movePiece(turnIndex, currentPlayer.getPosition());

            // Helper function for handling message about what happens after dice roll.
            handleCurrentSquare();
        });
        diceRollPauseTransition.play();
    }

    private void handleCurrentSquare() {

        // Handle "current field" messages. (Adding "passed start" and other rules if relevant)
        tokensBox.getChildren().add(messageTokens[turnIndex]);
        okButton.setText(textBook.ok);
        card.getChildren().addAll(tokensBox, buttonBox);

        // When button is clicked: show welcome to next player (after running the if-else below).
        okButton.setOnAction(e -> handleFieldMessagesAccepted());

        // Big if-else determining what messages to show for current field
        String fieldMessages = textBook.squareDescriptions[currentPlayer.getPosition()];
        if (currentPlayer.hasPassedStart()) {
            fieldMessages += textBook.passedStart;
        }
        if (game.getCurrentSquareType().equals("street")) {
            if (game.isMoneyPaid()) {
                if (game.youBoughtStreet()) {
                    fieldMessages += (textBook.youBoughtStreet + currentSquare.getTitle() +
                            " for " + currentSquare.getPrice() + " M.");
                    setOwned(turnIndex, currentPlayer.getPosition());
                } else if (game.youPaidRent()) {
                    fieldMessages += textBook.youPaidRent + game.getCurrentSquareOwnerName()
                            + "\n" + currentSquare.getPrice() + " M";
                } else {
                    System.out.println("Error: isMoneyPaid should be false");
                }
            } else if (game.youOwnStreet()){
                fieldMessages += textBook.youOwnStreet;
            }
        } else if (game.getCurrentSquareType().equals("chance")){
            // her begynner festen!
        }

        currentPlayer.setPassedStart(false); // Remember to reset.

        showText(fieldMessages);
        // update money for all players
        justASec.setOnFinished(eHoldForCash -> {
            for (Player x : players) {
                showMoneyUI(x, x.getMoney());
            }
            if (game.isMoneyPaid()) {
                moneySound.play();
            }
        });
        justASec.play();

        // Check if player is broke, then game ends
        if (currentPlayer.isBroke()){
            okButton.setDisable(true);
            gameEnd(turnIndex);
        }

        if (currentPlayer.isInPrison()) {
            System.out.println(currentPlayer.getName() + " is moved to prison;");
            currentPlayer.setPosition(6);
            six.getChildren().add(tokens[turnIndex]);
        }

    }

    private void handleFieldMessagesAccepted() {
        // This method increments turn index and sets up card for new player.
        tokensBox.getChildren().remove(messageTokens[turnIndex]);
        card.getChildren().removeAll(tokensBox, buttonBox);
        card.setVisible(false);
        turnIndex++;
        if (turnIndex >= numberOfPLayers) {
            turnIndex = 0;
        }
        System.out.println("\nTurn index incremented to " + turnIndex + ". it's " +
                players[turnIndex].getName() + "'s turn. token is " + tokens[turnIndex]);
        yourTurnMessage(turnIndex);
    }

    private void yourTurnMessage(int turnIndex) {
        // turnIndex @ end of rollDice method is already incremented when the button is pushed.
        tokensBox.getChildren().add(messageTokens[turnIndex]);
        okButton.setText(textBook.rollDice);
        card.getChildren().addAll(tokensBox, buttonBox);
        okButton.setOnAction(ePrepareYourself -> {
            tokensBox.getChildren().remove(messageTokens[turnIndex]);
            card.getChildren().removeAll(tokensBox, buttonBox);
            card.setVisible(false);
            rollDice();
        });
        tokenSounds[turnIndex].play();
        if (players[turnIndex].isInPrison()){
            okButton.setOnAction(e-> {
                tokensBox.getChildren().remove(messageTokens[turnIndex]);
                card.getChildren().removeAll(tokensBox, buttonBox);
                card.setVisible(false);
                handleFieldMessagesAccepted();
                players[turnIndex].setInPrison(false);
            });

            showText(players[turnIndex].getName() + textBook.stillInPrison);
        } else {
            showText(players[turnIndex].getName() + textBook.yourTurn);
        }
    }

    private void gameEnd(int turnIndex){
        fanfare.play();

        // Wait a second, then show winner
        justTwoSec.setOnFinished(e-> {
            // Tell who's won!
            game.findWinnerIndex(players);
            int winner = game.getWinnerIndex();

            tokensBox.getChildren().removeAll(messageTokens[turnIndex]);
            System.out.println("turnIndex: " + turnIndex);
            tokensBox.getChildren().add(messageTokens[game.getWinnerIndex()]);
            okButton.setText(textBook.exit);
            okButton.setDisable(false);
            okButton.setOnAction(eEnd -> {
                System.exit(0);
            });
            showText(textBook.congratulations + players[winner].getName() + textBook.youWon +
                players[winner].getMoney() + " M.");
        });
        justTwoSec.play();
    }


    // Move piece on board
    private void movePiece(int turnIndex, int squareNumber) {
        // TODO: move stepwise
        // remove game piece from previous
        getSquare(squareNumber).getChildren().add(tokens[turnIndex]);
    }

    // Show text (cards, buy-button and other text in centre of board)

    private void showText(String text) {
        // TODO fix buttons OK
        yesButtonClicked = false;
        gameText.setText(text);
        card.setVisible(true);
    }

    // Set account info for players (monopoly money) First time players money is updated,
    // their money field becomes visible. Fortune is the initial amount.
    public void showMoneyUI(Player x, int fortune) {
        if (x.getName().equals("Hund")) {
            dogMoney.setText(Integer.toString(fortune));
            dogMoneyBox.setVisible(true);
        } else if (x.getName().equals("Kat")) {
            catMoney.setText(Integer.toString(fortune));
            catMoneyBox.setVisible(true);
        } else if (x.getName().equals("Bil")) {
            carMoney.setText(Integer.toString(fortune));
            carMoneyBox.setVisible(true);
        } else if (x.getName().equals("Båd")) {
            boatMoney.setText(Integer.toString(fortune));
            boatMoneyBox.setVisible(true);
        } else {
            System.out.println("Error. Cannot update money account for unknown: " + x.getName());
        }
    }

    // Set "owned by"-token. use new imageview each time!
    public void setOwned(int playerIndex, int squareNumber) {
        System.out.println("Set owned:\nPlayer name: " + players[playerIndex].getName());
        System.out.println("Square object: " + getSquare(squareNumber));

        switch (players[playerIndex].getName()){
            case "Hund":
                getSquare(squareNumber).getChildren().add(new ImageView("images/monopoly-dog-owned.png"));
                break;
            case "Kat":
                getSquare(squareNumber).getChildren().add(new ImageView("images/monopoly-cat-owned.png"));
                break;
            case "Bil":
                getSquare(squareNumber).getChildren().add(new ImageView("images/monopoly-car-owned.png"));
                break;
            case "Båd":
                getSquare(squareNumber).getChildren().add(new ImageView("images/monopoly-boat-owned.png"));
                break;
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
    private StackPane getSquare(int x) {
        StackPane name;
        switch (x) {
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
        //card.setVisible(false);
        //card.getChildren().removeAll();
        yesButtonClicked = true;
    }

    public void yesButtonClick(ActionEvent actionEvent) {
        //card.setVisible(false);
        //card.getChildren().removeAll();
        yesButtonClicked = true;
    }

    public void noButtonClick(ActionEvent actionEvent) {
        //card.setVisible(false);
        //card.getChildren().removeAll();
        noButtonClicked = true;
    }

}

