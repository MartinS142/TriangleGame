
package Lab4;
import java.util.Iterator;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Lab4  extends Application
{
	public static void main(String[] args)
	{
    	launch(args);
   	 
	}

	@Override
	public void start(Stage stage) throws Exception
	{
     	stage.setTitle("Lab 4");

	Group root = new Group();
        Scene scene = new Scene(root, 650, 650);
        stage.setScene(scene);
        stage.show();
        
 Circle c1;
Random rand = new Random();

//creates 100 circles 
for(int i = 0; i<100; i++){
c1 = new Circle(30);
int x= rand.nextInt(600);
int y = rand.nextInt(600);
c1.setLayoutX(x);
c1.setLayoutY(y);
c1.setRadius(10);
c1.setFill(Color.RED);

root.getChildren().add(c1);


c1.setOnMousePressed(new EventHandler<MouseEvent>(){
	 
	@Override
	public void handle(MouseEvent t) {
 	Object o = t.getSource();
 	Circle c = (Circle)o;
 	root.getChildren().remove(c);
       
	
        
        for(int i = 0; i<2; i++){
 	Random rand1 = new Random();
   	c = new Circle();
        int x= rand1.nextInt(625);
        int y = rand1.nextInt(625);
        c.setLayoutX(x);
        c.setLayoutY(y);
        c.setRadius(10);
        c.setFill(Color.BLUE);
        
        
        root.getChildren().add(c);
        
        }   
}
});
}

Rectangle r = new Rectangle(0,0,60,30);
r.setLayoutY(100);
root.getChildren().add(r);

Rectangle bot = new Rectangle(0,0,60,30);
bot.setLayoutY(200);
bot.setLayoutX(300);
root.getChildren().add(bot);

Command moveLeft = (Node node) -> {
    node.setLayoutX(node.getLayoutX()-2);
             };

Command moveRight = (Node node) -> {
    node.setLayoutX(node.getLayoutX()+2);
             };

Command moveUp = (Node node) -> {
    node.setLayoutY(node.getLayoutY()-2);
             };

Command moveDown = (Node node) -> {
    node.setLayoutY(node.getLayoutY()+2);
             };



scene.setOnKeyPressed((KeyEvent evt) -> {
    if (evt.getCode()==KeyCode.A){
        moveLeft.execute(r);
    }
    
    else if(evt.getCode()==KeyCode.D){
        moveRight.execute(r);
    }
    
    else if(evt.getCode()==KeyCode.W){
        moveUp.execute(r);
    }
    
    else if (evt.getCode()==KeyCode.S){
        moveDown.execute(r);
    }        });


Iterator<Command> ai = new Iterator<Command>()
{
    Command[] list = {moveUp, moveUp, moveUp, moveLeft, moveLeft, moveLeft};
    private int step = 0;
    public boolean hasNext() {return true;}
    public Command next()
    {
        Command n = list[step];
        step++;
        if (step==list.length) step=0;
        return n;
    }
};

scene.setOnMouseMoved(new EventHandler<MouseEvent>()
{
    @Override
    public void handle(MouseEvent evt)
    {
        ai.next().execute(bot);
    }
});



 
 

 
 
   	 
   	 
	}    
    
}

