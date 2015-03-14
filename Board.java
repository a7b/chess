
import zen.core.Zen;

public class Board {
	private Piece[][] board;
	private Move[][] highlight;

	public static final int SCALE = 90;
	public static final String BLACK_COLOR = "black";
	public static final String WHITE_COLOR = "white";
	public static final String BLACK_SQUARE = "chocolate";
	public static final String WHITE_SQUARE = "tan";
	public static final String HIGHLIGHT_SQUARE = "light gray";
	public static final String HIGHLIGHT_SQUARE_BORDER = "gray";

	static int currentPlayer = Chess.WHITE;


	public Board() {
		board = new Piece[8][8];
		highlight = new Move[8][8];
		setup();
	} 

	private void setup() {
		for (int i = 0 ; i < 8 ; i++) {
			setPiece(i, 1, new Pawn(), Chess.BLACK);
			setPiece(i, 6, new Pawn(), Chess.WHITE);
		}
	}

	public void setPiece(int x, int y, Piece p, int color) {
		p.setPlayer(color);
		setPiece(x, y, p);
	}
	
	public void setPiece(int x, int y, Piece p) {
		if (isValid(x, y)) {
			board[x][y] = p;
			if (p != null) {
				p.setBoard(this);
				p.setPosition(x, y);
				clearHighlight();
			}
		}
	}

	public void draw() {
		for (int x = 0 ; x < 8 ; x++) {
			for (int y = 0 ; y < 8 ; y++) {
				if (highlight[x][y] != null) {
					Zen.setColor(HIGHLIGHT_SQUARE_BORDER);
				}
				else if (x % 2 == y % 2) {
					Zen.setColor(WHITE_SQUARE);
				}
				else {
					Zen.setColor(BLACK_SQUARE);
				}
				Zen.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
				if (highlight[x][y] != null) {
					Zen.setColor(HIGHLIGHT_SQUARE);
					Zen.fillRect(x * SCALE + 5, y * SCALE + 5, SCALE - 10, SCALE - 10);
				}

				if (board[x][y] != null) {
					board[x][y].draw();
				}
			}
		}
	}
	
	public Piece get(int x, int y) {
		if (isValid(x, y)) {
			return board[x][y];
		}
		return null;
	}

	public void select(int x, int y) {
		if (isValid(x, y)) {
			if (highlight[x][y] != null) {
				play(highlight[x][y]);
			}
			else if (board[x][y] != null && board[x][y].getPlayer() == currentPlayer) {
				clearHighlight();
				Move[] moves = board[x][y].getMoves();
				for (Move move : moves) {
					if (isValid(move.getX(), move.getY())) {
						highlight[move.getX()][move.getY()] = move;
					}
				}
			}
		}
	}

	public void play(Move move) {
		move.move();
		currentPlayer = 1 + currentPlayer % 2;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isEmpty(int x, int y) {
		return isValid(x, y) && board[x][y] == null;
	}

	public boolean isValid(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}

	public boolean isHighlighted(int x, int y) {
		return highlight[x][y] != null;
	}

	public void clearHighlight() {
		for (int x = 0 ; x < 8 ; x++) {
			for (int y = 0 ; y < 8 ; y++) {
				highlight[x][y] = null;
			}
		}
	}
}
