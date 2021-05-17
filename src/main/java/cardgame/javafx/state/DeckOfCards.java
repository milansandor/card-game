package cardgame.javafx.state;


import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;
    //private Image backOfCardImage;

    /**
     * This is a 1 argument contructor that passes in a collection of Card objects
     * @param deck
     */
    public DeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
        //backOfCardImage = new Image("../images/backOfCard.png");
    }

    /**
     * This is a zero argument constuctor that will build a full Deck of Cards
     */
    public DeckOfCards() {
        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        deck = new ArrayList<>();
        for (String suit:suits) {
            for (String faceName:faceNames) {
                deck.add(new Card(faceName,suit));
            }
        }
        //backOfCardImage = new Image("./images/backOfCard.png");
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    /**
     * This method will "deal" the top card off the deck
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "deck=" + deck +
                '}';
    }
}
