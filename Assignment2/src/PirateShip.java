import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
public class PirateShip implements Observer {
int xc;
int yc;
int pirateship_x;
int pirateship_y;
OceanMap oceanMap = OceanMap.getInstance();
//Point psl=oceanMap.getPirateShipLocation();//psl means pirateshiplocation
Point csl;
public PirateShip(int x, int y) {
xc = x;
yc =y;
}


public Point getPirateShipLocation() {
return new Point(pirateship_x,pirateship_y);
}
@Override
public void update(Observable o, Object arg) {
if(o instanceof Ship) {
csl=((Ship)o).getShipLocation();//csl means currentshiplocation of columbus ship
updatePirateShip();
}
}

public void updatePirateShip() {
int cship_x=csl.x;
int cship_y = csl.y;
pirateship_x = xc;
pirateship_y = yc;
if(pirateship_x!=9 && pirateship_x - cship_x <0) {
if(!oceanMap.getMap()[pirateship_x+1][pirateship_y]) {
pirateship_x=pirateship_x+1;

}

}
else if(pirateship_x!=0 && pirateship_x - cship_x >0) {
if(!oceanMap.getMap()[pirateship_x-1][pirateship_y]) {
pirateship_x=pirateship_x-1;
}



}
if(pirateship_y!=9 && pirateship_y - cship_y<0) {
if(!oceanMap.getMap()[pirateship_x][pirateship_y+1]) {
pirateship_y=pirateship_y+1;
}
}
else if(pirateship_y!=0 && pirateship_y -cship_y >0) {
if(!oceanMap.getMap()[pirateship_x][pirateship_y-1]) {
pirateship_y=pirateship_y-1;
}
}


}
}