import java.awt.Point;

public class Ship {
	int xcoordinate;
	int ycoordinate;

	public Ship(int x, int y) {

		xcoordinate = x;
		ycoordinate = y;
	}

	public void goEast() {
		if (xcoordinate != 9) {
			xcoordinate=xcoordinate+1;
		}
	}

	public void goWest() {
		if (xcoordinate != 0) {
			xcoordinate--;
		}
	}

	public void goNorth() {
		if (ycoordinate != 0) {
			ycoordinate=ycoordinate-1;
		}
	}

	public void goSouth() {
		if (ycoordinate != 9) {
			ycoordinate++;
		}
	}
	public Point getShipLocation() {
		return new Point(xcoordinate, ycoordinate);
	}

}