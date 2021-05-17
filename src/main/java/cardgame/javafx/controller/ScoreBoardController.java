package cardgame.javafx.controller;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



import java.util.Arrays;
import java.util.List;

public class ScoreBoardController {

    @FXML
    private TableView<Integer> scoreTable;

    @FXML
    private TableColumn<Integer, Number> playerOneColumn;

    @FXML
    private TableColumn<Integer, Number> playerTwoColumn;


    @FXML
    private void initialize() {
        List<Integer> playerOneScores = Arrays.asList(1,2,3);
        List<Integer> playerTwoScores = Arrays.asList(2,2,3);

        for (int i = 0; i < playerOneScores.size() && i < playerTwoScores.size(); i++) {
            scoreTable.getItems().add(i);
        }

        playerOneColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(playerOneScores.get(rowIndex));
        });

        playerTwoColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(playerTwoScores.get(rowIndex));
        });

    }

    @FXML
    private void exitButtonPushed(ActionEvent event) {
        System.out.println("Exiting...");
        Platform.exit();
    }
}
