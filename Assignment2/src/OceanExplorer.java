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
public class OceanExplorer extends Application{
	final int dimension = 10;
	final int scale = 50;
	boolean[][] oceanGrid = new boolean[10][10];
	OceanMap oceanMap = new OceanMap();
	Image shipImage;
	Ship ship;
	ImageView shipImageView;
	Point startPoint;

	
	public OceanExplorer() {
		oceanGrid = oceanMap.getMap();
	}
	
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
		startSailing(scene);
	}
	
	public void drawMap(AnchorPane myPane) {
		for(int x = 0; x < dimension; x++){
			 for(int y = 0; y < dimension; y++){
			 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK); // We want the black outline
			rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
			myPane.getChildren().add(rect); // Add to the node tree in the pane
			}
			}
	}
	
	private void LoadShipImage(AnchorPane pane) {
		Image shipImage = new Image("ship.png",50,50,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(startPoint.x * scale);
		shipImageView.setY(startPoint.y * scale);
		pane.getChildren().add(shipImageView);
	}
	
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
			}
		});

	}	

}