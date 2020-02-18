import java.awt.Point;
import javafx.application.*;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
public class OceanExplorer extends Application{
	final int dimension = 10;
	final int scale = 50;
	OceanMap oceanMap = OceanMap.getInstance();
	Image shipImage;
	Ship ship;
	PirateShip pirateShip;
	ImageView shipImageView;
	ImageView shipImageView1;
	ImageView shipImageView2;
	ImageView islandImageView;
	Point startPoint;


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane myPane = new AnchorPane();
		Scene scene = new Scene(myPane,500,500);	
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		oceanStage.show();
		drawMap(myPane);
		startPoint = oceanMap.getShipLocation();
		ship = new Ship(startPoint.x,startPoint.y);
		LoadShipImage(myPane);
		startPoint = oceanMap.getPirateShipLocation();
		pirateShip = new PirateShip(startPoint.x, startPoint.y);
		LoadPirateShipImage(myPane);
		//startPoint = oceanMap.getShipLocation();
		//LoadPirateShipImage2(myPane);
		
		startSailing(scene);
	}
	
	public void drawMap(AnchorPane myPane) {
//		for(int i=0;i<10;i++) {
//			for(int j=0;j<10;j++) {
//				System.out.print(oceanMap.getInstance().getMap()[i][j]);
//			}
//			System.out.println();
//		}
		//System.out.println("-----------------------------");

		for(int x = 0; x < dimension; x++){
			 for(int y = 0; y < dimension; y++){
			 
			 //System.out.print(oceanMap.getInstance().getMap()[x][y]);
			 if(oceanMap.getInstance().getMap()[x][y]) {
				 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				 
				 myPane.getChildren().add(rect);
				 Image island = new Image("island.jpg",50,50,true,true);
				 ImagePattern imagep = new ImagePattern(island);
				 rect.setFill(imagep);
				 
				 //rect.setStroke(Color.BLACK); // We want the black outline
				 //rect.setFill(Color.GREEN);

				 
				 
				 //				 Image islandImage = new Image("island.jpg",50,50,true,true);
//				 islandImageView = new ImageView(islandImage);
//				 islandImageView.setX(x * scale);
//				 islandImageView.setY(y * scale);
//				 myPane.getChildren().add(shipImageView);
			 }
			 else {
				 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				 myPane.getChildren().add(rect);
				 rect.setStroke(Color.BLACK); // We want the black outline
				 rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
			
			}
			 // Add to the node tree in the pane
			}
			 //System.out.println();
	}
  }
	private void LoadShipImage(AnchorPane pane) {
		Image shipImage = new Image("ship.png",50,50,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(startPoint.x * scale);
		shipImageView.setY(startPoint.y * scale);
		pane.getChildren().add(shipImageView);
	}
	
	private void LoadPirateShipImage(AnchorPane pane) {
		Image shipImage1 = new Image("pirateShip.png",50,50,true,true);
		shipImageView1 = new ImageView(shipImage1);
		shipImageView1.setX(startPoint.x * scale);
		shipImageView1.setY(startPoint.y * scale);
		pane.getChildren().add(shipImageView1);
	}
	
//	private void LoadPirateShipImage2(AnchorPane pane) {
//		Image shipImage2 = new Image("pirateShip.png",50,50,true,true);
//		shipImageView2 = new ImageView(shipImage2);
//		shipImageView2.setX(startPoint.x * scale);
//		shipImageView2.setY(startPoint.y * scale);
//		pane.getChildren().add(shipImageView2);
//	}
	private void startSailing(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
				shipImageView1.setX(pirateShip.getPirateShipLocation().x*scale);
				shipImageView1.setY(pirateShip.getPirateShipLocation().y*scale);
			}
		});

	}	

}