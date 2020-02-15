
package TrianglesFirst;


import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class TrianglesFirst extends Application
{
	public static void main(String[] args)
	{
    	launch(args);
   	 
	}

	@Override
	public void start(Stage stage) throws Exception
	{
     	
        Group root = new Group();
        Scene scene = new Scene(root, 320, 200);
        stage.setTitle("TrianglesFirst");
        stage.setScene(scene);
        stage.show();
        
        Button btn = new Button();
        btn.setText("Clcik to Play!");
        btn.setMaxWidth(320);
        btn.setMaxHeight(200);
        btn.setMinWidth(320);
        btn.setMinHeight(200);
        btn.setTextFill(Color.BLUEVIOLET);
        btn.setStyle("-fx-font: 20 arial;");
        Random rand = new Random();
        
        
        
        root.getChildren().add(btn);
        
         ArrayList<Node> triangles = new ArrayList<>();
         ArrayList<Node> squares = new ArrayList<>();
         ArrayList<Node> pentagons = new ArrayList<>();
         ArrayList<Node> hexagons = new ArrayList<>();
        
        btn.setOnMousePressed((MouseEvent event) -> {
            root.getChildren().remove(btn);
            ImageView A = new ImageView(new Image("resources/meteor.png"));
            int x1= rand.nextInt(310);
            int y1 = rand.nextInt(190);
            A.setLayoutX(160);
            A.setLayoutY(100);
            
            root.getChildren().add(A);
            
            scene.setOnMouseMoved((MouseEvent evt) -> {
                A.setLayoutX(evt.getSceneX()-17);
                A.setLayoutY(evt.getSceneY()-17);
                
                
                A.setOnMouseEntered((MouseEvent t) -> {
                    if(!(triangles.isEmpty())){
                        //loseScreen(root);
                    }
                });
            });
            
            for(int i = 0; i<6; i++){
                
                ImageView tri = new ImageView(new Image("resources/triangle.png"));
                root.getChildren().add(tri);
                int x = rand.nextInt(310);
                int y = rand.nextInt(190);
                tri.setTranslateX(x);
                tri.setTranslateY(y);
                triangles.add(tri);
                
                
                tri.setOnMousePressed((MouseEvent event1) -> {
                    root.getChildren().remove(tri);
                    triangles.remove(tri);
                    Random rand1 = new Random();
                    int x2 = rand1.nextInt(310);
                    int y2 = rand1.nextInt(190);
                    Rectangle square = new Rectangle(x2, y2, 15, 15);
                    root.getChildren().add(square);
                    squares.add(square);
                    square.setOnMouseEntered((MouseEvent t) -> {
                        if(!(triangles.isEmpty())){
                            loseScreen(root);
                        }
                    });
                    square.setOnMousePressed((MouseEvent t) -> {
                        ImageView pen = new ImageView(new Image("resources/pentagon.png"));
                        root.getChildren().add(pen);
                        pen.setPreserveRatio(true);
                        int x3 = rand1.nextInt(310);
                        int y3 = rand1.nextInt(190);
                        pen.setTranslateX(x3);
                        pen.setTranslateY(y3);
                        root.getChildren().remove(square);
                        pentagons.add(pen);
                        squares.remove(square);
                        pen.setOnMouseEntered((MouseEvent t1) -> {
                            if(!(squares.isEmpty())){
                                loseScreen(root);
                            }
                        });
                        pen.setOnMousePressed((MouseEvent t1) -> {
                            ImageView hex = new ImageView(new Image("resources/hexagon.png"));
                            root.getChildren().add(hex);
                            int x4 = rand1.nextInt(310);
                            int y4 = rand1.nextInt(190);
                            hex.setTranslateX(x4);
                            hex.setTranslateY(y4);
                            root.getChildren().remove(pen);
                            hexagons.add(hex);
                            pentagons.remove(pen);
                            hex.setOnMouseEntered((MouseEvent t2) -> {
                                if(!(pentagons.isEmpty())){
                                    loseScreen(root);
                                }
                            });
                            hex.setOnMousePressed((MouseEvent t3) -> {
                                hexagons.remove(hex);
                                root.getChildren().remove(hex);
                                if(hexagons.isEmpty()){
                                    winScreen(root);
                                }
                            });
                        });
                    });
                });
            }});
         
}
        
    public static void winScreen(Group root){
            Button btn = new Button();
        btn.setText("You Win!!!");
        btn.setMaxWidth(320);
        btn.setMaxHeight(200);
        btn.setMinWidth(320);
        btn.setMinHeight(200);
        btn.setTextFill(Color.GOLD);
        btn.setStyle("-fx-font: 30 arial;");
        
        root.getChildren().add(btn);
        
  }
    
    public static void loseScreen(Group root){
        Button btn = new Button();
        btn.setText("You Lose!");
        btn.setMaxWidth(320);
        btn.setMaxHeight(200);
        btn.setMinWidth(320);
        btn.setMinHeight(200);
        btn.setTextFill(Color.RED);
        btn.setStyle("-fx-font: 20 arial;");
        
        root.getChildren().add(btn);
    }
}