# Java Chess

I've done a pawn, you've got to build the rest of the pieces.

## How to draw a rook
```java
public void draw() {
		int x = getX() * Board.SCALE, 
			y = getY() * Board.SCALE, 
			s = Board.SCALE,
			w = s / 10;
		
		Zen.setColor(getColor());
		Zen.fillRect(x + s / 5, y + s / 6, w, s / 5);
		Zen.fillRect(x + s / 2 - w / 2, y + s / 6, w, s / 5);
		Zen.fillRect(x + s * 4 / 5 - w, y + s / 6, s / 10, s / 5);
		Zen.fillRect(x + s / 5, y + s / 4, s * 3 / 5, s / 5);
		Zen.fillRect(x + s / 4 + 2, y + s / 4, s / 2 - 4, s * 3 / 5);
		Zen.fillRect(x + s / 5, y + s * 4 / 5, s * 3 / 5, s / 6);
	}
```

## How to draw a bishop

```java
public void draw() {
		int x = getX() * Board.SCALE, 
			y = getY() * Board.SCALE, 
			s = Board.SCALE;
		
		Zen.setColor(getColor());
		Zen.fillOval(x + s * 2 / 5, y + s / 8, s / 5, s / 5);
		Zen.fillPolygon(
			new int[] { x + s / 2, x + s * 3 / 4, x + s / 4 },
			new int[] { y + s / 6, y + s / 2, y + s / 2 }
		);
		Zen.fillRect(x + s / 3, y + s / 2, s / 3, s / 3);
		Zen.fillRect(x + s / 4, y + s * 5 / 6, s / 2, s / 10);
	}
```

## How to draw a knight (hardcore)

```java
public void draw() {
		int x = getX() * Board.SCALE, 
			y = getY() * Board.SCALE, 
			s = Board.SCALE;
		
		Zen.setColor(getColor());
		Zen.fillPolygon(new int[] { 
			x + s / 4, x + s / 2, x + 2 * s / 3, x + s * 2 / 3, x + s * 7 / 12, x + s * 7 / 12, x + s * 2 / 3, 
			x + s * 3 / 4, x + s * 3 / 4, x + s / 4, x + s / 4,
			x + s / 3, x + s / 3, x + s / 2, x + s / 4
		}, new int[] {
			y + s * 3 / 8, y + s / 5, y + s / 3, y + s / 2, y + s * 2 / 3, y + s * 3 / 4, y + s * 4 / 5, 
			y + s * 4 / 5, y + s * 9 / 10, y + s * 9 / 10, y + s * 4 / 5,
			y + s * 4 / 5, y + s * 3 / 5, y + s * 2 / 5, y + s / 2
		});
	}
```
