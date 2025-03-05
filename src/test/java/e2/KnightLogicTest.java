package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightLogicTest {
    KnightLogic knightLogic;

    @BeforeEach
    public void setUp() {
        knightLogic = new KnightLogic();
    }

    @Test
    public void testMoveIsValid() {
        Pair<Integer, Integer> start = new Pair<>(1, 1);
        Pair<Integer, Integer> end = new Pair<>(3, 2);
        assertTrue(this.knightLogic.moveIsValid(start,end));
    }

    @Test
    public void testMoveIsNotValid() {
        Pair<Integer, Integer> start = new Pair<>(1, 1);
        Pair<Integer, Integer> end = new Pair<>(2, 2);
        assertFalse(this.knightLogic.moveIsValid(start,end));
    }
}
