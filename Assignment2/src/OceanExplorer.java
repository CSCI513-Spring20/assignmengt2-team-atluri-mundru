import java.util.Random;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
// OceanExplorer class extending application
public class OceanExplorer extends Application {

    int[][] islandMap;
    int count;
    final int dimensions = 10;
    final int scale = 50;
    final int islandCount = 10;
    boolean resetGame = true;
    Scene scene;
    AnchorPane myPane;
    OceanMap oceanMap;
    Ship ship;
    PirateShip pirateShip;
    PirateShip pirateShip1;
    ImageView shipImageView;
    ImageView pirateImageView;
    ImageView pirate1ImageView;
    Label moves;
    public static void main(String[] args) {
        launch(args);
    }
    // Start method
    @Override
    public void start(final Stage oceanStage) throws Exception {
        //count = total amount of moves for each game
        count = 0;
        oceanMap = new OceanMap(dimensions, scale);
        islandMap = oceanMap.getMap();

        myPane = new AnchorPane();
        setMap();
        //allocating islands
        setIslands(10);

        //declaring the three different ships/ adding pirates to observer list
        ship = new Ship(oceanMap);
        pirateShip = new PirateShip(oceanMap);
        pirateShip1 = new PirateShip(oceanMap);
        ship.addObserver(pirateShip);
        ship.addObserver(pirateShip1);
        loadShipImage();
        loadPirateImage();
        loadPirateImage2();

        // Placing reset button on to the grid
        Button reset = new Button("reset");
        
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	// Key event handler for button
                try {
                    start(oceanStage);
                    resetGame=true;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        reset.setLayoutX(0);
        reset.setLayoutY(500);
        myPane.getChildren().add(reset);
        // Setting scene to the stage
        scene = new Scene(myPane, 500, 500);
        oceanStage.setTitle("My Island");
        oceanStage.setScene(scene);
        oceanStage.show();

        startSailing();

    }

    // 10*10 Grid
    public void setMap(){
        for(int x = 0; x < dimensions; x++){
            for(int y = 0; y < dimensions; y++){
                Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.PALETURQUOISE);
                myPane.getChildren().add(rect);
            }
        }
    }

    // Placing columbus ship on the ocean
    public void loadShipImage(){
        Image shipImage = new Image("ship.png",50,50,true,true);
        shipImageView = new ImageView(shipImage);
        shipImageView.setX(ship.getShipLocation().x * scale);
        shipImageView.setY(ship.getShipLocation().y * scale);
        myPane.getChildren().add(shipImageView);
    }

    // Placing second pirate ship on the ocean
    public void loadPirateImage(){
        Image shipImage = new Image("pirateShip.png",50,50,true,true);
        pirateImageView = new ImageView(shipImage);
        pirateImageView.setX(pirateShip.getPirateLocation().x * scale);
        pirateImageView.setY(pirateShip.getPirateLocation().y * scale);
        myPane.getChildren().add(pirateImageView);
    }

    // Loading second pirate ship on the ocean
    public void loadPirateImage2(){
        Image shipImage = new Image("pirateShip.png",50,50,true,true);
        pirate1ImageView = new ImageView(shipImage);
        pirate1ImageView.setX(pirateShip1.getPirateLocation().x * scale);
        pirate1ImageView.setY(pirateShip1.getPirateLocation().y * scale);
        myPane.getChildren().add(pirate1ImageView);
    }

    //Implementation of islands allocation with islands in different locations
    public void setIslands(int i){
        int count = 0;
        Random rand = new Random();
        while(count<i){
            int x;
            int y;
            
            while(true){
                x = rand.nextInt(dimensions);
                y = rand.nextInt(dimensions);
                if(islandMap[x][y]!=1)
                    break;
            }
            Image islandImage = new Image("island.jpg",50,50,true,true);
            ImageView islandImageView = new ImageView(islandImage);
            islandImageView.setX(x*scale);
            islandImageView.setY(y*scale);
            islandMap[x][y] = 1;
            myPane.getChildren().add(islandImageView);
            count++;
        }
    }

    
    private void startSailing(){
    	// Key event handler for ship movements
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke) {
            	if(resetGame) {
                	System.out.println(resetGame);
                switch(ke.getCode()){
                    case RIGHT:
                        ship.goEast();// right arrow button goeast method is called
                        break;
                    case LEFT:
                        ship.goWest();// left arrow button gowest method is called
                        break;
                    case UP:
                        ship.goNorth();// up arrow button gonorth method is called
                        break;
                    case DOWN:
                        ship.goSouth();// down arrow button gosouth method is called
                        break;
                    default:
                        break;
                }
            	}
                
                shipImageView.setX(ship.getShipLocation().x*scale);
                shipImageView.setY(ship.getShipLocation().y*scale);
                pirateImageView.setX(pirateShip.getPirateLocation().x*scale);
                pirateImageView.setY(pirateShip.getPirateLocation().y*scale);
                pirate1ImageView.setX(pirateShip1.getPirateLocation().x*scale);
                pirate1ImageView.setY(pirateShip1.getPirateLocation().y*scale);
                if(ship.getShipLocation().x == pirateShip.getPirateLocation().x && ship.getShipLocation().y == pirateShip.getPirateLocation().y  ||(ship.getShipLocation().x == pirateShip.getPirateLocation().x && ship.getShipLocation().y == pirateShip1.getPirateLocation().y) ){//||
                		
                	resetGame = false;
                	//System.out.println(resetGame);
                }
            }});
    }


    

}