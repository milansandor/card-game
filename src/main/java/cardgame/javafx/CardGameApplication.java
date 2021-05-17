package cardgame.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CardGameApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/fxml/CardView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Deck Of Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
