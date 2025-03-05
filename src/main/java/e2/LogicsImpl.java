package e2;

public class LogicsImpl implements Logics {
	
	private final Chessboard  chessboard;
	private final PieceLogic knightLogic;
	 
    public LogicsImpl(int size){
    	this.chessboard = new SimpleChessboard(size);
		this.knightLogic = new KnightLogic();
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight){
        this.chessboard = new SimpleChessboard(size, pawn, knight);
		this.knightLogic = new KnightLogic();
	}
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.chessboard.getSize() || col >= this.chessboard.getSize()) {
			throw new IndexOutOfBoundsException();
		}
		if (this.knightLogic.moveIsValid(this.chessboard.getKnightPosition(), new Pair<>(row, col))){
			this.chessboard.moveKnight(row, col);
			return this.chessboard.getPawnPosition().equals(this.chessboard.getKnightPosition());
		} else {
			return false;
		}
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.chessboard.getKnightPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.chessboard.getPawnPosition().equals(new Pair<>(row,col));
	}
}
