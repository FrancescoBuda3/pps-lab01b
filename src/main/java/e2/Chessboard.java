package e2;

public interface Chessboard {
    Pair<Integer, Integer> getKnightPosition();
    Pair<Integer, Integer> getPawnPosition();
    int getSize();
    void moveKnight(int row, int col);
}
