package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChessboardTest {
    public static final int SIZE = 5;

    Chessboard chessboard;

    @BeforeEach
    public void setUp() {
        chessboard = new SimpleChessboard(SIZE);
    }

    @Test
    public void knightIsInitiallyPresent(){
        assertNotNull(this.chessboard.getKnightPosition());
    }

    @Test
    public void pawnIsInitiallyPresent(){
        assertNotNull(this.chessboard.getPawnPosition());
    }
}
