package e2;

public class LogicsImpl implements Logics {
	
	private final Chessboard  chessboard;
	 
    public LogicsImpl(int size){
    	this.chessboard = new SimpleChessboard(size);
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight){
		this.chessboard = new SimpleChessboard(size, pawn, knight);
	}
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.chessboard.getSize() || col >= this.chessboard.getSize()) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.chessboard.getKnightPosition().getX();
		int y = col-this.chessboard.getKnightPosition().getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.chessboard.moveKnight(row, col);
			return this.chessboard.getPawnPosition().equals(this.chessboard.getKnightPosition());
		}
		return false;
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
