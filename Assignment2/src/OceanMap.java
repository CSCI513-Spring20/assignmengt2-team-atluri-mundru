import java.awt.Point;
import java.util.Random;
public class OceanMap{
	int x,y;
	Random rand = new Random();
	boolean[][] oceanGrid = new boolean[10][10];
	public boolean[][] getMap() {
		return oceanGrid;
	}

    public Point getShipLocation(){
		x = rand.nextInt(10);		// Generating a random number from 0 -10
		y = rand.nextInt(10);
        return new Point(x,y);

    }

}