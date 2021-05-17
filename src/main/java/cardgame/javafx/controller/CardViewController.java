package cardgame.javafx.controller;

import cardgame.javafx.state.Card;
import cardgame.javafx.state.DeckOfCards;
import cardgame.javafx.state.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CardViewController {

    private static ArrayList<Card> getCardsFromDeck(DeckOfCards deck) {
        ArrayList<Card> hand1 = new ArrayList<>();
        while (hand1.size() < 5)
            hand1.add(deck.dealTopCard());
        return hand1;
    }

    private Player getPlayer(DeckOfCards deck) {
        ArrayList<Card> hand1 = getCardsFromDeck(deck);
        return new Player(hand1);
    }

    private void getANewDeck() {
        deck = new DeckOfCards();
    }

    @FXML
    private TextField playerOneTextField;
    @FXML
    private TextField playerTwoTextField;


    private DeckOfCards deck;
    private JSONArray gameList = new JSONArray();

    public void initialize() {
        getANewDeck();
        deck.shuffle();
    }

    @FXML
    public void playCardButtonPushed() {
        // 2 new player
        // new player1 with 5 cards
        Player player1 = getPlayer(deck);
        // new player2 with 5 cards
        Player player2 = getPlayer(deck);
        int player1Points = 0;
        int player2Points = 0;


        while (player1.getCardsOfHand().size() != 0 && player2.getCardsOfHand().size() != 0) {
            System.out.println("Size: "+player1.getCardsOfHand().size());
            Card playedByPlayer1Card = player1.playACard(0);
            System.out.println("played card by player1: "+playedByPlayer1Card);
            Card playedByPlayer2Card = player2.playACard(0);
            System.out.println("played card by player2: "+playedByPlayer2Card);
            if (playedByPlayer1Card.getCardValue() > playedByPlayer2Card.getCardValue()) {
                // 1 point for player1
                player1Points++;
                System.out.println(playedByPlayer1Card.getCardValue());
            }
            if (playedByPlayer1Card.getCardValue() < playedByPlayer2Card.getCardValue()) {
                player2Points++;
                System.out.println(playedByPlayer2Card.getCardValue());
            }
        }

        playerOneTextField.setText(String.valueOf(player1Points));
        playerTwoTextField.setText(String.valueOf(player2Points));

        /*
          create JSON gameDetails and JSON object
         */

        JSONObject gameDetails = new JSONObject();
        gameDetails.put("Player One", player1Points);
        gameDetails.put("Player Two", player2Points);

        JSONObject gameObject = new JSONObject();
        gameObject.put("game", gameDetails);

        /*
          add games to list
         */
        gameList.add(gameObject);

        getANewDeck();
        deck.shuffle();
    }

    @FXML
    public void saveGameButtonPushed() {
        /*
          write in JSON file
         */
        try (FileWriter file = new FileWriter("file.json")) {
            file.write(gameList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void scoreBoardPushed(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ScoreBoard.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }


}
