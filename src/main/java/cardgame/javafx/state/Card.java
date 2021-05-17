package cardgame.javafx.state;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceName, suit;
    //private Image image;

    public Card(String faceName, String suit) {
        setFaceName(faceName);
        setSuit(suit);
        String fileName = faceName + "_of_" + suit + ".png";
        //image = new Image("./images/"+fileName);
    }

    /*public Image getImage() {
        return image;
    }*/

    /*public void setImage(Image image) {
        this.image = image;
    }*/

    public String getFaceName() {
        return faceName;
    }

    /**
     * This method returns a list of face names that are valid for
     * Card objects
     */
    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("7","8","9","10","jack",
                "queen","king","ace");
    }

    /**
     * This method will validate the argument and set the instance variable
     * @param faceName 7,8,9,10,jack,queen,king
     */
    public void setFaceName(String faceName) {
        List<String> validFaceNames = getValidFaceNames();
        faceName = faceName.toLowerCase();

        if (validFaceNames.contains(faceName))
            this.faceName = faceName;
        else throw new IllegalArgumentException("Valid face names are: " + validFaceNames);
    }

    /**
     * This method returns a list of suits that are valid for
     * Card objects
     */
    public static List<String> getValidSuits()
    {
        return Arrays.asList("hearts","spades","diamonds","clubs");
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method will validate the argument and set the instance variable
     * @param suit hearts,spades,diamonds,clubs
     */
    public void setSuit(String suit) {
        List<String> validSuits = getValidSuits();
        suit = suit.toLowerCase();

        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException("valid suits are: "+ validSuits);
    }


    /**
     * This method will add a value by the face names
     * @return cardValue 7,8,9,10,11,12,13,14
     */
    public Integer getCardValue() {
        String str = getFaceName();
        int cardValue;
        switch (str)
        {
            case "7":
                cardValue = 7;
                break;
            case "8":
                cardValue = 8;
                break;
            case "9":
                cardValue = 9;
                break;
            case "10":
                cardValue = 10;
                break;
            case "jack":
                cardValue = 11;
                break;
            case "queen":
                cardValue = 12;
                break;
            case "king":
                cardValue = 13;
                break;
            case "ace":
                cardValue = 14;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + str);
        }
        return cardValue;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", faceName, suit);
    }
}