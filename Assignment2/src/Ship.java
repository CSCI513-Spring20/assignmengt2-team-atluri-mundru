import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;
import java.util.List;

public class Ship extends Observable{
	List<Observer> observer=new LinkedList<Observer>();
	int xcoordinate;
	int ycoordinate;
	OceanMap oceanMap = OceanMap.getInstance();
	//oceanGrid=oceanMap.getMap();

	public Ship(int x, int y) {

		xcoordinate = x;
		ycoordinate = y;
	}

	public void goEast() {
		if (xcoordinate != 9) {
			if(!oceanMap.getMap()[xcoordinate+1][ycoordinate]) {
			xcoordinate=xcoordinate+1;
			notifyObservers();
			
		}
	}
//		System.out.println("-----------------------------");
//		for(int i=0;i<10;i++) {
//			for(int j=0;j<10;j++) {
//				System.out.print(oceanMap.getInstance().getMap()[i][j]);
//			}
//			System.out.println();
//		}
		
}		

	public void goWest() {
		if (xcoordinate != 0) {
			if(!oceanMap.getMap()[xcoordinate-1][ycoordinate]) {
				xcoordinate=xcoordinate-1;
				notifyObservers();
			}
		}
		}
	

	public void goNorth() {
		if (ycoordinate != 0) {
			if(!oceanMap.getMap()[xcoordinate][ycoordinate-1]) {
				ycoordinate=ycoordinate-1;
				notifyObservers();
			}
		}
		}
	

	public void goSouth() {
		if (ycoordinate != 9) {
			if(!oceanMap.getMap()[xcoordinate][ycoordinate+1]) {
				ycoordinate=ycoordinate+1;
				notifyObservers();
			}
		}
		}
	public void registerObserver(Observer o) {
		observer.add(o);
	}
	public void notifyObserver() {
		for(Observer pirateObserver:observer)
			pirateObserver.update(this, pirateObserver);
	}
	
	public Point getShipLocation() {
		return new Point(xcoordinate, ycoordinate);
	}
	

}