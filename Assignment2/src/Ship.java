import java.util.Observable;
import java.util.Random;
import java.awt.Point;

// Ship class extending observable class
public class Ship extends Observable{
    OceanMap oceanMap;
    Point currentLocation;
    Random rand = new Random();

    public Ship(OceanMap oceanMap){
        
        this.oceanMap = oceanMap;
        oceanMap.ship = this;
        
        while(true){
            int x = rand.nextInt(oceanMap.dimensions);
            int y = rand.nextInt(oceanMap.dimensions);
            //initial point can't be an island
            if(oceanMap.getMap()[x][y] != 1){
                currentLocation = new Point(x,y);
                break;
            }
        }
    }

    public Point getShipLocation(){
        return this.currentLocation;
    }
    // Implementing methods for east, west, south, north key movements and notifying observers
    public void goEast() {
    	 if(currentLocation.x<9 && oceanMap.getMap()[currentLocation.x+1][currentLocation.y]!=1) {
             currentLocation.x++;
    	 	setChanged();
    	 	notifyObservers();
    	 }
    }
    public void goWest() {
    	 if(currentLocation.x>0 && oceanMap.getMap()[currentLocation.x-1][currentLocation.y]!=1 ) {
             currentLocation.x--;
             setChanged();
     	 	notifyObservers();
    	 }
    	
    }
    public void goNorth() {
    	 if(currentLocation.y>0 && oceanMap.getMap()[currentLocation.x][currentLocation.y-1]!=1) {
             currentLocation.y--;
    	     setChanged();
    	     notifyObservers();
    	 }
    	
    }
    public void goSouth() {
    	 if(currentLocation.y<9 && oceanMap.getMap()[currentLocation.x][currentLocation.y+1]!=1) {
             currentLocation.y++;
             setChanged();
    	     notifyObservers();
    	 }
    	
    }
    	 
    }

	
