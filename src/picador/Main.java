package picador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("picador.fxml"));

        // ORIGINAL IntelliJ generated load:
        // Parent root = FXMLLoader.load(getClass().getResource("picador.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("PICADOR the board game");
        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(710);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
