package e2;

import java.util.Random;

public class SimpleChessboard implements Chessboard {
    private final int size;
    private final Random random = new Random();
    private final Pair<Integer, Integer> knightPosition;
    private final Pair<Integer, Integer> pawnPosition;


    public SimpleChessboard(int size) {
        this.size = size;
        this.pawnPosition = randomEmptyPosition();
        this.knightPosition = randomEmptyPosition();
    }

    private Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawnPosition!=null && this.pawnPosition.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knightPosition;
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawnPosition;
    }
}
