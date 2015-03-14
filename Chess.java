
import zen.core.Zen;

public class Chess {
	
	public static final int WHITE = 1;
	public static final int BLACK = 2;
	
	public static final int PAWN = 3;
	public static final int ROOK = 4;
	public static final int KNIGHT = 5;
	public static final int BISHOP = 6;
	public static final int QUEEN = 7;
	public static final int KING = 8;
	
	
	static Board board;
	
	public static void main(String[] args) {
		Zen.create(8 * Board.SCALE, 8 * Board.SCALE);
		Zen.buffer(1);
		board = new Board();
		
		while (true) {
			if (Zen.isMouseClicked()) {
				int x = Zen.getMouseX() / Board.SCALE;
				int y = Zen.getMouseY() / Board.SCALE;
				board.select(x, y);
			}
			board.draw();
			Zen.buffer(33);
		}
	}

}
