package e2;

public interface Chessboard {
    Pair<Integer, Integer> getKnightPosition();
    Pair<Integer, Integer> getPawnPosition();
    void moveKnight(int row, int col);
}
