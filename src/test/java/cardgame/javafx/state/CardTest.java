package cardgame.javafx.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card underTest;

    @BeforeEach
    void setUp() {
        underTest = new Card("ace","spades");
    }

    @Test
    void testGetCardValue() {
        assertEquals(14,underTest.getCardValue());

    }
}