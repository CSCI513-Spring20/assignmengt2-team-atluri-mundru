import java.awt.Point;
import java.util.Random;
public class OceanMap{
<<<<<<< HEAD
	int x,y;
	private static OceanMap oceanMap = null;
	
	Random rand = new Random();
	boolean[][] oceanGrid = new boolean[10][10];
	public OceanMap() {
		int noOfIslands=0;
	    
    	while(noOfIslands<10) {
    		x=rand.nextInt(10);
        	y=rand.nextInt(10);
        	if(!oceanGrid[x][y]) {
        		oceanGrid[x][y]=true;
        		noOfIslands++;
        		continue;
        	}
    	}
    	
	}
//    	for(int i=0;i<10;i++) {
//			for(int j=0;j<10;j++) {
//				System.out.print(oceanGrid[i][j]);
//			}
//			System.out.println();
//		}
//	}
	public boolean[][] getMap() {
		return oceanGrid;
	}
	
	public static OceanMap getInstance() {
		if(oceanMap==null) {
			oceanMap=new OceanMap();
		}
		return oceanMap;
	}
=======
int x,y;
private static OceanMap oceanMap = null;

Random rand = new Random();
boolean[][] oceanGrid = new boolean[10][10];
public OceanMap() {
int noOfIslands=0;
   
    while(noOfIslands<10) {
    x=rand.nextInt(10);
        y=rand.nextInt(10);
        if(!oceanGrid[x][y]) {
        oceanGrid[x][y]=true;
        noOfIslands++;
        continue;
        }
    }
   
}
//     for(int i=0;i<10;i++) {
// for(int j=0;j<10;j++) {
// System.out.print(oceanGrid[i][j]);
// }
// System.out.println();
// }
// }
public boolean[][] getMap() {
return oceanGrid;
}

public static OceanMap getInstance() {
if(oceanMap==null) {
oceanMap=new OceanMap();
}
return oceanMap;
}
>>>>>>> origin/master

    public Point getShipLocation(){
x = rand.nextInt(10); // Generating a random number from 0 -10
y = rand.nextInt(10);
        return new Point(x,y);

    }
   
   

}