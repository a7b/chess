package testchess;

import java.util.ArrayList;

import zen.core.Zen;

/**
 * A Pawn object is a type of Piece that 
 */
public class Pawn extends Piece {

	// Stores whether this pawn has already moved, so it knows if it can do a double square jump or not.
	private boolean hasMoved = false;

	/**
	 * Overrides the move method by calling the Piece move method, then storing the hasMoved flag as true,
	 * so the pawn knows when it is allowed to move two squares and when it is allowed to move only one. 
	 */
	public void move(int x, int y) {
		super.move(x, y);
		hasMoved = true;
	}

	/**
	 * Draw the pawn.
	 */
	public void draw() {
		int x = getX() * Board.SCALE, 
				y = getY() * Board.SCALE, 
				s = Board.SCALE;
		Zen.setColor(getColor());
		Zen.fillOval(x + s / 3, y + s / 9, s * 1 / 3, s * 1 / 3);
		Zen.fillOval(x + s / 4, y + s / 3, s * 1 / 2, s * 1 / 2);
		Zen.fillRect(x + s / 5, y + s * 3 / 4, s * 3 / 5, s / 5);
	}
	
	/**
	 * Returns 1 if the player is black (so y is increasing for pawn motion), and
	 * returns -1 if the player is white (so y is decreasing in pawn motion).
	 */
	public int getDirection() {
		if (getPlayer() == Chess.BLACK) {
			return 1;
		}
		else {
			return -1;
		}
	}

	/**
	 * Returns an array of possible moves for this pawn.
	 */
	public Move[] getMoves() {
		// Every pawn can have at most 4 moves, so we tell the arraylist to start with enough
		// space for 4 possible Move objects. 
		ArrayList <Move> moves = new ArrayList <Move> (4);
		
		// Single square move.
		if (isEmpty(getX(), getY() + getDirection())) {
			moves.add(new Move(this, getX(), getY() + getDirection()));
		}
		
		// TODO: Double square move.
	  // TODO: Capturing to the left.
		// TODO: Capturing to the right.
		
		// Create an array from the ArrayList.
		return moves.toArray(new Move[moves.size()]);
	}

}
