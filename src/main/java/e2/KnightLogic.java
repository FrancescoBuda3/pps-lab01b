package e2;

public class KnightLogic implements PieceLogic {

    @Override
    public boolean moveIsValid(Pair<Integer, Integer> startPosition, Pair<Integer, Integer> endPosition) {
        int x = endPosition.getX()-startPosition.getX();
        int y = endPosition.getY()-startPosition.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
