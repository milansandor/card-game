package cardgame.javafx.state;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private ArrayList<Card> cardsOfHand;

    public Player(ArrayList<Card> cardsOfHand) {
        this.cardsOfHand = cardsOfHand;
    }

    public ArrayList<Card> getCardsOfHand() {
        return cardsOfHand;
    }

    public Card playACard(int index)
    {
        Card playedCard = cardsOfHand.get(index);
        cardsOfHand.remove(index);
        return playedCard;
    }




    public void setCardsOfHand(ArrayList<Card> cardsOfHand) {
        this.cardsOfHand = cardsOfHand;
    }
}
