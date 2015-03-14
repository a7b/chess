
public class Move {
	Piece piece;
	int x;
	int y;
	
	public Move(Piece piece, int x, int y) {
		this.piece = piece;
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		piece.move(x, y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
