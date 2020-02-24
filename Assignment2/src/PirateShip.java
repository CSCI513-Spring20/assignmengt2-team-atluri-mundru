import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
// Pirate ship class implementing Observer interface
public class PirateShip implements Observer{
    OceanMap oceanMap;
    OceanExplorer oceanExplorer = new OceanExplorer();
    Point shipLocation;
    Point pirateLocation;
    Random rand = new Random();

    public PirateShip(OceanMap oceanMap){
        
        this.oceanMap = oceanMap;
        
        while(true){
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if(oceanMap.getMap()[x][y] != 1){
                pirateLocation = new Point(x,y);
                break;
            }
        }
    }

    public Point getPirateLocation(){
        return this.pirateLocation;
    }

    @Override
    // Update method is called based on observable class
    public void update(Observable o, Object arg) {
        if(o instanceof Ship){
            shipLocation = ((Ship)o).getShipLocation();
            movePirate();
        }
    }

    public void movePirate(){
        // Movement of the pirate ship based on the columbus ship movement
        if(pirateLocation.x - shipLocation.x == 0){}
        else if(pirateLocation.x - shipLocation.x < 0){
            
            if(pirateLocation.x<9 && oceanMap.getMap()[pirateLocation.x+1][pirateLocation.y]!=1)
                pirateLocation.x++;
        }
        else if(pirateLocation.x>0 && oceanMap.getMap()[pirateLocation.x-1][pirateLocation.y]!=1)
            pirateLocation.x--;

        
        if(pirateLocation.y - shipLocation.y == 0){}
        else if(pirateLocation.y - shipLocation.y < 0){
            
            if(pirateLocation.y<9 &&oceanMap.getMap()[pirateLocation.x][pirateLocation.y+1]!=1)
                pirateLocation.y++;
        }
        else if(pirateLocation.y>0 && oceanMap.getMap()[pirateLocation.x][pirateLocation.y-1]!=1)
            pirateLocation.y--;
        
        
    }

}

