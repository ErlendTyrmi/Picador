package picador;

import Machine.DanishText;
import Machine.Game;
import Machine.Player;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;

public class ControlFreak{
    private AudioClip dice = new AudioClip(getClass().getResource("dice.wav").toExternalForm());
    private PauseTransition waitForIt = new PauseTransition(Duration.millis(1050));
    private Text message;
    private int chosenField, turnIndex;
    private Game game;
    private boolean won = false, yesButtonClicked = false, noButtonClicked = false,
                    dogChosen = false, catChosen = false, carChosen = false, boatChosen = false;
    private Player currentPlayer;
    @FXML
    private ImageView diceViewA, diceViewB;
    @FXML
    private Button mainButton, dogButton, catButton, carButton, boatButton;
    @FXML
    private Label dogMoney, catMoney, carMoney, boatMoney;
    @FXML
    private HBox dogMoneyBox, catMoneyBox, carMoneyBox, boatMoneyBox;
    @FXML
    private HBox buttonsBox;
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

    public void initialize(){
        // Difference between this and constructor, this loads after fxml!
        settings();
    }

    private void settings(){
        game = new Game();
        // Show greeting:
        showText(DanishText.greeting);
        while(!yesButtonClicked){
            waitForIt;
        }
        yesButtonClicked = false;
        // Choose your players!
        showPlayerChoice();
        while(!yesButtonClicked){
            waitForIt;
        }


        /*
        game.start();
        players = game.getPlayers();
        playGame();

        Image dogImg = new Image("images/monopoly-dog.png");
        pieces[0]= new ImageView(dogImg);
        Image catImg = new Image("images/monopoly-cat.png");
        pieces[1]= new ImageView(catImg);
        Image carImg = new Image("images/monopoly-car.png");
        pieces[2]= new ImageView(carImg);
        Image boatImg = new Image("images/monopoly-boat.png");
        pieces[3]= new ImageView(boatImg);

        Player dog = new Player("dog");
        Player cat = new Player("cat");
        Player car = new Player("car");
        Player boat = new Player("boat");
        */
    }

    private void playGame() {

        while(!won){
            currentPlayer = game.getPlayers()[turnIndex];
            game.playTurn(turnIndex);


        // TODO make players and put on start. Look at MAchine for inspiration
        // TODO write method to move them MAke one that moves instantly first, then add steps
        // TODO write method to communicate with game, and ask for info back Getters Setters
        }
    }
    // Move piece on board
    public void setPiece(Player player, String fieldNumber){
        // remove game piece from previous
        // put game piece in fieldNumber;
    }

    // Show text (cards, buy-button and other text in centre of board)

    public void showText(String text){
        yesButtonClicked = false;
        card.setVisible(true);
        message = new Text("text");
        card.getChildren().add(message);
        gameText.setText(text);
    }

    public void showPlayerChoice(){
        dogChosen = false;
        catChosen= false;
        carChosen = false;
        boatChosen = false;
        dogButton = new Button(DanishText.dog);
        catButton = new Button(DanishText.cat);
        carButton = new Button(DanishText.car);
        boatButton = new Button(DanishText.boat);
        message = new Text(DanishText.choosePiece);
        buttonsBox.getChildren().addAll(dogButton, catButton, carButton, boatButton);
        card.getChildren().add(message);
        card.getChildren().add(buttonsBox);
        card.setVisible(true);
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

    // Set Dice in UI:
    public void rolldice(MouseEvent mouseEvent) {
        // This seems to work!
        System.out.println("dice clicked!");

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

    public void dogButtonClick(ActionEvent actionEvent) {
        System.out.println("Dog chosen.");
        dogChosen = true;
    }

    public void catButtonClick(ActionEvent actionEvent) {
        System.out.println("Cat chosen.");
        catChosen = true;
    }

    public void carButtonClick(ActionEvent actionEvent) {
        System.out.println("Car chosen.");
        carChosen = true;
    }

    public void boatButtonClick(ActionEvent actionEvent) {
        System.out.println("Boat Chosen");
        boatChosen = true;
    }
}

