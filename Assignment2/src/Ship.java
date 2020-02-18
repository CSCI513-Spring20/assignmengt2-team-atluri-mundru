import java.awt.Point;

public class Ship {
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
}
}
// System.out.println("-----------------------------");
// for(int i=0;i<10;i++) {
// for(int j=0;j<10;j++) {
// System.out.print(oceanMap.getInstance().getMap()[i][j]);
// }
// System.out.println();
// }

}

public void goWest() {
if (xcoordinate != 0) {
if(!oceanMap.getMap()[xcoordinate-1][ycoordinate]) {
xcoordinate=xcoordinate-1;
}
}
}


public void goNorth() {
if (ycoordinate != 0) {
if(!oceanMap.getMap()[xcoordinate][ycoordinate-1]) {
ycoordinate=ycoordinate-1;
}
}
}


public void goSouth() {
if (ycoordinate != 9) {
if(!oceanMap.getMap()[xcoordinate][ycoordinate+1]) {
ycoordinate=ycoordinate+1;
}
}
}

public Point getShipLocation() {
return new Point(xcoordinate, ycoordinate);
}


}
