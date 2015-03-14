public abstract class Piece {
	private int x;
	private int y;
	private int player;
	private Board board;
	
	/**
	 * Default constructor.
	 */
	public Piece() {}
	
	/**
	 * Constructs a piece at the given x, y coordinate for the given player.
	 * @param x - x coordinate of the piece.
	 * @param y - y coordinate of the piece.
	 * @param player
	 */
	public Piece(int x, int y, int player) {
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	public abstract Move[] getMoves();
	public abstract void draw();
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void move(int x, int y) {
		if (getBoard().isValid(x, y)) {
			getBoard().setPiece(this.x, this.y, null);
			getBoard().setPiece(x, y, this);
			this.x = x;
			this.y = y;
		}
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPlayer(int player) {
		this.player = player;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int displayX() {
		return x * Board.SCALE;
	}
	
	public int displayY() {
		return y * Board.SCALE;
	}
	
	public int getPlayer() {
		return player;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Piece getPiece(int x, int y) {
		return board.get(x, y);
	}
	
	public boolean isEmpty(int x, int y) {
		return board.isEmpty(x, y);
	}
	
	public boolean hasPiece(int x, int y) {
		return ! board.isEmpty(x, y);
	}
	
	public boolean isOpponent(int x, int y) {
		Piece opponent = board.get(x, y);
		return opponent != null && opponent.getPlayer() != this.player;
	}
	
	public boolean isValid(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
	
	public String getColor() {
		if (player == Chess.WHITE) {
			return Board.WHITE_COLOR;
		}
		else {
			return Board.BLACK_COLOR;
		}
	}
}
