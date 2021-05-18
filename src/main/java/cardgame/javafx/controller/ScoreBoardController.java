package cardgame.javafx.controller;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoardController {

    private static List<Integer> playerOneScores = new ArrayList<>();
    private static List<Integer> playerTwoScores = new ArrayList<>();

    private static void parseGameObject(JSONObject game)
    {
        //Get gamee object within list
        JSONObject gameObject = (JSONObject) game.get("game");

        //Get game playerOneResult
        Long playerOneResult = (Long) gameObject.get("Player One");
        // add to playerOneScores List
        playerOneScores.add(playerOneResult.intValue());

        //Get game playerTwoResult
        Long playerTwoResult = (Long) gameObject.get("Player Two");
        // add to playerTwoScores List
        playerTwoScores.add(playerTwoResult.intValue());
    }

    @FXML
    private TableView<Integer> scoreTable;

    @FXML
    private TableColumn<Integer, Number> playerOneColumn;

    @FXML
    private TableColumn<Integer, Number> playerTwoColumn;


    @FXML
    private void initialize() {
        JSONParser jsonParser = new JSONParser();
        extracted(jsonParser);

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

    private void extracted(JSONParser jsonParser) {
        try (FileReader reader = new FileReader("file.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray gameList = (JSONArray) obj;
            //System.out.println(gameList);

            //Iterate over employee array
            gameList.forEach( gam -> parseGameObject( (JSONObject) gam ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitButtonPushed(ActionEvent event) {
        System.out.println("Exiting...");
        Platform.exit();
    }
}
